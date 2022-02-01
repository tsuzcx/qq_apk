package com.tencent.qqmini.sdk.entry;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;

public class MiniAppExposureManager$MiniAppModuleExposureData
  implements MiniAppExposureManager.BaseExposureReport
{
  private String actionType;
  private MiniAppInfo appConfig;
  private String subActionType;
  
  public MiniAppExposureManager$MiniAppModuleExposureData(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2)
  {
    this.actionType = paramString1;
    this.subActionType = paramString2;
    this.appConfig = paramMiniAppInfo;
  }
  
  public void report()
  {
    SDKMiniProgramLpReportDC04239.exposureReport(this.appConfig, MiniAppExposureManager.getAppType(this.appConfig), null, this.actionType, this.subActionType, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.entry.MiniAppExposureManager.MiniAppModuleExposureData
 * JD-Core Version:    0.7.0.1
 */