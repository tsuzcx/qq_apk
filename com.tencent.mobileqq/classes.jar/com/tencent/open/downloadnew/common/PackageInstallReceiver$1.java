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
    Object localObject = this.this$0.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ACTION_PACKAGE_REMOVED >> ");
    localStringBuilder.append(this.a);
    LogUtility.c((String)localObject, localStringBuilder.toString());
    if ((!TextUtils.isEmpty(this.b)) && (this.b.equals(DownloadConstants.r)))
    {
      DownloadManager.b().a(true);
      MyAppApi.l().o();
    }
    localObject = new DownloadInfo("", this.b);
    DownloadManager.b().a(9, (DownloadInfo)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.PackageInstallReceiver.1
 * JD-Core Version:    0.7.0.1
 */