package com.tencent.open.filedownload;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton.EventCallback;
import mqq.os.MqqHandler;

class ApkFileDownloadFragment$2
  extends ApkFileDownloadButton.EventCallback
{
  ApkFileDownloadFragment$2(ApkFileDownloadFragment paramApkFileDownloadFragment) {}
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new ApkFileDownloadFragment.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.filedownload.ApkFileDownloadFragment.2
 * JD-Core Version:    0.7.0.1
 */