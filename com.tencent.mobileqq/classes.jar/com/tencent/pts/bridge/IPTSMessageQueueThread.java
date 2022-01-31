package com.tencent.pts.bridge;

public abstract interface IPTSMessageQueueThread
{
  public abstract boolean isOnThread();
  
  public abstract void quitSynchronous();
  
  public abstract void runOnQueue(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.bridge.IPTSMessageQueueThread
 * JD-Core Version:    0.7.0.1
 */