package com.tencent.mobileqq.olympic.activity;

import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

class ScanTorchActivity$3
  extends QQBroadcastReceiver
{
  ScanTorchActivity$3(ScanTorchActivity paramScanTorchActivity) {}
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramAppRuntime = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, new Object[] { "onReceive, action=", paramAppRuntime });
    }
    if ("com.tencent.mobileqq__alive".equals(paramAppRuntime)) {
      ScanTorchActivity.access$008(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ScanTorchActivity.3
 * JD-Core Version:    0.7.0.1
 */