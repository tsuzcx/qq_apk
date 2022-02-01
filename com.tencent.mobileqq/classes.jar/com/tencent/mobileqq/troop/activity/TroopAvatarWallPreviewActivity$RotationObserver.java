package com.tencent.mobileqq.troop.activity;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings.System;

class TroopAvatarWallPreviewActivity$RotationObserver
  extends ContentObserver
{
  private ContentResolver b;
  
  public TroopAvatarWallPreviewActivity$RotationObserver(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, Handler paramHandler)
  {
    super(paramHandler);
    this.b = paramTroopAvatarWallPreviewActivity.getContentResolver();
  }
  
  public void a()
  {
    this.b.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this);
  }
  
  public void b()
  {
    this.b.unregisterContentObserver(this);
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if (Settings.System.getInt(this.a.getContentResolver(), "accelerometer_rotation", -1) == 1)
    {
      this.a.setRequestedOrientation(4);
      return;
    }
    this.a.setRequestedOrientation(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.RotationObserver
 * JD-Core Version:    0.7.0.1
 */