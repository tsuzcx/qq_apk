package com.tencent.open.downloadnew.common;

import com.tencent.open.appcircle.st.AppCircleReportManager;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;

class PackageInstallReceiver$3
  implements Runnable
{
  PackageInstallReceiver$3(PackageInstallReceiver paramPackageInstallReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    LogUtility.c(this.this$0.a, "ACTION_PACKAGE_ADDED >> " + this.a);
    DownloadInfo localDownloadInfo = DownloadDBHelper.a().a(this.b);
    if (localDownloadInfo != null)
    {
      LogUtility.c(this.this$0.a, "ACTION_PACKAGE_ADDED info != null>> " + localDownloadInfo.toString() + " " + localDownloadInfo.c + " " + localDownloadInfo.e);
      DownloadManager.a().d(localDownloadInfo);
      AppCircleReportManager.a().a(101, localDownloadInfo);
    }
    for (;;)
    {
      DownloadManager.a().a(6, localDownloadInfo);
      return;
      localDownloadInfo = new DownloadInfo("", this.b);
      LogUtility.c(this.this$0.a, "ACTION_PACKAGE_ADDED info == null>> " + localDownloadInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.PackageInstallReceiver.3
 * JD-Core Version:    0.7.0.1
 */