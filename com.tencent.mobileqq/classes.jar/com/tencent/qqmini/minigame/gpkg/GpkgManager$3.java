package com.tencent.qqmini.minigame.gpkg;

import com.tencent.qqmini.sdk.core.manager.WxapkgUnpacker;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import java.io.File;
import java.util.List;
import java.util.Map;

final class GpkgManager$3
  implements DownloaderProxy.DownloadListener
{
  GpkgManager$3(MiniGamePluginInfo paramMiniGamePluginInfo, GpkgManager.DownloadPluginCallback paramDownloadPluginCallback, File paramFile1, File paramFile2) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("[Gpkg] download plugin failed ");
    paramString.append(paramInt);
    paramString.append(" ");
    paramString.append(this.val$pluginInfo);
    QMLog.e("[minigame] GpkgManager", paramString.toString());
    paramString = this.val$listener;
    if (paramString != null) {
      paramString.onPluginDownloadComplete(false, null, null);
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    try
    {
      paramInt = this.val$pluginInfo.packageSize;
      if ((paramInt != 0) && (this.val$pluginInfo.packageSize != this.val$pkgFile.length()))
      {
        paramString = new StringBuilder();
        paramString.append("[Gpkg] download plugin file-size mismatch ");
        paramString.append(this.val$pluginInfo);
        QMLog.e("[minigame] GpkgManager", paramString.toString());
        if (this.val$listener != null)
        {
          paramString = this.val$listener;
          paramDownloadResult = new StringBuilder();
          paramDownloadResult.append("file size mismatch, expected:");
          paramDownloadResult.append(this.val$pluginInfo.packageSize);
          paramDownloadResult.append(" got:");
          paramDownloadResult.append(this.val$pkgFile.length());
          paramString.onPluginDownloadComplete(false, new RuntimeException(paramDownloadResult.toString()), null);
        }
      }
      for (;;)
      {
        this.val$pkgFile.delete();
        return;
        FileUtils.delete(this.val$folder.getAbsolutePath(), false);
        if (WxapkgUnpacker.unpackSync(this.val$pkgFile.getAbsolutePath(), this.val$folder.getAbsolutePath())) {
          break;
        }
        paramString = new StringBuilder();
        paramString.append("[Gpkg] download plugin unpack failed ");
        paramString.append(this.val$pluginInfo);
        QMLog.e("[minigame] GpkgManager", paramString.toString());
        if (this.val$listener != null) {
          this.val$listener.onPluginDownloadComplete(false, new RuntimeException("unpack file failed"), null);
        }
      }
      paramString = new StringBuilder();
      paramString.append("[Gpkg] download plugin success ");
      paramString.append(this.val$pluginInfo);
      QMLog.i("[minigame] GpkgManager", paramString.toString());
      if (this.val$listener != null) {
        this.val$listener.onPluginDownloadComplete(true, null, GpkgManager.access$000(paramDownloadResult));
      }
      this.val$pkgFile.delete();
      return;
    }
    finally
    {
      this.val$pkgFile.delete();
    }
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.GpkgManager.3
 * JD-Core Version:    0.7.0.1
 */