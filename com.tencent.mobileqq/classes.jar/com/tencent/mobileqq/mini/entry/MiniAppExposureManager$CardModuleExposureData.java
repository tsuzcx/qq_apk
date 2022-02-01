package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;

public class MiniAppExposureManager$CardModuleExposureData
  extends MiniAppExposureManager.BaseExposureReport
{
  private String actionType;
  private String reserves;
  private String reserves2;
  private String reserves3;
  private String reserves4;
  private String subActionType;
  
  public MiniAppExposureManager$CardModuleExposureData(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.actionType = paramString1;
    this.subActionType = paramString2;
    this.reserves = paramString3;
    this.reserves2 = paramString4;
  }
  
  public MiniAppExposureManager$CardModuleExposureData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.actionType = paramString1;
    this.subActionType = paramString2;
    this.reserves = paramString3;
    this.reserves2 = paramString4;
    this.reserves3 = paramString5;
    this.reserves4 = paramString6;
  }
  
  public void report()
  {
    MiniProgramLpReportDC04239.report(this.actionType, this.subActionType, this.reserves, this.reserves2, this.reserves3, this.reserves4, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppExposureManager.CardModuleExposureData
 * JD-Core Version:    0.7.0.1
 */