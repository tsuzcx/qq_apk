package com.tencent.mobileqq.magicface.drawable;

import ahcu;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import awew;
import awex;
import awfc;

public class PngFrameManager$1
  implements Runnable
{
  public PngFrameManager$1(awew paramawew, awfc paramawfc) {}
  
  public void run()
  {
    if ((this.a.a.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0) && (this.a.a.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
      this.a.a.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(new awex(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.1
 * JD-Core Version:    0.7.0.1
 */