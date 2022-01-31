package com.tencent.open.downloadnew.common;

import android.text.TextUtils;
import bfhg;
import bfjy;
import bfkb;
import bfko;
import com.tencent.open.downloadnew.DownloadInfo;

class PackageInstallReceiver$1
  implements Runnable
{
  PackageInstallReceiver$1(PackageInstallReceiver paramPackageInstallReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    bfhg.c(this.this$0.a, "ACTION_PACKAGE_REMOVED >> " + this.a);
    if ((!TextUtils.isEmpty(this.b)) && (this.b.equals(bfjy.q)))
    {
      bfkb.a().a(true);
      bfko.a().f();
    }
    DownloadInfo localDownloadInfo = new DownloadInfo("", this.b);
    bfkb.a().a(9, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.PackageInstallReceiver.1
 * JD-Core Version:    0.7.0.1
 */