package com.tencent.rmonitor.resource.collector;

import com.tencent.rmonitor.resource.meta.PerfItem;
import org.jetbrains.annotations.NotNull;

public abstract interface IPerfItemCollectorListener
  extends ICollectorListener
{
  public abstract void a(@NotNull PerfItem paramPerfItem);
  
  public abstract void b(@NotNull PerfItem paramPerfItem);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.collector.IPerfItemCollectorListener
 * JD-Core Version:    0.7.0.1
 */