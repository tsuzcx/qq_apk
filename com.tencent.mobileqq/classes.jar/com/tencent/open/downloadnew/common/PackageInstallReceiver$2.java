package com.tencent.open.downloadnew.common;

import bdii;
import bdle;
import com.tencent.open.downloadnew.DownloadInfo;

class PackageInstallReceiver$2
  implements Runnable
{
  PackageInstallReceiver$2(PackageInstallReceiver paramPackageInstallReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    bdii.c(this.this$0.a, "ACTION_PACKAGE_REPLACED >> " + this.a);
    DownloadInfo localDownloadInfo = new DownloadInfo("", this.b);
    bdle.a().a(13, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.PackageInstallReceiver.2
 * JD-Core Version:    0.7.0.1
 */