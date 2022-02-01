package com.tencent.open.downloadnew.common;

import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;

class PackageInstallReceiver$1
  implements Runnable
{
  PackageInstallReceiver$1(PackageInstallReceiver paramPackageInstallReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    LogUtility.c(this.this$0.a, "ACTION_PACKAGE_REMOVED >> " + this.a);
    if ((!TextUtils.isEmpty(this.b)) && (this.b.equals(DownloadConstants.q)))
    {
      DownloadManager.a().a(true);
      MyAppApi.a().f();
    }
    DownloadInfo localDownloadInfo = new DownloadInfo("", this.b);
    DownloadManager.a().a(9, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.PackageInstallReceiver.1
 * JD-Core Version:    0.7.0.1
 */