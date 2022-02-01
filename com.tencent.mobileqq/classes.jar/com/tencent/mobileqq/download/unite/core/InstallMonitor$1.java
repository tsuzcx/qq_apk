package com.tencent.mobileqq.download.unite.core;

import com.tencent.qphone.base.util.QLog;

class InstallMonitor$1
  implements Runnable
{
  InstallMonitor$1(InstallMonitor paramInstallMonitor, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    boolean bool = InstallMonitor.a(this.this$0, this.a, this.b, this.c);
    QLog.d("[UniteDownload] InstallMonitor", 2, new Object[] { "[check] monitorInstallIntent: invoked. ", " validApkMd5: ", Boolean.valueOf(bool) });
    InstallMonitor.a(this.this$0, this.d, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.core.InstallMonitor.1
 * JD-Core Version:    0.7.0.1
 */