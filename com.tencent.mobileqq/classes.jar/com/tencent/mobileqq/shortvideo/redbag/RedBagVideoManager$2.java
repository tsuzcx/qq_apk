package com.tencent.mobileqq.shortvideo.redbag;

import aran;
import arip;
import bdcy;
import bddc;
import bihu;
import bihw;
import bihz;
import com.tencent.mobileqq.app.QQAppInterface;
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
      if (bdcy.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : isLoadingRes = true");
        }
        return;
      }
      bdcy.jdField_a_of_type_Boolean = true;
      localObject = (arip)aran.a().a(252);
      String str1 = ((arip)localObject).b;
      localObject = ((arip)localObject).jdField_a_of_type_JavaLangString;
      if ((QLog.isColorLevel()) && (str1 != null) && (localObject != null)) {
        QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes: md5 = " + str1 + ", url = " + (String)localObject);
      }
      if ((str1 == null) || (str1.length() == 0) || (localObject == null) || (((String)localObject).length() == 0))
      {
        bdcy.jdField_a_of_type_Boolean = false;
        return;
      }
    }
    finally {}
    if (!bdcy.a(str2, this.a))
    {
      String str3 = bdcy.jdField_a_of_type_JavaLangString + "VideoRedbagRes_2.0_android.zip";
      bihu localbihu = new bihu((String)localObject, new File(str3));
      localbihu.n = true;
      bihz localbihz = ((bihw)this.a.getManager(47)).a(1);
      if (QLog.isColorLevel()) {
        QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [download] startDownload: " + (String)localObject + " path=" + str3);
      }
      localbihz.a(localbihu, new bddc(this, (String)localObject, str3, str2), null);
    }
    for (;;)
    {
      return;
      bdcy.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.2
 * JD-Core Version:    0.7.0.1
 */