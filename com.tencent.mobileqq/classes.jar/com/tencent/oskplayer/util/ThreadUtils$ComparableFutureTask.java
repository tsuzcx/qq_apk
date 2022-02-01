package com.tencent.oskplayer.util;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class ThreadUtils$ComparableFutureTask<T>
  extends FutureTask<T>
  implements Comparable<ComparableFutureTask<T>>
{
  volatile long priority = 0L;
  
  public ThreadUtils$ComparableFutureTask(Runnable paramRunnable, T paramT, long paramLong)
  {
    super(paramRunnable, paramT);
    this.priority = paramLong;
  }
  
  public ThreadUtils$ComparableFutureTask(Callable<T> paramCallable, long paramLong)
  {
    super(paramCallable);
    this.priority = paramLong;
  }
  
  public int compareTo(ComparableFutureTask<T> paramComparableFutureTask)
  {
    return Long.valueOf(this.priority).compareTo(Long.valueOf(paramComparableFutureTask.priority));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.util.ThreadUtils.ComparableFutureTask
 * JD-Core Version:    0.7.0.1
 */