package com.tencent.mobileqq.mini.reuse;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05325;

class MiniappDownloadUtil$2
  implements Downloader.DownloadListener
{
  MiniappDownloadUtil$2(MiniappDownloadUtil paramMiniappDownloadUtil, Downloader.DownloadListener paramDownloadListener, boolean paramBoolean, MiniAppConfig paramMiniAppConfig) {}
  
  public void onDownloadCanceled(String paramString)
  {
    Downloader.DownloadListener localDownloadListener = this.val$listener;
    if (localDownloadListener != null) {
      localDownloadListener.onDownloadCanceled(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    Downloader.DownloadListener localDownloadListener = this.val$listener;
    if (localDownloadListener != null) {
      localDownloadListener.onDownloadFailed(paramString, paramDownloadResult);
    }
    int i;
    if (!this.val$isSubApkg) {
      i = 1;
    } else {
      i = 2;
    }
    MiniProgramLpReportDC05325.reportApiReport(paramDownloadResult, i, this.val$miniAppConfig);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    Downloader.DownloadListener localDownloadListener = this.val$listener;
    if (localDownloadListener != null) {
      localDownloadListener.onDownloadProgress(paramString, paramLong, paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    Downloader.DownloadListener localDownloadListener = this.val$listener;
    if (localDownloadListener != null) {
      localDownloadListener.onDownloadSucceed(paramString, paramDownloadResult);
    }
    int i;
    if (!this.val$isSubApkg) {
      i = 1;
    } else {
      i = 2;
    }
    MiniProgramLpReportDC05325.reportApiReport(paramDownloadResult, i, this.val$miniAppConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil.2
 * JD-Core Version:    0.7.0.1
 */