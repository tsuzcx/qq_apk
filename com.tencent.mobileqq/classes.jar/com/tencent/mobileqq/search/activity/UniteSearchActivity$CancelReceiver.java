package com.tencent.mobileqq.search.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class UniteSearchActivity$CancelReceiver
  extends BroadcastReceiver
{
  public UniteSearchActivity$CancelReceiver(UniteSearchActivity paramUniteSearchActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.search.cancel".equals(paramIntent.getAction())) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.UniteSearchActivity.CancelReceiver
 * JD-Core Version:    0.7.0.1
 */