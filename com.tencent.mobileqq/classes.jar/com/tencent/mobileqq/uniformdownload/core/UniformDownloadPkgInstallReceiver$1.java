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
    if (("android.intent.action.PACKAGE_ADDED".equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) || ("android.intent.action.PACKAGE_REPLACED".equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)))
    {
      Object localObject = UniformDownloadMgr.a().a().a(this.b, true);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          SucDownloadInfo localSucDownloadInfo = (SucDownloadInfo)((Iterator)localObject).next();
          if (localSucDownloadInfo != null)
          {
            QLog.i("UniformDownloadPkgInstallReceiver", 1, "[UniformDL] send cancel notification.pkgName:" + this.b + " notificationId:" + localSucDownloadInfo.a);
            UniformDownloadNfn.a().c(localSucDownloadInfo.a, null);
            this.this$0.a(this.jdField_a_of_type_AndroidContentContext, localSucDownloadInfo);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadPkgInstallReceiver.1
 * JD-Core Version:    0.7.0.1
 */