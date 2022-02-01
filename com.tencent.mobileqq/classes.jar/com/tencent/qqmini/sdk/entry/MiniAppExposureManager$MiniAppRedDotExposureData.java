package com.tencent.qqmini.sdk.entry;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;

public class MiniAppExposureManager$MiniAppRedDotExposureData
  implements MiniAppExposureManager.BaseExposureReport
{
  private String actionType;
  private MiniAppInfo appConfig;
  private int redDotNum;
  private String subActionType;
  
  public MiniAppExposureManager$MiniAppRedDotExposureData(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, int paramInt)
  {
    this.actionType = paramString1;
    this.subActionType = paramString2;
    this.appConfig = paramMiniAppInfo;
    this.redDotNum = paramInt;
  }
  
  public MiniAppInfo getMiniAppConfig()
  {
    return this.appConfig;
  }
  
  public void report()
  {
    MiniAppInfo localMiniAppInfo = this.appConfig;
    String str2 = MiniAppExposureManager.getAppType(this.appConfig);
    String str3 = this.actionType;
    String str4 = this.subActionType;
    if (this.redDotNum > 0) {}
    for (String str1 = String.valueOf(this.redDotNum);; str1 = "0")
    {
      SDKMiniProgramLpReportDC04239.exposureReport(localMiniAppInfo, str2, null, str3, str4, null, str1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.entry.MiniAppExposureManager.MiniAppRedDotExposureData
 * JD-Core Version:    0.7.0.1
 */