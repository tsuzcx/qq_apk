package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import java.util.HashMap;

public class ExcitingTransferDownloadCompletedInfo
{
  public int mnSrvReturnCode = 0;
  public String mstrFileSavePath;
  public String mstrLastServerHost;
  public long muDownloadedSize;
  public int muFirstRecvDataSize;
  public long muFirstRecvDataTime;
  public int muFullWatingNum;
  public int muProxyType;
  public int muReAllocatedNum;
  public int muRetryTimes;
  public long muStartSize;
  public long muStartTime;
  public long muTotalTimes;
  
  public HashMap<String, String> getReportData()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FileSavePath", String.valueOf(this.mstrFileSavePath));
    localHashMap.put("param_StartSize", String.valueOf(this.muStartSize));
    localHashMap.put("param_TotalTimes", String.valueOf(this.muTotalTimes));
    localHashMap.put("param_DownloadedSize", String.valueOf(this.muDownloadedSize));
    localHashMap.put("param_StartTime", String.valueOf(this.muStartTime));
    localHashMap.put("param_FirstRecvDataTime", String.valueOf(this.muFirstRecvDataTime));
    localHashMap.put("param_FirstRecvDataSize", String.valueOf(this.muFirstRecvDataSize));
    localHashMap.put("param_FullWatingNum", String.valueOf(this.muFullWatingNum));
    localHashMap.put("param_ReAllocatedNum", String.valueOf(this.muReAllocatedNum));
    localHashMap.put("param_RetryTimes", String.valueOf(this.muRetryTimes));
    localHashMap.put("param_ProxyType", String.valueOf(this.muProxyType));
    localHashMap.put("param_LastServerHost", String.valueOf(this.mstrLastServerHost));
    long l = this.muTotalTimes;
    String str;
    if (l != 0L) {
      str = String.valueOf((float)this.muDownloadedSize / (float)l);
    } else {
      str = "0";
    }
    localHashMap.put("param_speed", str);
    localHashMap.put("param_SrvRetCode", String.valueOf(this.mnSrvReturnCode));
    return localHashMap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("m_strFileSavePath:");
    localStringBuilder.append(this.mstrFileSavePath);
    localStringBuilder.append(" m_uStartSize:");
    localStringBuilder.append(this.muStartSize);
    localStringBuilder.append(" m_uTotalTimes:");
    localStringBuilder.append(this.muTotalTimes);
    localStringBuilder.append(" m_uDownloadedSize:");
    localStringBuilder.append(this.muDownloadedSize);
    localStringBuilder.append(" m_uReAllocatedNum:");
    localStringBuilder.append(this.muReAllocatedNum);
    localStringBuilder.append(" m_uStartTime:");
    localStringBuilder.append(this.muStartTime);
    localStringBuilder.append(" m_uFirstRecvDataTime:");
    localStringBuilder.append(this.muFirstRecvDataTime);
    localStringBuilder.append(" m_uFirstRecvDataSize:");
    localStringBuilder.append(this.muFirstRecvDataSize);
    localStringBuilder.append(" m_uFullWatingNum:");
    localStringBuilder.append(this.muFullWatingNum);
    localStringBuilder.append(" m_uRetryTimes:");
    localStringBuilder.append(this.muRetryTimes);
    localStringBuilder.append(" m_uProxyType:");
    localStringBuilder.append(this.muProxyType);
    localStringBuilder.append(" m_strLastServerHost:");
    localStringBuilder.append(this.mstrLastServerHost);
    localStringBuilder.append(" m_nSrvReturnCode:");
    localStringBuilder.append(this.mnSrvReturnCode);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo
 * JD-Core Version:    0.7.0.1
 */