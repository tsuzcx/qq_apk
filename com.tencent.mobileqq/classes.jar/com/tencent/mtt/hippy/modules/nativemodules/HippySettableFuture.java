package com.tencent.mtt.hippy.modules.nativemodules;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class HippySettableFuture<T>
  implements Future<T>
{
  private Exception mException;
  private final CountDownLatch mReadyLatch = new CountDownLatch(1);
  private T mResult;
  
  private void checkNotSet()
  {
    if (this.mReadyLatch.getCount() != 0L) {
      return;
    }
    throw new RuntimeException("Result has already been set!");
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    throw new UnsupportedOperationException();
  }
  
  public T get()
  {
    this.mReadyLatch.await();
    Exception localException = this.mException;
    if (localException == null) {
      return this.mResult;
    }
    throw new ExecutionException(localException);
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
  {
    if (this.mReadyLatch.await(paramLong, paramTimeUnit))
    {
      paramTimeUnit = this.mException;
      if (paramTimeUnit == null) {
        return this.mResult;
      }
      throw new ExecutionException(paramTimeUnit);
    }
    throw new TimeoutException("Timed out waiting for result");
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean isDone()
  {
    return this.mReadyLatch.getCount() == 0L;
  }
  
  public void set(T paramT)
  {
    checkNotSet();
    this.mResult = paramT;
    this.mReadyLatch.countDown();
  }
  
  public void setException(Exception paramException)
  {
    checkNotSet();
    this.mException = paramException;
    this.mReadyLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.HippySettableFuture
 * JD-Core Version:    0.7.0.1
 */