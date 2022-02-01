package com.tencent.qqcamerakit.capture.cameraextend;

import android.app.Activity;
import android.provider.Settings.System;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qqcamerakit.common.QLog;

public class FrontFlashImpl
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  
  public FrontFlashImpl(Activity paramActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidAppActivity);
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1);
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.7F);
      if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_AndroidAppActivity.addContentView(this.jdField_a_of_type_AndroidViewView, new ViewGroup.LayoutParams(-1, -1));
      try
      {
        this.jdField_a_of_type_Int = Settings.System.getInt(this.jdField_a_of_type_AndroidAppActivity.getContentResolver(), "screen_brightness_mode");
        Settings.System.putInt(this.jdField_a_of_type_AndroidAppActivity.getContentResolver(), "screen_brightness_mode", 0);
        this.jdField_b_of_type_Int = Settings.System.getInt(this.jdField_a_of_type_AndroidAppActivity.getContentResolver(), "screen_brightness");
        Settings.System.putInt(this.jdField_a_of_type_AndroidAppActivity.getContentResolver(), "screen_brightness", 255);
        this.jdField_b_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_Int = 1;
        this.jdField_b_of_type_Int = 100;
        if (!QLog.a()) {
          return;
        }
      }
      QLog.a("FrontFlashImpl", 2, "turn FrontFlash Error ", localException);
      localException.printStackTrace();
    }
    else
    {
      if (this.jdField_b_of_type_Boolean)
      {
        Settings.System.putInt(this.jdField_a_of_type_AndroidAppActivity.getContentResolver(), "screen_brightness", this.jdField_b_of_type_Int);
        Settings.System.putInt(this.jdField_a_of_type_AndroidAppActivity.getContentResolver(), "screen_brightness_mode", this.jdField_a_of_type_Int);
        this.jdField_b_of_type_Boolean = false;
      }
      View localView = this.jdField_a_of_type_AndroidViewView;
      if ((localView != null) && (localView.getParent() != null)) {
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.cameraextend.FrontFlashImpl
 * JD-Core Version:    0.7.0.1
 */