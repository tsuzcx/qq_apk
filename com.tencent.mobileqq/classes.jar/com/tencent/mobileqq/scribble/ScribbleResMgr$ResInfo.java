package com.tencent.mobileqq.scribble;

import avyw;

public class ScribbleResMgr$ResInfo
{
  @avyw(a="downloading")
  public boolean downloading;
  @avyw(a="isShow")
  public int isShow = 1;
  @avyw(a="name")
  public String name = "";
  @avyw(a="orderIndex")
  public int orderIndex;
  @avyw(a="predownload")
  public int predownload = 1;
  @avyw(a="resType")
  public int resType;
  @avyw(a="showInApp")
  public int showInApp;
  @avyw(a="sourceId")
  public int sourceId;
  @avyw(a="sourceMd5")
  public String sourceMd5 = "";
  @avyw(a="sourceUrl")
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