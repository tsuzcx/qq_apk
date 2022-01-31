package com.tencent.mobileqq.filemanager.core;

import apcy;
import apwo;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadMgr$3
  implements Runnable
{
  public UniformDownloadMgr$3(apcy paramapcy) {}
  
  public void run()
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr onQQProcessExit releaseABSdkClient...");
    apwo.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.3
 * JD-Core Version:    0.7.0.1
 */