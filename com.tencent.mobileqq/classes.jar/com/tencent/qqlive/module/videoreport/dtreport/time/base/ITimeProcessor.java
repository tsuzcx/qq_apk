package com.tencent.qqlive.module.videoreport.dtreport.time.base;

public abstract interface ITimeProcessor
{
  public abstract long getBackgroundDuration();
  
  public abstract long getForegroundDuration();
  
  public abstract void reset();
  
  public abstract void setInForeground(boolean paramBoolean);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
 * JD-Core Version:    0.7.0.1
 */