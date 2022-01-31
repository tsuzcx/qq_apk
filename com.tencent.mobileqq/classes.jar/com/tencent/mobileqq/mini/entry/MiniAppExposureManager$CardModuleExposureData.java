package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;

public class MiniAppExposureManager$CardModuleExposureData
  implements MiniAppExposureManager.BaseExposureReport
{
  private String actionType;
  private String reserves;
  private String reserves2;
  private String subActionType;
  
  public MiniAppExposureManager$CardModuleExposureData(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.actionType = paramString1;
    this.subActionType = paramString2;
    this.reserves = paramString3;
    this.reserves2 = paramString4;
  }
  
  public void report()
  {
    MiniProgramLpReportDC04239.report(this.actionType, this.subActionType, this.reserves, this.reserves2, null, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppExposureManager.CardModuleExposureData
 * JD-Core Version:    0.7.0.1
 */