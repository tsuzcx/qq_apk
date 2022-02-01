package com.tencent.open.appstore.receiver;

import android.text.TextUtils;
import bjsz;
import bjtx;
import bjwo;
import bjxd;
import com.tencent.open.downloadnew.DownloadInfo;

class InstallStateReceiver$1
  implements Runnable
{
  InstallStateReceiver$1(InstallStateReceiver paramInstallStateReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    bjtx.c("InstallStateReceiver", "[onReceive] ACTION_PACKAGE_REMOVED >> " + this.a);
    if ((!TextUtils.isEmpty(this.b)) && (this.b.equals(bjwo.q)))
    {
      bjsz.a().a(true);
      bjxd.a().f();
    }
    DownloadInfo localDownloadInfo = bjsz.a().c(this.b);
    bjsz.a().d(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.receiver.InstallStateReceiver.1
 * JD-Core Version:    0.7.0.1
 */