package com.tencent.qqmini.sdk.entry;

import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;

public class MiniAppExposureManager$CommonExposureData
  implements MiniAppExposureManager.BaseExposureReport
{
  private String actionType;
  private String reserves;
  private String reserves2;
  private String reserves3;
  private String reserves4 = null;
  private String subActionType;
  
  public MiniAppExposureManager$CommonExposureData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.actionType = paramString1;
    this.subActionType = paramString2;
    this.reserves = paramString3;
    this.reserves2 = paramString4;
    this.reserves3 = paramString5;
  }
  
  public void report()
  {
    SDKMiniProgramLpReportDC04239.report(this.actionType, this.subActionType, this.reserves, this.reserves2, this.reserves3, this.reserves4, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.entry.MiniAppExposureManager.CommonExposureData
 * JD-Core Version:    0.7.0.1
 */