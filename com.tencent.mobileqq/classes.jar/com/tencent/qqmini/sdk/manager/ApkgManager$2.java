package com.tencent.qqmini.sdk.manager;

import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.util.List;
import java.util.Map;

class ApkgManager$2
  implements DownloaderProxy.DownloadListener
{
  ApkgManager$2(ApkgManager paramApkgManager, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener, MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    Object localObject = this.val$listener;
    if (localObject != null)
    {
      ((ApkgManager.OnGetApkgInfoListener)localObject).onGetApkgInfo(null, 1, "下载失败");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadFailed() called with: statusCode = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], errorMsg = [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QMLog.d("ApkgManager", ((StringBuilder)localObject).toString());
      MiniReportManager.reportEventType(this.val$miniAppInfo, 620, null, paramString, null, paramInt);
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    paramString = new StringBuilder();
    paramString.append("onDownloadSucceed ");
    paramString.append(this.val$apkUrl);
    QMLog.d("ApkgManager", paramString.toString());
    long l;
    if (paramDownloadResult != null) {
      l = paramDownloadResult.contentLength;
    } else {
      l = -1L;
    }
    MiniReportManager.reportEventType(this.val$miniAppInfo, 620, "", String.valueOf(l), "", 0, this.val$apkUrl, "", "", "");
    FileUtils.deleteDirectory(this.val$unPackFolderPath);
    ApkgManager.access$100(this.this$0, this.val$savePath, this.val$unPackFolderPath, this.val$miniAppInfo, this.val$subApkUrl, this.val$independentPath, this.val$listener);
    ApkgManager.downloadDuration = System.currentTimeMillis() - this.val$startTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.ApkgManager.2
 * JD-Core Version:    0.7.0.1
 */