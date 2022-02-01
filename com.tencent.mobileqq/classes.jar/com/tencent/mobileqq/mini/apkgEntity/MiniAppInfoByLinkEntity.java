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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniAppInfoByLinkEntity{link='");
    localStringBuilder.append(this.link);
    localStringBuilder.append('\'');
    localStringBuilder.append("linkType='");
    localStringBuilder.append(this.linkType);
    localStringBuilder.append('\'');
    localStringBuilder.append("linkType='");
    localStringBuilder.append(this.shareTicket);
    localStringBuilder.append('\'');
    localStringBuilder.append(", timeStamp='");
    localStringBuilder.append(this.timeStamp);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoByLinkEntity
 * JD-Core Version:    0.7.0.1
 */