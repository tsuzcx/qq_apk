package com.tencent.mobileqq.minigame.manager;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.LameMp3SoDownloadListener;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;

final class FileDownloadManager$4
  implements ModuleDownloadListener
{
  FileDownloadManager$4(DownloaderProxy.LameMp3SoDownloadListener paramLameMp3SoDownloadListener) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString) {}
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("libminigame_lamemp3.so")) {
      return;
    }
    paramString = ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).getModuleFilePath(paramString);
    this.val$listener.onLameMp3SoDownloadSucceed(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.FileDownloadManager.4
 * JD-Core Version:    0.7.0.1
 */