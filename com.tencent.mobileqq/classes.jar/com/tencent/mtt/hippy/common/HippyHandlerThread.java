package com.tencent.mtt.hippy.common;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;

public class HippyHandlerThread
  extends HandlerThread
{
  final Handler mHandler;
  
  public HippyHandlerThread(String paramString)
  {
    super(paramString);
    setPriority(10);
    start();
    this.mHandler = new Handler(getLooper());
  }
  
  public Handler getHandler()
  {
    return this.mHandler;
  }
  
  public boolean isThreadAlive()
  {
    return (this.mHandler != null) && (getLooper() != null) && (isAlive());
  }
  
  public boolean quit()
  {
    if (Build.VERSION.SDK_INT > 18) {
      return super.quitSafely();
    }
    this.mHandler.post(new HippyHandlerThread.1(this));
    return true;
  }
  
  public void runOnQueue(Runnable paramRunnable)
  {
    this.mHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.common.HippyHandlerThread
 * JD-Core Version:    0.7.0.1
 */