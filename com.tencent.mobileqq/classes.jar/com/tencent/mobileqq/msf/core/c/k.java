package com.tencent.mobileqq.msf.core.c;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

final class k
  extends Thread
{
  long a = 0L;
  long b = 0L;
  final long c = 5000L;
  final long d = 1000L;
  
  k(String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    for (;;)
    {
      this.a = SystemClock.elapsedRealtime();
      try
      {
        sleep(5000L);
        label13:
        this.b = SystemClock.elapsedRealtime();
        if (this.b - this.a > 6000L)
        {
          Iterator localIterator = j.k().entrySet().iterator();
          while (localIterator.hasNext()) {
            try
            {
              Map.Entry localEntry = (Map.Entry)localIterator.next();
              if ((localEntry != null) && (this.b - ((Long)localEntry.getKey()).longValue() > j.l())) {
                localIterator.remove();
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
          j.k().put(Long.valueOf(this.a), Long.valueOf(this.b));
          j.b(true);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("MSF.C.StatReport", 2, "find deep sleep. currTime:" + this.b + ", lastTime:" + this.a + ", sleep:" + (this.b - this.a));
          continue;
        }
        j.b(false);
      }
      catch (InterruptedException localInterruptedException)
      {
        break label13;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.k
 * JD-Core Version:    0.7.0.1
 */