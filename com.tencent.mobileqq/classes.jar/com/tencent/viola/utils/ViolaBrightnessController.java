package com.tencent.viola.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public class ViolaBrightnessController
{
  private ContentObserver brightnessObserver = new ViolaBrightnessController.1(this, new Handler());
  private boolean hasRegisterBrightnessObserver = false;
  private Activity mActivity;
  private boolean mHasSetCustomBrightness = false;
  private ViolaBrightnessController.OnBrightNessChangeListener mOnBrightNessChangeListener;
  
  public ViolaBrightnessController(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  private void registerBrightObserver()
  {
    if (!this.hasRegisterBrightnessObserver)
    {
      this.hasRegisterBrightnessObserver = true;
      this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("screen_brightness"), true, this.brightnessObserver);
    }
  }
  
  private void unregisterBrightObserver()
  {
    if (this.hasRegisterBrightnessObserver)
    {
      this.hasRegisterBrightnessObserver = false;
      this.mActivity.getContentResolver().unregisterContentObserver(this.brightnessObserver);
    }
  }
  
  public void doOnDestory()
  {
    unregisterBrightObserver();
  }
  
  public ViolaBrightnessController.OnBrightNessChangeListener getOnBrightNessChangeListener()
  {
    return this.mOnBrightNessChangeListener;
  }
  
  public float getScreenBrightness()
  {
    int i = 0;
    ContentResolver localContentResolver = this.mActivity.getContentResolver();
    try
    {
      int j = Settings.System.getInt(localContentResolver, "screen_brightness");
      i = j;
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException)
    {
      label19:
      break label19;
    }
    return i / 255.0F;
  }
  
  public boolean isAutoBrightness()
  {
    ContentResolver localContentResolver = this.mActivity.getContentResolver();
    try
    {
      int i = Settings.System.getInt(localContentResolver, "screen_brightness_mode");
      return i == 1;
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException)
    {
      localSettingNotFoundException.printStackTrace();
    }
    return false;
  }
  
  public void recoveryScreenBrightness()
  {
    if (this.mHasSetCustomBrightness)
    {
      this.mHasSetCustomBrightness = false;
      WindowManager.LayoutParams localLayoutParams = this.mActivity.getWindow().getAttributes();
      localLayoutParams.screenBrightness = -1.0F;
      this.mActivity.getWindow().setAttributes(localLayoutParams);
    }
  }
  
  public void setOnBrightNessChangeListener(ViolaBrightnessController.OnBrightNessChangeListener paramOnBrightNessChangeListener)
  {
    this.mOnBrightNessChangeListener = paramOnBrightNessChangeListener;
  }
  
  public void setScreenBrightness(float paramFloat)
  {
    registerBrightObserver();
    this.mHasSetCustomBrightness = true;
    WindowManager.LayoutParams localLayoutParams = this.mActivity.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.mActivity.getWindow().setAttributes(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.utils.ViolaBrightnessController
 * JD-Core Version:    0.7.0.1
 */