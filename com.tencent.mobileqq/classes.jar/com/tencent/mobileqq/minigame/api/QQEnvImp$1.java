package com.tencent.mobileqq.minigame.api;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.triton.sdk.download.ITDownloadListener;
import java.io.File;

class QQEnvImp$1
  implements Downloader.DownloadListener
{
  QQEnvImp$1(QQEnvImp paramQQEnvImp, ITDownloadListener paramITDownloadListener, String paramString) {}
  
  public void onDownloadCanceled(String paramString)
  {
    if (this.val$callback != null) {
      this.val$callback.onCancel(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (this.val$callback != null) {
      this.val$callback.onFail(paramString, paramDownloadResult.getStatus().getFailReason(), null);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.val$callback != null) {
      this.val$callback.onProgress(paramString, paramLong, paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    boolean bool = new File(this.val$targetTmpFile).exists();
    if (this.val$callback != null)
    {
      if (bool) {
        this.val$callback.onSuccess(paramString, paramDownloadResult.getContent().retCode, null, MiniAppFileManager.getInstance().getWxFilePath(this.val$targetTmpFile));
      }
    }
    else {
      return;
    }
    this.val$callback.onFail(paramString, 5, "target file not exists");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQEnvImp.1
 * JD-Core Version:    0.7.0.1
 */