package com.tencent.pts.bridge;

import android.os.Handler;
import android.os.Looper;
import com.tencent.pts.utils.PTSLog;

public class PTSMessageQueueThreadImpl
  implements IPTSMessageQueueThread
{
  private final String TAG = "PTSMessageQueueThreadImpl";
  private final Handler mHandler;
  private volatile boolean mIsFinished = false;
  private final Looper mLooper;
  private final String mName;
  
  private PTSMessageQueueThreadImpl(String paramString, Looper paramLooper)
  {
    this.mName = paramString;
    this.mLooper = paramLooper;
    this.mHandler = new Handler(paramLooper);
  }
  
  public Looper getLooper()
  {
    return this.mLooper;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public boolean isOnThread()
  {
    return this.mLooper.getThread() == Thread.currentThread();
  }
  
  public void quitSynchronous()
  {
    this.mIsFinished = true;
    this.mLooper.quit();
    if (this.mLooper.getThread() != Thread.currentThread()) {}
    try
    {
      this.mLooper.getThread().join();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new RuntimeException("Got interrupted waiting to join thread " + this.mName);
    }
  }
  
  public void runOnQueue(Runnable paramRunnable)
  {
    if (this.mIsFinished) {
      PTSLog.e("PTSMessageQueueThreadImpl", "Tried to enqueue runnable on already finished thread: " + getName());
    }
    this.mHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.bridge.PTSMessageQueueThreadImpl
 * JD-Core Version:    0.7.0.1
 */