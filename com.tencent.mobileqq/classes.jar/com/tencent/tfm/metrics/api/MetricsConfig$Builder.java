package com.tencent.tfm.metrics.api;

public final class MetricsConfig$Builder
{
  private String channel;
  private DimensionProvider dimensionProvider;
  private boolean logEnable = false;
  private long reportInterval = 10000L;
  private Reporter reporter;
  
  public MetricsConfig build()
  {
    return new MetricsConfig(this.reporter, this.dimensionProvider, this.channel, this.logEnable, this.reportInterval, null);
  }
  
  public String getChannel()
  {
    return this.channel;
  }
  
  public DimensionProvider getDimensionProvider()
  {
    return this.dimensionProvider;
  }
  
  public Reporter getReporter()
  {
    return this.reporter;
  }
  
  public Builder setChannel(String paramString)
  {
    this.channel = paramString;
    return this;
  }
  
  public Builder setDimensionProvider(DimensionProvider paramDimensionProvider)
  {
    this.dimensionProvider = paramDimensionProvider;
    return this;
  }
  
  public Builder setLogEnable(boolean paramBoolean)
  {
    this.logEnable = paramBoolean;
    return this;
  }
  
  public Builder setReportInterval(long paramLong)
  {
    this.reportInterval = paramLong;
    return this;
  }
  
  public Builder setReporter(Reporter paramReporter)
  {
    this.reporter = paramReporter;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tfm.metrics.api.MetricsConfig.Builder
 * JD-Core Version:    0.7.0.1
 */