package com.tencent.mobileqq.magicface.drawable;

import afrf;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import atte;
import attf;
import attk;

public class PngFrameManager$1
  implements Runnable
{
  public PngFrameManager$1(atte paramatte, attk paramattk) {}
  
  public void run()
  {
    if ((this.a.a.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0) && (this.a.a.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
      this.a.a.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(new attf(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.1
 * JD-Core Version:    0.7.0.1
 */