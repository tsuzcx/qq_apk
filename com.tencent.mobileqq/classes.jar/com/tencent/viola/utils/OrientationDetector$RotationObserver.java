package com.tencent.viola.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings.System;

class OrientationDetector$RotationObserver
  extends ContentObserver
{
  public OrientationDetector$RotationObserver(OrientationDetector paramOrientationDetector, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public ContentResolver getContentResolver()
  {
    if (this.this$0.getContext() != null) {
      return this.this$0.getContext().getContentResolver();
    }
    return null;
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if (this.this$0.getContext() == null) {
      return;
    }
    int i = Settings.System.getInt(this.this$0.getContext().getContentResolver(), "accelerometer_rotation", -1);
    if (i == 1)
    {
      OrientationDetector.access$002(this.this$0, true);
      this.this$0.enable(true);
    }
    for (;;)
    {
      ViolaLogUtils.d("OrientationDetector", "RotationObserver.onChange() : rotateState=" + i);
      return;
      OrientationDetector.access$002(this.this$0, false);
      this.this$0.enable(false);
    }
  }
  
  public void registerObserver()
  {
    if (getContentResolver() != null) {
      getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this);
    }
  }
  
  public void unregisterObserver()
  {
    if (getContentResolver() != null) {
      getContentResolver().unregisterContentObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.utils.OrientationDetector.RotationObserver
 * JD-Core Version:    0.7.0.1
 */