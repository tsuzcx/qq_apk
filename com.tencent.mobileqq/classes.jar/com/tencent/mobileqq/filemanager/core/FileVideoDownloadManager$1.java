package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

final class FileVideoDownloadManager$1
  implements SDKInitListener
{
  public void onSDKInited(boolean paramBoolean)
  {
    if (!paramBoolean) {
      QLog.e("FileVideoDownloadManager<FileAssistant>XOXO", 1, "initSDKAsync failed!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */