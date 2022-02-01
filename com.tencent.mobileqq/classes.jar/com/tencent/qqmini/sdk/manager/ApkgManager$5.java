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
    Object localObject = this.val$listener;
    if (localObject != null)
    {
      ((ApkgManager.OnInitApkgListener)localObject).onInitApkgInfo(2, this.val$apkgInfo, "下载失败");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadFailed() called with: statusCode = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], errorMsg = [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("] subRoot:");
      ((StringBuilder)localObject).append(this.val$subRoot);
      QMLog.d("ApkgManager", ((StringBuilder)localObject).toString());
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    paramString = new StringBuilder();
    paramString.append("onDownloadSucceed subRoot=");
    paramString.append(this.val$subRoot);
    paramString.append(" url=");
    paramString.append(this.val$subPackDownloadUrl);
    paramString.append(" path=");
    paramString.append(this.val$savePath);
    QMLog.i("ApkgManager", paramString.toString());
    MiniReportManager.reportEventType(this.val$appConfig, 614, this.val$url, null, null, 0, "0", 0L, null);
    paramString = ApkgManager.getApkgFolderPath(this.val$appConfig);
    paramDownloadResult = new File(this.val$savePath);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.val$subRoot);
    FileUtils.delete(localStringBuilder.toString(), false);
    boolean bool2 = this.val$appConfig.launchParam.isFlutterMode;
    boolean bool1;
    if (bool2)
    {
      MiniReportManager.reportEventType(this.val$appConfig, 615, this.val$url, null, null, 0, "0", 0L, null);
      bool1 = WxapkgUnpacker.unpackSync(paramDownloadResult.getAbsolutePath(), paramString, this.val$subRoot);
      paramDownloadResult = new StringBuilder();
      paramDownloadResult.append("downloadSubPack | getResPath :hasUnpack=");
      paramDownloadResult.append(bool1);
      paramDownloadResult.append("; folderPath=");
      paramDownloadResult.append(paramString);
      paramDownloadResult.append("; subRoot=");
      paramDownloadResult.append(this.val$subRoot);
      QMLog.d("ApkgManager", paramDownloadResult.toString());
      MiniReportManager.reportEventType(this.val$appConfig, 1045, null, null, null, 0);
    }
    else
    {
      bool1 = false;
    }
    if ((!bool1) && (bool2))
    {
      paramString = this.val$listener;
      if (paramString != null) {
        paramString.onInitApkgInfo(3, this.val$apkgInfo, "解包失败");
      }
    }
    else
    {
      paramString = this.val$listener;
      if (paramString != null) {
        paramString.onInitApkgInfo(0, this.val$apkgInfo, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.ApkgManager.5
 * JD-Core Version:    0.7.0.1
 */