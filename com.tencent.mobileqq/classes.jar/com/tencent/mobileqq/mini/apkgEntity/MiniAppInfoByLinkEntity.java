package com.tencent.mobileqq.mini.apkgEntity;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="link,linkType")
public class MiniAppInfoByLinkEntity
  extends Entity
{
  public byte[] appInfo;
  public String link;
  public int linkType;
  public String shareTicket;
  public long timeStamp;
  
  public String toString()
  {
    return "MiniAppInfoByLinkEntity{link='" + this.link + '\'' + "linkType='" + this.linkType + '\'' + "linkType='" + this.shareTicket + '\'' + ", timeStamp='" + this.timeStamp + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoByLinkEntity
 * JD-Core Version:    0.7.0.1
 */