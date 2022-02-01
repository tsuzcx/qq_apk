package com.tencent.tfm.metrics;

import com.tencent.tfm.metrics.api.Reporter;
import com.tencent.tfm.metrics.bean.LogItem;

public abstract interface ICollector
{
  public abstract void push(LogItem paramLogItem);
  
  public abstract void setReporter(Reporter paramReporter);
  
  public abstract void updateReportInterval(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tfm.metrics.ICollector
 * JD-Core Version:    0.7.0.1
 */