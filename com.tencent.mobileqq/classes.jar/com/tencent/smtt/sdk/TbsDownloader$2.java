package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.HttpUtil.HttpResponseListener;
import com.tencent.smtt.utils.TbsLog;
import java.util.Map;

final class TbsDownloader$2
  implements HttpUtil.HttpResponseListener
{
  TbsDownloader$2(TbsDownloadConfig paramTbsDownloadConfig, boolean paramBoolean) {}
  
  public void onHttpResponseCode(int paramInt)
  {
    long l = System.currentTimeMillis();
    this.val$tbsDownloadConfig.mSyncMap.put("last_check", Long.valueOf(l));
    this.val$tbsDownloadConfig.commit();
    TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] httpResponseCode=" + paramInt);
    if ((TbsShareManager.isThirdPartyApp(TbsDownloader.access$100())) && (paramInt == 200))
    {
      this.val$tbsDownloadConfig.mSyncMap.put("last_request_success", Long.valueOf(System.currentTimeMillis()));
      this.val$tbsDownloadConfig.mSyncMap.put("request_fail", Long.valueOf(0L));
      this.val$tbsDownloadConfig.mSyncMap.put("count_request_fail_in_24hours", Long.valueOf(0L));
      this.val$tbsDownloadConfig.commit();
    }
    if (paramInt >= 300)
    {
      if (this.val$isQuery) {
        this.val$tbsDownloadConfig.setDownloadInterruptCode(-107);
      }
    }
    else {
      return;
    }
    this.val$tbsDownloadConfig.setDownloadInterruptCode(-207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloader.2
 * JD-Core Version:    0.7.0.1
 */