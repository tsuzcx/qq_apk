package com.tencent.mobileqq.uniformdownload.core;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.commonsdk.util.notification.SdkInfoUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.uniformdownload.data.DownloadingRbResmeInfoMgr;
import com.tencent.mobileqq.uniformdownload.downloader.UniformDownloader;
import com.tencent.mobileqq.uniformdownload.util.UDConstants;
import com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class UniformDownloadNfn
{
  public static String a = "UniformDownloadNfn";
  private static UniformDownloadNfn d;
  private static QQNotificationManager e;
  protected HandlerThread b = null;
  protected Handler c = null;
  private UniformDownloadNfn.NotificationStyle f = null;
  private long g;
  private int h = 278;
  
  private UniformDownloadNfn()
  {
    try
    {
      e = QQNotificationManager.getInstance();
      this.f = new UniformDownloadNfn.NotificationStyle(this, BaseApplication.getContext());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.g = 123456L;
  }
  
  public static UniformDownloadNfn a()
  {
    if (d == null) {
      d = new UniformDownloadNfn();
    }
    return d;
  }
  
  private int b()
  {
    try
    {
      int i = this.h;
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("genNID : notificationId[");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      QLog.e(str, 1, localStringBuilder.toString());
      this.h += 1;
      if (this.h > 377)
      {
        this.h = 278;
        QLog.e(a, 1, "genNID : notificationId is reach to the max Id.");
      }
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private long b(int paramInt)
  {
    long l1;
    long l2;
    if (paramInt == 0)
    {
      l1 = this.g;
      l2 = 30L;
    }
    for (;;)
    {
      return l1 - l2;
      if (1 == paramInt)
      {
        l1 = this.g;
        l2 = 20L;
      }
      else
      {
        if (2 != paramInt) {
          break;
        }
        l1 = this.g;
        l2 = 10L;
      }
    }
    if (3 == paramInt) {
      return this.g;
    }
    return System.currentTimeMillis();
  }
  
  private void b(Bundle paramBundle)
  {
    if (paramBundle.getInt("_download_qqbrowser_business_", -1) == 1) {
      ReportController.b(null, "dc00898", "", "", "0X800ADF0", "0X800ADF0", 0, 0, "", "", "", "");
    }
  }
  
  private int c()
  {
    return (int)(System.currentTimeMillis() & 0xFFFFFFF);
  }
  
  public int a(UniformDownloader paramUniformDownloader, Bundle paramBundle, long paramLong, int paramInt)
  {
    String str;
    StringBuilder localStringBuilder;
    if (-1 == paramInt)
    {
      paramInt = b();
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]. attachDownloader.notificationId = ");
      localStringBuilder.append(paramInt);
      QLog.i(str, 1, localStringBuilder.toString());
    }
    else
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]. attachDownloader.here will using notificationid,maybe is not uinform id");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (paramUniformDownloader != null)
    {
      paramUniformDownloader.a(new UniformDownloadNfn.DownloaderNfnHandler(this, ThreadManager.getSubThreadHandler().getLooper(), paramInt, paramBundle, paramLong), false);
      return paramInt;
    }
    paramUniformDownloader = a;
    paramBundle = new StringBuilder();
    paramBundle.append("[UniformDL][");
    paramBundle.append(paramLong);
    paramBundle.append("]. attachDownloader.dler = null. notificationId = ");
    paramBundle.append(paramInt);
    QLog.e(paramUniformDownloader, 1, paramBundle.toString());
    return paramInt;
  }
  
  public Notification a(Bundle paramBundle)
  {
    Object localObject1 = new NotificationCompat.Builder(BaseApplication.getContext());
    if ((SdkInfoUtil.isOreo()) && (SdkInfoUtil.isTargetSDKOreo())) {
      ((NotificationCompat.Builder)localObject1).setChannelId("CHANNEL_ID_OTHER");
    }
    localObject1 = ((NotificationCompat.Builder)localObject1).build();
    if (paramBundle != null)
    {
      Object localObject2 = paramBundle.getString("_notify_param_ContentTitle");
      ((Notification)localObject1).icon = 2130848709;
      paramBundle = new RemoteViews(BaseApplication.getContext().getPackageName(), 2131628223);
      paramBundle.setImageViewResource(2131439448, 2130848708);
      paramBundle.setTextViewText(2131439460, (CharSequence)localObject2);
      paramBundle.setProgressBar(2131439440, 100, 0, false);
      paramBundle.setViewVisibility(2131439447, 8);
      paramBundle.setViewVisibility(2131439441, 8);
      paramBundle.setTextColor(2131439460, -7829368);
      paramBundle.setTextColor(2131439447, -7829368);
      paramBundle.setTextColor(2131439442, -7829368);
      float f1 = this.f.a();
      if (this.f.a() <= 0.0F)
      {
        QLog.w(a, 1, "[UniformDL]. initNotification param error. getTextSize failed. set defualt value:14");
        f1 = 14.0F;
      }
      paramBundle.setFloat(2131439447, "setTextSize", f1);
      paramBundle.setFloat(2131439442, "setTextSize", f1);
      float f2 = this.f.c();
      f1 = f2;
      if (f2 <= 0.0F)
      {
        QLog.w(a, 1, "[UniformDL]. initNotification param error. getTitleSize failed. set defualt value:16");
        f1 = 16.0F;
      }
      paramBundle.setFloat(2131439460, "setTextSize", f1);
      localObject2 = BaseApplication.getContext().getApplicationInfo();
      if ((localObject2 != null) && (((ApplicationInfo)localObject2).targetSdkVersion < 10) && (Build.VERSION.SDK_INT > 10)) {
        try
        {
          int i = this.f.b().intValue();
          paramBundle.setInt(2131439449, "setBackgroundColor", -1 - i + (i & 0xFF000000));
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      ((Notification)localObject1).contentView = paramBundle;
      return localObject1;
    }
    QLog.e(a, 1, "[UniformDL]. getNfn param error, NF");
    return null;
  }
  
  protected void a(int paramInt)
  {
    QQNotificationManager localQQNotificationManager = e;
    if (localQQNotificationManager != null) {
      localQQNotificationManager.cancel(a, paramInt);
    }
  }
  
  protected void a(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification != null) && (paramBundle1 != null) && (paramBundle2 != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(BaseApplication.getContext().getString(2131913975));
      localStringBuilder.append(" ");
      localStringBuilder.append(paramBundle1.getString("_notify_param_Filename"));
      paramNotification.tickerText = localStringBuilder.toString();
      paramNotification.contentView.setImageViewResource(2131439448, 2130848708);
      int i = paramBundle2.getInt("_START_WAITING_");
      if (1 == i) {
        paramNotification.contentView.setTextViewText(2131439442, BaseApplication.getContext().getString(2131913977));
      } else {
        paramNotification.contentView.setTextViewText(2131439442, "0%");
      }
      paramNotification.contentView.setViewVisibility(2131439441, 0);
      paramNotification.contentView.setViewVisibility(2131439447, 8);
      paramNotification.contentView.setProgressBar(2131439440, 100, 0, false);
      paramNotification.flags = 34;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.PAUSE");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle2.putExtra("param_notifyid", paramInt);
      paramBundle1 = PendingIntent.getBroadcast(BaseApplication.getContext(), c(), paramBundle2, 134217728);
      if (1 == i) {
        paramNotification.when = b(2);
      } else {
        paramNotification.when = b(3);
      }
      if (Build.VERSION.SDK_INT < 11) {
        paramNotification.contentIntent = paramBundle1;
      } else {
        paramNotification.contentView.setOnClickPendingIntent(2131439449, paramBundle1);
      }
      paramBundle1 = e;
      if (paramBundle1 != null) {
        try
        {
          paramBundle1.notify(a, paramInt, paramNotification);
          return;
        }
        catch (Exception paramNotification)
        {
          paramNotification.printStackTrace();
        }
      }
      return;
    }
    paramNotification = a;
    paramBundle1 = new StringBuilder();
    paramBundle1.append("[UniformDL]. nfnUPDATE, param error. mId = ");
    paramBundle1.append(paramInt);
    QLog.e(paramNotification, 1, paramBundle1.toString());
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      paramBundle = a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[UniformDL]. sendPauseNotification param error, NF id:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.e(paramBundle, 1, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[UniformDL]. sendPauseNotification, NF id:");
    ((StringBuilder)localObject2).append(paramInt);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("_FILE_PROGRESS_", paramBundle.getInt("_notify_param_Progress"));
    localObject2 = a(paramBundle);
    if (localObject2 != null)
    {
      c(paramInt, (Notification)localObject2, paramBundle, (Bundle)localObject1);
      UniformDownloadMgr.a().d().a(paramBundle.getString("_notify_param_Url"));
      return;
    }
    paramBundle = a;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[UniformDL]. sendPauseNotification failed to getNfn, NF id:");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.e(paramBundle, 1, ((StringBuilder)localObject1).toString());
  }
  
  protected void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramBundle1 != null) && (paramBundle2 != null))
    {
      Object localObject = e;
      if (localObject != null) {
        ((QQNotificationManager)localObject).cancel(a, paramInt);
      }
      Notification localNotification = a(paramBundle1);
      String str2 = paramBundle2.getString("_FILE_PATH_");
      paramBundle2.getLong("_FILE_SIZE_");
      int i = paramBundle2.getInt("_NEW_N_ID_");
      String str3 = paramBundle2.getString("_PKG_NAME_");
      paramBundle2 = new StringBuilder();
      paramBundle2.append(BaseApplication.getContext().getString(2131913969));
      paramBundle2.append(" ");
      paramBundle2.append(paramBundle1.getString("_notify_param_Filename"));
      localNotification.tickerText = paramBundle2.toString();
      localObject = paramBundle1.getBundle("_notify_param_userdata");
      paramBundle2 = "";
      if (localObject != null) {
        paramBundle2 = ((Bundle)localObject).getString("big_brother_source_key", "");
      }
      localObject = null;
      String str1 = BaseApplication.getContext().getString(2131913971);
      if (UniformDownloadUtil.c(str2) != null)
      {
        localObject = UniformDownloadUtil.a(str2);
        str1 = BaseApplication.getContext().getString(2131913970);
      }
      if (localObject == null)
      {
        int j = QQFileManagerUtil.q(str2);
        if (j != 0) {
          localNotification.contentView.setImageViewResource(2131439448, j);
        } else {
          localNotification.contentView.setImageViewResource(2131439448, 2130848707);
        }
        localNotification.contentView.setImageViewResource(2131439448, 2130848707);
      }
      else
      {
        localNotification.contentView.setImageViewBitmap(2131439448, (Bitmap)localObject);
      }
      localNotification.contentView.setViewVisibility(2131439447, 0);
      localNotification.contentView.setViewVisibility(2131439441, 8);
      localNotification.contentView.setTextViewText(2131439447, str1);
      localNotification.flags = 16;
      localObject = new Intent("com.tencent.mobileqq.UniformDownloadNfn.INSTALL");
      ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
      ((Intent)localObject).putExtra("_PARAM_FILEPATH", str2);
      ((Intent)localObject).putExtra("_PARAM_DL_SUC_NEW_NID", i);
      ((Intent)localObject).putExtra("param_notifyid", paramInt);
      if (!TextUtils.isEmpty(paramBundle2)) {
        ((Intent)localObject).putExtra("big_brother_source_key", paramBundle2);
      }
      if (str3 != null) {
        ((Intent)localObject).putExtra("_PARAM_PKGNAME", str3);
      }
      localNotification.contentIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), c(), (Intent)localObject, 134217728);
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.BEDEL");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_DL_SUC_NEW_NID", i);
      if (str3 != null) {
        paramBundle2.putExtra("_PARAM_PKGNAME", str3);
      }
      localNotification.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), c(), paramBundle2, 134217728);
      localNotification.when = b(0);
      if (e != null)
      {
        paramBundle2 = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[UniformDL]. NF_SUC, NF. newNId = ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" url:");
        ((StringBuilder)localObject).append(paramBundle1.getString("_notify_param_Url"));
        QLog.i(paramBundle2, 1, ((StringBuilder)localObject).toString());
        try
        {
          e.notify(a, i, localNotification);
          return;
        }
        catch (Exception paramBundle1)
        {
          paramBundle1.printStackTrace();
        }
      }
      return;
    }
    paramBundle1 = a;
    paramBundle2 = new StringBuilder();
    paramBundle2.append("[UniformDL]. nfnSUCESS, param error. mId = ");
    paramBundle2.append(paramInt);
    QLog.e(paramBundle1, 1, paramBundle2.toString());
  }
  
  protected void b(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification != null) && (paramBundle1 != null) && (paramBundle2 != null))
    {
      paramNotification.tickerText = null;
      paramNotification.contentView.setImageViewResource(2131439448, 2130848708);
      paramNotification.contentView.setViewVisibility(2131439447, 8);
      paramNotification.contentView.setViewVisibility(2131439441, 0);
      int i = paramBundle2.getInt("_FILE_PROGRESS_");
      paramNotification.contentView.setProgressBar(2131439440, 100, i, false);
      paramBundle2 = paramNotification.contentView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      localStringBuilder.append("%");
      paramBundle2.setTextViewText(2131439442, localStringBuilder.toString());
      paramNotification.flags = 34;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.PAUSE");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle2.putExtra("param_notifyid", paramInt);
      paramBundle1 = PendingIntent.getBroadcast(BaseApplication.getContext(), c(), paramBundle2, 134217728);
      paramNotification.when = b(3);
      if (Build.VERSION.SDK_INT < 11) {
        paramNotification.contentIntent = paramBundle1;
      } else {
        paramNotification.contentView.setOnClickPendingIntent(2131439449, paramBundle1);
      }
      paramBundle1 = e;
      if (paramBundle1 != null) {
        try
        {
          paramBundle1.notify(a, paramInt, paramNotification);
          return;
        }
        catch (Exception paramNotification)
        {
          paramNotification.printStackTrace();
        }
      }
      return;
    }
    paramNotification = a;
    paramBundle1 = new StringBuilder();
    paramBundle1.append("[UniformDL]. nfnUPDATE, param error. mId = ");
    paramBundle1.append(paramInt);
    QLog.e(paramNotification, 1, paramBundle1.toString());
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      paramBundle = a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[UniformDL]. sendStartAndWatingNotification param error, NF id:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.e(paramBundle, 1, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[UniformDL]. sendStartAndWatingNotification, NF id:");
    ((StringBuilder)localObject2).append(paramInt);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("_FILE_PROGRESS_", 0);
    ((Bundle)localObject1).putInt("_START_WAITING_", 1);
    localObject2 = a(paramBundle);
    if (localObject2 != null)
    {
      a(paramInt, (Notification)localObject2, paramBundle, (Bundle)localObject1);
      UniformDownloadMgr.a().d().a(paramBundle.getString("_notify_param_Url"), paramBundle.getString("_notify_param_Filename"), paramBundle.getString("_notify_param_ContentTitle", ""), paramBundle.getLong("_notify_param_Filesize"), paramBundle.getBundle("_notify_param_userdata"), paramInt, true);
      return;
    }
    paramBundle = a;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[UniformDL]. sendStartAndWatingNotification failed to getNfn, NF id:");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.e(paramBundle, 1, ((StringBuilder)localObject1).toString());
  }
  
  protected void c(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification != null) && (paramBundle1 != null) && (paramBundle2 != null))
    {
      Object localObject = e;
      if (localObject != null) {
        ((QQNotificationManager)localObject).cancel(a, paramInt);
      }
      paramNotification.tickerText = null;
      int i = paramBundle2.getInt("_FILE_PROGRESS_");
      paramNotification.contentView.setImageViewResource(2131439448, 2130848710);
      paramNotification.contentView.setViewVisibility(2131439447, 0);
      paramNotification.contentView.setViewVisibility(2131439441, 8);
      paramNotification.contentView.setTextViewText(2131439447, BaseApplication.getContext().getString(2131913974));
      paramNotification.contentView.setProgressBar(2131439440, 100, i, false);
      paramBundle2 = paramNotification.contentView;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("%");
      paramBundle2.setTextViewText(2131439442, ((StringBuilder)localObject).toString());
      paramNotification.flags = 16;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.DO_DOWNLOAD");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle2.putExtra("param_notifyid", paramInt);
      paramBundle2 = PendingIntent.getBroadcast(BaseApplication.getContext(), c(), paramBundle2, 134217728);
      paramNotification.when = b(1);
      if (Build.VERSION.SDK_INT < 11) {
        paramNotification.contentIntent = paramBundle2;
      } else {
        paramNotification.contentView.setOnClickPendingIntent(2131439449, paramBundle2);
      }
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.BEDEL");
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramNotification.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), c(), paramBundle2, 134217728);
      paramBundle1 = e;
      if (paramBundle1 != null) {
        try
        {
          paramBundle1.notify(a, paramInt, paramNotification);
          return;
        }
        catch (Exception paramNotification)
        {
          paramNotification.printStackTrace();
        }
      }
      return;
    }
    paramNotification = a;
    paramBundle1 = new StringBuilder();
    paramBundle1.append("[UniformDL]. nfnPUASE, param error. mId = ");
    paramBundle1.append(paramInt);
    QLog.e(paramNotification, 1, paramBundle1.toString());
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL]. sendCancelNotification, NF id:");
    localStringBuilder.append(paramInt);
    QLog.i(str, 1, localStringBuilder.toString());
    a(paramInt);
    if (paramBundle != null) {
      UniformDownloadMgr.a().d().a(paramBundle.getString("_notify_param_Url"));
    }
  }
  
  protected void d(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification != null) && (paramBundle1 != null) && (paramBundle2 != null))
    {
      Object localObject = e;
      if (localObject != null) {
        ((QQNotificationManager)localObject).cancel(a, paramInt);
      }
      paramNotification.contentView.setViewVisibility(2131439441, 8);
      int i = paramBundle2.getInt("_FILE_ERR_CODE_");
      if (5 == i)
      {
        paramNotification.tickerText = BaseApplication.getContext().getString(2131913973);
        paramNotification.contentView.setTextViewText(2131439447, BaseApplication.getContext().getString(2131913973));
      }
      else
      {
        paramBundle2 = new StringBuilder();
        paramBundle2.append(BaseApplication.getContext().getString(2131913972));
        paramBundle2.append(" ");
        paramBundle2.append(paramBundle1.getString("_notify_param_Filename"));
        paramNotification.tickerText = paramBundle2.toString();
        paramBundle2 = paramNotification.contentView;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(UDConstants.a(i));
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131913976));
        paramBundle2.setTextViewText(2131439447, ((StringBuilder)localObject).toString());
      }
      paramNotification.contentView.setImageViewResource(2131439448, 2130848706);
      paramNotification.contentView.setViewVisibility(2131439447, 0);
      paramNotification.contentView.setTextViewText(2131439442, " ");
      paramNotification.flags = 16;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.TRY_DOWNLOAD");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle2.putExtra("param_notifyid", paramInt);
      paramBundle2 = PendingIntent.getBroadcast(BaseApplication.getContext(), c(), paramBundle2, 134217728);
      paramNotification.when = b(1);
      if (Build.VERSION.SDK_INT < 11) {
        paramNotification.contentIntent = paramBundle2;
      } else {
        paramNotification.contentView.setOnClickPendingIntent(2131439449, paramBundle2);
      }
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.BEDEL");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramNotification.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), c(), paramBundle2, 134217728);
      paramBundle1 = e;
      if (paramBundle1 != null) {
        try
        {
          paramBundle1.notify(a, paramInt, paramNotification);
          return;
        }
        catch (Exception paramNotification)
        {
          paramNotification.printStackTrace();
        }
      }
      return;
    }
    paramNotification = a;
    paramBundle1 = new StringBuilder();
    paramBundle1.append("[UniformDL]. nfnFAILED, param error. mId = ");
    paramBundle1.append(paramInt);
    QLog.e(paramNotification, 1, paramBundle1.toString());
  }
  
  protected void e(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification != null) && (paramBundle1 != null) && (paramBundle2 != null))
    {
      QQNotificationManager localQQNotificationManager = e;
      if (localQQNotificationManager != null) {
        localQQNotificationManager.cancel(a, paramInt);
      }
      paramNotification.tickerText = null;
      paramNotification.contentView.setImageViewResource(2131439448, 2130848708);
      paramNotification.contentView.setViewVisibility(2131439447, 8);
      paramNotification.contentView.setViewVisibility(2131439441, 0);
      int i = paramBundle2.getInt("_FILE_PROGRESS_");
      paramNotification.contentView.setProgressBar(2131439440, 100, i, false);
      paramNotification.contentView.setTextViewText(2131439442, BaseApplication.getContext().getString(2131913977));
      paramNotification.flags = 34;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.PAUSE");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle2.putExtra("param_notifyid", paramInt);
      paramBundle1 = PendingIntent.getBroadcast(BaseApplication.getContext(), c(), paramBundle2, 134217728);
      paramNotification.when = b(2);
      if (Build.VERSION.SDK_INT < 11) {
        paramNotification.contentIntent = paramBundle1;
      } else {
        paramNotification.contentView.setOnClickPendingIntent(2131439449, paramBundle1);
      }
      paramBundle1 = e;
      if (paramBundle1 != null) {
        try
        {
          paramBundle1.notify(a, paramInt, paramNotification);
          return;
        }
        catch (Exception paramNotification)
        {
          paramNotification.printStackTrace();
        }
      }
      return;
    }
    paramNotification = a;
    paramBundle1 = new StringBuilder();
    paramBundle1.append("[UniformDL]. nfnRESUME, param error. mId = ");
    paramBundle1.append(paramInt);
    QLog.e(paramNotification, 1, paramBundle1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadNfn
 * JD-Core Version:    0.7.0.1
 */