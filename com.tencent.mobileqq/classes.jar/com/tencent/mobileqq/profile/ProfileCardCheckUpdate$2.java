package com.tencent.mobileqq.profile;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import azxq;
import bhhz;
import bihu;
import bihw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ProfileCardCheckUpdate$2
  implements Runnable
{
  public ProfileCardCheckUpdate$2(azxq paramazxq, String paramString1, String paramString2) {}
  
  public void run()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate start downloadLabelConfigJson url=" + this.a + ",version=" + this.b);
    }
    try
    {
      Object localObject = bhhz.a(this.this$0.a.getApplication());
      localObject = new File((String)localObject + ".tmp");
      bihu localbihu = new bihu(this.a, (File)localObject);
      localbihu.f = "profileCardDownload";
      localbihu.e = "VIP_profilecard";
      localbihu.a = 1;
      localbihu.n = true;
      int j = bihw.a(localbihu, this.this$0.a);
      if (j == 0) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate downloadLabelConfigJson result code=" + j);
        }
        if (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate downloadLabelConfigJson update label config  success version=" + this.b);
          }
          this.this$0.a.getPreferences().edit().putString("profileLabelVersion", this.b).commit();
          azxq.a(this.this$0, (File)localObject);
        }
        return;
        i = 0;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardCheckUpdate.2
 * JD-Core Version:    0.7.0.1
 */