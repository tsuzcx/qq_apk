package com.tencent.open.downloadnew.common;

import bjhn;
import bjko;
import bjna;
import bjop;
import com.tencent.open.downloadnew.DownloadInfo;

class PackageInstallReceiver$3
  implements Runnable
{
  PackageInstallReceiver$3(PackageInstallReceiver paramPackageInstallReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    bjko.c(this.this$0.a, "ACTION_PACKAGE_ADDED >> " + this.a);
    DownloadInfo localDownloadInfo = bjop.a().a(this.b);
    if (localDownloadInfo != null)
    {
      bjko.c(this.this$0.a, "ACTION_PACKAGE_ADDED info != null>> " + localDownloadInfo.toString() + " " + localDownloadInfo.c + " " + localDownloadInfo.e);
      bjna.a().d(localDownloadInfo);
      bjhn.a().a(101, localDownloadInfo);
    }
    for (;;)
    {
      bjna.a().a(6, localDownloadInfo);
      return;
      localDownloadInfo = new DownloadInfo("", this.b);
      bjko.c(this.this$0.a, "ACTION_PACKAGE_ADDED info == null>> " + localDownloadInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.PackageInstallReceiver.3
 * JD-Core Version:    0.7.0.1
 */