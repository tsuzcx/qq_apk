package com.tencent.mobileqq.shortvideo.redbag;

import aogj;
import aomw;
import azey;
import azfc;
import bdvv;
import bdvx;
import bdwa;
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
      if (azey.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : isLoadingRes = true");
        }
        return;
      }
      azey.jdField_a_of_type_Boolean = true;
      localObject = (aomw)aogj.a().a(252);
      String str1 = ((aomw)localObject).b;
      localObject = ((aomw)localObject).jdField_a_of_type_JavaLangString;
      if ((QLog.isColorLevel()) && (str1 != null) && (localObject != null)) {
        QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes: md5 = " + str1 + ", url = " + (String)localObject);
      }
      if ((str1 == null) || (str1.length() == 0) || (localObject == null) || (((String)localObject).length() == 0))
      {
        azey.jdField_a_of_type_Boolean = false;
        return;
      }
    }
    finally {}
    if (!azey.a(str2, this.a))
    {
      String str3 = azey.jdField_a_of_type_JavaLangString + "VideoRedbagRes_2.0_android.zip";
      bdvv localbdvv = new bdvv((String)localObject, new File(str3));
      localbdvv.n = true;
      bdwa localbdwa = ((bdvx)this.a.getManager(47)).a(1);
      if (QLog.isColorLevel()) {
        QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [download] startDownload: " + (String)localObject + " path=" + str3);
      }
      localbdwa.a(localbdvv, new azfc(this, (String)localObject, str3, str2), null);
    }
    for (;;)
    {
      return;
      azey.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.2
 * JD-Core Version:    0.7.0.1
 */