package com.tencent.thumbplayer.utils;

public class TPFutureResult
{
  private Throwable mException = null;
  private boolean mIsReady = false;
  private Object mRealResult = null;
  
  public Object getResult()
  {
    try
    {
      if (!this.mIsReady) {
        wait();
      }
      if (this.mException == null)
      {
        Object localObject1 = this.mRealResult;
        return localObject1;
      }
      throw this.mException;
    }
    finally {}
  }
  
  public Object getResult(long paramLong)
  {
    try
    {
      if (!this.mIsReady) {
        wait(paramLong);
      }
      if (this.mException == null)
      {
        Object localObject1 = this.mRealResult;
        return localObject1;
      }
      throw this.mException;
    }
    finally {}
  }
  
  public void setException(Throwable paramThrowable)
  {
    if (paramThrowable != null) {}
    try
    {
      this.mException = paramThrowable;
      this.mIsReady = true;
      notifyAll();
    }
    finally {}
  }
  
  public void setResult(Object paramObject)
  {
    try
    {
      boolean bool = this.mIsReady;
      if (bool) {
        return;
      }
      this.mRealResult = paramObject;
      this.mIsReady = true;
      notifyAll();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPFutureResult
 * JD-Core Version:    0.7.0.1
 */