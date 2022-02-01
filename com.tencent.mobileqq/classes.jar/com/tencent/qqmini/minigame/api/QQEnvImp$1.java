package com.tencent.qqmini.minigame.api;

import com.tencent.mobileqq.triton.sdk.download.ITDownloadListener;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import java.io.File;
import java.util.List;
import java.util.Map;

class QQEnvImp$1
  implements DownloaderProxy.DownloadListener
{
  QQEnvImp$1(QQEnvImp paramQQEnvImp, ITDownloadListener paramITDownloadListener, String paramString1, String paramString2) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    if (this.val$callback != null) {
      this.val$callback.onFail(this.val$downloadUrl, paramInt, null);
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    if (this.val$callback != null) {
      this.val$callback.onProgress(this.val$downloadUrl, paramLong2, paramFloat);
    }
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    boolean bool = new File(this.val$targetTmpFile).exists();
    String str;
    if (this.val$callback != null)
    {
      if (!bool) {
        break label98;
      }
      paramString = MiniAppFileManager.getMiniAppFileManager(this.this$0.getAppId());
      paramDownloadResult = this.val$callback;
      str = this.val$downloadUrl;
      if (paramString == null) {
        break label92;
      }
    }
    label92:
    for (paramString = paramString.getWxFilePath(this.val$targetTmpFile);; paramString = "")
    {
      paramDownloadResult.onSuccess(str, paramInt, null, paramString);
      this.val$callback.onSuccess(this.val$downloadUrl, paramInt, null, "");
      return;
    }
    label98:
    this.val$callback.onFail(this.val$downloadUrl, 5, "target file not exists");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.QQEnvImp.1
 * JD-Core Version:    0.7.0.1
 */