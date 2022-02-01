package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;

public class MiniAppReportEntity
  extends Entity
  implements Serializable
{
  public String appId;
  public String appType;
  @unique
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
    localStringBuilder.append("launchId: ");
    localStringBuilder.append(this.launchId);
    localStringBuilder.append(", appId: ");
    localStringBuilder.append(this.appId);
    localStringBuilder.append(", subActionType: ");
    localStringBuilder.append(this.subActionType);
    localStringBuilder.append(", appType: ");
    localStringBuilder.append(this.appType);
    localStringBuilder.append(", verType: ");
    localStringBuilder.append(this.verType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppReportEntity
 * JD-Core Version:    0.7.0.1
 */