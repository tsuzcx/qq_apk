package com.tencent.mobileqq.nearby.profilecard;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.config.PicIPManager;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

class NearbyPeopleProfileActivity$DownloadHDAvatarRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  NearbyPeopleProfileActivity$DownloadHDAvatarRunnable(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    int j = 1;
    Object localObject = this.b + this.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.e("Q.nearby_people_card.", 2, "downloadHDAvatar()  uin=" + this.jdField_a_of_type_JavaLangString + ", mgSize=" + this.jdField_a_of_type_Int + ", url = " + (String)localObject);
    }
    File localFile1 = new File(FaceUtil.a(String.valueOf(this.jdField_a_of_type_JavaLangString)));
    boolean bool2;
    if ((localFile1.exists()) && (!this.jdField_a_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.nearby_people_card.", 2, "download HDAvatar file is exists");
      }
      bool2 = true;
      localObject = new Message();
      ((Message)localObject).what = 102;
      if (!bool2) {
        break label398;
      }
      i = 1;
      label158:
      ((Message)localObject).arg1 = i;
      if (!this.jdField_a_of_type_Boolean) {
        break label403;
      }
    }
    label398:
    label403:
    for (int i = j;; i = 0)
    {
      for (;;)
      {
        ((Message)localObject).arg2 = i;
        this.this$0.a.sendMessage((Message)localObject);
        return;
        File localFile2 = new File(localFile1.getPath() + Long.toString(System.currentTimeMillis()));
        String str = MsfSdkUtils.insertMtype("friendlist", (String)localObject);
        try
        {
          localObject = new URL(str);
          localObject = new URL(((URL)localObject).getProtocol(), PicIPManager.a(0), ((URL)localObject).getFile()).toString();
          if (HttpDownloadUtil.downloadData(this.this$0.app, new DownloadInfo((String)localObject, localFile2, 0), null) == 0)
          {
            bool2 = true;
            boolean bool1 = bool2;
            if (bool2) {
              bool1 = localFile2.renameTo(localFile1);
            }
            this.this$0.u = bool1;
            bool2 = bool1;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("Q.nearby_people_card.", 2, "donwload HDAvatar finish : " + bool1);
            bool2 = bool1;
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            localObject = str;
            if (QLog.isDevelopLevel())
            {
              localMalformedURLException.printStackTrace();
              localObject = str;
              continue;
              bool2 = false;
            }
          }
        }
      }
      i = 0;
      break label158;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.DownloadHDAvatarRunnable
 * JD-Core Version:    0.7.0.1
 */