package com.tencent.mobileqq.shortvideo.redbag;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.RedBagVideoResProcessor.RedBagVideoResConfigBean;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class RedBagVideoManager$2
  implements Runnable
{
  RedBagVideoManager$2(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject;
    try
    {
      if (RedBagVideoManager.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : isLoadingRes = true");
        }
        return;
      }
      RedBagVideoManager.jdField_a_of_type_Boolean = true;
      localObject = (RedBagVideoResProcessor.RedBagVideoResConfigBean)QConfigManager.a().a(252);
      String str1 = ((RedBagVideoResProcessor.RedBagVideoResConfigBean)localObject).b;
      localObject = ((RedBagVideoResProcessor.RedBagVideoResConfigBean)localObject).jdField_a_of_type_JavaLangString;
      if ((QLog.isColorLevel()) && (str1 != null) && (localObject != null)) {
        QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes: md5 = " + str1 + ", url = " + (String)localObject);
      }
      if ((str1 == null) || (str1.length() == 0) || (localObject == null) || (((String)localObject).length() == 0))
      {
        RedBagVideoManager.jdField_a_of_type_Boolean = false;
        return;
      }
    }
    finally {}
    if (!RedBagVideoManager.a(str2, this.a))
    {
      String str3 = RedBagVideoManager.jdField_a_of_type_JavaLangString + "VideoRedbagRes_2.0_android.zip";
      DownloadTask localDownloadTask = new DownloadTask((String)localObject, new File(str3));
      localDownloadTask.n = true;
      DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.a.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
      if (QLog.isColorLevel()) {
        QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [download] startDownload: " + (String)localObject + " path=" + str3);
      }
      localDownloaderInterface.a(localDownloadTask, new RedBagVideoManager.2.1(this, (String)localObject, str3, str2), null);
    }
    for (;;)
    {
      return;
      RedBagVideoManager.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.2
 * JD-Core Version:    0.7.0.1
 */