package com.tribe.async.async;

import java.util.concurrent.TimeUnit;

public abstract interface ExecutorConfig
{
  public static final String TAG = "ExecutorConfig";
  
  public abstract int getAliveTime();
  
  public abstract int getCore();
  
  public abstract int getMaximum();
  
  public abstract TimeUnit getTimeUnit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tribe.async.async.ExecutorConfig
 * JD-Core Version:    0.7.0.1
 */