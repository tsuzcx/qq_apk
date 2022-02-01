package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import java.util.HashMap;

public class ExcitingTransferDownloaderResultRp
{
  public boolean bIsAutoDownload;
  public boolean bIsFlashTransfer;
  public boolean bIsXTFValid;
  public int dwLastLanResult;
  public int dwLastLanSubReason;
  public int dwReserved1;
  public int dwReserved2;
  public int dwReserved3;
  public int dwReserved4;
  public int eFinalResult;
  public int eXTFInvalidReason;
  public int nLastLanUserCode;
  public int speedUpType;
  public String strFileUrl;
  public int u32FtnTimeOutDuration;
  public int u32LifeInSecond;
  public long u64FtnTransferSize;
  public long u64FtnlSpeed;
  public long u64FtnlTransferTime;
  public long u64LanSpeed;
  public long u64LanTransferSize;
  public long u64LanTransferTime;
  public long u64StartSize;
  public long u64TransferSize;
  public long u64TransferSpeed;
  public long u64TransferTime;
  public int uMaxDownloadingFtnNum;
  public int wFtnConnectCount;
  public int wFtnConnectFailCount;
  public int wFtnRetryCount;
  public int wLanConnectCount;
  public int wLanConnectFailCount;
  public int wTransferMode;
  
  public HashMap<String, String> getReportData()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_IsXTFValid", String.valueOf(this.bIsXTFValid));
    localHashMap.put("param_XTFInvalidReason", String.valueOf(this.eXTFInvalidReason));
    localHashMap.put("param_FinalResult", String.valueOf(this.eFinalResult));
    localHashMap.put("param_FileUrl", String.valueOf(this.strFileUrl));
    localHashMap.put("param_LifeInSecond", String.valueOf(this.u32LifeInSecond));
    localHashMap.put("param_SpeedUpType", String.valueOf(this.speedUpType));
    localHashMap.put("param_StartSize", String.valueOf(this.u64StartSize));
    localHashMap.put("param_TransferSpeed", String.valueOf(this.u64TransferSpeed));
    localHashMap.put("param_TransferTime", String.valueOf(this.u64TransferTime));
    localHashMap.put("param_TransferSize", String.valueOf(this.u64TransferSize));
    localHashMap.put("param_LanSpeed", String.valueOf(this.u64LanSpeed));
    localHashMap.put("param_LanTransferTime", String.valueOf(this.u64LanTransferTime));
    localHashMap.put("param_LanTransferSize", String.valueOf(this.u64LanTransferSize));
    localHashMap.put("param_FtnlSpeed", String.valueOf(this.u64FtnlSpeed));
    localHashMap.put("param_FtnlTransferTime", String.valueOf(this.u64FtnlTransferTime));
    localHashMap.put("param_FtnTransferSize", String.valueOf(this.u64FtnTransferSize));
    localHashMap.put("param_MaxDownloadingFtnNum", String.valueOf(this.uMaxDownloadingFtnNum));
    localHashMap.put("param_LanConnectCount", String.valueOf(this.wLanConnectCount));
    localHashMap.put("param_FtnConnectCount", String.valueOf(this.wFtnConnectCount));
    localHashMap.put("param_LanConnectFailCount", String.valueOf(this.wLanConnectFailCount));
    localHashMap.put("param_FtnConnectFailCount", String.valueOf(this.wFtnConnectFailCount));
    localHashMap.put("param_LastLanResult", String.valueOf(this.dwLastLanResult));
    localHashMap.put("param_LastLanSubReason", String.valueOf(this.dwLastLanSubReason));
    localHashMap.put("param_LastLanUserCode", String.valueOf(this.nLastLanUserCode));
    localHashMap.put("param_FtnRetryCount", String.valueOf(this.wFtnRetryCount));
    localHashMap.put("param_FtnTimeOutDuration", String.valueOf(this.u32FtnTimeOutDuration));
    localHashMap.put("param_IsFlashTransfer", String.valueOf(this.bIsFlashTransfer));
    localHashMap.put("param_TransferMode", String.valueOf(this.wTransferMode));
    localHashMap.put("param_IsAutoDownload", String.valueOf(this.bIsAutoDownload));
    localHashMap.put("param_Reserved1", String.valueOf(this.dwReserved1));
    localHashMap.put("param_Reserved2", String.valueOf(this.dwReserved2));
    localHashMap.put("param_Reserved3", String.valueOf(this.dwReserved3));
    localHashMap.put("param_Reserved4", String.valueOf(this.dwReserved4));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloaderResultRp
 * JD-Core Version:    0.7.0.1
 */