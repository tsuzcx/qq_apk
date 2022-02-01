package com.tencent.qqlive.module.videoreport.dtreport.api;

public class DTConfig$Builder
{
  private boolean videoReportSupport = false;
  private boolean webViewReportSupport = false;
  
  public DTConfig build()
  {
    DTConfig localDTConfig = new DTConfig();
    DTConfig.access$002(localDTConfig, this.videoReportSupport);
    DTConfig.access$102(localDTConfig, this.webViewReportSupport);
    return localDTConfig;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.api.DTConfig.Builder
 * JD-Core Version:    0.7.0.1
 */