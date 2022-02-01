package com.tencent.mobileqq.filemanageraux.core;

import atdm;
import atgz;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadMgr$3
  implements Runnable
{
  public UniformDownloadMgr$3(atdm paramatdm) {}
  
  public void run()
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr onQQProcessExit releaseABSdkClient...");
    atgz.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.3
 * JD-Core Version:    0.7.0.1
 */