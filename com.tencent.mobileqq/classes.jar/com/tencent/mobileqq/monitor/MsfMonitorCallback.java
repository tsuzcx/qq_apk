package com.tencent.mobileqq.monitor;

public abstract interface MsfMonitorCallback
{
  public static final int THREAD_TYPE_LIGHT_SENDER = 3;
  public static final int THREAD_TYPE_NET = 4;
  public static final int THREAD_TYPE_RECEIVER = 2;
  public static final int THREAD_TYPE_SENDER = 1;
  
  public abstract boolean handleEnd(int paramInt);
  
  public abstract boolean handleStart(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.monitor.MsfMonitorCallback
 * JD-Core Version:    0.7.0.1
 */