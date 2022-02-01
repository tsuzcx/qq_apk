package com.tencent.rlottie.decoder;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.concurrent.CountDownLatch;

class DispatchQueue
  extends Thread
{
  public static volatile Handler a;
  private volatile Handler b = null;
  private CountDownLatch c = new CountDownLatch(1);
  private long d;
  
  public DispatchQueue(String paramString)
  {
    this(paramString, true);
  }
  
  public DispatchQueue(String paramString, boolean paramBoolean)
  {
    setName(paramString);
    if (paramBoolean) {
      start();
    }
  }
  
  public static void a(Runnable paramRunnable)
  {
    a(paramRunnable, 0L);
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    if (a == null) {
      a = new Handler(Looper.getMainLooper());
    }
    if (paramLong == 0L)
    {
      a.post(paramRunnable);
      return;
    }
    a.postDelayed(paramRunnable, paramLong);
  }
  
  public long a()
  {
    return this.d;
  }
  
  public void b()
  {
    this.b.getLooper().quit();
  }
  
  public boolean b(Runnable paramRunnable)
  {
    this.d = SystemClock.elapsedRealtime();
    return b(paramRunnable, 0L);
  }
  
  public boolean b(Runnable paramRunnable, long paramLong)
  {
    try
    {
      this.c.await();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (paramLong <= 0L) {
      return this.b.post(paramRunnable);
    }
    return this.b.postDelayed(paramRunnable, paramLong);
  }
  
  public void run()
  {
    Looper.prepare();
    this.b = new Handler();
    this.c.countDown();
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rlottie.decoder.DispatchQueue
 * JD-Core Version:    0.7.0.1
 */