package com.tencent.mobileqq.mini.apkg;

import anzj;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Process;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
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
    if (this.val$listener != null)
    {
      this.val$listener.onInitApkgInfo(1, this.val$apkgInfo, null);
      QLog.d("ApkgManager", 1, "onDownloadCanceled() called with: s = [" + paramString + "]");
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (this.val$listener != null)
    {
      this.val$listener.onInitApkgInfo(2, this.val$apkgInfo, anzj.a(2131699204));
      QLog.d("ApkgManager", 1, "onDownloadFailed() called with: s = [" + paramString + "], downloadResult = [" + paramDownloadResult + "]");
    }
    int i;
    if (paramDownloadResult.getStatus().exception2Code != 0) {
      i = paramDownloadResult.getStatus().exception2Code;
    }
    for (;;)
    {
      MiniReportManager.reportEventType(this.val$apkgInfo.appConfig, 614, this.val$url, null, null, i, "0", paramDownloadResult.getProcess().duration, null);
      return;
      if (paramDownloadResult.getStatus().httpStatus > 0) {
        i = paramDownloadResult.getStatus().httpStatus;
      } else {
        i = -99999;
      }
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if ((paramDownloadResult != null) && (paramDownloadResult.getContent() != null)) {}
    for (long l = paramDownloadResult.getContent().length;; l = -1L)
    {
      MiniReportManager.reportEventType(this.val$apkgInfo.appConfig, 614, this.val$url, String.valueOf(l), null, 0, "0", paramDownloadResult.getProcess().duration, null);
      MiniReportManager.reportEventType(this.val$apkgInfo.appConfig, 615, this.val$url, null, null, 0, "0", 0L, null);
      paramString = ApkgManager.getApkgFolderPath(this.val$apkgInfo.appConfig.config);
      boolean bool = WxapkgUnpacker.unpackSync(new File(this.val$savePath).getAbsolutePath(), paramString, ApkgManager.access$100(this.this$0));
      QLog.d("ApkgManager", 1, "downloadSubPack | getResPath :hasUnpack=" + bool + "; folderPath=" + paramString + "; subRoot=" + ApkgManager.access$100(this.this$0));
      MiniReportManager.reportEventType(this.val$apkgInfo.appConfig, 616, this.val$url, null, null, 0, "0", 0L, null);
      if (bool) {
        if (this.val$listener != null) {
          this.val$listener.onInitApkgInfo(0, this.val$apkgInfo, null);
        }
      }
      while (this.val$listener == null) {
        return;
      }
      this.val$listener.onInitApkgInfo(3, this.val$apkgInfo, anzj.a(2131699205));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgManager.5
 * JD-Core Version:    0.7.0.1
 */