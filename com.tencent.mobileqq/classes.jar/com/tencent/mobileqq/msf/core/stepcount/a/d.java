package com.tencent.mobileqq.msf.core.stepcount.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.stepcount.c;
import com.tencent.qphone.base.util.QLog;

class d
  extends BroadcastReceiver
{
  d(b paramb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StepEventHandlerImpl", 2, "receive alarm when enter a new day");
    }
    long l = NetConnInfoCenter.getServerTime();
    b.a(this.a).a(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.stepcount.a.d
 * JD-Core Version:    0.7.0.1
 */