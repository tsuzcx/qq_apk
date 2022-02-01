package com.tencent.upload.utils.pool;

import android.util.Log;

class PriorityThreadPoolExecutor$PriorityRunnable
  extends PriorityThreadPoolExecutor.PriorityTask
  implements Runnable
{
  protected Runnable mR;
  
  public PriorityThreadPoolExecutor$PriorityRunnable(Runnable paramRunnable)
  {
    this.mR = paramRunnable;
  }
  
  public PriorityThreadPoolExecutor$PriorityRunnable(Runnable paramRunnable, int paramInt)
  {
    super(paramInt);
    this.mR = paramRunnable;
  }
  
  public void run()
  {
    if (System.currentTimeMillis() - this.mPostTime > 30000L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("this job hangury too long. job:");
      localStringBuilder.append(this);
      localStringBuilder.append(". job:");
      localStringBuilder.append(this.mR);
      Log.w("PriorityThreadPoolExecutor", localStringBuilder.toString());
    }
    try
    {
      this.mR.run();
    }
    catch (Throwable localThrowable)
    {
      Log.w("PriorityThreadPoolExecutor", localThrowable);
    }
    this.mR = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.utils.pool.PriorityThreadPoolExecutor.PriorityRunnable
 * JD-Core Version:    0.7.0.1
 */