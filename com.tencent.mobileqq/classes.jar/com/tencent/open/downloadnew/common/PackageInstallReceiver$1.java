package com.tencent.open.downloadnew.common;

import android.text.TextUtils;
import bdii;
import bdlb;
import bdle;
import bdlr;
import com.tencent.open.downloadnew.DownloadInfo;

class PackageInstallReceiver$1
  implements Runnable
{
  PackageInstallReceiver$1(PackageInstallReceiver paramPackageInstallReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    bdii.c(this.this$0.a, "ACTION_PACKAGE_REMOVED >> " + this.a);
    if ((!TextUtils.isEmpty(this.b)) && (this.b.equals(bdlb.q)))
    {
      bdle.a().a(true);
      bdlr.a().f();
    }
    DownloadInfo localDownloadInfo = new DownloadInfo("", this.b);
    bdle.a().a(9, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.PackageInstallReceiver.1
 * JD-Core Version:    0.7.0.1
 */