package com.tribe.async.async;

import com.tribe.async.log.SLog;
import java.util.concurrent.TimeUnit;

public class ExecutorConfig$CpuExecutorConfig
  implements ExecutorConfig
{
  public int getAliveTime()
  {
    return 10000;
  }
  
  public int getCore()
  {
    int i = Runtime.getRuntime().availableProcessors() + 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cpu core = ");
    localStringBuilder.append(i);
    SLog.d("ExecutorConfig", localStringBuilder.toString());
    return i;
  }
  
  public int getMaximum()
  {
    int i = Runtime.getRuntime().availableProcessors() * 2 + 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cpu max = ");
    localStringBuilder.append(i);
    SLog.d("ExecutorConfig", localStringBuilder.toString());
    return i;
  }
  
  public TimeUnit getTimeUnit()
  {
    return TimeUnit.MILLISECONDS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.async.ExecutorConfig.CpuExecutorConfig
 * JD-Core Version:    0.7.0.1
 */