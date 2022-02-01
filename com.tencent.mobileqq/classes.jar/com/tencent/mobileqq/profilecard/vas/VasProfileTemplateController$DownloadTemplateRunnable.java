package com.tencent.mobileqq.profilecard.vas;

import android.os.Message;
import azri;
import bhaa;
import bhyo;
import bhyq;
import bkys;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
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
  private WeakReference<azri> b;
  
  VasProfileTemplateController$DownloadTemplateRunnable(FriendProfileCardActivity paramFriendProfileCardActivity, azri paramazri, AtomicBoolean paramAtomicBoolean, String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFriendProfileCardActivity);
    this.b = new WeakReference(paramazri);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = paramAtomicBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private boolean a(FriendProfileCardActivity paramFriendProfileCardActivity, boolean paramBoolean)
  {
    boolean bool1 = paramBoolean;
    String str;
    if (!paramBoolean)
    {
      str = bhaa.a(paramFriendProfileCardActivity.app, -1L);
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
    Object localObject = new bhyo("https://imgcache.gtimg.cn/club/mobile/profile/template/android_common_583.zip", localFile);
    ((bhyo)localObject).f = "profileCardDownload";
    ((bhyo)localObject).e = "VIP_profilecard";
    int j = bhyq.a((bhyo)localObject, paramFriendProfileCardActivity.app);
    if (j == 0) {}
    boolean bool2;
    for (int i = 1;; i = 0)
    {
      bool2 = paramBoolean;
      if (i != 0) {}
      try
      {
        FileUtils.uncompressZip(localFile.getAbsolutePath(), str + File.separator, false);
        bhaa.a(paramFriendProfileCardActivity.app, "common", "583");
        bool2 = paramBoolean;
        if (bhaa.a(paramFriendProfileCardActivity.app))
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
        if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.b != null))
        {
          FriendProfileCardActivity localFriendProfileCardActivity = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          Object localObject = (azri)this.b.get();
          if ((localFriendProfileCardActivity != null) && (localObject != null))
          {
            long l = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d("ProfileTemplateCheckController", 2, "DownloadTemplateRunnable start");
            }
            boolean bool3 = bhaa.a(localFriendProfileCardActivity.app);
            if ((this.jdField_a_of_type_Long != 160L) && (this.jdField_a_of_type_Long != 1600L)) {
              break label468;
            }
            bool1 = bhaa.a(localFriendProfileCardActivity.app.getApplication(), this.jdField_a_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.d("ProfileTemplateCheckController", 2, String.format("DownloadTemplateRunnable start isExistsTemplateDir=%s isExistBgResource=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
            }
            boolean bool2 = bool1;
            if (!bool1)
            {
              localObject = new File(bhaa.a(localFriendProfileCardActivity.app.getApplication(), this.jdField_a_of_type_JavaLangString));
              localObject = new bhyo(this.jdField_a_of_type_JavaLangString, (File)localObject);
              ((bhyo)localObject).f = "profileCardDownload";
              ((bhyo)localObject).e = "VIP_profilecard";
              i = bhyq.a((bhyo)localObject, localFriendProfileCardActivity.app);
              if ((i != 0) || (!bhaa.a(localFriendProfileCardActivity.app.getApplication(), this.jdField_a_of_type_JavaLangString))) {
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
            bool1 = a(localFriendProfileCardActivity, bool3);
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
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
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
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.VasProfileTemplateController.DownloadTemplateRunnable
 * JD-Core Version:    0.7.0.1
 */