package com.tencent.mobileqq.msf.core;

import com.tencent.mobileqq.msf.core.c.e;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Calendar;

final class n
  extends Thread
{
  public void run()
  {
    File localFile = new File(QLog.getLogPath());
    try
    {
      i.j();
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        try
        {
          boolean bool = i.b(localFile);
          if (!bool) {
            continue;
          }
          return;
        }
        catch (Throwable localThrowable1)
        {
          localThrowable1.printStackTrace();
          QLog.e(i.b, 1, "run: failed. ", localThrowable1);
          Calendar localCalendar = Calendar.getInstance();
          localCalendar.set(6, localCalendar.get(6) - 7);
          localCalendar.set(11, 0);
          localCalendar.set(12, 0);
          localCalendar.set(13, 0);
          localCalendar.set(14, 0);
          e.b(localCalendar.getTimeInMillis());
        }
        localThrowable2 = localThrowable2;
        localThrowable2.printStackTrace();
        QLog.e(i.b, 1, "run: failed. ", localThrowable2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.n
 * JD-Core Version:    0.7.0.1
 */