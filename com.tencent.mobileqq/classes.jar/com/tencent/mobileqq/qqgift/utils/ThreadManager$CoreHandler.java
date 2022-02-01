package com.tencent.mobileqq.qqgift.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;

public class ThreadManager$CoreHandler
{
  long a = 0L;
  Handler b;
  HandlerThread c;
  boolean d = true;
  
  ThreadManager$CoreHandler(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.c = new HandlerThread(paramString);
      this.c.start();
      this.b = new Handler(this.c.getLooper());
      return;
    }
    throw new RuntimeException("Handle ID empty!");
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    this.a = (System.currentTimeMillis() + paramLong);
    this.b.postDelayed(paramRunnable, paramLong);
  }
  
  public void a(Runnable paramRunnable, boolean paramBoolean)
  {
    this.a = System.currentTimeMillis();
    if (paramBoolean)
    {
      this.b.postAtFrontOfQueue(paramRunnable);
      return;
    }
    this.b.post(paramRunnable);
  }
  
  boolean a()
  {
    return (this.d) && (System.currentTimeMillis() - this.a > 300000L);
  }
  
  void b()
  {
    if (this.c.isAlive()) {
      this.c.quit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.utils.ThreadManager.CoreHandler
 * JD-Core Version:    0.7.0.1
 */