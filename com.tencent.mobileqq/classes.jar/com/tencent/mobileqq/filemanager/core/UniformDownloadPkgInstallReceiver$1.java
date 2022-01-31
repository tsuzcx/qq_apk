package com.tencent.mobileqq.filemanager.core;

import aqwa;
import aqwh;
import aqwi;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class UniformDownloadPkgInstallReceiver$1
  implements Runnable
{
  UniformDownloadPkgInstallReceiver$1(UniformDownloadPkgInstallReceiver paramUniformDownloadPkgInstallReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (("android.intent.action.PACKAGE_ADDED".equalsIgnoreCase(this.a)) || ("android.intent.action.PACKAGE_REPLACED".equalsIgnoreCase(this.a)))
    {
      Object localObject = aqwa.a().a(this.b, true);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          aqwh localaqwh = (aqwh)((Iterator)localObject).next();
          if (localaqwh != null)
          {
            QLog.i("UniformDownloadPkgInstallReceiver<FileAssistant>", 1, "[UniformDL] send cancel notification.pkgName:" + this.b + " notificationId:" + localaqwh.a);
            aqwi.a().c(localaqwh.a, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadPkgInstallReceiver.1
 * JD-Core Version:    0.7.0.1
 */