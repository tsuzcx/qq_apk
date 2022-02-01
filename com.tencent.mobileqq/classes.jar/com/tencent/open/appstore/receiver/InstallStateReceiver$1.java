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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onReceive] ACTION_PACKAGE_REMOVED >> ");
    ((StringBuilder)localObject).append(this.a);
    LogUtility.c("InstallStateReceiver", ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(this.b)) && (this.b.equals(DownloadConstants.r)))
    {
      DownloadManagerV2.a().a(true);
      MyAppApi.a().h();
    }
    localObject = DownloadManagerV2.a().c(this.b);
    DownloadManagerV2.a().d((DownloadInfo)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.receiver.InstallStateReceiver.1
 * JD-Core Version:    0.7.0.1
 */