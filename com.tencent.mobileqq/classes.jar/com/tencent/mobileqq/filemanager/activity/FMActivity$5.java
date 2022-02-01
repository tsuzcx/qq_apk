package com.tencent.mobileqq.filemanager.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class FMActivity$5
  extends BroadcastReceiver
{
  FMActivity$5(FMActivity paramFMActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.qlink.destory.fmactivity".equalsIgnoreCase(paramIntent.getAction()))
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMActivity.5
 * JD-Core Version:    0.7.0.1
 */