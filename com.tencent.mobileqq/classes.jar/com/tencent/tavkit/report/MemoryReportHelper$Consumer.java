package com.tencent.tavkit.report;

class MemoryReportHelper$Consumer
{
  private long count = 0L;
  private final String key;
  private long maxM = 0L;
  private long totalM = 0L;
  
  public MemoryReportHelper$Consumer(String paramString)
  {
    this.key = paramString;
  }
  
  private long getAvgMB()
  {
    long l = this.count;
    if (l == 0L) {
      return 0L;
    }
    return this.totalM / l;
  }
  
  private void tick(long paramLong)
  {
    this.totalM += paramLong;
    this.count += 1L;
    if (paramLong > this.maxM) {
      this.maxM = paramLong;
    }
  }
  
  public long getMaxM()
  {
    return this.maxM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.report.MemoryReportHelper.Consumer
 * JD-Core Version:    0.7.0.1
 */