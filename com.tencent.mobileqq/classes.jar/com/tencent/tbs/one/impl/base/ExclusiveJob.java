package com.tencent.tbs.one.impl.base;

import java.io.File;

public abstract class ExclusiveJob<T>
  extends CancellableJob<T>
{
  private final File mFile;
  private ProcessLock mLock;
  private final long mTimeoutMs;
  
  public ExclusiveJob(File paramFile, long paramLong)
  {
    this.mFile = paramFile;
    this.mTimeoutMs = paramLong;
  }
  
  private void releaseLock()
  {
    if (this.mLock != null) {
      this.mLock.releaseQuietly();
    }
  }
  
  public void fail(int paramInt, String paramString, Throwable paramThrowable)
  {
    releaseLock();
    super.fail(paramInt, paramString, paramThrowable);
  }
  
  public void finish(T paramT)
  {
    releaseLock();
    super.finish(paramT);
  }
  
  protected abstract void onLockGranted();
  
  protected abstract void onLockTimeout(Exception paramException);
  
  protected void run()
  {
    ThreadUtils.postOnBackgroundThread(new ExclusiveJob.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.ExclusiveJob
 * JD-Core Version:    0.7.0.1
 */