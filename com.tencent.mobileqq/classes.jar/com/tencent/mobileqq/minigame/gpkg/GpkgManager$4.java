package com.tencent.mobileqq.minigame.gpkg;

import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.qphone.base.util.QLog;

final class GpkgManager$4
  implements Downloader.DownloadListener
{
  GpkgManager$4(MiniAppConfig paramMiniAppConfig, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean) {}
  
  public void onDownloadCanceled(String paramString)
  {
    MiniReportManager.reportEventType(this.val$gameConfig, 1011, "game pkg download canceled s=" + paramString, "1");
    if (this.val$listener != null)
    {
      QLog.e("[minigame] GpkgManager", 1, "[Gpkg] onDownloadCanceled() called with: s = [" + paramString + "]");
      this.val$listener.onInitGpkgInfo(2003, null, "download canceled");
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    int i;
    if ((paramDownloadResult != null) && (paramDownloadResult.getStatus() != null)) {
      if (paramDownloadResult.getStatus().exception2Code != 0)
      {
        i = paramDownloadResult.getStatus().exception2Code;
        MiniReportManager.reportEventType(this.val$gameConfig, 1011, "game pkg download failed s=[" + paramString + "], httpStatus=[" + paramDownloadResult.getStatus().httpStatus + "] detailDownloadInfo=[" + paramDownloadResult.getStatus().detailDownloadInfo + "], downloadResult = [" + paramDownloadResult + "]", "1");
        MiniReportManager.reportEventType(this.val$gameConfig, 620, null, null, null, i, "1", 0L, null);
      }
    }
    for (;;)
    {
      if (((paramDownloadResult == null) || (paramDownloadResult.getStatus() == null) || (this.val$gameConfig.config.verType == 3) || (paramDownloadResult.getStatus().httpStatus != 403) || (paramDownloadResult.getReport() == null) || (paramDownloadResult.getReport().response == null)) || (this.val$listener != null))
      {
        this.val$listener.onInitGpkgInfo(2004, null, "download pkg fail");
        StringBuilder localStringBuilder = new StringBuilder().append("[Gpkg]onDownloadFailed() called with: s = [").append(paramString).append("], downloadResult = [");
        paramString = paramDownloadResult;
        if (paramDownloadResult != null)
        {
          paramString = paramDownloadResult;
          if (paramDownloadResult.getStatus() != null) {
            paramString = Integer.valueOf(paramDownloadResult.getStatus().getFailReason());
          }
        }
        QLog.e("[minigame] GpkgManager", 1, paramString + "]");
      }
      MiniProgramLpReportDC04239.reportPageView(this.val$gameConfig, "1", null, "load_fail", "download_apk_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "download_apk_fail", null, this.val$gameConfig);
      return;
      if (paramDownloadResult.getStatus().httpStatus > 0)
      {
        i = paramDownloadResult.getStatus().httpStatus;
        break;
      }
      i = -99999;
      break;
      MiniReportManager.reportEventType(this.val$gameConfig, 1011, "game pkg download failed s=[ unknow ], httpStatus=[unknow] detailDownloadInfo=[unknow], downloadResult = [unknow]", "1");
      MiniReportManager.reportEventType(this.val$gameConfig, 620, null, null, null, -1, "1", 0L, null);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadGpkgProgress(this.val$gameConfig.config, paramFloat, paramLong);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    long l2 = 0L;
    GpkgManager.downloadDuration = System.currentTimeMillis() - this.val$startTime;
    QLog.i("[minigame] GpkgManager", 1, "[Gpkg] onDownloadSucceed " + paramString + ",cost:" + GpkgManager.downloadDuration);
    if ((paramDownloadResult != null) && (paramDownloadResult.getContent() != null)) {}
    for (long l1 = paramDownloadResult.getContent().length;; l1 = -1L)
    {
      MiniReportManager.addCostTimeEventAttachInfo(this.val$gameConfig, 2, "1");
      paramString = this.val$gameConfig;
      if (GpkgManager.downloadDuration > 0L) {
        l2 = GpkgManager.downloadDuration;
      }
      MiniReportManager.reportEventType(paramString, 620, null, String.valueOf(l1), null, 0, "1", l2, null);
      GpkgManager.access$100(GpkgManager.access$000(this.val$savePath), this.val$unPackFolderPath, this.val$gameConfig, this.val$listener, this.val$finalSubApkUrl, this.val$finalIndependentPath, this.val$isMiniGameProcess);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.gpkg.GpkgManager.4
 * JD-Core Version:    0.7.0.1
 */