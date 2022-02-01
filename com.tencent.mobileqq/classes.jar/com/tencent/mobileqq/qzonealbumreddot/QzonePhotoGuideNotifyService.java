package com.tencent.mobileqq.qzonealbumreddot;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QzonePhotoGuideNotifyService
{
  protected QQAppInterface a;
  protected QzoneAlbumRedTouchManager b;
  protected Handler c;
  Runnable d = new QzonePhotoGuideNotifyService.1(this);
  private BroadcastReceiver e = new QzonePhotoGuideNotifyService.2(this);
  
  public QzonePhotoGuideNotifyService(QQAppInterface paramQQAppInterface, QzoneAlbumRedTouchManager paramQzoneAlbumRedTouchManager)
  {
    this.a = paramQQAppInterface;
    this.b = paramQzoneAlbumRedTouchManager;
    if (paramQQAppInterface != null) {
      try
      {
        paramQzoneAlbumRedTouchManager = new IntentFilter("com.qzonex.localalbum.new_photo_notification_feedback_action");
        paramQQAppInterface.getApp().registerReceiver(this.e, paramQzoneAlbumRedTouchManager);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQzoneAlbumRedTouchManager = new StringBuilder();
        paramQzoneAlbumRedTouchManager.append("registerreceiver fail:");
        paramQzoneAlbumRedTouchManager.append(paramQQAppInterface);
        QLog.e("QzonePhotoGuideNotifyServlet", 1, paramQzoneAlbumRedTouchManager.toString());
      }
    }
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    int i;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo("com.qzone", 128);
      if ((paramContext != null) && (paramContext.metaData != null)) {
        i = paramContext.metaData.getInt("com.qzone.versioncode");
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      i = 0;
    }
    return i >= paramInt;
  }
  
  public void a()
  {
    try
    {
      Intent localIntent = new Intent("com.qzonex.localalbum.new_photo_notification_action");
      localIntent.setComponent(new ComponentName("com.qzone", "com.qzonex.proxy.localalbum.business.NewPhotoNotificationService"));
      this.a.getApp().startService(localIntent);
      if (QLog.isColorLevel()) {
        QLog.i("QzonePhotoGuideNotifyServlet", 2, "calling qzone");
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startService fail:");
      localStringBuilder.append(localException);
      QLog.e("QzonePhotoGuideNotifyServlet", 1, localStringBuilder.toString());
    }
    this.c = new Handler(ThreadManager.getSubThreadLooper());
    this.c.postDelayed(this.d, 10000L);
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null) {
      try
      {
        localQQAppInterface.getApp().unregisterReceiver(this.e);
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopService fail:");
        localStringBuilder.append(localException);
        QLog.e("QzonePhotoGuideNotifyServlet", 1, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzonealbumreddot.QzonePhotoGuideNotifyService
 * JD-Core Version:    0.7.0.1
 */