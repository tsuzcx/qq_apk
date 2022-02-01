package com.tencent.open.appstore.receiver;

import android.text.TextUtils;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.MyAppApi;

class InstallStateReceiver$1
  implements Runnable
{
  InstallStateReceiver$1(InstallStateReceiver paramInstallStateReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    LogUtility.c("InstallStateReceiver", "[onReceive] ACTION_PACKAGE_REMOVED >> " + this.a);
    if ((!TextUtils.isEmpty(this.b)) && (this.b.equals(DownloadConstants.q)))
    {
      DownloadManagerV2.a().a(true);
      MyAppApi.a().f();
    }
    DownloadInfo localDownloadInfo = DownloadManagerV2.a().c(this.b);
    DownloadManagerV2.a().d(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.receiver.InstallStateReceiver.1
 * JD-Core Version:    0.7.0.1
 */