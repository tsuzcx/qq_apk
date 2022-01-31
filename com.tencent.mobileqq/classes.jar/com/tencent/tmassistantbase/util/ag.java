package com.tencent.tmassistantbase.util;

import android.util.Log;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

final class ag
  extends Thread
{
  public void run()
  {
    try
    {
      for (;;)
      {
        String str = (String)ac.j.take();
        if (str != null) {
          ac.b(str);
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Log.d("TMLog", "write log file error." + localInterruptedException);
      }
    }
    catch (Throwable localThrowable1)
    {
      if (((localThrowable1 instanceof IOException)) && (localThrowable1.getMessage().contains("ENOSPC")))
      {
        if (ac.s.compareAndSet(false, true)) {
          localThrowable1.printStackTrace();
        }
        return;
      }
      ac.s.compareAndSet(true, false);
      localThrowable1.printStackTrace();
      try
      {
        ac.k();
        return;
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.ag
 * JD-Core Version:    0.7.0.1
 */