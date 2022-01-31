package com.tencent.open.downloadnew.common;

import bfef;
import bfhg;
import bfkb;
import bflq;
import com.tencent.open.downloadnew.DownloadInfo;

class PackageInstallReceiver$3
  implements Runnable
{
  PackageInstallReceiver$3(PackageInstallReceiver paramPackageInstallReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    bfhg.c(this.this$0.a, "ACTION_PACKAGE_ADDED >> " + this.a);
    DownloadInfo localDownloadInfo = bflq.a().a(this.b);
    if (localDownloadInfo != null)
    {
      bfhg.c(this.this$0.a, "ACTION_PACKAGE_ADDED info != null>> " + localDownloadInfo.toString() + " " + localDownloadInfo.c + " " + localDownloadInfo.e);
      bfkb.a().d(localDownloadInfo);
      bfef.a().a(101, localDownloadInfo);
    }
    for (;;)
    {
      bfkb.a().a(6, localDownloadInfo);
      return;
      localDownloadInfo = new DownloadInfo("", this.b);
      bfhg.c(this.this$0.a, "ACTION_PACKAGE_ADDED info == null>> " + localDownloadInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.PackageInstallReceiver.3
 * JD-Core Version:    0.7.0.1
 */