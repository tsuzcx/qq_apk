package com.tencent.mobileqq.msf.core.d;

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
        synchronized (j.n())
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.StatReport", 2, "try wait to report");
          }
          j.n().wait(5000L);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        this.b = SystemClock.elapsedRealtime();
        if (this.b - this.a > 6000L)
        {
          ??? = j.o().entrySet().iterator();
          while (((Iterator)???).hasNext()) {
            try
            {
              Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
              if ((localEntry != null) && (this.b - ((Long)localEntry.getKey()).longValue() > j.p())) {
                ((Iterator)???).remove();
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
          j.o().put(Long.valueOf(this.a), Long.valueOf(this.b));
          j.b(true);
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("find deep sleep. currTime:");
            ((StringBuilder)???).append(this.b);
            ((StringBuilder)???).append(", lastTime:");
            ((StringBuilder)???).append(this.a);
            ((StringBuilder)???).append(", sleep:");
            ((StringBuilder)???).append(this.b - this.a);
            QLog.d("MSF.C.StatReport", 2, ((StringBuilder)???).toString());
          }
        }
        else
        {
          j.b(false);
        }
      }
    }
    for (;;)
    {
      throw localException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d.k
 * JD-Core Version:    0.7.0.1
 */