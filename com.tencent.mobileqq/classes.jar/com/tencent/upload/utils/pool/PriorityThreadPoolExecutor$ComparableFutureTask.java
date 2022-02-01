package com.tencent.upload.utils.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class PriorityThreadPoolExecutor$ComparableFutureTask<V>
  extends FutureTask<V>
  implements Comparable<ComparableFutureTask<V>>
{
  private Object object;
  
  public PriorityThreadPoolExecutor$ComparableFutureTask(Runnable paramRunnable, V paramV)
  {
    super(paramRunnable, paramV);
    this.object = paramRunnable;
  }
  
  public PriorityThreadPoolExecutor$ComparableFutureTask(Callable<V> paramCallable)
  {
    super(paramCallable);
    this.object = paramCallable;
  }
  
  public int compareTo(ComparableFutureTask<V> paramComparableFutureTask)
  {
    if (this == paramComparableFutureTask) {
      return 0;
    }
    if (paramComparableFutureTask == null) {
      return -1;
    }
    Object localObject = this.object;
    if ((localObject != null) && (paramComparableFutureTask.object != null) && (localObject.getClass().equals(paramComparableFutureTask.object.getClass())))
    {
      localObject = this.object;
      if ((localObject instanceof Comparable)) {
        return ((Comparable)localObject).compareTo(paramComparableFutureTask.object);
      }
    }
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof ComparableFutureTask)))
    {
      paramObject = (ComparableFutureTask)paramObject;
      return this.object.equals(paramObject.object);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.utils.pool.PriorityThreadPoolExecutor.ComparableFutureTask
 * JD-Core Version:    0.7.0.1
 */