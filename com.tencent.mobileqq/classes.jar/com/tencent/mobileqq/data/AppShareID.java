package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class AppShareID
  extends Entity
{
  public String appstorelink;
  public String bundleid;
  public String messagetail;
  public String officalwebsite;
  public short sLanType;
  public short sPriority;
  public short sResType;
  public String sourceUrl;
  @unique
  public String strPkgName;
  public String strResDesc;
  public String strResName;
  public String strResURLBig;
  public String strResURLSmall;
  public long uiNewVer;
  @unique
  public long uiResID;
  public long updateTime;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("[strPkgName = ");
    localStringBuilder.append(this.strPkgName);
    localStringBuilder.append("; uiResID = ");
    localStringBuilder.append(this.uiResID);
    localStringBuilder.append("; uiNewVer = ");
    localStringBuilder.append(this.uiNewVer);
    localStringBuilder.append("; messagetail = ");
    localStringBuilder.append(this.messagetail);
    localStringBuilder.append("; bundleid = ");
    localStringBuilder.append(this.bundleid);
    localStringBuilder.append("; sourceUrl = ");
    localStringBuilder.append(this.sourceUrl);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.AppShareID
 * JD-Core Version:    0.7.0.1
 */