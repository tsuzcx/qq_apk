package com.tencent.mobileqq.filemanager.core;

import aqwa;
import arps;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadMgr$3
  implements Runnable
{
  public UniformDownloadMgr$3(aqwa paramaqwa) {}
  
  public void run()
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr onQQProcessExit releaseABSdkClient...");
    arps.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.3
 * JD-Core Version:    0.7.0.1
 */