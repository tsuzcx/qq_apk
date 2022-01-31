package com.tencent.mobileqq.scribble;

import arlx;

public class ScribbleResMgr$ResInfo
{
  @arlx(a="downloading")
  public boolean downloading;
  @arlx(a="isShow")
  public int isShow = 1;
  @arlx(a="name")
  public String name = "";
  @arlx(a="orderIndex")
  public int orderIndex;
  @arlx(a="predownload")
  public int predownload = 1;
  @arlx(a="resType")
  public int resType;
  @arlx(a="showInApp")
  public int showInApp;
  @arlx(a="sourceId")
  public int sourceId;
  @arlx(a="sourceMd5")
  public String sourceMd5 = "";
  @arlx(a="sourceUrl")
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