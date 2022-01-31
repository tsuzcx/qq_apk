package com.tencent.replacemonitor;

public class MonitorResult
{
  public MonitorType monitorType;
  public String replaceChannelId;
  public String replaceFileMD5;
  public long replaceTime;
  public long replacedFileSize;
  public String replacedPkgName;
  public long replacedVersionCode;
  public int resultCode;
  public String resultMsg;
  public MonitorStep step;
  
  public MonitorResult(MonitorStep paramMonitorStep, int paramInt, String paramString, MonitorType paramMonitorType)
  {
    this.step = paramMonitorStep;
    this.monitorType = paramMonitorType;
    this.resultCode = paramInt;
    this.resultMsg = paramString;
  }
  
  public String toString()
  {
    return " step = " + this.step + " resultCode = " + this.resultCode + " resultMsg = " + this.resultMsg + " monitorType = " + this.monitorType + " replacedPkgName = " + this.replacedPkgName + " replacedVersionCode = " + this.replacedVersionCode + " replacedFileSize = " + this.replacedFileSize + " replaceChannelId = " + this.replaceChannelId + " replaceFileMD5 = " + this.replaceFileMD5 + " replaceTime = " + this.replaceTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.replacemonitor.MonitorResult
 * JD-Core Version:    0.7.0.1
 */