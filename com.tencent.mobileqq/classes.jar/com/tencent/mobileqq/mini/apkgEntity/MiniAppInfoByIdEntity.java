package com.tencent.mobileqq.mini.apkgEntity;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="appId,entryPath")
public class MiniAppInfoByIdEntity
  extends Entity
{
  public String appId;
  public byte[] appInfo;
  public String entryPath;
  public long timeStamp;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniAppInfoByIdEntity{appId='");
    localStringBuilder.append(this.appId);
    localStringBuilder.append('\'');
    localStringBuilder.append("entryPath='");
    localStringBuilder.append(this.entryPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", timeStamp='");
    localStringBuilder.append(this.timeStamp);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoByIdEntity
 * JD-Core Version:    0.7.0.1
 */