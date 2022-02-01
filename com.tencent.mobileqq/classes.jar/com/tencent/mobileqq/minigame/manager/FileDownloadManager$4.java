package com.tencent.mobileqq.minigame.manager;

import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.LameMp3SoDownloadListener;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleManager;

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
    paramString = QzoneModuleManager.getInstance().getModuleFilePath(paramString);
    this.val$listener.onLameMp3SoDownloadSucceed(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.FileDownloadManager.4
 * JD-Core Version:    0.7.0.1
 */