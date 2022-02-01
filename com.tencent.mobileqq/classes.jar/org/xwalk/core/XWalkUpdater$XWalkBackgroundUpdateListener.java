package org.xwalk.core;

import com.tencent.xweb.xwalk.updater.Scheduler;

public abstract interface XWalkUpdater$XWalkBackgroundUpdateListener
{
  public abstract void onXWalkUpdateCancelled();
  
  public abstract void onXWalkUpdateCompleted(Scheduler paramScheduler);
  
  public abstract void onXWalkUpdateFailed(int paramInt, Scheduler paramScheduler);
  
  public abstract void onXWalkUpdateProgress(int paramInt);
  
  public abstract void onXWalkUpdateStarted();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener
 * JD-Core Version:    0.7.0.1
 */