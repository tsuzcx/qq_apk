package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.support.annotation.NonNull;
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
    String str = "0";
    if (this.mTotalTimes != 0L) {
      str = String.valueOf((float)this.mDownloadedSize / (float)this.mTotalTimes);
    }
    localHashMap.put("param_speed", str);
    return localHashMap;
  }
  
  @NonNull
  public String toString()
  {
    return "m_strIp:" + this.mstrIp + " m_Port:" + this.mPort + " m_SubReason:" + this.mSubReason + " m_SrvRetCode:" + this.mSrvRetCode + " m_UserRetCode:" + this.mUserRetCode + " m_ConnectTimes:" + this.mConnectTimes + " m_TotalTimes:" + this.mTotalTimes + " m_DownloadedSize:" + this.mDownloadedSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete
 * JD-Core Version:    0.7.0.1
 */