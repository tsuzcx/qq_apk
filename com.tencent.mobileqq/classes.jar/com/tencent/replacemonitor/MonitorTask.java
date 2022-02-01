package com.tencent.replacemonitor;

import com.tencent.tmassistantbase.util.d;
import java.util.Map;

public class MonitorTask
{
  public String additionalId;
  public String appName;
  public int appType;
  public String cpChannelId;
  public String downloadUrl;
  public Map<String, String> externalParams;
  public String fileMd5;
  public String filePath;
  public long fileSize;
  public long id;
  public String installDir;
  public boolean isTencentDownload;
  public long lastModifedTime;
  public MonitorStep lastStep;
  public String packageName;
  public String traceId;
  public int versionCode;
  public long yybApkId;
  public long yybAppId;
  
  public MonitorTask() {}
  
  public MonitorTask(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.packageName = paramString1;
    this.versionCode = paramInt;
    this.downloadUrl = paramString2;
    this.filePath = paramString3;
  }
  
  public MonitorTask(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong, String paramString4)
  {
    this(paramString1, paramInt, paramString2, paramString3);
    this.fileSize = paramLong;
    this.fileMd5 = paramString4;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("MonitorTask:");
    localStringBuffer.append(" id = ");
    localStringBuffer.append(this.id);
    localStringBuffer.append(" packageName = ");
    localStringBuffer.append(this.packageName);
    localStringBuffer.append(" versionCode = ");
    localStringBuffer.append(this.versionCode);
    localStringBuffer.append(" appName = ");
    localStringBuffer.append(this.appName);
    localStringBuffer.append(" fileSize = ");
    localStringBuffer.append(this.fileSize);
    localStringBuffer.append(" fileMd5 = ");
    localStringBuffer.append(this.fileMd5);
    localStringBuffer.append(" cpChannelId = ");
    localStringBuffer.append(this.cpChannelId);
    localStringBuffer.append(" filePath = ");
    localStringBuffer.append(this.filePath);
    localStringBuffer.append(" downloadUrl = ");
    localStringBuffer.append(this.downloadUrl);
    localStringBuffer.append(" yybAppId = ");
    localStringBuffer.append(this.yybAppId);
    localStringBuffer.append(" yybApkId = ");
    localStringBuffer.append(this.yybApkId);
    localStringBuffer.append(" installDir = ");
    localStringBuffer.append(this.installDir);
    localStringBuffer.append(" lastModifedTime = ");
    localStringBuffer.append(this.lastModifedTime);
    localStringBuffer.append(" additionalId = ");
    localStringBuffer.append(this.additionalId);
    localStringBuffer.append(" traceId = ");
    localStringBuffer.append(this.traceId);
    localStringBuffer.append(" appType = ");
    localStringBuffer.append(this.appType);
    localStringBuffer.append(" lastStep = ");
    localStringBuffer.append(this.lastStep);
    localStringBuffer.append(" isTencentDownload = ");
    localStringBuffer.append(this.isTencentDownload);
    localStringBuffer.append(" externalParams = ");
    localStringBuffer.append(d.a(this.externalParams, "&"));
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.replacemonitor.MonitorTask
 * JD-Core Version:    0.7.0.1
 */