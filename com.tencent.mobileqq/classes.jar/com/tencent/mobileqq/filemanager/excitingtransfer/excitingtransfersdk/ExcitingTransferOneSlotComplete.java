package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.support.annotation.NonNull;
import java.util.HashMap;

public class ExcitingTransferOneSlotComplete
{
  public long m_ConnectTimes;
  public long m_DownloadedSize;
  public int m_Port;
  public int m_SrvRetCode;
  @Deprecated
  public int m_SubReason;
  public long m_TotalTimes;
  @Deprecated
  public int m_UserRetCode;
  public String m_strIp;
  
  public HashMap<String, String> getReportData()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_strIp", String.valueOf(this.m_strIp));
    localHashMap.put("param_Port", String.valueOf(this.m_Port));
    localHashMap.put("param_SrvRetCode", String.valueOf(this.m_SrvRetCode));
    localHashMap.put("param_ConnectTimes", String.valueOf(this.m_ConnectTimes));
    localHashMap.put("param_TotalTimes", String.valueOf(this.m_TotalTimes));
    localHashMap.put("param_DownloadedSize", String.valueOf(this.m_DownloadedSize));
    String str = "0";
    if (this.m_TotalTimes != 0L) {
      str = String.valueOf((float)this.m_DownloadedSize / (float)this.m_TotalTimes);
    }
    localHashMap.put("param_speed", str);
    return localHashMap;
  }
  
  @NonNull
  public String toString()
  {
    return "m_strIp:" + this.m_strIp + " m_Port:" + this.m_Port + " m_SubReason:" + this.m_SubReason + " m_SrvRetCode:" + this.m_SrvRetCode + " m_UserRetCode:" + this.m_UserRetCode + " m_ConnectTimes:" + this.m_ConnectTimes + " m_TotalTimes:" + this.m_TotalTimes + " m_DownloadedSize:" + this.m_DownloadedSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete
 * JD-Core Version:    0.7.0.1
 */