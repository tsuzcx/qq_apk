package com.tencent.qqmini.sdk.launcher.model;

import java.util.Properties;

public class MtaReportSt
{
  public String reportKey;
  public Properties reportObj;
  
  public MtaReportSt(String paramString, Properties paramProperties)
  {
    this.reportObj = paramProperties;
    this.reportKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.MtaReportSt
 * JD-Core Version:    0.7.0.1
 */