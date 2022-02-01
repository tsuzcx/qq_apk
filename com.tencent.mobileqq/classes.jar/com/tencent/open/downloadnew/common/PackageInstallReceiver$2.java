package com.tencent.open.downloadnew.common;

import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;

class PackageInstallReceiver$2
  implements Runnable
{
  PackageInstallReceiver$2(PackageInstallReceiver paramPackageInstallReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = this.this$0.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ACTION_PACKAGE_REPLACED >> ");
    localStringBuilder.append(this.a);
    LogUtility.c((String)localObject, localStringBuilder.toString());
    localObject = new DownloadInfo("", this.b);
    DownloadManager.a().a(13, (DownloadInfo)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.PackageInstallReceiver.2
 * JD-Core Version:    0.7.0.1
 */