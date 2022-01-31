package com.tencent.mobileqq.scribble;

import atgw;

public class ScribbleResMgr$ResInfo
{
  @atgw(a="downloading")
  public boolean downloading;
  @atgw(a="isShow")
  public int isShow = 1;
  @atgw(a="name")
  public String name = "";
  @atgw(a="orderIndex")
  public int orderIndex;
  @atgw(a="predownload")
  public int predownload = 1;
  @atgw(a="resType")
  public int resType;
  @atgw(a="showInApp")
  public int showInApp;
  @atgw(a="sourceId")
  public int sourceId;
  @atgw(a="sourceMd5")
  public String sourceMd5 = "";
  @atgw(a="sourceUrl")
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