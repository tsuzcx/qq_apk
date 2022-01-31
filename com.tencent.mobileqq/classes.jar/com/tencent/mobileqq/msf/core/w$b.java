package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

class w$b
  extends BroadcastReceiver
{
  private w$b(w paramw) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.NetCenterNewImpl", 2, "idleChaned receive broadcast intent == null return");
      }
    }
    do
    {
      do
      {
        return;
        QLog.d("MSF.D.NetCenterNewImpl", 1, "idleChaned receive broadcast " + paramIntent);
        if (paramIntent.getAction() != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MSF.D.NetCenterNewImpl", 2, "idleChaned receive broadcast intent.getAction() == null return");
      return;
    } while (!paramIntent.getAction().equals("android.os.action.DEVICE_IDLE_MODE_CHANGED"));
    if (Build.VERSION.SDK_INT >= 23) {
      this.a.b(paramContext);
    }
    w.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.w.b
 * JD-Core Version:    0.7.0.1
 */