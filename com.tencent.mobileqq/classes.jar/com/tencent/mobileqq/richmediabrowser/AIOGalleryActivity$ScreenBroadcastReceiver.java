package com.tencent.mobileqq.richmediabrowser;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class AIOGalleryActivity$ScreenBroadcastReceiver
  extends BroadcastReceiver
{
  Activity a;
  boolean b = true;
  
  AIOGalleryActivity$ScreenBroadcastReceiver(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(paramIntent)) {
      this.b = (a(paramContext) ^ true);
    } else if ("android.intent.action.SCREEN_OFF".equals(paramIntent)) {
      this.b = false;
    } else if ("android.intent.action.USER_PRESENT".equals(paramIntent)) {
      this.b = true;
    }
    if (!this.b)
    {
      this.a.unregisterReceiver(this);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.ScreenBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */