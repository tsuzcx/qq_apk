package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;

public class MiniAppExposureManager$MiniAppModuleExposureData
  extends MiniAppExposureManager.BaseExposureReport
{
  private String actionType;
  private MiniAppConfig appConfig;
  private String subActionType;
  
  public MiniAppExposureManager$MiniAppModuleExposureData(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2)
  {
    this.actionType = paramString1;
    this.subActionType = paramString2;
    this.appConfig = paramMiniAppConfig;
  }
  
  public void report()
  {
    MiniProgramLpReportDC04239.exposureReport(this.appConfig, MiniAppExposureManager.getAppType(this.appConfig), null, this.actionType, this.subActionType, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData
 * JD-Core Version:    0.7.0.1
 */