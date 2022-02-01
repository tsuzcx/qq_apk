package com.tencent.mobileqq.download.unite.core;

import asax;
import com.tencent.qphone.base.util.QLog;

public class InstallMonitor$1
  implements Runnable
{
  public InstallMonitor$1(asax paramasax, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    boolean bool = asax.a(this.this$0, this.a, this.b, this.c);
    QLog.d("[UniteDownload] InstallMonitor", 2, new Object[] { "[check] monitorInstallIntent: invoked. ", " validApkMd5: ", Boolean.valueOf(bool) });
    asax.a(this.this$0, this.d, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.core.InstallMonitor.1
 * JD-Core Version:    0.7.0.1
 */