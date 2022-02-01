package com.tencent.mobileqq.uniformdownload.core;

import android.content.Context;
import com.tencent.mobileqq.uniformdownload.data.SucDownloadInfoMgr;
import com.tencent.mobileqq.uniformdownload.util.SucDownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class UniformDownloadPkgInstallReceiver$1
  implements Runnable
{
  UniformDownloadPkgInstallReceiver$1(UniformDownloadPkgInstallReceiver paramUniformDownloadPkgInstallReceiver, String paramString1, String paramString2, Context paramContext) {}
  
  public void run()
  {
    if (("android.intent.action.PACKAGE_ADDED".equalsIgnoreCase(this.a)) || ("android.intent.action.PACKAGE_REPLACED".equalsIgnoreCase(this.a)))
    {
      Object localObject = UniformDownloadMgr.a().c().a(this.b, true);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          SucDownloadInfo localSucDownloadInfo = (SucDownloadInfo)((Iterator)localObject).next();
          if (localSucDownloadInfo != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[UniformDL] send cancel notification.pkgName:");
            localStringBuilder.append(this.b);
            localStringBuilder.append(" notificationId:");
            localStringBuilder.append(localSucDownloadInfo.b);
            QLog.i("UniformDownloadPkgInstallReceiver", 1, localStringBuilder.toString());
            UniformDownloadNfn.a().c(localSucDownloadInfo.b, null);
            this.this$0.a(this.c, localSucDownloadInfo);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadPkgInstallReceiver.1
 * JD-Core Version:    0.7.0.1
 */