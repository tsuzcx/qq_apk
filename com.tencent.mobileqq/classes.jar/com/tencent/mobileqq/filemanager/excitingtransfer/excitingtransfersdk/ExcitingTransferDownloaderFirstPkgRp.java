package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import java.util.HashMap;

public class ExcitingTransferDownloaderFirstPkgRp
{
  public long mCSEndTime;
  public long mCSStartTime;
  public long mHtpFirstDataSize = -1L;
  public long mHttpFirstTime = 0L;
  
  public HashMap<String, String> getReportData()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_CSTime", String.valueOf(this.mCSEndTime - this.mCSStartTime));
    localHashMap.put("param_HttpFirstTime", String.valueOf(this.mHttpFirstTime));
    localHashMap.put("param_HttpFirstDataSize", String.valueOf(this.mHtpFirstDataSize));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloaderFirstPkgRp
 * JD-Core Version:    0.7.0.1
 */