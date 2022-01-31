package com.tencent.mobileqq.profile;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import awqs;
import bddf;
import beae;
import beag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ProfileCardCheckUpdate$2
  implements Runnable
{
  public ProfileCardCheckUpdate$2(awqs paramawqs, String paramString1, String paramString2) {}
  
  public void run()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate start downloadLabelConfigJson url=" + this.a + ",version=" + this.b);
    }
    try
    {
      Object localObject = bddf.a(this.this$0.a.getApplication());
      localObject = new File((String)localObject + ".tmp");
      beae localbeae = new beae(this.a, (File)localObject);
      localbeae.f = "profileCardDownload";
      localbeae.e = "VIP_profilecard";
      localbeae.a = 1;
      localbeae.n = true;
      int j = beag.a(localbeae, this.this$0.a);
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
          awqs.a(this.this$0, (File)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardCheckUpdate.2
 * JD-Core Version:    0.7.0.1
 */