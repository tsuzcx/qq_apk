package com.tencent.qqmini.minigame.gpkg;

import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import java.util.List;
import java.util.Map;

final class GpkgManager$4
  implements DownloaderProxy.DownloadListener
{
  GpkgManager$4(MiniAppInfo paramMiniAppInfo, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    Object localObject = this.val$miniAppInfo;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("game pkg download failed s=[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], httpStatus=[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("] ");
    MiniReportManager.reportEventType((MiniAppInfo)localObject, 1011, localStringBuilder.toString(), "1");
    MiniReportManager.reportEventType(this.val$miniAppInfo, 620, null, null, null, paramInt, "1", 0L, null);
    localObject = this.val$listener;
    if (localObject != null)
    {
      ((GpkgManager.OnInitGpkgListener)localObject).onInitGpkgInfo(2004, null, "download pkg fail", null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Gpkg]onDownloadFailed() called with: s = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], downloadResult = [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QMLog.e("[minigame] GpkgManager", ((StringBuilder)localObject).toString());
    }
    SDKMiniProgramLpReportDC04239.reportForSDK(this.val$miniAppInfo, "1", null, "page_view", "load_fail", "download_apk_fail", "");
    MiniAppReportManager2.reportPageView("2launch_fail", "download_apk_fail", null, this.val$miniAppInfo);
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    if (this.val$listener != null)
    {
      float f = paramFloat;
      long l = paramLong2;
      if (paramLong2 == 0L)
      {
        int i = this.val$fFileSize;
        f = paramFloat;
        l = paramLong2;
        if (i > 0)
        {
          paramLong2 = i;
          f = paramFloat;
          l = paramLong2;
          if (paramLong2 > paramLong1)
          {
            f = (float)paramLong1 * 1.0F / (float)paramLong2;
            l = paramLong2;
          }
        }
      }
      this.val$listener.onDownloadGpkgProgress(this.val$miniAppInfo, f, l);
    }
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    GpkgManager.downloadDuration = System.currentTimeMillis() - this.val$startTime;
    paramString = new StringBuilder();
    paramString.append("[Gpkg] onDownloadSucceed ");
    paramString.append(paramInt);
    paramString.append(",cost:");
    paramString.append(GpkgManager.downloadDuration);
    QMLog.i("[minigame] GpkgManager", paramString.toString());
    MiniReportManager.addCostTimeEventAttachInfo(this.val$miniAppInfo, 2, "1");
    paramString = this.val$miniAppInfo;
    long l;
    if (GpkgManager.downloadDuration > 0L) {
      l = GpkgManager.downloadDuration;
    } else {
      l = 0L;
    }
    MiniReportManager.reportEventType(paramString, 620, null, null, null, 0, "1", l, null);
    GpkgManager.access$200(GpkgManager.access$100(this.val$savePath), this.val$unPackFolderPath, this.val$miniAppInfo, this.val$listener, this.val$finalSubApkUrl, this.val$finalIndependentPath, paramDownloadResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.GpkgManager.4
 * JD-Core Version:    0.7.0.1
 */