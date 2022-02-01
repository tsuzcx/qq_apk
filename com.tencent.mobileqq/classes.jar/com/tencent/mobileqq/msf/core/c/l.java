package com.tencent.mobileqq.msf.core.c;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

final class l
  extends Thread
{
  long a = 0L;
  long b = 0L;
  final long c = 5000L;
  final long d = 1000L;
  
  l(String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    for (;;)
    {
      this.a = SystemClock.elapsedRealtime();
      synchronized (k.n())
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.StatReport", 2, "try wait to report");
          }
          k.n().wait(5000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
        this.b = SystemClock.elapsedRealtime();
        if (this.b - this.a <= 6000L) {
          break label241;
        }
        ??? = k.o().entrySet().iterator();
        for (;;)
        {
          if (((Iterator)???).hasNext()) {
            try
            {
              Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
              if ((localEntry != null) && (this.b - ((Long)localEntry.getKey()).longValue() > k.p())) {
                ((Iterator)???).remove();
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
      }
      k.o().put(Long.valueOf(this.a), Long.valueOf(this.b));
      k.b(true);
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.StatReport", 2, "find deep sleep. currTime:" + this.b + ", lastTime:" + this.a + ", sleep:" + (this.b - this.a));
        continue;
        label241:
        k.b(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.l
 * JD-Core Version:    0.7.0.1
 */