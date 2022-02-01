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
    QLog.d("MSF.C.DeepSleepDetector", 1, "[reset] startTime = 0, count = 0.");
  }
  
  private void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAppBackground setStartTime ");
    localStringBuilder.append(paramLong);
    QLog.d("MSF.C.DeepSleepDetector", 1, localStringBuilder.toString());
    this.a = paramLong;
  }
  
  private boolean a(boolean paramBoolean)
  {
    int i = i.a().l() * 1000;
    long l1 = this.a;
    boolean bool = false;
    if (l1 > 0L) {
      if ((i.a().j()) && ("huawei".equalsIgnoreCase(Build.MANUFACTURER)))
      {
        l1 = SystemClock.elapsedRealtime() - this.a;
        long l2 = (this.b - 1) * i;
        if (Math.abs(l1 - l2) > i) {
          bool = true;
        } else {
          bool = false;
        }
        QLog.d("MSF.C.DeepSleepDetector", 1, new Object[] { "[hasInDeepSleep] result: ", Boolean.valueOf(bool), ", bgTime: ", Long.valueOf(l1), ", countTime: ", Long.valueOf(l2), ", interval: ", Integer.valueOf(i) });
      }
      else
      {
        l1 = SystemClock.elapsedRealtime() - this.a;
        if (Math.abs((int)(l1 / i) + 1 - this.b) > 1) {
          bool = true;
        } else {
          bool = false;
        }
        QLog.d("MSF.C.DeepSleepDetector", 1, new Object[] { "[hasInDeepSleep] result: ", Boolean.valueOf(bool), ", bgTime: ", Long.valueOf(l1), ", mCount: ", Integer.valueOf(this.b), ", interval: ", Integer.valueOf(i) });
      }
    }
    if ((bool) && (paramBoolean)) {
      a();
    }
    return bool;
  }
  
  public void run()
  {
    this.b += 1;
    a.a(this.c).postDelayed(this, i.a().l() * 1000);
    QLog.d("MSF.C.DeepSleepDetector", 1, new Object[] { "[run] count after++: ", Integer.valueOf(this.b) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.a.a
 * JD-Core Version:    0.7.0.1
 */