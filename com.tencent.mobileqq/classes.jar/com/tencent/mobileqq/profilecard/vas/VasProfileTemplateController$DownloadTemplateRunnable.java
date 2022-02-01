package com.tencent.mobileqq.profilecard.vas;

import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.util.ProfileCardTemplateUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class VasProfileTemplateController$DownloadTemplateRunnable
  implements Runnable
{
  private Runnable endCallback;
  private long mBackgroundId;
  private String mBackgroundUrl;
  private WeakReference<ProfileCardTemplate> mCardTemplateRef;
  private AtomicBoolean mIsRunning;
  
  VasProfileTemplateController$DownloadTemplateRunnable(ProfileCardTemplate paramProfileCardTemplate, AtomicBoolean paramAtomicBoolean, String paramString, long paramLong, Runnable paramRunnable)
  {
    this.mCardTemplateRef = new WeakReference(paramProfileCardTemplate);
    this.mIsRunning = paramAtomicBoolean;
    this.mBackgroundUrl = paramString;
    this.mBackgroundId = paramLong;
    this.endCallback = paramRunnable;
  }
  
  private boolean isExistsTemplateDir(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    boolean bool2 = paramBoolean;
    if (!paramBoolean)
    {
      String str = ProfileCardTemplateUtil.a(-1L);
      bool2 = paramBoolean;
      if (str != null)
      {
        Object localObject1 = new File(str);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append("config_black.json");
        localObject2 = new File(((StringBuilder)localObject2).toString());
        if ((((File)localObject1).isDirectory()) && (((File)localObject2).exists()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTemplateCheckController", 2, "DownloadTemplateRunnable template already exists");
          }
          return true;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append(".zip");
        localObject1 = new File(((StringBuilder)localObject1).toString());
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        localObject2 = new DownloadTask("https://imgcache.gtimg.cn/club/mobile/profile/template/android_common_583.zip", (File)localObject1);
        ((DownloadTask)localObject2).L = "profileCardDownload";
        ((DownloadTask)localObject2).K = "VIP_profilecard";
        int j = DownloaderFactory.a((DownloadTask)localObject2, paramAppRuntime);
        int i;
        if (j == 0) {
          i = 1;
        } else {
          i = 0;
        }
        boolean bool1 = paramBoolean;
        if (i != 0) {
          try
          {
            paramAppRuntime = ((File)localObject1).getAbsolutePath();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(str);
            ((StringBuilder)localObject2).append(File.separator);
            FileUtils.uncompressZip(paramAppRuntime, ((StringBuilder)localObject2).toString(), false);
            bool1 = paramBoolean;
            if (ProfileCardTemplateUtil.a())
            {
              ((File)localObject1).delete();
              bool1 = true;
            }
          }
          catch (Throwable paramAppRuntime)
          {
            QLog.e("ProfileTemplateCheckController", 1, "DownloadTemplateRunnable unzip fail.", paramAppRuntime);
            bool1 = paramBoolean;
          }
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("ProfileTemplateCheckController", 2, String.format("DownloadTemplateRunnable download template resultCode=%s isExistsTemplateDir=%s", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool1) }));
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        Object localObject = (ProfileCardTemplate)this.mCardTemplateRef.get();
        if ((localAppRuntime != null) && (this.mCardTemplateRef != null) && (localObject != null))
        {
          long l = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTemplateCheckController", 2, "DownloadTemplateRunnable start");
          }
          boolean bool3 = ProfileCardTemplateUtil.a();
          if (this.mBackgroundId != 160L) {
            if (this.mBackgroundId != 1600L) {
              break label365;
            }
          }
          bool1 = ProfileCardUtil.b(this.mBackgroundUrl);
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTemplateCheckController", 2, String.format("DownloadTemplateRunnable start isExistsTemplateDir=%s isExistBgResource=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
          }
          bool2 = bool1;
          if (!bool1)
          {
            localObject = new File(ProfileCardUtil.c(this.mBackgroundUrl));
            localObject = new DownloadTask(this.mBackgroundUrl, (File)localObject);
            ((DownloadTask)localObject).L = "profileCardDownload";
            ((DownloadTask)localObject).K = "VIP_profilecard";
            int i = DownloaderFactory.a((DownloadTask)localObject, localAppRuntime);
            if ((i != 0) || (!ProfileCardUtil.b(this.mBackgroundUrl))) {
              break label371;
            }
            bool1 = true;
            if (!QLog.isColorLevel()) {
              break label377;
            }
            QLog.d("ProfileTemplateCheckController", 2, String.format("DownloadTemplateRunnable download bg resultBgCode=%s isExistBgResource=%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) }));
            break label377;
          }
          bool1 = isExistsTemplateDir(localAppRuntime, bool3);
          if (QLog.isColorLevel())
          {
            QLog.d("ProfileTemplateCheckController", 2, String.format("DownloadTemplateRunnable end isExistsTemplateDir=%s isExistBgResource=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
            QLog.d("ProfileTemplateCheckController", 2, String.format("DownloadTemplateRunnable end timeCost=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
          }
          this.endCallback.run();
        }
        else
        {
          this.mIsRunning.set(false);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ProfileTemplateCheckController", 1, "DownloadTemplateRunnable fail.", localThrowable);
        this.mIsRunning.set(false);
        return;
      }
      label365:
      boolean bool1 = true;
      continue;
      label371:
      bool1 = false;
      continue;
      label377:
      boolean bool2 = bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.VasProfileTemplateController.DownloadTemplateRunnable
 * JD-Core Version:    0.7.0.1
 */