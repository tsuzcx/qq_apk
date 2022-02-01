package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import java.util.HashMap;

public class ExcitingTransferOneSlotComplete
{
  public long mConnectTimes;
  public long mDownloadedSize;
  public int mPort;
  public int mSrvRetCode;
  @Deprecated
  public int mSubReason;
  public long mTotalTimes;
  @Deprecated
  public int mUserRetCode;
  public String mstrIp;
  
  public HashMap<String, String> getReportData()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_strIp", String.valueOf(this.mstrIp));
    localHashMap.put("param_Port", String.valueOf(this.mPort));
    localHashMap.put("param_SrvRetCode", String.valueOf(this.mSrvRetCode));
    localHashMap.put("param_ConnectTimes", String.valueOf(this.mConnectTimes));
    localHashMap.put("param_TotalTimes", String.valueOf(this.mTotalTimes));
    localHashMap.put("param_DownloadedSize", String.valueOf(this.mDownloadedSize));
    long l = this.mTotalTimes;
    String str;
    if (l != 0L) {
      str = String.valueOf((float)this.mDownloadedSize / (float)l);
    } else {
      str = "0";
    }
    localHashMap.put("param_speed", str);
    return localHashMap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("m_strIp:");
    localStringBuilder.append(this.mstrIp);
    localStringBuilder.append(" m_Port:");
    localStringBuilder.append(this.mPort);
    localStringBuilder.append(" m_SubReason:");
    localStringBuilder.append(this.mSubReason);
    localStringBuilder.append(" m_SrvRetCode:");
    localStringBuilder.append(this.mSrvRetCode);
    localStringBuilder.append(" m_UserRetCode:");
    localStringBuilder.append(this.mUserRetCode);
    localStringBuilder.append(" m_ConnectTimes:");
    localStringBuilder.append(this.mConnectTimes);
    localStringBuilder.append(" m_TotalTimes:");
    localStringBuilder.append(this.mTotalTimes);
    localStringBuilder.append(" m_DownloadedSize:");
    localStringBuilder.append(this.mDownloadedSize);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete
 * JD-Core Version:    0.7.0.1
 */