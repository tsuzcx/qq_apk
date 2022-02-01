package com.tencent.mobileqq.nearby;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import axqc;
import com.tencent.mobileqq.olympic.ScannerResultReceiver;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

public class NearbyReceiver
  extends QQBroadcastReceiver
{
  public String getModuleId()
  {
    return "module_nearby";
  }
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramIntent.setExtrasClassLoader(ScannerResultReceiver.class.getClassLoader());
      if ((paramAppRuntime != null) && ((paramAppRuntime instanceof NearbyAppInterface)))
      {
        paramContext = (ResultReceiver)paramIntent.getParcelableExtra("resultreceiver_nearbyfakeactivity");
        if (paramContext != null) {
          paramContext.send(0, new Bundle());
        }
        int i = paramIntent.getIntExtra("nearby_preload_from", 0);
        axqc.c(paramAppRuntime.getAccount());
        ((NearbyAppInterface)paramAppRuntime).a(1, i);
      }
    } while (!QLog.isColorLevel());
    QLog.d("NearbyReceiver", 2, "PRELOAD_NEARBY_PROCESS, " + paramAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyReceiver
 * JD-Core Version:    0.7.0.1
 */