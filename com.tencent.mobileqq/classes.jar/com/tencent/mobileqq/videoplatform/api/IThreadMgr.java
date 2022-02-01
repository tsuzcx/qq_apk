package com.tencent.mobileqq.videoplatform.api;

public abstract interface IThreadMgr
{
  public abstract void postOnSubThread(Runnable paramRunnable);
  
  public abstract void postOnSubThreadDelayed(Runnable paramRunnable, long paramLong);
  
  public abstract void postOnUIThread(Runnable paramRunnable);
  
  public abstract void postOnUIThreadDelayed(Runnable paramRunnable, long paramLong);
  
  public abstract void quitSubThread();
  
  public abstract void removeCallbackOnSubHandler(Runnable paramRunnable);
  
  public abstract void removeCallbackOnUIHandler(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.api.IThreadMgr
 * JD-Core Version:    0.7.0.1
 */