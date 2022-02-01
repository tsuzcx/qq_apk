package com.tencent.mobileqq.emosm.web;

import android.os.Handler;
import android.os.HandlerThread;

public class EmojiIPCAlarmer
{
  EmojiIPCAlarmer.TimeoutObserver a;
  private volatile Handler b;
  
  public EmojiIPCAlarmer(EmojiIPCAlarmer.TimeoutObserver paramTimeoutObserver)
  {
    this.a = paramTimeoutObserver;
  }
  
  public Runnable a(int paramInt, long paramLong)
  {
    EmojiIPCAlarmer.TimeoutTaskWrapper localTimeoutTaskWrapper = new EmojiIPCAlarmer.TimeoutTaskWrapper(this, paramInt);
    this.b.postDelayed(localTimeoutTaskWrapper, paramLong);
    return localTimeoutTaskWrapper;
  }
  
  public void a()
  {
    HandlerThread localHandlerThread = new HandlerThread("EmojiIPCTimeoutChecker", 5);
    localHandlerThread.start();
    this.b = new Handler(localHandlerThread.getLooper());
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.b.removeCallbacks(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.EmojiIPCAlarmer
 * JD-Core Version:    0.7.0.1
 */