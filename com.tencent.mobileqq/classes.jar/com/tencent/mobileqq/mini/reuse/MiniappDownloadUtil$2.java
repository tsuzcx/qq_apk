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
    if (this.val$listener != null) {
      this.val$listener.onDownloadCanceled(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadFailed(paramString, paramDownloadResult);
    }
    if (!this.val$isSubApkg) {}
    for (int i = 1;; i = 2)
    {
      MiniProgramLpReportDC05325.reportApiReport(paramDownloadResult, i, this.val$miniAppConfig);
      return;
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadProgress(paramString, paramLong, paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadSucceed(paramString, paramDownloadResult);
    }
    if (!this.val$isSubApkg) {}
    for (int i = 1;; i = 2)
    {
      MiniProgramLpReportDC05325.reportApiReport(paramDownloadResult, i, this.val$miniAppConfig);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil.2
 * JD-Core Version:    0.7.0.1
 */