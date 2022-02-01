package com.tencent.mobileqq.mini.apkg;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.mini.utils.WxapkgUnpacker;
import com.tencent.qphone.base.util.QLog;

class ApkgManager$2
  implements Downloader.DownloadListener
{
  ApkgManager$2(ApkgManager paramApkgManager, MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = new StringBuilder();
    paramString.append("preloadFlutterPkg download fail! appid:");
    paramString.append(this.val$miniConfig.config.appId);
    paramString.append(" name:");
    paramString.append(this.val$miniConfig.config.name);
    QLog.d("ApkgManager", 1, paramString.toString());
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    try
    {
      boolean bool = WxapkgUnpacker.unpackSync(this.val$savePath, this.val$folderPath);
      paramString = new StringBuilder();
      paramString.append("preloadFlutterPkg unpack appid:");
      paramString.append(this.val$miniConfig.config.appId);
      paramString.append(" name:");
      paramString.append(this.val$miniConfig.config.name);
      paramString.append(" folder:");
      paramString.append(this.val$folderPath);
      paramString.append(" hasUnpack:");
      paramString.append(bool);
      QLog.d("ApkgManager", 1, paramString.toString());
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ApkgManager", 1, "exception!", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgManager.2
 * JD-Core Version:    0.7.0.1
 */