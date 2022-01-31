package com.tencent.mobileqq.minigame.gpkg;

import bdcs;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.mini.apkg.MiniGamePluginInfo;
import com.tencent.mobileqq.mini.utils.WxapkgUnpacker;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class GpkgManager$3
  implements Downloader.DownloadListener
{
  GpkgManager$3(GpkgManager.DownloadPluginCallback paramDownloadPluginCallback, MiniGamePluginInfo paramMiniGamePluginInfo, File paramFile1, File paramFile2) {}
  
  public void onDownloadCanceled(String paramString)
  {
    this.val$listener.onPluginDownloadComplete(false, new RuntimeException("download canceled"));
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QLog.e("[minigame] GpkgManager", 1, "[Gpkg] download plugin failed " + paramDownloadResult.getStatus().failReason + " " + this.val$pluginInfo);
    this.val$listener.onPluginDownloadComplete(false, paramDownloadResult.getStatus().failException);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    try
    {
      if ((this.val$pluginInfo.packageSize != 0) && (this.val$pluginInfo.packageSize != this.val$pkgFile.length()))
      {
        QLog.e("[minigame] GpkgManager", 1, "[Gpkg] download plugin file-size mismatch " + this.val$pluginInfo);
        this.val$listener.onPluginDownloadComplete(false, new RuntimeException("file size mismatch, expected:" + this.val$pluginInfo.packageSize + " got:" + this.val$pkgFile.length()));
        return;
      }
      bdcs.a(this.val$folder.getAbsolutePath(), false);
      if (!WxapkgUnpacker.unpackSync(this.val$pkgFile.getAbsolutePath(), this.val$folder.getAbsolutePath(), "", true))
      {
        QLog.e("[minigame] GpkgManager", 1, "[Gpkg] download plugin unpack failed " + this.val$pluginInfo);
        this.val$listener.onPluginDownloadComplete(false, new RuntimeException("unpack file failed"));
        return;
      }
      QLog.i("[minigame] GpkgManager", 1, "[Gpkg] download plugin success " + this.val$pluginInfo);
      this.val$listener.onPluginDownloadComplete(true, null);
      return;
    }
    finally
    {
      this.val$pkgFile.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.gpkg.GpkgManager.3
 * JD-Core Version:    0.7.0.1
 */