package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.support.annotation.NonNull;
import java.util.HashMap;

public class ExcitingTransferDownloadCompletedInfo
{
  public int m_nSrvReturnCode;
  public String m_strFileSavePath;
  public String m_strLastServerHost;
  public long m_uDownloadedSize;
  public int m_uFirstRecvDataSize;
  public long m_uFirstRecvDataTime;
  public int m_uFullWatingNum;
  public int m_uProxyType;
  public int m_uReAllocatedNum;
  public int m_uRetryTimes;
  public long m_uStartSize;
  public long m_uStartTime;
  public long m_uTotalTimes;
  
  public HashMap<String, String> getReportData()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FileSavePath", String.valueOf(this.m_strFileSavePath));
    localHashMap.put("param_StartSize", String.valueOf(this.m_uStartSize));
    localHashMap.put("param_TotalTimes", String.valueOf(this.m_uTotalTimes));
    localHashMap.put("param_DownloadedSize", String.valueOf(this.m_uDownloadedSize));
    localHashMap.put("param_StartTime", String.valueOf(this.m_uStartTime));
    localHashMap.put("param_FirstRecvDataTime", String.valueOf(this.m_uFirstRecvDataTime));
    localHashMap.put("param_FirstRecvDataSize", String.valueOf(this.m_uFirstRecvDataSize));
    localHashMap.put("param_FullWatingNum", String.valueOf(this.m_uFullWatingNum));
    localHashMap.put("param_ReAllocatedNum", String.valueOf(this.m_uReAllocatedNum));
    localHashMap.put("param_RetryTimes", String.valueOf(this.m_uRetryTimes));
    localHashMap.put("param_ProxyType", String.valueOf(this.m_uProxyType));
    localHashMap.put("param_LastServerHost", String.valueOf(this.m_strLastServerHost));
    String str = "0";
    if (this.m_uTotalTimes != 0L) {
      str = String.valueOf((float)this.m_uDownloadedSize / (float)this.m_uTotalTimes);
    }
    localHashMap.put("param_speed", str);
    localHashMap.put("param_SrvRetCode", String.valueOf(this.m_nSrvReturnCode));
    return localHashMap;
  }
  
  @NonNull
  public String toString()
  {
    return "m_strFileSavePath:" + this.m_strFileSavePath + " m_uStartSize:" + this.m_uStartSize + " m_uTotalTimes:" + this.m_uTotalTimes + " m_uDownloadedSize:" + this.m_uDownloadedSize + " m_uReAllocatedNum:" + this.m_uReAllocatedNum + " m_uStartTime:" + this.m_uStartTime + " m_uFirstRecvDataTime:" + this.m_uFirstRecvDataTime + " m_uFirstRecvDataSize:" + this.m_uFirstRecvDataSize + " m_uFullWatingNum:" + this.m_uFullWatingNum + " m_uRetryTimes:" + this.m_uRetryTimes + " m_uProxyType:" + this.m_uProxyType + " m_strLastServerHost:" + this.m_strLastServerHost + " m_nSrvReturnCode:" + this.m_nSrvReturnCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo
 * JD-Core Version:    0.7.0.1
 */