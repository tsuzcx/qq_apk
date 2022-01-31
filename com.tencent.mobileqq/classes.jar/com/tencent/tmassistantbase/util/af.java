package com.tencent.tmassistantbase.util;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class af
  extends Thread
{
  af(ae paramae, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    int i = 0;
    if ((ac.g()) && (ac.t.compareAndSet(false, true))) {
      try
      {
        ac.j();
        try
        {
          ac.o = ac.h.getPackageName();
          ac.j = new LinkedBlockingQueue(15000);
          ac.n = Process.myPid();
          Log.d("TMLog", "TMLog init start ");
          ac.k();
          ac.y.setName("logWriteThread");
          ac.y.start();
          ac.w.removeCallbacks(ac.x);
          return;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ac.o = "unknow";
          }
        }
        int j;
        return;
      }
      catch (Exception localException2)
      {
        ac.t.set(false);
        localException2.printStackTrace();
        j = ac.v.get();
        Log.d("TMLog", "TMLog init post retry " + j + " times, interval " + ac.u[j]);
        ac.w.removeCallbacks(ac.x);
        ac.w.postDelayed(ac.x, ac.u[j] * 60000);
        j += 1;
        if (j >= ac.u.length) {}
        for (;;)
        {
          ac.v.set(i);
          return;
          i = j;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.af
 * JD-Core Version:    0.7.0.1
 */