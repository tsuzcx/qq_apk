package com.tencent.qqlive.module.videoreport.dtreport.api;

public class DTConfig$Builder
{
  private boolean videoReportSupport = false;
  
  public DTConfig build()
  {
    DTConfig localDTConfig = new DTConfig();
    DTConfig.access$002(localDTConfig, this.videoReportSupport);
    return localDTConfig;
  }
  
  public Builder supportVideoReport(boolean paramBoolean)
  {
    this.videoReportSupport = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.api.DTConfig.Builder
 * JD-Core Version:    0.7.0.1
 */