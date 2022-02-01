package com.tencent.qqlive.module.videoreport.utils;

public abstract class DelayedIdleHandler$DelayedRunnable
  implements Runnable
{
  @Deprecated
  public void run()
  {
    run(1);
  }
  
  protected abstract void run(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.DelayedIdleHandler.DelayedRunnable
 * JD-Core Version:    0.7.0.1
 */