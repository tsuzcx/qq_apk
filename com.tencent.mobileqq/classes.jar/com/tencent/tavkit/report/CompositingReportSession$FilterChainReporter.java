package com.tencent.tavkit.report;

import java.util.HashMap;
import java.util.Map;

class CompositingReportSession$FilterChainReporter
  implements FilterChainReportSession.IReporter
{
  private Map<String, Long> values = new HashMap();
  
  public void onCommit(Map<String, Long> paramMap)
  {
    paramMap.putAll(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.report.CompositingReportSession.FilterChainReporter
 * JD-Core Version:    0.7.0.1
 */