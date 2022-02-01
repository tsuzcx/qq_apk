package com.tencent.mobileqq.scribble;

import avnm;

public class ScribbleResMgr$ResInfo
{
  @avnm(a="downloading")
  public boolean downloading;
  @avnm(a="isShow")
  public int isShow = 1;
  @avnm(a="name")
  public String name = "";
  @avnm(a="orderIndex")
  public int orderIndex;
  @avnm(a="predownload")
  public int predownload = 1;
  @avnm(a="resType")
  public int resType;
  @avnm(a="showInApp")
  public int showInApp;
  @avnm(a="sourceId")
  public int sourceId;
  @avnm(a="sourceMd5")
  public String sourceMd5 = "";
  @avnm(a="sourceUrl")
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo
 * JD-Core Version:    0.7.0.1
 */