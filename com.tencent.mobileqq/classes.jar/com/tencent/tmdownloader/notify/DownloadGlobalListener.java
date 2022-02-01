package com.tencent.tmdownloader.notify;

public abstract interface DownloadGlobalListener
{
  public abstract void onTaskCompleted(DownloadTaskInfo paramDownloadTaskInfo);
  
  public abstract void onTaskFailed(DownloadTaskInfo paramDownloadTaskInfo);
  
  public abstract void onTaskPaused(DownloadTaskInfo paramDownloadTaskInfo);
  
  public abstract void onTaskStarted(DownloadTaskInfo paramDownloadTaskInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.notify.DownloadGlobalListener
 * JD-Core Version:    0.7.0.1
 */