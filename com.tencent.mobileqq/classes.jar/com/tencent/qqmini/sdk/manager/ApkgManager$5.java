package com.tencent.qqmini.sdk.manager;

import com.tencent.qqmini.sdk.core.manager.WxapkgUnpacker;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.io.File;
import java.util.List;
import java.util.Map;

class ApkgManager$5
  implements DownloaderProxy.DownloadListener
{
  ApkgManager$5(ApkgManager paramApkgManager, ApkgManager.OnInitApkgListener paramOnInitApkgListener, ApkgInfo paramApkgInfo, String paramString1, String paramString2, String paramString3, MiniAppInfo paramMiniAppInfo, String paramString4) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    if (this.val$listener != null)
    {
      this.val$listener.onInitApkgInfo(2, this.val$apkgInfo, "下载失败");
      QMLog.d("ApkgManager", "onDownloadFailed() called with: statusCode = [" + paramInt + "], errorMsg = [" + paramString + "] subRoot:" + this.val$subRoot);
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    QMLog.i("ApkgManager", "onDownloadSucceed subRoot=" + this.val$subRoot + " url=" + this.val$subPackDownloadUrl + " path=" + this.val$savePath);
    MiniReportManager.reportEventType(this.val$appConfig, 614, this.val$url, null, null, 0, "0", 0L, null);
    paramString = ApkgManager.getApkgFolderPath(this.val$appConfig);
    paramDownloadResult = new File(this.val$savePath);
    FileUtils.delete(paramString + File.separator + this.val$subRoot, false);
    boolean bool2 = this.val$appConfig.launchParam.isFlutterMode;
    boolean bool1 = false;
    if (bool2)
    {
      MiniReportManager.reportEventType(this.val$appConfig, 615, this.val$url, null, null, 0, "0", 0L, null);
      bool1 = WxapkgUnpacker.unpackSync(paramDownloadResult.getAbsolutePath(), paramString, this.val$subRoot);
      QMLog.d("ApkgManager", "downloadSubPack | getResPath :hasUnpack=" + bool1 + "; folderPath=" + paramString + "; subRoot=" + this.val$subRoot);
      MiniReportManager.reportEventType(this.val$appConfig, 1045, null, null, null, 0);
    }
    if ((bool1) || (!bool2)) {
      if (this.val$listener != null) {
        this.val$listener.onInitApkgInfo(0, this.val$apkgInfo, null);
      }
    }
    while (this.val$listener == null) {
      return;
    }
    this.val$listener.onInitApkgInfo(3, this.val$apkgInfo, "解包失败");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.ApkgManager.5
 * JD-Core Version:    0.7.0.1
 */