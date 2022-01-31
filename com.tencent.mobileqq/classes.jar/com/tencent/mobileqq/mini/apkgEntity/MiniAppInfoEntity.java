package com.tencent.mobileqq.mini.apkgEntity;

import auko;
import aumc;

public class MiniAppInfoEntity
  extends auko
{
  public static final String TAG = "MiniAppInfoEntity";
  @aumc
  public String appId;
  public byte[] appInfo;
  public long timeStamp;
  
  public String toString()
  {
    return "MiniAppInfoEntity{appId='" + this.appId + '\'' + ", timeStamp='" + this.timeStamp + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoEntity
 * JD-Core Version:    0.7.0.1
 */