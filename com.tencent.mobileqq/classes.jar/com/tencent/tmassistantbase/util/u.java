package com.tencent.tmassistantbase.util;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class u
  extends Thread
{
  u(t paramt, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    int i = 0;
    if ((r.g()) && (r.t.compareAndSet(false, true))) {
      try
      {
        r.j();
        try
        {
          r.o = r.h.getPackageName();
          r.j = new LinkedBlockingQueue(15000);
          r.n = Process.myPid();
          Log.d("TMLog", "TMLog init start ");
          r.k();
          r.y.setName("logWriteThread");
          r.y.start();
          r.w.removeCallbacks(r.x);
          return;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            r.o = "unknow";
          }
        }
        int j;
        return;
      }
      catch (Exception localException2)
      {
        r.t.set(false);
        localException2.printStackTrace();
        j = r.v.get();
        Log.d("TMLog", "TMLog init post retry " + j + " times, interval " + r.u[j]);
        r.w.removeCallbacks(r.x);
        r.w.postDelayed(r.x, r.u[j] * 60000);
        j += 1;
        if (j >= r.u.length) {}
        for (;;)
        {
          r.v.set(i);
          return;
          i = j;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.u
 * JD-Core Version:    0.7.0.1
 */