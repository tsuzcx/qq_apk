package com.tencent.viola.utils;

import android.app.Activity;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings.System;

class ViolaBrightnessController$1
  extends ContentObserver
{
  ViolaBrightnessController$1(ViolaBrightnessController paramViolaBrightnessController, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    super.onChange(paramBoolean, paramUri);
    int i = Settings.System.getInt(ViolaBrightnessController.access$000(this.this$0).getContentResolver(), "screen_brightness", 125);
    if ((ViolaBrightnessController.access$100(this.this$0) != null) && (i > 0)) {
      ViolaBrightnessController.access$100(this.this$0).onChange(i / 255.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.viola.utils.ViolaBrightnessController.1
 * JD-Core Version:    0.7.0.1
 */