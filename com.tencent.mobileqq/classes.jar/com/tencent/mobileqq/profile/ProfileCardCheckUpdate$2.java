package com.tencent.mobileqq.profile;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.ProfileCardTemplateUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ProfileCardCheckUpdate$2
  implements Runnable
{
  ProfileCardCheckUpdate$2(ProfileCardCheckUpdate paramProfileCardCheckUpdate, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ProfileCardCheckUpdate start downloadLabelConfigJson url=");
      ((StringBuilder)localObject1).append(this.a);
      ((StringBuilder)localObject1).append(",version=");
      ((StringBuilder)localObject1).append(this.b);
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        localObject1 = ProfileCardTemplateUtil.a(this.this$0.a.getApplication());
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(".tmp");
        localObject1 = new File(((StringBuilder)localObject2).toString());
        localObject2 = new DownloadTask(this.a, (File)localObject1);
        ((DownloadTask)localObject2).L = "profileCardDownload";
        ((DownloadTask)localObject2).K = "VIP_profilecard";
        i = 1;
        ((DownloadTask)localObject2).O = 1;
        ((DownloadTask)localObject2).J = true;
        int j = DownloaderFactory.a((DownloadTask)localObject2, this.this$0.a);
        if (j != 0) {
          break label305;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ProfileCardCheckUpdate downloadLabelConfigJson result code=");
          ((StringBuilder)localObject2).append(j);
          QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, ((StringBuilder)localObject2).toString());
        }
        if (i != 0)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("ProfileCardCheckUpdate downloadLabelConfigJson update label config  success version=");
            ((StringBuilder)localObject2).append(this.b);
            QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, ((StringBuilder)localObject2).toString());
          }
          this.this$0.a.getPreferences().edit().putString("profileLabelVersion", this.b).commit();
          ProfileCardCheckUpdate.a(this.this$0, (File)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label305:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardCheckUpdate.2
 * JD-Core Version:    0.7.0.1
 */