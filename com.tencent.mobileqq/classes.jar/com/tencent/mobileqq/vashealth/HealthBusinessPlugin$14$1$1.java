package com.tencent.mobileqq.vashealth;

import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import biff;
import bifg;

public class HealthBusinessPlugin$14$1$1
  implements Runnable
{
  public HealthBusinessPlugin$14$1$1(bifg parambifg, SeekBar paramSeekBar, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, TextView paramTextView3) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Bifg.a.a.c)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_Bifg.a.a.f = false;
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.14.1.1
 * JD-Core Version:    0.7.0.1
 */