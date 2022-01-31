package com.tencent.mobileqq.scribble;

import arlz;

public class ScribbleResMgr$ResInfo
{
  @arlz(a="downloading")
  public boolean downloading;
  @arlz(a="isShow")
  public int isShow = 1;
  @arlz(a="name")
  public String name = "";
  @arlz(a="orderIndex")
  public int orderIndex;
  @arlz(a="predownload")
  public int predownload = 1;
  @arlz(a="resType")
  public int resType;
  @arlz(a="showInApp")
  public int showInApp;
  @arlz(a="sourceId")
  public int sourceId;
  @arlz(a="sourceMd5")
  public String sourceMd5 = "";
  @arlz(a="sourceUrl")
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