package com.tencent.trackrecordlib.core;

public abstract interface IRecordConfig
{
  public abstract int getCachedEventSize();
  
  public abstract String getTitleBarId();
  
  public abstract boolean isEnableRelease();
  
  public abstract boolean isFilterUGC();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.IRecordConfig
 * JD-Core Version:    0.7.0.1
 */