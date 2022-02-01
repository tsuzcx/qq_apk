package com.tencent.mobileqq.kandian.biz.video.playfeeds.entity;

import android.app.Activity;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings.System;

class VideoBrightnessController$1
  extends ContentObserver
{
  VideoBrightnessController$1(VideoBrightnessController paramVideoBrightnessController, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    super.onChange(paramBoolean, paramUri);
    int i = Settings.System.getInt(VideoBrightnessController.a(this.a).getContentResolver(), "screen_brightness", 125);
    if ((VideoBrightnessController.b(this.a)) && (i > 0)) {
      this.a.a(i / 255.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoBrightnessController.1
 * JD-Core Version:    0.7.0.1
 */