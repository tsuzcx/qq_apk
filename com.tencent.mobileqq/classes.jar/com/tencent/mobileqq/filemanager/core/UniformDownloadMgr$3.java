package com.tencent.mobileqq.filemanager.core;

import apdc;
import apwq;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadMgr$3
  implements Runnable
{
  public UniformDownloadMgr$3(apdc paramapdc) {}
  
  public void run()
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr onQQProcessExit releaseABSdkClient...");
    apwq.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.3
 * JD-Core Version:    0.7.0.1
 */