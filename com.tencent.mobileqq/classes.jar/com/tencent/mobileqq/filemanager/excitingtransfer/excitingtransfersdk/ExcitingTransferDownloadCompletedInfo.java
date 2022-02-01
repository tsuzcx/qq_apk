package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.support.annotation.NonNull;
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
    String str = "0";
    if (this.muTotalTimes != 0L) {
      str = String.valueOf((float)this.muDownloadedSize / (float)this.muTotalTimes);
    }
    localHashMap.put("param_speed", str);
    localHashMap.put("param_SrvRetCode", String.valueOf(this.mnSrvReturnCode));
    return localHashMap;
  }
  
  @NonNull
  public String toString()
  {
    return "m_strFileSavePath:" + this.mstrFileSavePath + " m_uStartSize:" + this.muStartSize + " m_uTotalTimes:" + this.muTotalTimes + " m_uDownloadedSize:" + this.muDownloadedSize + " m_uReAllocatedNum:" + this.muReAllocatedNum + " m_uStartTime:" + this.muStartTime + " m_uFirstRecvDataTime:" + this.muFirstRecvDataTime + " m_uFirstRecvDataSize:" + this.muFirstRecvDataSize + " m_uFullWatingNum:" + this.muFullWatingNum + " m_uRetryTimes:" + this.muRetryTimes + " m_uProxyType:" + this.muProxyType + " m_strLastServerHost:" + this.mstrLastServerHost + " m_nSrvReturnCode:" + this.mnSrvReturnCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo
 * JD-Core Version:    0.7.0.1
 */