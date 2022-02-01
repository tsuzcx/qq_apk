package com.tencent.mobileqq.mediabrowser.impl;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class MediaBrowserActivity$ScreenBroadcastReceiver
  extends BroadcastReceiver
{
  Activity jdField_a_of_type_AndroidAppActivity;
  boolean jdField_a_of_type_Boolean = true;
  
  MediaBrowserActivity$ScreenBroadcastReceiver(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(paramIntent)) {
      this.jdField_a_of_type_Boolean = (a(paramContext) ^ true);
    } else if ("android.intent.action.SCREEN_OFF".equals(paramIntent)) {
      this.jdField_a_of_type_Boolean = false;
    } else if ("android.intent.action.USER_PRESENT".equals(paramIntent)) {
      this.jdField_a_of_type_Boolean = true;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this);
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mediabrowser.impl.MediaBrowserActivity.ScreenBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */