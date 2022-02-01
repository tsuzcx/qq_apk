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
    return this.packageName + "|" + this.versionCode + "|" + this.fileSize + "|" + this.channelId + "|" + this.yybAppId + "|" + this.yybApkId + "|" + this.replacePackageName + "|" + this.replaceVersionCode + "|" + this.replaceFileSize + "|" + this.replaceChannelId + "|" + this.replaceFileMd5 + "|" + this.additionalId + "|" + this.traceId + "|" + this.appType + "|" + this.replaceInterval + "|" + this.step + "|" + this.monitorType + "|" + this.isTDownloadApp + "|" + d.a(this.externalParams, "&");
  }
  
  public int getType()
  {
    return 5001;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.st.ReplaceMonitorLog
 * JD-Core Version:    0.7.0.1
 */