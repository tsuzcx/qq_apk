package com.tencent.mobileqq.shortvideo.redbag;

import ampm;
import amvs;
import axjq;
import axju;
import bbwg;
import bbwi;
import bbwl;
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
      if (axjq.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : isLoadingRes = true");
        }
        return;
      }
      axjq.jdField_a_of_type_Boolean = true;
      localObject = (amvs)ampm.a().a(252);
      String str1 = ((amvs)localObject).b;
      localObject = ((amvs)localObject).jdField_a_of_type_JavaLangString;
      if ((QLog.isColorLevel()) && (str1 != null) && (localObject != null)) {
        QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes: md5 = " + str1 + ", url = " + (String)localObject);
      }
      if ((str1 == null) || (str1.length() == 0) || (localObject == null) || (((String)localObject).length() == 0))
      {
        axjq.jdField_a_of_type_Boolean = false;
        return;
      }
    }
    finally {}
    if (!axjq.a(str2, this.a))
    {
      String str3 = axjq.jdField_a_of_type_JavaLangString + "VideoRedbagRes_2.0_android.zip";
      bbwg localbbwg = new bbwg((String)localObject, new File(str3));
      localbbwg.n = true;
      bbwl localbbwl = ((bbwi)this.a.getManager(47)).a(1);
      if (QLog.isColorLevel()) {
        QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [download] startDownload: " + (String)localObject + " path=" + str3);
      }
      localbbwl.a(localbbwg, new axju(this, (String)localObject, str3, str2), null);
    }
    for (;;)
    {
      return;
      axjq.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.2
 * JD-Core Version:    0.7.0.1
 */