package com.tencent.tavkit.report;

import android.support.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FilterChainReportSession
{
  @Nullable
  private static FilterChainReportSession.IReporter reporter;
  private Map<String, FilterChainReportSession.TimeConsumer> timeConsumerMap = new HashMap();
  
  public static void setReporter(@Nullable FilterChainReportSession.IReporter paramIReporter)
  {
    try
    {
      reporter = paramIReporter;
      return;
    }
    finally
    {
      paramIReporter = finally;
      throw paramIReporter;
    }
  }
  
  public void commit()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.timeConsumerMap.values().iterator();
    while (localIterator.hasNext())
    {
      FilterChainReportSession.TimeConsumer localTimeConsumer = (FilterChainReportSession.TimeConsumer)localIterator.next();
      if (localTimeConsumer != null) {
        localHashMap.put(FilterChainReportSession.TimeConsumer.access$000(localTimeConsumer), Long.valueOf(FilterChainReportSession.TimeConsumer.access$200(localTimeConsumer)));
      }
    }
    try
    {
      if (reporter != null) {
        reporter.onCommit(localHashMap);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void tick(String paramString, long paramLong)
  {
    FilterChainReportSession.TimeConsumer localTimeConsumer2 = (FilterChainReportSession.TimeConsumer)this.timeConsumerMap.get(paramString);
    FilterChainReportSession.TimeConsumer localTimeConsumer1 = localTimeConsumer2;
    if (localTimeConsumer2 == null)
    {
      localTimeConsumer1 = new FilterChainReportSession.TimeConsumer(paramString);
      this.timeConsumerMap.put(FilterChainReportSession.TimeConsumer.access$000(localTimeConsumer1), localTimeConsumer1);
    }
    FilterChainReportSession.TimeConsumer.access$100(localTimeConsumer1, paramLong / 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.report.FilterChainReportSession
 * JD-Core Version:    0.7.0.1
 */