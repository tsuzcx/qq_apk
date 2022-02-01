package com.tencent.mobileqq.kandian.biz.video.playfeeds.entity;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public class VideoBrightnessController
{
  private boolean a = false;
  private boolean b = false;
  private Activity c;
  private ContentObserver d = new VideoBrightnessController.1(this, new Handler());
  
  public VideoBrightnessController(Activity paramActivity)
  {
    this.c = paramActivity;
  }
  
  private void e()
  {
    if (!this.b)
    {
      this.b = true;
      this.c.getContentResolver().registerContentObserver(Settings.System.getUriFor("screen_brightness"), true, this.d);
    }
  }
  
  private void f()
  {
    if (this.b)
    {
      this.b = false;
      this.c.getContentResolver().unregisterContentObserver(this.d);
    }
  }
  
  public void a()
  {
    if (this.a)
    {
      this.a = false;
      WindowManager.LayoutParams localLayoutParams = this.c.getWindow().getAttributes();
      localLayoutParams.screenBrightness = -1.0F;
      this.c.getWindow().setAttributes(localLayoutParams);
    }
  }
  
  public void a(float paramFloat)
  {
    e();
    this.a = true;
    WindowManager.LayoutParams localLayoutParams = this.c.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.c.getWindow().setAttributes(localLayoutParams);
  }
  
  public boolean b()
  {
    ContentResolver localContentResolver = this.c.getContentResolver();
    try
    {
      int i = Settings.System.getInt(localContentResolver, "screen_brightness_mode");
      if (i == 1) {
        return true;
      }
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException)
    {
      localSettingNotFoundException.printStackTrace();
    }
    return false;
  }
  
  public int c()
  {
    ContentResolver localContentResolver = this.c.getContentResolver();
    try
    {
      int i = Settings.System.getInt(localContentResolver, "screen_brightness");
      return i;
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException)
    {
      label17:
      break label17;
    }
    return 0;
  }
  
  public void d()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoBrightnessController
 * JD-Core Version:    0.7.0.1
 */