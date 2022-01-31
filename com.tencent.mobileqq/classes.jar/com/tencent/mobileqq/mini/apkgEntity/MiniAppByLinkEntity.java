package com.tencent.mobileqq.mini.apkgEntity;

import awge;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.util.Arrays;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="link,linkType")
public class MiniAppByLinkEntity
  extends awge
{
  public String appId;
  public String extData;
  public byte[] extInfo;
  public String extendData;
  public byte[] first;
  public String link;
  public int linkType;
  public byte[] mDebug;
  public byte[] operInfo;
  public String shareTicket;
  public long timeStamp;
  
  public String toString()
  {
    return "MiniAppByLinkEntity{link='" + this.link + '\'' + ", linkType=" + this.linkType + ", appId='" + this.appId + '\'' + ", timeStamp='" + this.timeStamp + '\'' + ", shareTicket='" + this.shareTicket + '\'' + ", first=" + Arrays.toString(this.first) + ", mDebug=" + Arrays.toString(this.mDebug) + ", extData='" + this.extData + '\'' + ", operInfo=" + Arrays.toString(this.operInfo) + ", extInfo=" + Arrays.toString(this.extInfo) + ", extendData='" + this.extendData + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkgEntity.MiniAppByLinkEntity
 * JD-Core Version:    0.7.0.1
 */