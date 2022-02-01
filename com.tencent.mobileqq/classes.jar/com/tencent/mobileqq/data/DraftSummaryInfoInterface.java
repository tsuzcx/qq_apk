package com.tencent.mobileqq.data;

import com.tencent.mobileqq.qroute.annotation.PluginInterface;

@PluginInterface
public abstract interface DraftSummaryInfoInterface
{
  public abstract String getSummary();
  
  public abstract long getTime();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.DraftSummaryInfoInterface
 * JD-Core Version:    0.7.0.1
 */