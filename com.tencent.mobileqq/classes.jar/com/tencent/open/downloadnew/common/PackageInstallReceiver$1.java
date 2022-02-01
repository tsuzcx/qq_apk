package com.tencent.open.downloadnew.common;

import android.text.TextUtils;
import bjtx;
import bjwo;
import bjwq;
import bjxd;
import com.tencent.open.downloadnew.DownloadInfo;

class PackageInstallReceiver$1
  implements Runnable
{
  PackageInstallReceiver$1(PackageInstallReceiver paramPackageInstallReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    bjtx.c(this.this$0.a, "ACTION_PACKAGE_REMOVED >> " + this.a);
    if ((!TextUtils.isEmpty(this.b)) && (this.b.equals(bjwo.q)))
    {
      bjwq.a().a(true);
      bjxd.a().f();
    }
    DownloadInfo localDownloadInfo = new DownloadInfo("", this.b);
    bjwq.a().a(9, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.PackageInstallReceiver.1
 * JD-Core Version:    0.7.0.1
 */