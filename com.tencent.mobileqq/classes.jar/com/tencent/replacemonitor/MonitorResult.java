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
    StringBuffer localStringBuffer = new StringBuffer(" step = ");
    localStringBuffer.append(this.step);
    localStringBuffer.append(" resultCode = ");
    localStringBuffer.append(this.resultCode);
    localStringBuffer.append(" resultMsg = ");
    localStringBuffer.append(this.resultMsg);
    localStringBuffer.append(" monitorType = ");
    localStringBuffer.append(this.monitorType);
    localStringBuffer.append(" replacedPkgName = ");
    localStringBuffer.append(this.replacedPkgName);
    localStringBuffer.append(" replacedVersionCode = ");
    localStringBuffer.append(this.replacedVersionCode);
    localStringBuffer.append(" replacedFileSize = ");
    localStringBuffer.append(this.replacedFileSize);
    localStringBuffer.append(" replaceChannelId = ");
    localStringBuffer.append(this.replaceChannelId);
    localStringBuffer.append(" replaceFileMD5 = ");
    localStringBuffer.append(this.replaceFileMD5);
    localStringBuffer.append(" replaceTime = ");
    localStringBuffer.append(this.replaceTime);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.replacemonitor.MonitorResult
 * JD-Core Version:    0.7.0.1
 */