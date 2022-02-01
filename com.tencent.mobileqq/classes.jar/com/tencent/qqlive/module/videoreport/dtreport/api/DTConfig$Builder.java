package com.tencent.qqlive.module.videoreport.dtreport.api;

public class DTConfig$Builder
{
  private boolean seekReportSupport = false;
  private boolean speedRatioReportSupport = false;
  private boolean videoReportSupport = false;
  private boolean webViewReportSupport = false;
  
  public DTConfig build()
  {
    DTConfig localDTConfig = new DTConfig();
    DTConfig.access$002(localDTConfig, this.videoReportSupport);
    DTConfig.access$102(localDTConfig, this.webViewReportSupport);
    DTConfig.access$202(localDTConfig, this.seekReportSupport);
    DTConfig.access$302(localDTConfig, this.speedRatioReportSupport);
    return localDTConfig;
  }
  
  public Builder supportSeekReport(boolean paramBoolean)
  {
    this.seekReportSupport = paramBoolean;
    return this;
  }
  
  public Builder supportSpeedRatioReport(boolean paramBoolean)
  {
    this.speedRatioReportSupport = paramBoolean;
    return this;
  }
  
  public Builder supportVideoReport(boolean paramBoolean)
  {
    this.videoReportSupport = paramBoolean;
    return this;
  }
  
  public Builder supportWebViewReport(boolean paramBoolean)
  {
    this.webViewReportSupport = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.api.DTConfig.Builder
 * JD-Core Version:    0.7.0.1
 */