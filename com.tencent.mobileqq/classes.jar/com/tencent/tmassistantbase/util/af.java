package com.tencent.tmassistantbase.util;

import android.util.Log;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

final class af
  extends Thread
{
  public void run()
  {
    try
    {
      StringBuilder localStringBuilder;
      for (;;)
      {
        String str = (String)ab.j.take();
        if (str != null) {
          ab.b(str);
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      if (((localThrowable1 instanceof IOException)) && (localThrowable1.getMessage().contains("ENOSPC")))
      {
        if (ab.s.compareAndSet(false, true)) {
          localThrowable1.printStackTrace();
        }
      }
      else
      {
        ab.s.compareAndSet(true, false);
        localThrowable1.printStackTrace();
        try
        {
          ab.k();
          return;
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
        }
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("write log file error.");
      localStringBuilder.append(localInterruptedException);
      Log.d("TMLog", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.af
 * JD-Core Version:    0.7.0.1
 */