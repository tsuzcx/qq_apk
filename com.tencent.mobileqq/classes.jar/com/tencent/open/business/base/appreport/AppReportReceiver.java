package com.tencent.open.business.base.appreport;

import alfu;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;

public class AppReportReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ThreadManager.executeOnSubThread(new alfu(this, paramIntent, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppReportReceiver
 * JD-Core Version:    0.7.0.1
 */