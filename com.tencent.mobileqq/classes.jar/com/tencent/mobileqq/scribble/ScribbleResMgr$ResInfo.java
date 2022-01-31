package com.tencent.mobileqq.scribble;

import atcn;

public class ScribbleResMgr$ResInfo
{
  @atcn(a="downloading")
  public boolean downloading;
  @atcn(a="isShow")
  public int isShow = 1;
  @atcn(a="name")
  public String name = "";
  @atcn(a="orderIndex")
  public int orderIndex;
  @atcn(a="predownload")
  public int predownload = 1;
  @atcn(a="resType")
  public int resType;
  @atcn(a="showInApp")
  public int showInApp;
  @atcn(a="sourceId")
  public int sourceId;
  @atcn(a="sourceMd5")
  public String sourceMd5 = "";
  @atcn(a="sourceUrl")
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo
 * JD-Core Version:    0.7.0.1
 */