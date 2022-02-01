package com.tencent.tmassistantbase.util;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class ae
  extends Thread
{
  ae(ad paramad, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    int i = 0;
    if ((ab.g()) && (ab.t.compareAndSet(false, true))) {
      try
      {
        ab.j();
        try
        {
          ab.o = ab.h.getPackageName();
          ab.j = new LinkedBlockingQueue(15000);
          ab.n = Process.myPid();
          Log.d("TMLog", "TMLog init start ");
          ab.k();
          ab.y.setName("logWriteThread");
          ab.y.start();
          ab.w.removeCallbacks(ab.x);
          return;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ab.o = "unknow";
          }
        }
        int j;
        return;
      }
      catch (Exception localException2)
      {
        ab.t.set(false);
        localException2.printStackTrace();
        j = ab.v.get();
        Log.d("TMLog", "TMLog init post retry " + j + " times, interval " + ab.u[j]);
        ab.w.removeCallbacks(ab.x);
        ab.w.postDelayed(ab.x, ab.u[j] * 60000);
        j += 1;
        if (j >= ab.u.length) {}
        for (;;)
        {
          ab.v.set(i);
          return;
          i = j;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.ae
 * JD-Core Version:    0.7.0.1
 */