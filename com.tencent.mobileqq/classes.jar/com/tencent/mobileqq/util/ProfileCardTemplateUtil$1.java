package com.tencent.mobileqq.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

final class ProfileCardTemplateUtil$1
  implements Runnable
{
  ProfileCardTemplateUtil$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    Object localObject2;
    Object localObject4;
    Object localObject3;
    Object localObject5;
    if (localObject1 != null)
    {
      localObject2 = ((QQAppInterface)localObject1).getPreferences();
      localObject4 = ((SharedPreferences)localObject2).getString("cardTemplateVersion", "0");
      localObject1 = ((SharedPreferences)localObject2).getString("cardTemplateServerVersion", "0");
      localObject3 = ((SharedPreferences)localObject2).getString("cardTemplateServerUrl", "0");
      if (QLog.isColorLevel())
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("func downloadProfileStyleFile, serverUrl:");
        ((StringBuilder)localObject5).append((String)localObject3);
        ((StringBuilder)localObject5).append(",localVersion:");
        ((StringBuilder)localObject5).append((String)localObject4);
        ((StringBuilder)localObject5).append(",serverVersion:");
        ((StringBuilder)localObject5).append((String)localObject1);
        QLog.d("ProfileCardUtil", 2, ((StringBuilder)localObject5).toString());
      }
      if ((!TextUtils.equals((CharSequence)localObject4, (CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("downloadProfileStyleFile start downloadProfileStyleFile url=");
          ((StringBuilder)localObject4).append((String)localObject3);
          ((StringBuilder)localObject4).append(",version=");
          ((StringBuilder)localObject4).append((String)localObject1);
          QLog.d("ProfileCardUtil", 2, ((StringBuilder)localObject4).toString());
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localObject4 = ProfileCardTemplateUtil.b(this.a.getApplication());
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append((String)localObject4);
        ((StringBuilder)localObject5).append(".tmp");
        localObject5 = new File(((StringBuilder)localObject5).toString());
        Object localObject6 = new DownloadTask((String)localObject3, (File)localObject5);
        ((DownloadTask)localObject6).f = "profileCardDownload";
        ((DownloadTask)localObject6).e = "VIP_profilecard";
        ((DownloadTask)localObject6).a = 1;
        int j = DownloaderFactory.a((DownloadTask)localObject6, this.a);
        i = 0;
        if (j != 0) {
          break label693;
        }
        bool = true;
        if (QLog.isColorLevel())
        {
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("func downloadProfileStyleFile, downloadSuccess:");
          ((StringBuilder)localObject6).append(bool);
          QLog.d("ProfileCardUtil", 2, ((StringBuilder)localObject6).toString());
        }
        if (bool)
        {
          if (((File)localObject5).exists())
          {
            localObject3 = FileUtils.readFileContent((File)localObject5);
            if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (new JSONObject((String)localObject3).optJSONArray("style").length() > 0))
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append((String)localObject4);
              ((StringBuilder)localObject3).append(".tmp");
              FileUtils.copyFile(((StringBuilder)localObject3).toString(), (String)localObject4);
              ((File)localObject5).delete();
              localObject3 = new File((String)localObject4).getParentFile().listFiles();
              if ((localObject3 != null) && (localObject3.length > 0) && (i < localObject3.length))
              {
                localObject4 = localObject3[i].getName();
                if ((!((String)localObject4).startsWith("qvip_profile_template.json")) || (((String)localObject4).endsWith("8.7.0"))) {
                  break label698;
                }
                FileUtils.deleteFile((String)localObject4);
                if (!QLog.isColorLevel()) {
                  break label698;
                }
                localObject5 = new StringBuilder();
                ((StringBuilder)localObject5).append("delete old file=");
                ((StringBuilder)localObject5).append((String)localObject4);
                QLog.i("Q.profilecard.FrdProfileCard", 2, ((StringBuilder)localObject5).toString());
                break label698;
              }
              ((SharedPreferences)localObject2).edit().putString("cardTemplateVersion", (String)localObject1).commit();
              ProfileCardTemplateUtil.a(true);
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("ProfileCardCheckUpdate update template list file success version=");
                ((StringBuilder)localObject2).append((String)localObject1);
                QLog.d("Q.profilecard.FrdProfileCard", 2, ((StringBuilder)localObject2).toString());
              }
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("ProfileCardCheckUpdate download error resultCode=");
          ((StringBuilder)localObject1).append(j);
          ((StringBuilder)localObject1).append(",url=");
          ((StringBuilder)localObject1).append((String)localObject3);
          QLog.d("Q.profilecard.FrdProfileCard", 2, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      return;
      label693:
      boolean bool = false;
      continue;
      label698:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardTemplateUtil.1
 * JD-Core Version:    0.7.0.1
 */