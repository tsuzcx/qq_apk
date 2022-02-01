package com.tencent.mobileqq.search.base.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BaseSearchActivity$CancelReceiver
  extends BroadcastReceiver
{
  public BaseSearchActivity$CancelReceiver(BaseSearchActivity paramBaseSearchActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.search.cancel".equals(paramIntent.getAction())) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.activity.BaseSearchActivity.CancelReceiver
 * JD-Core Version:    0.7.0.1
 */