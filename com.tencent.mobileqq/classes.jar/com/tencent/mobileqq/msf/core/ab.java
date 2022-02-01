package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import com.tencent.qphone.base.util.QLog;

final class ab
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.ACTION_SHUTDOWN"))
    {
      try
      {
        v.a(v.Q);
        return;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      paramIntent = new StringBuilder();
      paramIntent.append("setTodayOffSet Exception:");
      paramIntent.append(paramContext.toString());
      QLog.e("health_manager", 2, paramIntent.toString());
    }
    else if (paramIntent.getAction().equals("MSF_Action_Refresh_Steps"))
    {
      paramContext = new StringBuilder();
      paramContext.append("AlarmManager 23:59 action received:");
      paramContext.append(v.M);
      QLog.i("health_manager", 1, paramContext.toString());
      if (!v.M) {
        return;
      }
      if ((v.L != null) && (v.al != null)) {
        try
        {
          v.L.flush(v.al);
          return;
        }
        catch (Exception paramContext)
        {
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("Exception:");
            paramIntent.append(paramContext.toString());
            QLog.e("health_manager", 2, paramIntent.toString());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ab
 * JD-Core Version:    0.7.0.1
 */