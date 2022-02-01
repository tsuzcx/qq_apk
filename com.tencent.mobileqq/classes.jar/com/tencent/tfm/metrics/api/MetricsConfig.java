package com.tencent.tfm.metrics.api;

public class MetricsConfig
{
  private final String channel;
  private final DimensionProvider dimensionProvider;
  private final boolean logEnable;
  private final long reportInterval;
  private final Reporter reporter;
  
  private MetricsConfig(Reporter paramReporter, DimensionProvider paramDimensionProvider, String paramString, boolean paramBoolean, long paramLong)
  {
    this.reporter = paramReporter;
    this.dimensionProvider = paramDimensionProvider;
    this.channel = paramString;
    this.logEnable = paramBoolean;
    this.reportInterval = paramLong;
  }
  
  public static MetricsConfig.Builder builder()
  {
    return new MetricsConfig.Builder();
  }
  
  public String getChannel()
  {
    return this.channel;
  }
  
  public DimensionProvider getDimensionProvider()
  {
    return this.dimensionProvider;
  }
  
  public long getReportInterval()
  {
    return this.reportInterval;
  }
  
  public Reporter getReporter()
  {
    return this.reporter;
  }
  
  public boolean isLogEnable()
  {
    return this.logEnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tfm.metrics.api.MetricsConfig
 * JD-Core Version:    0.7.0.1
 */