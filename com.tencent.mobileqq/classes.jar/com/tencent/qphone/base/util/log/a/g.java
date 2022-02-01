package com.tencent.qphone.base.util.log.a;

import com.tencent.mobileqq.msf.core.c.d;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Calendar;

final class g
  extends Thread
{
  public void run()
  {
    File localFile = new File(QLog.getLogPath());
    try
    {
      b.i();
    }
    catch (Throwable localThrowable2)
    {
      localThrowable2.printStackTrace();
      QLog.e(b.f, 1, "run: failed. ", localThrowable2);
    }
    try
    {
      boolean bool = b.b(localFile);
      if (bool) {
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      localThrowable1.printStackTrace();
      QLog.e(b.f, 1, "run: failed. ", localThrowable1);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(6, localCalendar.get(6) - 7);
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      d.b(localCalendar.getTimeInMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.a.g
 * JD-Core Version:    0.7.0.1
 */