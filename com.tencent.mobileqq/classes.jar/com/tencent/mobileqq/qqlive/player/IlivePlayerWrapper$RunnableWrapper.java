package com.tencent.mobileqq.qqlive.player;

import com.tencent.qphone.base.util.QLog;

class IlivePlayerWrapper$RunnableWrapper
  implements Runnable
{
  private final Runnable a;
  
  public IlivePlayerWrapper$RunnableWrapper(Runnable paramRunnable)
  {
    this.a = paramRunnable;
  }
  
  public void run()
  {
    try
    {
      if (this.a != null)
      {
        this.a.run();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CachePlayer", 1, "runnable exception", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.player.IlivePlayerWrapper.RunnableWrapper
 * JD-Core Version:    0.7.0.1
 */