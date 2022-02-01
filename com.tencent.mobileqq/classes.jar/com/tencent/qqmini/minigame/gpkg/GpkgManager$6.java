package com.tencent.qqmini.minigame.gpkg;

import com.tencent.qqmini.sdk.core.manager.WxapkgUnpacker;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.io.File;
import java.util.List;
import java.util.Map;

final class GpkgManager$6
  implements DownloaderProxy.DownloadListener
{
  GpkgManager$6(MiniAppInfo paramMiniAppInfo, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener, String paramString1, String paramString2, MiniGamePkg paramMiniGamePkg, int paramInt) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    MiniReportManager.reportEventType(this.val$gameInfo, 614, null, null, null, paramInt, "1", 0L, null);
    Object localObject = this.val$listener;
    if (localObject != null)
    {
      ((GpkgManager.OnInitGpkgListener)localObject).onInitGpkgInfo(2010, null, "download sub pkg fail", null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadFailed() called with: s = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], downloadResult = [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QMLog.d("[minigame] GpkgManager", ((StringBuilder)localObject).toString());
    }
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
        int i = this.val$fileSize;
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
      this.val$listener.onDownloadGpkgProgress(this.val$gameInfo, f, l);
    }
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    MiniReportManager.reportEventType(this.val$gameInfo, 614, "1");
    paramDownloadResult = GpkgManager.access$100(this.val$savePath);
    paramString = ApkgManager.getApkgFolderPath(this.val$gameInfo);
    paramDownloadResult = new File(paramDownloadResult);
    MiniReportManager.reportEventType(this.val$gameInfo, 615, "1");
    boolean bool = WxapkgUnpacker.unpackSync(paramDownloadResult.getAbsolutePath(), paramString, this.val$subRoot, true);
    MiniReportManager.reportEventType(this.val$gameInfo, 616, null, null, null, bool ^ true, "1", 0L, null);
    paramDownloadResult = new StringBuilder();
    paramDownloadResult.append("downloadSubPack | getResPath :hasUnpack=");
    paramDownloadResult.append(bool);
    paramDownloadResult.append("; folderPath=");
    paramDownloadResult.append(paramString);
    paramDownloadResult.append("; subRoot=");
    paramDownloadResult.append(this.val$subRoot);
    QMLog.d("[minigame] GpkgManager", paramDownloadResult.toString());
    if (bool)
    {
      paramString = this.val$listener;
      if (paramString != null) {
        paramString.onInitGpkgInfo(0, this.val$miniGamePkg, "download sub pkg and unpack succeed", null);
      }
    }
    else
    {
      paramString = this.val$listener;
      if (paramString != null) {
        paramString.onInitGpkgInfo(2011, null, "download sub pkg succeed, but unpack sub pkg fail", null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.GpkgManager.6
 * JD-Core Version:    0.7.0.1
 */