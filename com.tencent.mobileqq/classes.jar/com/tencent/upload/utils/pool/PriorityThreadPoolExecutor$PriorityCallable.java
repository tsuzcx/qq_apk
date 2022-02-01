package com.tencent.upload.utils.pool;

import android.util.Log;
import java.util.concurrent.Callable;

class PriorityThreadPoolExecutor$PriorityCallable<T>
  extends PriorityThreadPoolExecutor.PriorityTask
  implements Callable<T>
{
  protected Callable<T> mC;
  
  public PriorityThreadPoolExecutor$PriorityCallable(Callable<T> paramCallable)
  {
    this.mC = paramCallable;
  }
  
  public PriorityThreadPoolExecutor$PriorityCallable(Callable<T> paramCallable, int paramInt)
  {
    super(paramInt);
    this.mC = paramCallable;
  }
  
  public T call()
  {
    if (System.currentTimeMillis() - this.mPostTime > 30000L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("this job hangury too long. job:");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(". job:");
      ((StringBuilder)localObject).append(this.mC);
      Log.w("PriorityThreadPoolExecutor", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mC.call();
    this.mC = null;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.utils.pool.PriorityThreadPoolExecutor.PriorityCallable
 * JD-Core Version:    0.7.0.1
 */