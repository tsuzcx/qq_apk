package com.tencent.mobileqq.mini.apkgEntity;

import awbv;
import awdj;

public class MiniAppInfoEntity
  extends awbv
{
  public static final String TAG = "MiniAppInfoEntity";
  @awdj
  public String appId;
  public byte[] appInfo;
  public long timeStamp;
  
  public String toString()
  {
    return "MiniAppInfoEntity{appId='" + this.appId + '\'' + ", timeStamp='" + this.timeStamp + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoEntity
 * JD-Core Version:    0.7.0.1
 */