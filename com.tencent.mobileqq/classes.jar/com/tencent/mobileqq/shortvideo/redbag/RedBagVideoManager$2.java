package com.tencent.mobileqq.shortvideo.redbag;

import aqlk;
import aqtd;
import bckg;
import bckk;
import bhhf;
import bhhh;
import bhhk;
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
      if (bckg.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : isLoadingRes = true");
        }
        return;
      }
      bckg.jdField_a_of_type_Boolean = true;
      localObject = (aqtd)aqlk.a().a(252);
      String str1 = ((aqtd)localObject).b;
      localObject = ((aqtd)localObject).jdField_a_of_type_JavaLangString;
      if ((QLog.isColorLevel()) && (str1 != null) && (localObject != null)) {
        QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes: md5 = " + str1 + ", url = " + (String)localObject);
      }
      if ((str1 == null) || (str1.length() == 0) || (localObject == null) || (((String)localObject).length() == 0))
      {
        bckg.jdField_a_of_type_Boolean = false;
        return;
      }
    }
    finally {}
    if (!bckg.a(str2, this.a))
    {
      String str3 = bckg.jdField_a_of_type_JavaLangString + "VideoRedbagRes_2.0_android.zip";
      bhhf localbhhf = new bhhf((String)localObject, new File(str3));
      localbhhf.n = true;
      bhhk localbhhk = ((bhhh)this.a.getManager(47)).a(1);
      if (QLog.isColorLevel()) {
        QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [download] startDownload: " + (String)localObject + " path=" + str3);
      }
      localbhhk.a(localbhhf, new bckk(this, (String)localObject, str3, str2), null);
    }
    for (;;)
    {
      return;
      bckg.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.2
 * JD-Core Version:    0.7.0.1
 */