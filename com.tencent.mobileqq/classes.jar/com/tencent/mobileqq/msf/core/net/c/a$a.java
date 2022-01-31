package com.tencent.mobileqq.msf.core.net.c;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

class a$a
  implements Runnable
{
  long a;
  int b;
  
  a$a(a parama) {}
  
  private void a()
  {
    this.a = 0L;
    this.b = 0;
  }
  
  private void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeepSleepDetector", 2, "onAppBackground setStartTime " + paramLong);
    }
    this.a = paramLong;
  }
  
  private boolean b()
  {
    boolean bool = true;
    if (this.a > 0L) {
      if (Math.abs((int)((SystemClock.elapsedRealtime() - this.a) / 120000L) + 1 - this.b) <= 1) {}
    }
    for (;;)
    {
      if (bool) {
        a();
      }
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public void run()
  {
    this.b += 1;
    a.a(this.c).postDelayed(this, 120000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.a.a
 * JD-Core Version:    0.7.0.1
 */