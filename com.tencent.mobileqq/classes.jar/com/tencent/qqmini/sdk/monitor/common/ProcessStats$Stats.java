package com.tencent.qqmini.sdk.monitor.common;

public class ProcessStats$Stats
  extends RecyclablePool.Recyclable
{
  public long base_stime;
  public long base_utime;
  public int cpuUsage;
  public String name;
  public long rel_stime;
  public long rel_utime;
  
  public void recycle()
  {
    super.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.common.ProcessStats.Stats
 * JD-Core Version:    0.7.0.1
 */