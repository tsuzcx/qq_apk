package com.tencent.mobileqq.mini.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

public class AppUIProxy$AppBrandCommonReceiver
  extends BroadcastReceiver
{
  public AppUIProxy$AppBrandCommonReceiver(AppUIProxy paramAppUIProxy) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    QLog.i("miniapp-start_AppUIProxy", 1, "AppBrandCommonReceiver onReceive action:" + paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppUIProxy.AppBrandCommonReceiver
 * JD-Core Version:    0.7.0.1
 */