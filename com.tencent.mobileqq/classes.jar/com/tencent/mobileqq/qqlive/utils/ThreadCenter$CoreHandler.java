package com.tencent.mobileqq.qqlive.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;

public class ThreadCenter$CoreHandler
{
  long a = 0L;
  Handler b;
  HandlerThread c;
  boolean d = true;
  
  ThreadCenter$CoreHandler(String paramString)
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
  
  boolean a()
  {
    return (this.d) && (System.currentTimeMillis() - this.a > 300000L);
  }
  
  public Handler b()
  {
    this.d = false;
    return this.b;
  }
  
  void c()
  {
    if (this.c.isAlive()) {
      this.c.quit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.utils.ThreadCenter.CoreHandler
 * JD-Core Version:    0.7.0.1
 */