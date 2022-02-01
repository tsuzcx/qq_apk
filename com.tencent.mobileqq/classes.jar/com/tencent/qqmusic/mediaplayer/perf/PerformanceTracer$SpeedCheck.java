package com.tencent.qqmusic.mediaplayer.perf;

import java.util.Locale;

class PerformanceTracer$SpeedCheck
{
  private static final double f = 1000000.0D;
  private double avg;
  private double max;
  private double min;
  private final String name;
  private long totalBufferLength;
  private long totalTimeNanoSecond;
  
  private PerformanceTracer$SpeedCheck(String paramString)
  {
    this.name = paramString;
  }
  
  private void compute()
  {
    double d1 = this.totalBufferLength;
    Double.isNaN(d1);
    double d2 = this.totalTimeNanoSecond;
    Double.isNaN(d2);
    this.avg = (d1 * 1000000.0D / d2);
  }
  
  private void update(int paramInt, long paramLong)
  {
    this.totalBufferLength += paramInt;
    this.totalTimeNanoSecond += paramLong;
    double d1 = paramInt;
    Double.isNaN(d1);
    double d2 = paramLong;
    Double.isNaN(d2);
    d1 = d1 * 1000000.0D / d2;
    d2 = this.max;
    if ((d1 <= d2) && (d2 != 0.0D))
    {
      d2 = this.min;
      if ((d1 < d2) || (d2 == 0.0D)) {
        this.min = d1;
      }
    }
    else
    {
      this.max = d1;
    }
  }
  
  public double getAvg()
  {
    return this.avg;
  }
  
  public double getMax()
  {
    return this.max;
  }
  
  public double getMin()
  {
    return this.min;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public long getTotalBufferLength()
  {
    return this.totalBufferLength;
  }
  
  public long getTotalTimeMs()
  {
    double d = this.totalTimeNanoSecond;
    Double.isNaN(d);
    return Math.round(d / 1000000.0D);
  }
  
  void reset()
  {
    this.avg = 0.0D;
    this.max = 0.0D;
    this.min = 0.0D;
    this.totalTimeNanoSecond = 0L;
    this.totalBufferLength = 0L;
  }
  
  public String toString()
  {
    compute();
    return String.format(Locale.getDefault(), "%10s%15.2f%15.2f%15.2f%10d%15d", new Object[] { this.name, Double.valueOf(this.avg), Double.valueOf(this.max), Double.valueOf(this.min), Long.valueOf(this.totalTimeNanoSecond), Long.valueOf(this.totalBufferLength) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer.SpeedCheck
 * JD-Core Version:    0.7.0.1
 */