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
    if (System.currentTimeMillis() - this.mPostTime > 30000L) {
      Log.w("PriorityThreadPoolExecutor", "this job hangury too long. job:" + this + ". job:" + this.mR);
    }
    try
    {
      this.mR.run();
      this.mR = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.w("PriorityThreadPoolExecutor", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.utils.pool.PriorityThreadPoolExecutor.PriorityRunnable
 * JD-Core Version:    0.7.0.1
 */