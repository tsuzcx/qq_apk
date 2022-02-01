package com.tencent.mtt.hippy.common;

import android.os.Handler;

public class ThreadExecutor
  implements Thread.UncaughtExceptionHandler
{
  HippyHandlerThread mDomThread;
  HippyHandlerThread mJsBridgeThread;
  HippyHandlerThread mJsThread = new HippyHandlerThread("hippy-js-Thread");
  ThreadExecutor.UncaughtExceptionHandler mUncaughtExceptionHandler;
  
  public ThreadExecutor()
  {
    this.mJsThread.setUncaughtExceptionHandler(this);
    this.mJsBridgeThread = new HippyHandlerThread("hippy-jsBridge-Thread");
    this.mJsBridgeThread.setUncaughtExceptionHandler(this);
    this.mDomThread = new HippyHandlerThread("hippy-DomThread");
    this.mDomThread.setUncaughtExceptionHandler(this);
  }
  
  public void assertOnDomThread()
  {
    if (Thread.currentThread().getId() != this.mDomThread.getId()) {
      throw new RuntimeException("call is not on dom-thread");
    }
  }
  
  public void assertOnJsBridge()
  {
    if (Thread.currentThread().getId() != this.mJsBridgeThread.getId()) {
      throw new RuntimeException("call is not on Js-bridge-thread");
    }
  }
  
  public void assertOnJsThread()
  {
    if (Thread.currentThread().getId() != this.mJsThread.getId()) {
      throw new RuntimeException("call is not on Js-thread");
    }
  }
  
  public void destroy()
  {
    if ((this.mDomThread != null) && (this.mDomThread.isThreadAlive()))
    {
      this.mDomThread.quit();
      this.mDomThread.setUncaughtExceptionHandler(null);
    }
    if ((this.mJsBridgeThread != null) && (this.mJsBridgeThread.isThreadAlive()))
    {
      this.mJsBridgeThread.quit();
      this.mJsBridgeThread.setUncaughtExceptionHandler(null);
    }
    if ((this.mJsThread != null) && (this.mJsThread.isThreadAlive()))
    {
      this.mJsThread.quit();
      this.mJsThread.setUncaughtExceptionHandler(null);
    }
    this.mUncaughtExceptionHandler = null;
  }
  
  public HippyHandlerThread getDomThread()
  {
    return this.mDomThread;
  }
  
  public HippyHandlerThread getJsBridgeThread()
  {
    return this.mJsBridgeThread;
  }
  
  public HippyHandlerThread getJsThread()
  {
    return this.mJsThread;
  }
  
  public void postDelayOnJsThread(int paramInt, Runnable paramRunnable)
  {
    this.mJsThread.getHandler().postDelayed(paramRunnable, paramInt);
  }
  
  public void postOnDomThread(Runnable paramRunnable)
  {
    this.mDomThread.runOnQueue(paramRunnable);
  }
  
  public void postOnJsBridgeThread(Runnable paramRunnable)
  {
    this.mJsThread.runOnQueue(paramRunnable);
  }
  
  public void postOnJsThread(Runnable paramRunnable)
  {
    this.mJsBridgeThread.runOnQueue(paramRunnable);
  }
  
  public void setUncaughtExceptionHandler(ThreadExecutor.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.mUncaughtExceptionHandler = paramUncaughtExceptionHandler;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (this.mUncaughtExceptionHandler != null)
    {
      this.mUncaughtExceptionHandler.handleThreadUncaughtException(paramThread, paramThrowable);
      return;
    }
    throw new RuntimeException(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.common.ThreadExecutor
 * JD-Core Version:    0.7.0.1
 */