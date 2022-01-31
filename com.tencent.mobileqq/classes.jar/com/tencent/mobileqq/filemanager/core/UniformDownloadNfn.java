package com.tencent.mobileqq.filemanager.core;

import adie;
import adif;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloader;
import com.tencent.mobileqq.msf.sdk.QNotificationManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class UniformDownloadNfn
{
  private static UniformDownloadNfn jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadNfn;
  private static QNotificationManager jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager;
  public static String a;
  private long jdField_a_of_type_Long;
  private adif jdField_a_of_type_Adif;
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniformDownloadNfn<FileAssistant>";
  }
  
  private UniformDownloadNfn()
  {
    try
    {
      jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager = new QNotificationManager(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_Adif = new adif(this, BaseApplicationImpl.getContext());
      this.jdField_a_of_type_Long = 123456L;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private int a()
  {
    return (int)(System.currentTimeMillis() & 0xFFFFFFF);
  }
  
  private long a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_Long - 30L;
    }
    if (1 == paramInt) {
      return this.jdField_a_of_type_Long - 20L;
    }
    if (2 == paramInt) {
      return this.jdField_a_of_type_Long - 10L;
    }
    if (3 == paramInt) {
      return this.jdField_a_of_type_Long;
    }
    return System.currentTimeMillis();
  }
  
  public static UniformDownloadNfn a()
  {
    if (jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadNfn == null) {
      jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadNfn = new UniformDownloadNfn();
    }
    return jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadNfn;
  }
  
  private int b()
  {
    return (int)(System.currentTimeMillis() & 0xFFFFFFF);
  }
  
  public int a(UniformDownloader paramUniformDownloader, Bundle paramBundle, long paramLong, int paramInt)
  {
    if (-1 == paramInt)
    {
      paramInt = a();
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + paramLong + "]. attachDownloader.notificationId = " + paramInt);
    }
    while (paramUniformDownloader != null)
    {
      paramUniformDownloader.a(new adie(this, ThreadManager.getSubThreadHandler().getLooper(), paramInt, paramBundle, paramLong), false);
      return paramInt;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + paramLong + "]. attachDownloader.here will using notificationid,maybe is not uinform id");
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + paramLong + "]. attachDownloader.dler = null. notificationId = " + paramInt);
    return paramInt;
  }
  
  public Notification a(Bundle paramBundle)
  {
    Notification localNotification = new Notification();
    if (paramBundle != null)
    {
      Object localObject = paramBundle.getString("_notify_param_ContentTitle");
      localNotification.icon = 2130841696;
      paramBundle = new RemoteViews(BaseApplication.getContext().getPackageName(), 2130970050);
      paramBundle.setImageViewResource(2131365716, 2130841692);
      paramBundle.setTextViewText(2131365718, (CharSequence)localObject);
      paramBundle.setProgressBar(2131365722, 100, 0, false);
      paramBundle.setViewVisibility(2131365720, 8);
      paramBundle.setViewVisibility(2131365721, 8);
      if (this.jdField_a_of_type_Adif.b() != null) {
        paramBundle.setTextColor(2131365718, this.jdField_a_of_type_Adif.b().intValue());
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Adif.a() != null)
        {
          paramBundle.setTextColor(2131365720, this.jdField_a_of_type_Adif.a().intValue());
          paramBundle.setTextColor(2131368847, this.jdField_a_of_type_Adif.a().intValue());
          label154:
          float f1 = this.jdField_a_of_type_Adif.a();
          if (this.jdField_a_of_type_Adif.a() <= 0.0F)
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. initNotification param error. getTextSize failed. set defualt value:14");
            f1 = 14.0F;
          }
          paramBundle.setFloat(2131365720, "setTextSize", f1);
          paramBundle.setFloat(2131368847, "setTextSize", f1);
          float f2 = this.jdField_a_of_type_Adif.b();
          f1 = f2;
          if (f2 <= 0.0F)
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. initNotification param error. getTitleSize failed. set defualt value:16");
            f1 = 16.0F;
          }
          paramBundle.setFloat(2131365718, "setTextSize", f1);
          localObject = BaseApplication.getContext().getApplicationInfo();
          if ((localObject == null) || (((ApplicationInfo)localObject).targetSdkVersion >= 10) || (Build.VERSION.SDK_INT <= 10)) {}
        }
        try
        {
          int i = this.jdField_a_of_type_Adif.b().intValue();
          paramBundle.setInt(2131368845, "setBackgroundColor", (i & 0xFF000000) + (-1 - i));
          localNotification.contentView = paramBundle;
          return localNotification;
          QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. initNotification param error. getTitleColor failed.");
          this.jdField_a_of_type_Adif.a(BaseApplication.getContext(), true);
          if (this.jdField_a_of_type_Adif.b() != null)
          {
            paramBundle.setTextColor(2131365718, this.jdField_a_of_type_Adif.b().intValue());
          }
          else
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. initNotification param error. getTitleColor failed. set defualt value");
            paramBundle.setTextColor(2131365718, -7829368);
            continue;
            QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. initNotification param error. getTextColor failed. ");
            this.jdField_a_of_type_Adif.a(BaseApplication.getContext(), true);
            if (this.jdField_a_of_type_Adif.a() != null)
            {
              paramBundle.setTextColor(2131365720, this.jdField_a_of_type_Adif.a().intValue());
              paramBundle.setTextColor(2131368847, this.jdField_a_of_type_Adif.a().intValue());
              break label154;
            }
            QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. initNotification param error. getTitleColor failed. set defualt value");
            paramBundle.setTextColor(2131365720, -7829368);
            paramBundle.setTextColor(2131368847, -7829368);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. getNfn param error, NF");
    return null;
  }
  
  public void a(int paramInt)
  {
    if (jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager != null) {
      jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.cancel(jdField_a_of_type_JavaLangString, paramInt);
    }
  }
  
  public void a(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null)) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. nfnUPDATE, param error. mId = " + paramInt);
    }
    label273:
    label285:
    label296:
    for (;;)
    {
      return;
      paramNotification.tickerText = (BaseApplication.getContext().getString(2131428277) + " " + paramBundle1.getString("_notify_param_Filename"));
      paramNotification.contentView.setImageViewResource(2131365716, 2130841692);
      int i = paramBundle2.getInt("_START_WAITING_");
      if (1 == i)
      {
        paramNotification.contentView.setTextViewText(2131368847, BaseApplication.getContext().getString(2131428278));
        paramNotification.contentView.setViewVisibility(2131365721, 0);
        paramNotification.contentView.setViewVisibility(2131365720, 8);
        paramNotification.contentView.setProgressBar(2131365722, 100, 0, false);
        paramNotification.flags = 34;
        paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.PAUSE");
        paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
        paramBundle1 = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
        if (1 != i) {
          break label273;
        }
        paramNotification.when = a(2);
        label221:
        if (Build.VERSION.SDK_INT >= 11) {
          break label285;
        }
        paramNotification.contentIntent = paramBundle1;
      }
      for (;;)
      {
        if (jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager == null) {
          break label296;
        }
        try
        {
          jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.notify(jdField_a_of_type_JavaLangString, paramInt, paramNotification);
          return;
        }
        catch (Exception paramNotification)
        {
          paramNotification.printStackTrace();
          return;
        }
        paramNotification.contentView.setTextViewText(2131368847, "0%");
        break;
        paramNotification.when = a(3);
        break label221;
        paramNotification.contentView.setOnClickPendingIntent(2131368845, paramBundle1);
      }
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendPauseNotification param error, NF id:" + paramInt);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendPauseNotification, NF id:" + paramInt);
    Bundle localBundle = new Bundle();
    localBundle.putInt("_FILE_PROGRESS_", paramBundle.getInt("_notify_param_Progress"));
    Notification localNotification = a(paramBundle);
    if (localNotification != null)
    {
      c(paramInt, localNotification, paramBundle, localBundle);
      UniformDownloadMgr.a().c(paramBundle.getString("_notify_param_Url"));
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendPauseNotification failed to getNfn, NF id:" + paramInt);
  }
  
  public void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramBundle1 == null) || (paramBundle2 == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. nfnSUCESS, param error. mId = " + paramInt);
      return;
    }
    if (jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager != null) {
      jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.cancel(jdField_a_of_type_JavaLangString, paramInt);
    }
    Notification localNotification = a(paramBundle1);
    String str1 = paramBundle2.getString("_FILE_PATH_");
    paramBundle2.getLong("_FILE_SIZE_");
    paramInt = paramBundle2.getInt("_NEW_N_ID_");
    String str2 = paramBundle2.getString("_PKG_NAME_");
    localNotification.tickerText = (BaseApplication.getContext().getString(2131428280) + " " + paramBundle1.getString("_notify_param_Filename"));
    Bitmap localBitmap = null;
    paramBundle2 = BaseApplication.getContext().getString(2131428282);
    if (UniformDownloadUtil.a(str1) != null)
    {
      localBitmap = UniformDownloadUtil.a(str1);
      paramBundle2 = BaseApplication.getContext().getString(2131428281);
    }
    if (localBitmap == null)
    {
      int i = FileManagerUtil.b(str1);
      if (i != 0)
      {
        localNotification.contentView.setImageViewResource(2131365716, i);
        label203:
        localNotification.contentView.setImageViewResource(2131365716, 2130841694);
      }
    }
    for (;;)
    {
      localNotification.contentView.setViewVisibility(2131365720, 0);
      localNotification.contentView.setViewVisibility(2131365721, 8);
      localNotification.contentView.setTextViewText(2131365720, paramBundle2);
      localNotification.flags = 16;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.INSTALL");
      paramBundle2.putExtra("_PARAM_FILEPATH", str1);
      paramBundle2.putExtra("_PARAM_DL_SUC_NEW_NID", paramInt);
      if (str2 != null) {
        paramBundle2.putExtra("_PARAM_PKGNAME", str2);
      }
      localNotification.contentIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.BEDEL");
      paramBundle2.putExtra("_PARAM_DL_SUC_NEW_NID", paramInt);
      if (str2 != null) {
        paramBundle2.putExtra("_PARAM_PKGNAME", str2);
      }
      localNotification.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
      localNotification.when = a(0);
      if (jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager == null) {
        break;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. NF_SUC, NF. newNId = " + paramInt + " url:" + paramBundle1.getString("_notify_param_Url"));
      try
      {
        jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.notify(jdField_a_of_type_JavaLangString, paramInt, localNotification);
        return;
      }
      catch (Exception paramBundle1)
      {
        paramBundle1.printStackTrace();
        return;
      }
      localNotification.contentView.setImageViewResource(2131365716, 2130841694);
      break label203;
      localNotification.contentView.setImageViewBitmap(2131365716, localBitmap);
    }
  }
  
  public void b(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null)) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. nfnUPDATE, param error. mId = " + paramInt);
    }
    for (;;)
    {
      return;
      paramNotification.tickerText = null;
      paramNotification.contentView.setImageViewResource(2131365716, 2130841692);
      paramNotification.contentView.setViewVisibility(2131365720, 8);
      paramNotification.contentView.setViewVisibility(2131365721, 0);
      int i = paramBundle2.getInt("_FILE_PROGRESS_");
      paramNotification.contentView.setProgressBar(2131365722, 100, i, false);
      paramNotification.contentView.setTextViewText(2131368847, "" + i + "%");
      paramNotification.flags = 34;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.PAUSE");
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle1 = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
      paramNotification.when = a(3);
      if (Build.VERSION.SDK_INT < 11) {
        paramNotification.contentIntent = paramBundle1;
      }
      while ((jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager != null) && (jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.getNotificationManager() != null))
      {
        try
        {
          jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.getNotificationManager().notify(paramInt, paramNotification);
          return;
        }
        catch (Exception paramNotification)
        {
          paramNotification.printStackTrace();
          return;
        }
        paramNotification.contentView.setOnClickPendingIntent(2131368845, paramBundle1);
      }
    }
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendStartAndWatingNotification param error, NF id:" + paramInt);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendStartAndWatingNotification, NF id:" + paramInt);
    Bundle localBundle = new Bundle();
    localBundle.putInt("_FILE_PROGRESS_", 0);
    localBundle.putInt("_START_WAITING_", 1);
    Notification localNotification = a(paramBundle);
    if (localNotification != null)
    {
      a(paramInt, localNotification, paramBundle, localBundle);
      UniformDownloadMgr.a().a(paramBundle.getString("_notify_param_Url"), paramBundle.getString("_notify_param_Filename"), paramBundle.getLong("_notify_param_Filesize"), paramBundle.getBundle("_notify_param_userdata"), paramInt, true);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendStartAndWatingNotification failed to getNfn, NF id:" + paramInt);
  }
  
  public void c(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. nfnPUASE, param error. mId = " + paramInt);
      return;
    }
    if (jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager != null) {
      jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.cancel(jdField_a_of_type_JavaLangString, paramInt);
    }
    paramNotification.tickerText = null;
    int i = paramBundle2.getInt("_FILE_PROGRESS_");
    paramNotification.contentView.setImageViewResource(2131365716, 2130841695);
    paramNotification.contentView.setViewVisibility(2131365720, 0);
    paramNotification.contentView.setViewVisibility(2131365721, 8);
    paramNotification.contentView.setTextViewText(2131365720, BaseApplication.getContext().getString(2131428279));
    paramNotification.contentView.setProgressBar(2131365722, 100, i, false);
    paramNotification.contentView.setTextViewText(2131368847, "" + i + "%");
    paramNotification.flags = 16;
    paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.DO_DOWNLOAD");
    paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
    paramBundle2 = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
    paramNotification.when = a(1);
    if (Build.VERSION.SDK_INT < 11) {
      paramNotification.contentIntent = paramBundle2;
    }
    for (;;)
    {
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.BEDEL");
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramNotification.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
      if (jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager == null) {
        break;
      }
      try
      {
        jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.notify(jdField_a_of_type_JavaLangString, paramInt, paramNotification);
        return;
      }
      catch (Exception paramNotification)
      {
        paramNotification.printStackTrace();
        return;
      }
      paramNotification.contentView.setOnClickPendingIntent(2131368845, paramBundle2);
    }
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendCancelNotification, NF id:" + paramInt);
    a(paramInt);
    if (paramBundle != null) {
      UniformDownloadMgr.a().c(paramBundle.getString("_notify_param_Url"));
    }
  }
  
  public void d(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. nfnFAILED, param error. mId = " + paramInt);
      return;
    }
    if (jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager != null) {
      jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.cancel(jdField_a_of_type_JavaLangString, paramInt);
    }
    paramNotification.contentView.setViewVisibility(2131365721, 8);
    int i = paramBundle2.getInt("_FILE_ERR_CODE_");
    if (2 == i)
    {
      paramNotification.tickerText = BaseApplication.getContext().getString(2131428283);
      paramNotification.contentView.setTextViewText(2131365720, BaseApplication.getContext().getString(2131428283));
      label115:
      paramNotification.contentView.setImageViewResource(2131365716, 2130841693);
      paramNotification.contentView.setViewVisibility(2131365720, 0);
      paramNotification.contentView.setTextViewText(2131368847, " ");
      paramNotification.flags = 16;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.TRY_DOWNLOAD");
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle2 = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
      paramNotification.when = a(1);
      if (Build.VERSION.SDK_INT >= 11) {
        break label360;
      }
      paramNotification.contentIntent = paramBundle2;
    }
    for (;;)
    {
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.BEDEL");
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramNotification.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
      if (jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager == null) {
        break;
      }
      try
      {
        jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.notify(jdField_a_of_type_JavaLangString, paramInt, paramNotification);
        return;
      }
      catch (Exception paramNotification)
      {
        paramNotification.printStackTrace();
        return;
      }
      paramNotification.tickerText = (BaseApplication.getContext().getString(2131428284) + " " + paramBundle1.getString("_notify_param_Filename"));
      paramNotification.contentView.setTextViewText(2131365720, UniformDownloader.a(i) + "，点击重试");
      break label115;
      label360:
      paramNotification.contentView.setOnClickPendingIntent(2131368845, paramBundle2);
    }
  }
  
  public void e(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null)) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. nfnRESUME, param error. mId = " + paramInt);
    }
    for (;;)
    {
      return;
      if (jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager != null) {
        jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.cancel(jdField_a_of_type_JavaLangString, paramInt);
      }
      paramNotification.tickerText = null;
      paramNotification.contentView.setImageViewResource(2131365716, 2130841692);
      paramNotification.contentView.setViewVisibility(2131365720, 8);
      paramNotification.contentView.setViewVisibility(2131365721, 0);
      int i = paramBundle2.getInt("_FILE_PROGRESS_");
      paramNotification.contentView.setProgressBar(2131365722, 100, i, false);
      paramNotification.contentView.setTextViewText(2131368847, BaseApplication.getContext().getString(2131428278));
      paramNotification.flags = 34;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.PAUSE");
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle1 = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
      paramNotification.when = a(2);
      if (Build.VERSION.SDK_INT < 11) {
        paramNotification.contentIntent = paramBundle1;
      }
      while (jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager != null)
      {
        try
        {
          jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.notify(jdField_a_of_type_JavaLangString, paramInt, paramNotification);
          return;
        }
        catch (Exception paramNotification)
        {
          paramNotification.printStackTrace();
          return;
        }
        paramNotification.contentView.setOnClickPendingIntent(2131368845, paramBundle1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadNfn
 * JD-Core Version:    0.7.0.1
 */