package com.tencent.open.appstore.receiver;

import android.text.TextUtils;
import bdhk;
import bdii;
import bdlb;
import bdlr;
import com.tencent.open.downloadnew.DownloadInfo;

class InstallStateReceiver$1
  implements Runnable
{
  InstallStateReceiver$1(InstallStateReceiver paramInstallStateReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    bdii.c("InstallStateReceiver", "[onReceive] ACTION_PACKAGE_REMOVED >> " + this.a);
    if ((!TextUtils.isEmpty(this.b)) && (this.b.equals(bdlb.q)))
    {
      bdhk.a().a(true);
      bdlr.a().f();
    }
    DownloadInfo localDownloadInfo = bdhk.a().c(this.b);
    bdhk.a().d(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.receiver.InstallStateReceiver.1
 * JD-Core Version:    0.7.0.1
 */