package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import java.util.HashMap;

public class ExcitingTransferDownloaderRp
{
  public int dwProxyType;
  public long dwSrvCode;
  public long dwSubReason;
  public int dwTimeOutDuration;
  public long nUserReturCode;
  public String strServerIp;
  public long u64EndPos;
  public long u64StartPos;
  public long u64TransferSize;
  public long u64TransferSpeed;
  public long u64TransferTime;
  public int wIPStack;
  public int wLanChannelNum;
  public int wRetryCount;
  public int wServerPort;
  
  public HashMap<String, String> getReportData()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_SubReason", String.valueOf(this.dwSubReason));
    localHashMap.put("param_SrvCode", String.valueOf(this.dwSrvCode));
    localHashMap.put("param_UserReturCode", String.valueOf(this.nUserReturCode));
    localHashMap.put("param_RetryCount", String.valueOf(this.wRetryCount));
    localHashMap.put("param_TimeOutDuration", String.valueOf(this.dwTimeOutDuration));
    localHashMap.put("param_TransferSpeed", String.valueOf(this.u64TransferSpeed));
    localHashMap.put("param_TransferTime", String.valueOf(this.u64TransferTime));
    localHashMap.put("param_TransferSize", String.valueOf(this.u64TransferSize));
    localHashMap.put("param_ServerIp", String.valueOf(this.strServerIp));
    localHashMap.put("param_ServerPort", String.valueOf(this.wServerPort));
    localHashMap.put("param_ProxyType", String.valueOf(this.dwProxyType));
    localHashMap.put("param_StartPos", String.valueOf(this.u64StartPos));
    localHashMap.put("param_EndPos", String.valueOf(this.u64EndPos));
    localHashMap.put("param_LanChannelNum", String.valueOf(this.wLanChannelNum));
    localHashMap.put("param_ipStack", String.valueOf(this.wIPStack));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloaderRp
 * JD-Core Version:    0.7.0.1
 */