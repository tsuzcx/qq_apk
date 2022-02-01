package com.tencent.mobileqq.scribble;

import com.tencent.mobileqq.jsonconverter.Alias;

public class ScribbleResMgr$ResInfo
{
  @Alias(a="downloading")
  public boolean downloading = false;
  @Alias(a="isShow")
  public int isShow = 1;
  @Alias(a="name")
  public String name = "";
  @Alias(a="orderIndex")
  public int orderIndex = 0;
  @Alias(a="predownload")
  public int predownload = 1;
  @Alias(a="resType")
  public int resType = 0;
  @Alias(a="showInApp")
  public int showInApp;
  @Alias(a="sourceId")
  public int sourceId = 0;
  @Alias(a="sourceMd5")
  public String sourceMd5 = "";
  @Alias(a="sourceUrl")
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