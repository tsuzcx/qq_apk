package com.tencent.qqlive.module.videoreport.dtreport.api;

public class DTConfig
{
  private boolean videoReportSupport = false;
  private boolean webViewReportSupport = false;
  
  public void videoReportSupport(boolean paramBoolean)
  {
    this.videoReportSupport = paramBoolean;
  }
  
  public boolean videoReportSupport()
  {
    return this.videoReportSupport;
  }
  
  public void webViewReportSupport(boolean paramBoolean)
  {
    this.webViewReportSupport = paramBoolean;
  }
  
  public boolean webViewReportSupport()
  {
    return this.webViewReportSupport;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.api.DTConfig
 * JD-Core Version:    0.7.0.1
 */