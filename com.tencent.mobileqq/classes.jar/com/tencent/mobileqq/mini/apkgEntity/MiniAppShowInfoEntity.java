package com.tencent.mobileqq.mini.apkgEntity;

import awbv;
import awdj;

public class MiniAppShowInfoEntity
  extends awbv
{
  @awdj
  public String appId;
  public String appName;
  public String desc;
  public int engineType;
  public String icon;
  public boolean interMode;
  public int reportType;
  public long timeStamp;
  
  public String toString()
  {
    return "MiniAppShowInfoEntity{appId='" + this.appId + '\'' + ", appName='" + this.appName + '\'' + ", icon='" + this.icon + '\'' + ", desc='" + this.desc + '\'' + ", reportType=" + this.reportType + ", engineType=" + this.engineType + ", interMode=" + this.interMode + ", timeStamp='" + this.timeStamp + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkgEntity.MiniAppShowInfoEntity
 * JD-Core Version:    0.7.0.1
 */