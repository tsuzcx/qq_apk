package com.tencent.replacemonitor.replace.st;

import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorType;
import com.tencent.tmassistantbase.util.d;

public class ReplaceMonitorLog
  extends ReplaceBaseLog
{
  public String additionalId;
  public int appType;
  public String channelId;
  public long fileSize;
  public MonitorType monitorType;
  public String replaceChannelId;
  public String replaceFileMd5;
  public long replaceFileSize;
  public long replaceInterval;
  public String replacePackageName;
  public long replaceVersionCode;
  public MonitorStep step;
  
  public String build()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.packageName);
    localStringBuilder.append("|");
    localStringBuilder.append(this.versionCode);
    localStringBuilder.append("|");
    localStringBuilder.append(this.fileSize);
    localStringBuilder.append("|");
    localStringBuilder.append(this.channelId);
    localStringBuilder.append("|");
    localStringBuilder.append(this.yybAppId);
    localStringBuilder.append("|");
    localStringBuilder.append(this.yybApkId);
    localStringBuilder.append("|");
    localStringBuilder.append(this.replacePackageName);
    localStringBuilder.append("|");
    localStringBuilder.append(this.replaceVersionCode);
    localStringBuilder.append("|");
    localStringBuilder.append(this.replaceFileSize);
    localStringBuilder.append("|");
    localStringBuilder.append(this.replaceChannelId);
    localStringBuilder.append("|");
    localStringBuilder.append(this.replaceFileMd5);
    localStringBuilder.append("|");
    localStringBuilder.append(this.additionalId);
    localStringBuilder.append("|");
    localStringBuilder.append(this.traceId);
    localStringBuilder.append("|");
    localStringBuilder.append(this.appType);
    localStringBuilder.append("|");
    localStringBuilder.append(this.replaceInterval);
    localStringBuilder.append("|");
    localStringBuilder.append(this.step);
    localStringBuilder.append("|");
    localStringBuilder.append(this.monitorType);
    localStringBuilder.append("|");
    localStringBuilder.append(this.isTDownloadApp);
    localStringBuilder.append("|");
    localStringBuilder.append(d.a(this.externalParams, "&"));
    return localStringBuilder.toString();
  }
  
  protected int getType()
  {
    return 5001;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.st.ReplaceMonitorLog
 * JD-Core Version:    0.7.0.1
 */