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
    return "MiniAppInfoByIdEntity{appId='" + this.appId + '\'' + "entryPath='" + this.entryPath + '\'' + ", timeStamp='" + this.timeStamp + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoByIdEntity
 * JD-Core Version:    0.7.0.1
 */