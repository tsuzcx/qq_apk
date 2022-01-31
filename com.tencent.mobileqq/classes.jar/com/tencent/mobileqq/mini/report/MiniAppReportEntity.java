package com.tencent.mobileqq.mini.report;

import awbv;
import awdj;
import java.io.Serializable;

public class MiniAppReportEntity
  extends awbv
  implements Serializable
{
  public String appId;
  public String appType;
  @awdj
  public String launchId;
  public String subActionType;
  public String verType;
  
  public MiniAppReportEntity() {}
  
  public MiniAppReportEntity(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.launchId = paramString1;
    this.appId = paramString2;
    this.subActionType = paramString3;
    this.appType = paramString4;
    this.verType = paramString5;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchId: ").append(this.launchId).append(", appId: ").append(this.appId).append(", subActionType: ").append(this.subActionType).append(", appType: ").append(this.appType).append(", verType: ").append(this.verType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppReportEntity
 * JD-Core Version:    0.7.0.1
 */