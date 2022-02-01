package com.tencent.mobileqq.scribble;

import ausx;

public class ScribbleResMgr$ResInfo
{
  @ausx(a="downloading")
  public boolean downloading;
  @ausx(a="isShow")
  public int isShow = 1;
  @ausx(a="name")
  public String name = "";
  @ausx(a="orderIndex")
  public int orderIndex;
  @ausx(a="predownload")
  public int predownload = 1;
  @ausx(a="resType")
  public int resType;
  @ausx(a="showInApp")
  public int showInApp;
  @ausx(a="sourceId")
  public int sourceId;
  @ausx(a="sourceMd5")
  public String sourceMd5 = "";
  @ausx(a="sourceUrl")
  public String sourceUrl = "";
  
  ResInfo cpy(ResInfo paramResInfo)
  {
    ResInfo localResInfo = new ResInfo();
    localResInfo.resType = paramResInfo.resType;
    localResInfo.sourceId = paramResInfo.sourceId;
    localResInfo.sourceUrl = paramResInfo.sourceUrl;
    localResInfo.sourceMd5 = paramResInfo.sourceMd5;
    localResInfo.name = paramResInfo.name;
    localResInfo.predownload = paramResInfo.predownload;
    localResInfo.downloading = paramResInfo.downloading;
    localResInfo.isShow = paramResInfo.isShow;
    localResInfo.showInApp = paramResInfo.showInApp;
    localResInfo.orderIndex = paramResInfo.orderIndex;
    return localResInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo
 * JD-Core Version:    0.7.0.1
 */