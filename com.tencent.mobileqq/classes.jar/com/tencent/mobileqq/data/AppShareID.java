package com.tencent.mobileqq.data;

import awbv;
import awdj;

public class AppShareID
  extends awbv
{
  public String appstorelink;
  public String bundleid;
  public String messagetail;
  public String officalwebsite;
  public short sLanType;
  public short sPriority;
  public short sResType;
  public String sourceUrl;
  @awdj
  public String strPkgName;
  public String strResDesc;
  public String strResName;
  public String strResURL_big;
  public String strResURL_small;
  public long uiNewVer;
  @awdj
  public long uiResID;
  public long updateTime;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("[strPkgName = ").append(this.strPkgName).append("; uiResID = ").append(this.uiResID).append("; uiNewVer = ").append(this.uiNewVer).append("; messagetail = ").append(this.messagetail).append("; bundleid = ").append(this.bundleid).append("; sourceUrl = ").append(this.sourceUrl).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.data.AppShareID
 * JD-Core Version:    0.7.0.1
 */