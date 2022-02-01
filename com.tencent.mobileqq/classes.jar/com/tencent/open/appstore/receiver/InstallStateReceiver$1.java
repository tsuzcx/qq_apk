package com.tencent.open.appstore.receiver;

import android.text.TextUtils;
import bjjq;
import bjko;
import bjmy;
import bjnn;
import com.tencent.open.downloadnew.DownloadInfo;

class InstallStateReceiver$1
  implements Runnable
{
  InstallStateReceiver$1(InstallStateReceiver paramInstallStateReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    bjko.c("InstallStateReceiver", "[onReceive] ACTION_PACKAGE_REMOVED >> " + this.a);
    if ((!TextUtils.isEmpty(this.b)) && (this.b.equals(bjmy.q)))
    {
      bjjq.a().a(true);
      bjnn.a().f();
    }
    DownloadInfo localDownloadInfo = bjjq.a().c(this.b);
    bjjq.a().d(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.receiver.InstallStateReceiver.1
 * JD-Core Version:    0.7.0.1
 */