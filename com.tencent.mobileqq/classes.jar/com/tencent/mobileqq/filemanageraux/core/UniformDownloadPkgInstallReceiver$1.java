package com.tencent.mobileqq.filemanageraux.core;

import android.content.Context;
import aure;
import aurl;
import aurm;
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
      Object localObject = aure.a().a(this.b, true);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          aurl localaurl = (aurl)((Iterator)localObject).next();
          if (localaurl != null)
          {
            QLog.i("UniformDownloadPkgInstallReceiver<FileAssistant>", 1, "[UniformDL] send cancel notification.pkgName:" + this.b + " notificationId:" + localaurl.a);
            aurm.a().c(localaurl.a, null);
            this.this$0.a(this.jdField_a_of_type_AndroidContentContext, localaurl);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.UniformDownloadPkgInstallReceiver.1
 * JD-Core Version:    0.7.0.1
 */