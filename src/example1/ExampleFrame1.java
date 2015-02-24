package example1;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
/**
 * intend to ilustrate how springLayout works
 * TODO: there's a textField in the example, try to complete this:
 * 		When the textField is empty, output the current time by the right side of the screen.
 * 		When the textField is not empty, output the what the textField contains on the left side of screen.
 * @author Xingyu
 *
 */
public class ExampleFrame1 extends JFrame{
	ExampleFrame1 thisObj;
	
	SpringLayout layout = null;
	JLabel lastLabel = null;
	
	JTextField textField = null; 
	public ExampleFrame1() {
		thisObj = this;
		
		Dimension dimension = new Dimension(800, 600);
		setPreferredSize(dimension);
		setSize(dimension);
		
		layout = new SpringLayout();
		setLayout(layout);
		
		init();
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void init() {
		Button jbutton = new Button("add timer");
		jbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addLabel("time:\t"+(new Date().toString()));
			}
		});
		add(jbutton);
		
		layout.putConstraint(SpringLayout.NORTH, jbutton, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, jbutton, 5, SpringLayout.WEST, this);

		textField = new JTextField();
		Dimension dimension = new Dimension(300, 20);
		textField.setSize(dimension);
		textField.setPreferredSize(dimension);
		add(textField);
		
		layout.putConstraint(SpringLayout.NORTH, textField, 5, SpringLayout.SOUTH, jbutton);
		layout.putConstraint(SpringLayout.WEST, textField, 5, SpringLayout.WEST, this);
		
		
	}
	
	public void addLabel(String message) {
		JLabel nl = new JLabel(message);
		Dimension dimension = new Dimension(300, 20);
		nl.setPreferredSize(dimension);
		nl.setSize(dimension);
		add(nl);
		layout.putConstraint(SpringLayout.EAST, nl, -10, SpringLayout.EAST, thisObj);
		if(null == lastLabel)
			layout.putConstraint(SpringLayout.NORTH, nl, 5, SpringLayout.NORTH, thisObj);
		else
			layout.putConstraint(SpringLayout.NORTH, nl, 5, SpringLayout.SOUTH, lastLabel);
		lastLabel = nl;
		validate();
		repaint();
	}
	
	public static void main(String[] args) {
		ExampleFrame1 ef = new ExampleFrame1();
	}
}
