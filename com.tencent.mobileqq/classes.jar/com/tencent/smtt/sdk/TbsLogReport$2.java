package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.HttpUtil.HttpResponseListener;
import com.tencent.smtt.utils.TbsLog;

class TbsLogReport$2
  implements HttpUtil.HttpResponseListener
{
  TbsLogReport$2(TbsLogReport paramTbsLogReport) {}
  
  public void onHttpResponseCode(int paramInt)
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportTbsLog] httpResponseCode=" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport.2
 * JD-Core Version:    0.7.0.1
 */