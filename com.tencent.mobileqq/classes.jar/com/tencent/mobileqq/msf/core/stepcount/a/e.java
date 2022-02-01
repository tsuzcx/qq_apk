package com.tencent.mobileqq.msf.core.stepcount.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.stepcount.c;
import com.tencent.qphone.base.util.QLog;

class e
  extends BroadcastReceiver
{
  e(b paramb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = NetConnInfoCenter.getServerTime();
    QLog.d("StepEventHandlerImpl", 1, "receive shut down broadcast");
    b.c(this.a);
    b.a(this.a).b(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.stepcount.a.e
 * JD-Core Version:    0.7.0.1
 */