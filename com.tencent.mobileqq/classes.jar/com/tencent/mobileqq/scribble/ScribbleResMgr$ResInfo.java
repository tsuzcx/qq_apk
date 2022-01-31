package com.tencent.mobileqq.scribble;

import aqrf;

public class ScribbleResMgr$ResInfo
{
  @aqrf(a="downloading")
  public boolean downloading;
  @aqrf(a="isShow")
  public int isShow = 1;
  @aqrf(a="name")
  public String name = "";
  @aqrf(a="orderIndex")
  public int orderIndex;
  @aqrf(a="predownload")
  public int predownload = 1;
  @aqrf(a="resType")
  public int resType;
  @aqrf(a="showInApp")
  public int showInApp;
  @aqrf(a="sourceId")
  public int sourceId;
  @aqrf(a="sourceMd5")
  public String sourceMd5 = "";
  @aqrf(a="sourceUrl")
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo
 * JD-Core Version:    0.7.0.1
 */