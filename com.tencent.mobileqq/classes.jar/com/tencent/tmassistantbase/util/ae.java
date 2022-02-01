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
    if ((ab.g()) && (ab.t.compareAndSet(false, true))) {
      try
      {
        ab.j();
      }
      catch (Exception localException1)
      {
        label32:
        ab.t.set(false);
        localException1.printStackTrace();
        int i = ab.v.get();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("TMLog init post retry ");
        localStringBuilder.append(i);
        localStringBuilder.append(" times, interval ");
        localStringBuilder.append(ab.u[i]);
        Log.d("TMLog", localStringBuilder.toString());
        ab.w.removeCallbacks(ab.x);
        ab.w.postDelayed(ab.x, ab.u[i] * 60000);
        int j = i + 1;
        i = j;
        if (j >= ab.u.length) {
          i = 0;
        }
        ab.v.set(i);
      }
    }
    try
    {
      ab.o = ab.h.getPackageName();
    }
    catch (Exception localException2)
    {
      break label32;
    }
    ab.o = "unknow";
    ab.j = new LinkedBlockingQueue(15000);
    ab.n = Process.myPid();
    Log.d("TMLog", "TMLog init start ");
    ab.k();
    ab.y.setName("logWriteThread");
    ab.y.start();
    ab.w.removeCallbacks(ab.x);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.ae
 * JD-Core Version:    0.7.0.1
 */