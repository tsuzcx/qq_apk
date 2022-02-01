package com.tencent.mobileqq.uniformdownload.core;

import com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBabySdk;
import com.tencent.qphone.base.util.QLog;

class UniformDownloadMgr$6
  implements Runnable
{
  UniformDownloadMgr$6(UniformDownloadMgr paramUniformDownloadMgr) {}
  
  public void run()
  {
    QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] UniformDownloadMgr onQQProcessExit releaseABSdkClient...");
    UniformDownloaderAppBabySdk.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.6
 * JD-Core Version:    0.7.0.1
 */