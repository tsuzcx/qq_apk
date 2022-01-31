package com.tencent.mobileqq.msf.service;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.qphone.base.util.QLog;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

class e
{
  public static int a = 8;
  public static int b = 22;
  public static String c = "MSFAliveManager";
  public static boolean d;
  
  public static long a(long paramLong)
  {
    return TimeUnit.MILLISECONDS.toDays(TimeZone.getDefault().getRawOffset() + paramLong);
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 1, "onMSFServiceDestroy");
    }
    a.c();
  }
  
  public static void a(j paramj, boolean paramBoolean)
  {
    d = paramBoolean;
    long l3 = System.currentTimeMillis();
    long l4 = SystemClock.elapsedRealtime();
    long l1 = System.currentTimeMillis();
    long l2 = b(l1);
    if (QLog.isColorLevel()) {
      QLog.d(c, 1, "MSFAliveRecorder onMSFServiceBegin " + l1);
    }
    a.a();
    if ((a.d <= 0L) || (Math.abs(a.d - (l3 - l4)) > 10000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d(c, 1, "reboot or bad data " + a.d);
      }
      a.b();
    }
    label331:
    for (;;)
    {
      if (l2 < a) {
        a.b();
      }
      if (l2 <= b) {
        a.a(paramj);
      }
      return;
      l3 = a(a.c);
      l4 = a(l1);
      if (l3 != l4)
      {
        if (QLog.isColorLevel()) {
          QLog.d(c, 1, "not same day report " + l3 + " " + l4);
        }
        a.b(paramj);
      }
      for (;;)
      {
        if (l2 <= b) {
          break label331;
        }
        a.b(paramj);
        break;
        if (QLog.isColorLevel()) {
          QLog.d(c, 1, "fix data " + a.p + " " + a.c);
        }
        if ((l1 <= a.c) || (l1 - a.c > 39600000L))
        {
          a.b();
        }
        else
        {
          if (!a.p) {
            a.o += l1 - a.c;
          }
          a.c = l1;
        }
      }
    }
  }
  
  public static long b(long paramLong)
  {
    return TimeUnit.MILLISECONDS.toHours(TimeZone.getDefault().getRawOffset() + paramLong) % 24L;
  }
  
  public static void b()
  {
    d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.e
 * JD-Core Version:    0.7.0.1
 */