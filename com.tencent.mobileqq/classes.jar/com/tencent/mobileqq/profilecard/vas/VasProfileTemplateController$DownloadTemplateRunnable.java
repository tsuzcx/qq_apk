package com.tencent.mobileqq.profilecard.vas;

import android.os.Message;
import azfl;
import bghy;
import bgmg;
import bhhf;
import bhhh;
import bkgm;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

class VasProfileTemplateController$DownloadTemplateRunnable
  implements Runnable
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<FriendProfileCardActivity> jdField_a_of_type_JavaLangRefWeakReference;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private WeakReference<azfl> b;
  
  VasProfileTemplateController$DownloadTemplateRunnable(FriendProfileCardActivity paramFriendProfileCardActivity, azfl paramazfl, AtomicBoolean paramAtomicBoolean, String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFriendProfileCardActivity);
    this.b = new WeakReference(paramazfl);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = paramAtomicBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void run()
  {
    for (;;)
    {
      boolean bool3;
      int i;
      boolean bool2;
      try
      {
        if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.b != null))
        {
          localFriendProfileCardActivity = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          localObject1 = (azfl)this.b.get();
          if ((localFriendProfileCardActivity != null) && (localObject1 != null))
          {
            long l = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d("ProfileTemplateCheckController", 2, "DownloadTemplateRunnable start");
            }
            bool3 = bghy.a(localFriendProfileCardActivity.app);
            if ((this.jdField_a_of_type_Long != 160L) && (this.jdField_a_of_type_Long != 1600L)) {
              break label800;
            }
            bool1 = bghy.a(localFriendProfileCardActivity.app.getApplication(), this.jdField_a_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.d("ProfileTemplateCheckController", 2, String.format("DownloadTemplateRunnable start isExistsTemplateDir=%s isExistBgResource=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
            }
            boolean bool4 = bool1;
            if (!bool1)
            {
              localObject1 = new File(bghy.a(localFriendProfileCardActivity.app.getApplication(), this.jdField_a_of_type_JavaLangString));
              localObject1 = new bhhf(this.jdField_a_of_type_JavaLangString, (File)localObject1);
              ((bhhf)localObject1).f = "profileCardDownload";
              ((bhhf)localObject1).e = "VIP_profilecard";
              i = bhhh.a((bhhf)localObject1, localFriendProfileCardActivity.app);
              if ((i != 0) || (!bghy.a(localFriendProfileCardActivity.app.getApplication(), this.jdField_a_of_type_JavaLangString))) {
                break label806;
              }
              bool1 = true;
              bool4 = bool1;
              if (QLog.isColorLevel())
              {
                QLog.d("ProfileTemplateCheckController", 2, String.format("DownloadTemplateRunnable download bg resultBgCode=%s isExistBgResource=%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) }));
                bool4 = bool1;
              }
            }
            bool1 = bool3;
            if (!bool3)
            {
              localObject1 = bghy.a(localFriendProfileCardActivity.app, -1L);
              bool1 = bool3;
              if (localObject1 != null)
              {
                localFile = new File((String)localObject1);
                localObject2 = new File((String)localObject1 + File.separator + "config_black.json");
                if ((!localFile.isDirectory()) || (!((File)localObject2).exists())) {
                  continue;
                }
                if (!QLog.isColorLevel()) {
                  break label794;
                }
                QLog.d("ProfileTemplateCheckController", 2, "DownloadTemplateRunnable template already exists");
                bool1 = true;
              }
            }
            if (QLog.isColorLevel())
            {
              QLog.d("ProfileTemplateCheckController", 2, String.format("DownloadTemplateRunnable end isExistsTemplateDir=%s isExistBgResource=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool4) }));
              QLog.d("ProfileTemplateCheckController", 2, String.format("DownloadTemplateRunnable end timeCost=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
            }
            if (localFriendProfileCardActivity.a != null)
            {
              localObject1 = localFriendProfileCardActivity.a.obtainMessage();
              ((Message)localObject1).what = 7;
              if ((!bool1) || (!bool4)) {
                break label789;
              }
              i = 1;
              ((Message)localObject1).arg1 = i;
              ((Message)localObject1).arg2 = 0;
              localFriendProfileCardActivity.a.sendMessage((Message)localObject1);
            }
          }
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return;
        localFile = new File((String)localObject1 + ".zip");
        if (localFile.exists()) {
          localFile.delete();
        }
        Object localObject2 = new bhhf("https://imgcache.gtimg.cn/club/mobile/profile/template/android_common_583.zip", localFile);
        ((bhhf)localObject2).f = "profileCardDownload";
        ((bhhf)localObject2).e = "VIP_profilecard";
        j = bhhh.a((bhhf)localObject2, localFriendProfileCardActivity.app);
        if (j == 0)
        {
          i = 1;
          bool2 = bool3;
          if (i == 0) {}
        }
      }
      catch (Throwable localThrowable1)
      {
        FriendProfileCardActivity localFriendProfileCardActivity;
        Object localObject1;
        File localFile;
        int j;
        QLog.e("ProfileTemplateCheckController", 1, "DownloadTemplateRunnable fail.", localThrowable1);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return;
      }
      try
      {
        bgmg.a(localFile.getAbsolutePath(), (String)localObject1 + File.separator, false);
        bghy.a(localFriendProfileCardActivity.app, "common", "583");
        bool2 = bool3;
        if (bghy.a(localFriendProfileCardActivity.app))
        {
          localFile.delete();
          bool2 = true;
        }
      }
      catch (Throwable localThrowable2)
      {
        QLog.e("ProfileTemplateCheckController", 1, "DownloadTemplateRunnable unzip fail.", localThrowable2);
        bool2 = bool3;
        continue;
      }
      boolean bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("ProfileTemplateCheckController", 2, String.format("DownloadTemplateRunnable download template resultCode=%s isExistsTemplateDir=%s", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool2) }));
        bool1 = bool2;
        continue;
        i = 0;
        continue;
        label789:
        i = 0;
        continue;
        label794:
        bool1 = true;
        continue;
        label800:
        bool1 = true;
        continue;
        label806:
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.VasProfileTemplateController.DownloadTemplateRunnable
 * JD-Core Version:    0.7.0.1
 */