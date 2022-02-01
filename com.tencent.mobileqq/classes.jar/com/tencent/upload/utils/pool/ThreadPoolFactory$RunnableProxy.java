package com.tencent.upload.utils.pool;

import android.util.Log;

class ThreadPoolFactory$RunnableProxy
  implements Runnable
{
  private final String TAG = "Execption";
  private final Runnable mR;
  
  public ThreadPoolFactory$RunnableProxy(Runnable paramRunnable)
  {
    this.mR = paramRunnable;
  }
  
  public void run()
  {
    try
    {
      this.mR.run();
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("Execption", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.utils.pool.ThreadPoolFactory.RunnableProxy
 * JD-Core Version:    0.7.0.1
 */