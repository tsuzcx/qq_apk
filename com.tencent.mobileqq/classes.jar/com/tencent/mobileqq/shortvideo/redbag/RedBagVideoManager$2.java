package com.tencent.mobileqq.shortvideo.redbag;

import aqxe;
import arfn;
import bdcw;
import bdda;
import bhyo;
import bhyq;
import bhyt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class RedBagVideoManager$2
  implements Runnable
{
  public RedBagVideoManager$2(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject;
    try
    {
      if (bdcw.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : isLoadingRes = true");
        }
        return;
      }
      bdcw.jdField_a_of_type_Boolean = true;
      localObject = (arfn)aqxe.a().a(252);
      String str1 = ((arfn)localObject).b;
      localObject = ((arfn)localObject).jdField_a_of_type_JavaLangString;
      if ((QLog.isColorLevel()) && (str1 != null) && (localObject != null)) {
        QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes: md5 = " + str1 + ", url = " + (String)localObject);
      }
      if ((str1 == null) || (str1.length() == 0) || (localObject == null) || (((String)localObject).length() == 0))
      {
        bdcw.jdField_a_of_type_Boolean = false;
        return;
      }
    }
    finally {}
    if (!bdcw.a(str2, this.a))
    {
      String str3 = bdcw.jdField_a_of_type_JavaLangString + "VideoRedbagRes_2.0_android.zip";
      bhyo localbhyo = new bhyo((String)localObject, new File(str3));
      localbhyo.n = true;
      bhyt localbhyt = ((bhyq)this.a.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
      if (QLog.isColorLevel()) {
        QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [download] startDownload: " + (String)localObject + " path=" + str3);
      }
      localbhyt.a(localbhyo, new bdda(this, (String)localObject, str3, str2), null);
    }
    for (;;)
    {
      return;
      bdcw.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.2
 * JD-Core Version:    0.7.0.1
 */