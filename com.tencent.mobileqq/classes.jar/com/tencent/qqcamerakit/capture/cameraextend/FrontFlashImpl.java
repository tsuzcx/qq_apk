package com.tencent.qqcamerakit.capture.cameraextend;

import android.app.Activity;
import android.provider.Settings.System;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qqcamerakit.common.QLog;

public class FrontFlashImpl
{
  public boolean a = false;
  private View b;
  private int c;
  private int d;
  private boolean e = false;
  private Activity f;
  
  public FrontFlashImpl(Activity paramActivity)
  {
    this.f = paramActivity;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.b == null) {
        this.b = new View(this.f);
      }
      this.b.setBackgroundColor(-1);
      this.b.setAlpha(0.7F);
      if (this.b.getParent() != null) {
        ((ViewGroup)this.b.getParent()).removeView(this.b);
      }
      this.f.addContentView(this.b, new ViewGroup.LayoutParams(-1, -1));
      try
      {
        this.c = Settings.System.getInt(this.f.getContentResolver(), "screen_brightness_mode");
        Settings.System.putInt(this.f.getContentResolver(), "screen_brightness_mode", 0);
        this.d = Settings.System.getInt(this.f.getContentResolver(), "screen_brightness");
        Settings.System.putInt(this.f.getContentResolver(), "screen_brightness", 255);
        this.e = true;
        return;
      }
      catch (Exception localException)
      {
        this.c = 1;
        this.d = 100;
        if (!QLog.a()) {
          return;
        }
      }
      QLog.a("FrontFlashImpl", 2, "turn FrontFlash Error ", localException);
      localException.printStackTrace();
    }
    else
    {
      if (this.e)
      {
        Settings.System.putInt(this.f.getContentResolver(), "screen_brightness", this.d);
        Settings.System.putInt(this.f.getContentResolver(), "screen_brightness_mode", this.c);
        this.e = false;
      }
      View localView = this.b;
      if ((localView != null) && (localView.getParent() != null)) {
        ((ViewGroup)this.b.getParent()).removeView(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.cameraextend.FrontFlashImpl
 * JD-Core Version:    0.7.0.1
 */