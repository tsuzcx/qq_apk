package com.tencent.mobileqq.msf.core.net.c;

import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.i;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAppBackground setStartTime ");
      localStringBuilder.append(paramLong);
      QLog.d("MSF.C.DeepSleepDetector", 2, localStringBuilder.toString());
    }
    this.a = paramLong;
  }
  
  private boolean a(boolean paramBoolean)
  {
    long l = this.a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (l > 0L) {
      if ((i.a().h()) && ("huawei".equalsIgnoreCase(Build.MANUFACTURER)))
      {
        bool1 = bool2;
        if (Math.abs(SystemClock.elapsedRealtime() - this.a - (this.b - 1) * 120000) <= 120000L) {}
      }
      else
      {
        do
        {
          bool1 = true;
          break;
          bool1 = bool2;
        } while (Math.abs((int)((SystemClock.elapsedRealtime() - this.a) / 120000L) + 1 - this.b) > 1);
      }
    }
    if ((bool1) && (paramBoolean)) {
      a();
    }
    return bool1;
  }
  
  public void run()
  {
    this.b += 1;
    a.a(this.c).postDelayed(this, 120000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.a.a
 * JD-Core Version:    0.7.0.1
 */