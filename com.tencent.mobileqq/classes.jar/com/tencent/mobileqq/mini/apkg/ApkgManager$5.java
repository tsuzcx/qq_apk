package com.tencent.mobileqq.mini.apkg;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Process;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.utils.WxapkgUnpacker;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ApkgManager$5
  implements Downloader.DownloadListener
{
  ApkgManager$5(ApkgManager paramApkgManager, ApkgManager.OnInitApkgListener paramOnInitApkgListener, ApkgInfo paramApkgInfo, String paramString1, String paramString2) {}
  
  public void onDownloadCanceled(String paramString)
  {
    Object localObject = this.val$listener;
    if (localObject != null)
    {
      ((ApkgManager.OnInitApkgListener)localObject).onInitApkgInfo(1, this.val$apkgInfo, null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadCanceled() called with: s = [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.d("ApkgManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    Object localObject = this.val$listener;
    if (localObject != null)
    {
      ((ApkgManager.OnInitApkgListener)localObject).onInitApkgInfo(2, this.val$apkgInfo, HardCodeUtil.a(2131898541));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadFailed() called with: s = [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], downloadResult = [");
      ((StringBuilder)localObject).append(paramDownloadResult);
      ((StringBuilder)localObject).append("]");
      QLog.d("ApkgManager", 1, ((StringBuilder)localObject).toString());
    }
    int i;
    if (paramDownloadResult.getStatus().exception2Code != 0) {
      i = paramDownloadResult.getStatus().exception2Code;
    }
    for (;;)
    {
      break;
      if (paramDownloadResult.getStatus().httpStatus > 0) {
        i = paramDownloadResult.getStatus().httpStatus;
      } else {
        i = -99999;
      }
    }
    MiniReportManager.reportEventType(this.val$apkgInfo.appConfig, 614, this.val$url, null, null, i, "0", paramDownloadResult.getProcess().duration, null);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    long l;
    if ((paramDownloadResult != null) && (paramDownloadResult.getContent() != null)) {
      l = paramDownloadResult.getContent().length;
    } else {
      l = -1L;
    }
    MiniReportManager.reportEventType(this.val$apkgInfo.appConfig, 614, this.val$url, String.valueOf(l), null, 0, "0", paramDownloadResult.getProcess().duration, null);
    MiniReportManager.reportEventType(this.val$apkgInfo.appConfig, 615, this.val$url, null, null, 0, "0", 0L, null);
    paramString = ApkgManager.getApkgFolderPath(this.val$apkgInfo.appConfig.config);
    boolean bool = WxapkgUnpacker.unpackSync(new File(this.val$savePath).getAbsolutePath(), paramString, ApkgManager.access$100(this.this$0));
    paramDownloadResult = new StringBuilder();
    paramDownloadResult.append("downloadSubPack | getResPath :hasUnpack=");
    paramDownloadResult.append(bool);
    paramDownloadResult.append("; folderPath=");
    paramDownloadResult.append(paramString);
    paramDownloadResult.append("; subRoot=");
    paramDownloadResult.append(ApkgManager.access$100(this.this$0));
    QLog.d("ApkgManager", 1, paramDownloadResult.toString());
    MiniReportManager.reportEventType(this.val$apkgInfo.appConfig, 616, this.val$url, null, null, 0, "0", 0L, null);
    if (bool)
    {
      paramString = this.val$listener;
      if (paramString != null) {
        paramString.onInitApkgInfo(0, this.val$apkgInfo, null);
      }
    }
    else
    {
      paramString = this.val$listener;
      if (paramString != null) {
        paramString.onInitApkgInfo(3, this.val$apkgInfo, HardCodeUtil.a(2131898542));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgManager.5
 * JD-Core Version:    0.7.0.1
 */