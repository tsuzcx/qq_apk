package com.tencent.mobileqq.filemanageraux.core;

import android.content.Context;
import auht;
import auia;
import auib;
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
      Object localObject = auht.a().a(this.b, true);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          auia localauia = (auia)((Iterator)localObject).next();
          if (localauia != null)
          {
            QLog.i("UniformDownloadPkgInstallReceiver<FileAssistant>", 1, "[UniformDL] send cancel notification.pkgName:" + this.b + " notificationId:" + localauia.a);
            auib.a().c(localauia.a, null);
            this.this$0.a(this.jdField_a_of_type_AndroidContentContext, localauia);
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