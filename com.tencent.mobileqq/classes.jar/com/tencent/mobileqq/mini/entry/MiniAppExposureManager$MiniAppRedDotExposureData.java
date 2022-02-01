package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;

public class MiniAppExposureManager$MiniAppRedDotExposureData
  extends MiniAppExposureManager.BaseExposureReport
{
  private String actionType;
  private MiniAppConfig appConfig;
  private int redDotNum;
  private String subActionType;
  
  public MiniAppExposureManager$MiniAppRedDotExposureData(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, int paramInt)
  {
    this.actionType = paramString1;
    this.subActionType = paramString2;
    this.appConfig = paramMiniAppConfig;
    this.redDotNum = paramInt;
  }
  
  public MiniAppConfig getMiniAppConfig()
  {
    return this.appConfig;
  }
  
  public void report()
  {
    MiniAppConfig localMiniAppConfig = this.appConfig;
    String str2 = MiniAppExposureManager.getAppType(localMiniAppConfig);
    String str3 = this.actionType;
    String str4 = this.subActionType;
    int i = this.redDotNum;
    String str1;
    if (i > 0) {
      str1 = String.valueOf(i);
    } else {
      str1 = "0";
    }
    MiniProgramLpReportDC04239.exposureReport(localMiniAppConfig, str2, null, str3, str4, null, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppRedDotExposureData
 * JD-Core Version:    0.7.0.1
 */