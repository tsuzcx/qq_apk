package com.tribe.async.async;

import java.util.List;

public abstract interface MonitorThreadPoolExecutor$ThreadPoolMonitorListener
{
  public abstract void onQueueExceedLimit(String paramString, int paramInt);
  
  public abstract void onWorkerExceedTime(String paramString, List<Runnable> paramList, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tribe.async.async.MonitorThreadPoolExecutor.ThreadPoolMonitorListener
 * JD-Core Version:    0.7.0.1
 */