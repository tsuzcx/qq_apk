package com.tencent.mobileqq.qzonevip.gift;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

final class QzoneGiftUtil$2
  implements Downloader.DownloadListener
{
  QzoneGiftUtil$2(QzoneZipCacheHelperCallBack paramQzoneZipCacheHelperCallBack) {}
  
  public void onDownloadCanceled(String paramString)
  {
    paramString = this.a;
    if (paramString != null) {
      paramString.onResult(false);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = this.a;
    if (paramString != null) {
      paramString.onResult(false);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = this.a;
    if (paramString != null) {
      paramString.onResult(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.QzoneGiftUtil.2
 * JD-Core Version:    0.7.0.1
 */