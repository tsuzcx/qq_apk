package com.tencent.mobileqq.mini.apkgEntity;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class MiniAppShowInfoEntity
  extends Entity
{
  @unique
  public String appId;
  public String appName;
  public String desc;
  public int engineType;
  public String gameApprovalNumber;
  public String gameCopyrightInfo;
  public String gameOperatingCompany;
  public String gamePublicationCompany;
  public String gamePublicationNumber;
  public String icon;
  public boolean interMode;
  public int miniAppType;
  public int reportType;
  public long timeStamp;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniAppShowInfoEntity{appId='");
    localStringBuilder.append(this.appId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appName='");
    localStringBuilder.append(this.appName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", icon='");
    localStringBuilder.append(this.icon);
    localStringBuilder.append('\'');
    localStringBuilder.append(", desc='");
    localStringBuilder.append(this.desc);
    localStringBuilder.append('\'');
    localStringBuilder.append(", reportType=");
    localStringBuilder.append(this.reportType);
    localStringBuilder.append(", engineType=");
    localStringBuilder.append(this.engineType);
    localStringBuilder.append(", interMode=");
    localStringBuilder.append(this.interMode);
    localStringBuilder.append(", timeStamp='");
    localStringBuilder.append(this.timeStamp);
    localStringBuilder.append('\'');
    localStringBuilder.append(", miniAppType='");
    localStringBuilder.append(this.miniAppType);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkgEntity.MiniAppShowInfoEntity
 * JD-Core Version:    0.7.0.1
 */