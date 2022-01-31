package com.tencent.thumbplayer.utils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class TPReadWriteLock
  extends ReentrantReadWriteLock
{
  private static final int INTERRUPTED_TIMES = 3;
  private static final String TAG = "TPReadWriteLock";
  private Condition mWriteLockCond = writeLock().newCondition();
  
  public void read()
  {
    readLock().lock();
  }
  
  public boolean readTryLock(long paramLong)
  {
    int i = 3;
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      try
      {
        boolean bool = readLock().tryLock(paramLong, TimeUnit.MICROSECONDS);
        return bool;
      }
      catch (InterruptedException localInterruptedException)
      {
        TPLogUtil.e("TPReadWriteLock", localInterruptedException);
      }
    }
    throw new InterruptedException("tryLock interrupted.");
  }
  
  public void unReadLock()
  {
    readLock().unlock();
  }
  
  public void unWriteLock()
  {
    writeLock().unlock();
  }
  
  public void write()
  {
    writeLock().lock();
  }
  
  public void writeLockCondSignal()
  {
    this.mWriteLockCond.signal();
  }
  
  public void writeLockCondSignalAll()
  {
    this.mWriteLockCond.signalAll();
  }
  
  public boolean writeLockCondWait(long paramLong)
  {
    boolean bool2 = false;
    int i = 3;
    for (;;)
    {
      i -= 1;
      boolean bool1 = bool2;
      if (i >= 0) {}
      try
      {
        bool1 = this.mWriteLockCond.await(paramLong, TimeUnit.MILLISECONDS);
        return bool1;
      }
      catch (InterruptedException localInterruptedException)
      {
        TPLogUtil.e("TPReadWriteLock", localInterruptedException);
      }
    }
  }
  
  public boolean writeTryLock(long paramLong)
  {
    int i = 3;
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      try
      {
        boolean bool = writeLock().tryLock(paramLong, TimeUnit.MICROSECONDS);
        return bool;
      }
      catch (InterruptedException localInterruptedException)
      {
        TPLogUtil.e("TPReadWriteLock", localInterruptedException);
      }
    }
    throw new InterruptedException("tryLock interrupted.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPReadWriteLock
 * JD-Core Version:    0.7.0.1
 */