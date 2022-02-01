package com.tencent.open.downloadnew.common;

import bjtx;
import bjwq;
import com.tencent.open.downloadnew.DownloadInfo;

class PackageInstallReceiver$2
  implements Runnable
{
  PackageInstallReceiver$2(PackageInstallReceiver paramPackageInstallReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    bjtx.c(this.this$0.a, "ACTION_PACKAGE_REPLACED >> " + this.a);
    DownloadInfo localDownloadInfo = new DownloadInfo("", this.b);
    bjwq.a().a(13, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.PackageInstallReceiver.2
 * JD-Core Version:    0.7.0.1
 */