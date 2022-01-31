package com.tencent.open.appstore.receiver;

import android.text.TextUtils;
import bfgi;
import bfhg;
import bfjy;
import bfko;
import com.tencent.open.downloadnew.DownloadInfo;

class InstallStateReceiver$1
  implements Runnable
{
  InstallStateReceiver$1(InstallStateReceiver paramInstallStateReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    bfhg.c("InstallStateReceiver", "[onReceive] ACTION_PACKAGE_REMOVED >> " + this.a);
    if ((!TextUtils.isEmpty(this.b)) && (this.b.equals(bfjy.q)))
    {
      bfgi.a().a(true);
      bfko.a().f();
    }
    DownloadInfo localDownloadInfo = bfgi.a().c(this.b);
    bfgi.a().d(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.receiver.InstallStateReceiver.1
 * JD-Core Version:    0.7.0.1
 */