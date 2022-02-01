package com.tencent.mobileqq.minigame.manager;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.WebAudioDownloadListener;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;

final class FileDownloadManager$3
  implements ModuleDownloadListener
{
  FileDownloadManager$3(DownloaderProxy.WebAudioDownloadListener paramWebAudioDownloadListener) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString) {}
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("libwebAudio.so")) {
      return;
    }
    paramString = ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).getModuleFilePath(paramString);
    this.val$listener.onWebAudioSoDownloadSucceed(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.FileDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */