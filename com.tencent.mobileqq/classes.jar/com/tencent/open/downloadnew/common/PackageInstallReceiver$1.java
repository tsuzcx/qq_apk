package com.tencent.open.downloadnew.common;

import android.text.TextUtils;
import bjko;
import bjmy;
import bjna;
import bjnn;
import com.tencent.open.downloadnew.DownloadInfo;

class PackageInstallReceiver$1
  implements Runnable
{
  PackageInstallReceiver$1(PackageInstallReceiver paramPackageInstallReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    bjko.c(this.this$0.a, "ACTION_PACKAGE_REMOVED >> " + this.a);
    if ((!TextUtils.isEmpty(this.b)) && (this.b.equals(bjmy.q)))
    {
      bjna.a().a(true);
      bjnn.a().f();
    }
    DownloadInfo localDownloadInfo = new DownloadInfo("", this.b);
    bjna.a().a(9, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.PackageInstallReceiver.1
 * JD-Core Version:    0.7.0.1
 */