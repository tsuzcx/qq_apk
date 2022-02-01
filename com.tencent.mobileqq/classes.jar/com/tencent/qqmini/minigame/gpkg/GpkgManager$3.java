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
    QMLog.e("[minigame] GpkgManager", "[Gpkg] download plugin failed " + paramInt + " " + this.val$pluginInfo);
    if (this.val$listener != null) {
      this.val$listener.onPluginDownloadComplete(false, null, null);
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    try
    {
      if ((this.val$pluginInfo.packageSize != 0) && (this.val$pluginInfo.packageSize != this.val$pkgFile.length()))
      {
        QMLog.e("[minigame] GpkgManager", "[Gpkg] download plugin file-size mismatch " + this.val$pluginInfo);
        if (this.val$listener != null) {
          this.val$listener.onPluginDownloadComplete(false, new RuntimeException("file size mismatch, expected:" + this.val$pluginInfo.packageSize + " got:" + this.val$pkgFile.length()), null);
        }
        return;
      }
      FileUtils.delete(this.val$folder.getAbsolutePath(), false);
      if (!WxapkgUnpacker.unpackSync(this.val$pkgFile.getAbsolutePath(), this.val$folder.getAbsolutePath()))
      {
        QMLog.e("[minigame] GpkgManager", "[Gpkg] download plugin unpack failed " + this.val$pluginInfo);
        if (this.val$listener != null) {
          this.val$listener.onPluginDownloadComplete(false, new RuntimeException("unpack file failed"), null);
        }
        return;
      }
      QMLog.i("[minigame] GpkgManager", "[Gpkg] download plugin success " + this.val$pluginInfo);
      if (this.val$listener != null) {
        this.val$listener.onPluginDownloadComplete(true, null, GpkgManager.access$000(paramDownloadResult));
      }
      return;
    }
    finally
    {
      this.val$pkgFile.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.GpkgManager.3
 * JD-Core Version:    0.7.0.1
 */