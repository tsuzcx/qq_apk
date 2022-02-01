package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

class s$b
  extends BroadcastReceiver
{
  private s$b(s params) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.NetCenterNewImpl", 2, "idleChaned receive broadcast intent == null return");
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("idleChaned receive broadcast ");
    localStringBuilder.append(paramIntent);
    QLog.d("MSF.D.NetCenterNewImpl", 1, localStringBuilder.toString());
    if (paramIntent.getAction() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.NetCenterNewImpl", 2, "idleChaned receive broadcast intent.getAction() == null return");
      }
      return;
    }
    if (paramIntent.getAction().equals("android.os.action.DEVICE_IDLE_MODE_CHANGED"))
    {
      if (Build.VERSION.SDK_INT >= 23) {
        this.a.b(paramContext);
      }
      s.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.s.b
 * JD-Core Version:    0.7.0.1
 */