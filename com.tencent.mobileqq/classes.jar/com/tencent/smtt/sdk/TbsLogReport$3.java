package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.HttpUtil.HttpResponseListener;
import com.tencent.smtt.utils.TbsLog;

class TbsLogReport$3
  implements HttpUtil.HttpResponseListener
{
  TbsLogReport$3(TbsLogReport paramTbsLogReport) {}
  
  public void onHttpResponseCode(int paramInt)
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + paramInt);
    if (paramInt < 300) {
      TbsLogReport.access$1900(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport.3
 * JD-Core Version:    0.7.0.1
 */