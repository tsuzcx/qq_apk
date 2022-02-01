package com.tencent.tbs.one.impl.base;

import java.util.ArrayList;

public abstract class CancellableJob<T>
{
  public static final int PUBLISH_PROGRESS_INTERVAL = 2;
  private ArrayList<ProgressiveCallback<T>> mCallbacks = new ArrayList();
  private int mErrorCode;
  private String mErrorMessage;
  private boolean mIsCancelled;
  private boolean mIsCompleted;
  private boolean mIsRunning;
  private int mLastProgress;
  private final Object mLock = new Object();
  private T mResult;
  private Throwable mThrowable;
  
  public void cancel()
  {
    this.mIsCancelled = true;
  }
  
  public void fail(int paramInt, String paramString, Throwable paramThrowable)
  {
    int i = 0;
    synchronized (this.mLock)
    {
      this.mIsRunning = false;
      this.mLastProgress = 0;
      this.mErrorCode = paramInt;
      this.mErrorMessage = paramString;
      this.mThrowable = paramThrowable;
      ProgressiveCallback[] arrayOfProgressiveCallback = (ProgressiveCallback[])this.mCallbacks.toArray(new ProgressiveCallback[0]);
      this.mCallbacks.clear();
      int j = arrayOfProgressiveCallback.length;
      while (i < j)
      {
        arrayOfProgressiveCallback[i].onError(paramInt, paramString, paramThrowable);
        i += 1;
      }
      return;
    }
  }
  
  public void finish(T paramT)
  {
    int i = 0;
    synchronized (this.mLock)
    {
      this.mIsRunning = false;
      this.mIsCompleted = true;
      int j = this.mLastProgress;
      this.mLastProgress = 100;
      this.mResult = paramT;
      ProgressiveCallback[] arrayOfProgressiveCallback = (ProgressiveCallback[])this.mCallbacks.toArray(new ProgressiveCallback[0]);
      this.mCallbacks.clear();
      int k = arrayOfProgressiveCallback.length;
      while (i < k)
      {
        ProgressiveCallback localProgressiveCallback = arrayOfProgressiveCallback[i];
        localProgressiveCallback.onProgressChanged(j, 100);
        localProgressiveCallback.onCompleted(paramT);
        i += 1;
      }
      return;
    }
  }
  
  public boolean isCancelled()
  {
    return this.mIsCancelled;
  }
  
  protected abstract void run();
  
  public void setProgress(int paramInt)
  {
    int i = 0;
    synchronized (this.mLock)
    {
      if (paramInt - this.mLastProgress > 2)
      {
        int j = this.mLastProgress;
        this.mLastProgress = paramInt;
        ProgressiveCallback[] arrayOfProgressiveCallback = (ProgressiveCallback[])this.mCallbacks.toArray(new ProgressiveCallback[0]);
        int k = arrayOfProgressiveCallback.length;
        while (i < k)
        {
          arrayOfProgressiveCallback[i].onProgressChanged(j, paramInt);
          i += 1;
        }
      }
      return;
    }
  }
  
  public void start(ProgressiveCallback<T> paramProgressiveCallback)
  {
    synchronized (this.mLock)
    {
      if (this.mIsCompleted)
      {
        if (paramProgressiveCallback != null)
        {
          paramProgressiveCallback.onProgressChanged(0, 100);
          paramProgressiveCallback.onCompleted(this.mResult);
        }
        return;
      }
      if (this.mErrorCode != 0)
      {
        if (paramProgressiveCallback != null) {
          paramProgressiveCallback.onError(this.mErrorCode, this.mErrorMessage, this.mThrowable);
        }
        return;
      }
    }
    if (paramProgressiveCallback != null)
    {
      paramProgressiveCallback.onProgressChanged(0, this.mLastProgress);
      this.mCallbacks.add(paramProgressiveCallback);
    }
    if (this.mIsRunning) {
      return;
    }
    this.mIsRunning = true;
    run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.CancellableJob
 * JD-Core Version:    0.7.0.1
 */