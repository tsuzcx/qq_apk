package com.tencent.mobileqq.scribble;

import awfx;

public class ScribbleResMgr$ResInfo
{
  @awfx(a="downloading")
  public boolean downloading;
  @awfx(a="isShow")
  public int isShow = 1;
  @awfx(a="name")
  public String name = "";
  @awfx(a="orderIndex")
  public int orderIndex;
  @awfx(a="predownload")
  public int predownload = 1;
  @awfx(a="resType")
  public int resType;
  @awfx(a="showInApp")
  public int showInApp;
  @awfx(a="sourceId")
  public int sourceId;
  @awfx(a="sourceMd5")
  public String sourceMd5 = "";
  @awfx(a="sourceUrl")
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