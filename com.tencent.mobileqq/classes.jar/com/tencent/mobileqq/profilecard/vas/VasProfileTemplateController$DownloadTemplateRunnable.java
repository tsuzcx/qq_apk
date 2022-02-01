package com.tencent.mobileqq.profilecard.vas;

import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

class VasProfileTemplateController$DownloadTemplateRunnable
  implements Runnable
{
  private WeakReference<FriendProfileCardActivity> mActivityRef;
  private long mBackgroundId;
  private String mBackgroundUrl;
  private WeakReference<ProfileCardTemplate> mCardTemplateRef;
  private AtomicBoolean mIsRunning;
  
  VasProfileTemplateController$DownloadTemplateRunnable(FriendProfileCardActivity paramFriendProfileCardActivity, ProfileCardTemplate paramProfileCardTemplate, AtomicBoolean paramAtomicBoolean, String paramString, long paramLong)
  {
    this.mActivityRef = new WeakReference(paramFriendProfileCardActivity);
    this.mCardTemplateRef = new WeakReference(paramProfileCardTemplate);
    this.mIsRunning = paramAtomicBoolean;
    this.mBackgroundUrl = paramString;
    this.mBackgroundId = paramLong;
  }
  
  private boolean isExistsTemplateDir(FriendProfileCardActivity paramFriendProfileCardActivity, boolean paramBoolean)
  {
    boolean bool1 = paramBoolean;
    String str;
    if (!paramBoolean)
    {
      str = ProfileCardUtil.a(paramFriendProfileCardActivity.app, -1L);
      bool1 = paramBoolean;
      if (str != null)
      {
        localFile = new File(str);
        localObject = new File(str + File.separator + "config_black.json");
        if ((!localFile.isDirectory()) || (!((File)localObject).exists())) {
          break label109;
        }
        if (!QLog.isColorLevel()) {
          break label332;
        }
        QLog.d("ProfileTemplateCheckController", 2, "DownloadTemplateRunnable template already exists");
        bool1 = true;
      }
    }
    return bool1;
    label109:
    File localFile = new File(str + ".zip");
    if (localFile.exists()) {
      localFile.delete();
    }
    Object localObject = new DownloadTask("https://imgcache.gtimg.cn/club/mobile/profile/template/android_common_583.zip", localFile);
    ((DownloadTask)localObject).f = "profileCardDownload";
    ((DownloadTask)localObject).e = "VIP_profilecard";
    int j = DownloaderFactory.a((DownloadTask)localObject, paramFriendProfileCardActivity.app);
    if (j == 0) {}
    boolean bool2;
    for (int i = 1;; i = 0)
    {
      bool2 = paramBoolean;
      if (i != 0) {}
      try
      {
        FileUtils.a(localFile.getAbsolutePath(), str + File.separator, false);
        ProfileCardUtil.a(paramFriendProfileCardActivity.app, "common", "583");
        bool2 = paramBoolean;
        if (ProfileCardUtil.a(paramFriendProfileCardActivity.app))
        {
          localFile.delete();
          bool2 = true;
        }
      }
      catch (Throwable paramFriendProfileCardActivity)
      {
        for (;;)
        {
          QLog.e("ProfileTemplateCheckController", 1, "DownloadTemplateRunnable unzip fail.", paramFriendProfileCardActivity);
          bool2 = paramBoolean;
        }
      }
      bool1 = bool2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ProfileTemplateCheckController", 2, String.format("DownloadTemplateRunnable download template resultCode=%s isExistsTemplateDir=%s", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool2) }));
      return bool2;
    }
    label332:
    return true;
  }
  
  public void run()
  {
    label468:
    for (;;)
    {
      try
      {
        if ((this.mActivityRef != null) && (this.mCardTemplateRef != null))
        {
          FriendProfileCardActivity localFriendProfileCardActivity = (FriendProfileCardActivity)this.mActivityRef.get();
          Object localObject = (ProfileCardTemplate)this.mCardTemplateRef.get();
          if ((localFriendProfileCardActivity != null) && (localObject != null))
          {
            long l = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d("ProfileTemplateCheckController", 2, "DownloadTemplateRunnable start");
            }
            boolean bool3 = ProfileCardUtil.a(localFriendProfileCardActivity.app);
            if ((this.mBackgroundId != 160L) && (this.mBackgroundId != 1600L)) {
              break label468;
            }
            bool1 = ProfileCardUtil.a(localFriendProfileCardActivity.app.getApplication(), this.mBackgroundUrl);
            if (QLog.isColorLevel()) {
              QLog.d("ProfileTemplateCheckController", 2, String.format("DownloadTemplateRunnable start isExistsTemplateDir=%s isExistBgResource=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
            }
            boolean bool2 = bool1;
            if (!bool1)
            {
              localObject = new File(ProfileCardUtil.a(localFriendProfileCardActivity.app.getApplication(), this.mBackgroundUrl));
              localObject = new DownloadTask(this.mBackgroundUrl, (File)localObject);
              ((DownloadTask)localObject).f = "profileCardDownload";
              ((DownloadTask)localObject).e = "VIP_profilecard";
              i = DownloaderFactory.a((DownloadTask)localObject, localFriendProfileCardActivity.app);
              if ((i != 0) || (!ProfileCardUtil.a(localFriendProfileCardActivity.app.getApplication(), this.mBackgroundUrl))) {
                continue;
              }
              bool1 = true;
              bool2 = bool1;
              if (QLog.isColorLevel())
              {
                QLog.d("ProfileTemplateCheckController", 2, String.format("DownloadTemplateRunnable download bg resultBgCode=%s isExistBgResource=%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) }));
                bool2 = bool1;
              }
            }
            bool1 = isExistsTemplateDir(localFriendProfileCardActivity, bool3);
            if (QLog.isColorLevel())
            {
              QLog.d("ProfileTemplateCheckController", 2, String.format("DownloadTemplateRunnable end isExistsTemplateDir=%s isExistBgResource=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
              QLog.d("ProfileTemplateCheckController", 2, String.format("DownloadTemplateRunnable end timeCost=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
            }
            if (localFriendProfileCardActivity.a != null)
            {
              localObject = localFriendProfileCardActivity.a.obtainMessage();
              ((Message)localObject).what = 7;
              if ((!bool1) || (!bool2)) {
                continue;
              }
              i = 1;
              ((Message)localObject).arg1 = i;
              ((Message)localObject).arg2 = 0;
              localFriendProfileCardActivity.a.sendMessage((Message)localObject);
            }
          }
        }
        this.mIsRunning.set(false);
        return;
        boolean bool1 = false;
        continue;
        int i = 0;
        continue;
        bool1 = true;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ProfileTemplateCheckController", 1, "DownloadTemplateRunnable fail.", localThrowable);
        this.mIsRunning.set(false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.VasProfileTemplateController.DownloadTemplateRunnable
 * JD-Core Version:    0.7.0.1
 */