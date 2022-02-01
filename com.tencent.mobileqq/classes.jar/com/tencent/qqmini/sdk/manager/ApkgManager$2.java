package com.tencent.qqmini.sdk.manager;

import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.List;
import java.util.Map;

class ApkgManager$2
  implements DownloaderProxy.DownloadListener
{
  ApkgManager$2(ApkgManager paramApkgManager, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener, String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo, String paramString3, String paramString4, long paramLong) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    if (this.val$listener != null)
    {
      this.val$listener.onGetApkgInfo(null, 1, "下载失败");
      QMLog.d("ApkgManager", "onDownloadFailed() called with: statusCode = [" + paramInt + "], errorMsg = [" + paramString + "]");
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    FileUtils.deleteDirectory(this.val$unPackFolderPath);
    ApkgManager.access$100(this.this$0, this.val$savePath, this.val$unPackFolderPath, this.val$miniAppInfo, this.val$subApkUrl, this.val$independentPath, this.val$listener);
    ApkgManager.downloadDuration = System.currentTimeMillis() - this.val$startTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.ApkgManager.2
 * JD-Core Version:    0.7.0.1
 */