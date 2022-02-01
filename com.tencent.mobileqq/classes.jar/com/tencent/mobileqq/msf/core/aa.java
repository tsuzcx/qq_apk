package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import com.tencent.qphone.base.util.QLog;

final class aa
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.ACTION_SHUTDOWN"))
    {
      try
      {
        u.a(u.Q);
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
      paramContext.append(u.M);
      QLog.i("health_manager", 1, paramContext.toString());
      if (!u.M) {
        return;
      }
      if ((u.L != null) && (u.al != null)) {
        try
        {
          u.L.flush(u.al);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.aa
 * JD-Core Version:    0.7.0.1
 */