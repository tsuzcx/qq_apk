package com.tencent.tavkit.report;

class FilterChainReportSession$TimeConsumer
{
  private long count = 0L;
  private final String key;
  private long totalUs = 0L;
  
  public FilterChainReportSession$TimeConsumer(String paramString)
  {
    this.key = paramString;
  }
  
  private long getAvgTimeUs()
  {
    if (this.count == 0L) {
      return 0L;
    }
    return this.totalUs / this.count;
  }
  
  private void tick(long paramLong)
  {
    this.totalUs += paramLong;
    this.count += 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.report.FilterChainReportSession.TimeConsumer
 * JD-Core Version:    0.7.0.1
 */