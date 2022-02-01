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
    Object localObject1 = this.this$0.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("ACTION_PACKAGE_ADDED >> ");
    ((StringBuilder)localObject2).append(this.a);
    LogUtility.c((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = DownloadDBHelper.a().a(this.b);
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      localObject2 = this.this$0.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ACTION_PACKAGE_ADDED info != null>> ");
      localStringBuilder.append(((DownloadInfo)localObject1).toString());
      localStringBuilder.append(" ");
      localStringBuilder.append(((DownloadInfo)localObject1).c);
      localStringBuilder.append(" ");
      localStringBuilder.append(((DownloadInfo)localObject1).e);
      LogUtility.c((String)localObject2, localStringBuilder.toString());
      DownloadManager.a().d((DownloadInfo)localObject1);
      AppCircleReportManager.a().a(101, (DownloadInfo)localObject1);
    }
    else
    {
      localObject1 = new DownloadInfo("", this.b);
      localObject2 = this.this$0.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ACTION_PACKAGE_ADDED info == null>> ");
      localStringBuilder.append(((DownloadInfo)localObject1).toString());
      LogUtility.c((String)localObject2, localStringBuilder.toString());
    }
    DownloadManager.a().a(6, (DownloadInfo)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.PackageInstallReceiver.3
 * JD-Core Version:    0.7.0.1
 */