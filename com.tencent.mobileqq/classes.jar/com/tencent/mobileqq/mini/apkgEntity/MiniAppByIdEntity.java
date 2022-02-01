package com.tencent.mobileqq.mini.apkgEntity;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.util.Arrays;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="appId,entryPath")
@Deprecated
public class MiniAppByIdEntity
  extends Entity
{
  public String appId;
  public String entryPath;
  public String extData;
  public byte[] extInfo;
  public String extendData;
  public byte[] first;
  public byte[] mDebug;
  public byte[] operInfo;
  public String shareTicket;
  public long timeStamp;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniAppByIdEntity{appId='");
    localStringBuilder.append(this.appId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", entryPath='");
    localStringBuilder.append(this.entryPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", timeStamp='");
    localStringBuilder.append(this.timeStamp);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareTicket='");
    localStringBuilder.append(this.shareTicket);
    localStringBuilder.append('\'');
    localStringBuilder.append(", first=");
    localStringBuilder.append(Arrays.toString(this.first));
    localStringBuilder.append(", mDebug=");
    localStringBuilder.append(Arrays.toString(this.mDebug));
    localStringBuilder.append(", extData='");
    localStringBuilder.append(this.extData);
    localStringBuilder.append('\'');
    localStringBuilder.append(", operInfo=");
    localStringBuilder.append(Arrays.toString(this.operInfo));
    localStringBuilder.append(", extInfo=");
    localStringBuilder.append(Arrays.toString(this.extInfo));
    localStringBuilder.append(", extendData='");
    localStringBuilder.append(this.extendData);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkgEntity.MiniAppByIdEntity
 * JD-Core Version:    0.7.0.1
 */