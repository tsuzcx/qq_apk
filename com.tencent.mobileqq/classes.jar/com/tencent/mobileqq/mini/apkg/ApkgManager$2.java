package com.tencent.mobileqq.mini.apkg;

import beji;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.qphone.base.util.QLog;

class ApkgManager$2
  implements Downloader.DownloadListener
{
  ApkgManager$2(ApkgManager paramApkgManager, MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QLog.d("ApkgManager", 1, "preloadFlutterPkg download fail! appid:" + this.val$miniConfig.config.appId + " name:" + this.val$miniConfig.config.name);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    try
    {
      boolean bool = beji.a(this.val$savePath, this.val$folderPath);
      QLog.d("ApkgManager", 1, "preloadFlutterPkg unpack appid:" + this.val$miniConfig.config.appId + " name:" + this.val$miniConfig.config.name + " folder:" + this.val$folderPath + " hasUnpack:" + bool);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ApkgManager", 1, "exception!", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgManager.2
 * JD-Core Version:    0.7.0.1
 */