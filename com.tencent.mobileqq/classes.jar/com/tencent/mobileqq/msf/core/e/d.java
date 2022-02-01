package com.tencent.mobileqq.msf.core.e;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class d
  implements Runnable
{
  d(a parama) {}
  
  public void run()
  {
    if (!a.e(this.a))
    {
      a.f(this.a).sendEmptyMessageDelayed(10001, com.tencent.mobileqq.msf.core.a.a.o());
      return;
    }
    QLog.d("StandbyModeManager", 1, "stop try start standby by lockScreenMsg ON when screenoff");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.e.d
 * JD-Core Version:    0.7.0.1
 */