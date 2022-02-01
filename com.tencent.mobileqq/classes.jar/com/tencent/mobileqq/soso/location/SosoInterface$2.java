package com.tencent.mobileqq.soso.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

final class SosoInterface$2
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_ON"))
    {
      SosoInterface.access$302(true);
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS", 2, "onReceive action is screen on.");
      }
    }
    else if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
    {
      SosoInterface.access$302(false);
      SosoInterface.access$200().sendEmptyMessage(1002);
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS", 2, "onReceive action is screen off.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.SosoInterface.2
 * JD-Core Version:    0.7.0.1
 */