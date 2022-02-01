package com.tencent.open.downloadnew.common;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.ImageUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.StringAddition;
import com.tencent.open.business.base.AppUtil;
import com.tencent.util.BadgeUtils;
import java.util.concurrent.ConcurrentHashMap;

public class AppNotificationManager
{
  protected static AppNotificationManager a;
  protected QQNotificationManager a;
  protected AppNotificationManager.NotificationStyleDiscover a;
  protected final ConcurrentHashMap<String, AppNotificationManager.NoticeIdentity> a;
  
  static
  {
    jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager = null;
  }
  
  protected AppNotificationManager()
  {
    this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
  }
  
  private int a(String paramString)
  {
    LogUtility.b("AppNotificationManager", ">genNextNotificationId key:" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return 378;
    }
    int i = Math.abs(paramString.hashCode()) % 99;
    LogUtility.b("AppNotificationManager", ">genNextNotificationId mod:" + i);
    i += 378;
    LogUtility.b("AppNotificationManager", ">genNextNotificationId id:" + i);
    return i;
  }
  
  public static AppNotificationManager a()
  {
    if (jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager == null) {
      jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager = new AppNotificationManager();
    }
    return jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager;
  }
  
  public int a(String paramString1, int paramInt, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      LogUtility.e("AppNotificationManager", ">getNotificationId param error, return invalid id.");
      return -1;
    }
    LogUtility.b("AppNotificationManager", ">getNotificationId " + paramString1 + ", " + paramString2);
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = paramString2;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      paramString1 = new AppNotificationManager.NoticeIdentity(this);
      paramString1.jdField_a_of_type_JavaLangString = str;
      paramString1.jdField_a_of_type_Int = a(str);
      paramString1.jdField_b_of_type_Int = paramInt;
      paramString1.jdField_b_of_type_JavaLangString = paramString2;
      paramString1.jdField_a_of_type_Long = (System.currentTimeMillis() + paramString1.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
    }
    return ((AppNotificationManager.NoticeIdentity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).jdField_a_of_type_Int;
  }
  
  public long a(String paramString1, int paramInt, String paramString2)
  {
    LogUtility.b("AppNotificationManager", ">getNotificationWhen " + paramString1 + ", " + paramString2);
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      AppNotificationManager.NoticeIdentity localNoticeIdentity = new AppNotificationManager.NoticeIdentity(this);
      localNoticeIdentity.jdField_a_of_type_JavaLangString = paramString1;
      localNoticeIdentity.jdField_a_of_type_Int = a(paramString1);
      localNoticeIdentity.jdField_b_of_type_Int = paramInt;
      localNoticeIdentity.jdField_b_of_type_JavaLangString = paramString2;
      localNoticeIdentity.jdField_a_of_type_Long = (System.currentTimeMillis() + localNoticeIdentity.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localNoticeIdentity);
    }
    return ((AppNotificationManager.NoticeIdentity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1)).jdField_a_of_type_Long;
  }
  
  public Notification a(NoticeParam paramNoticeParam)
  {
    if ((CommonDataAdapter.a().a() == null) || (paramNoticeParam == null))
    {
      LogUtility.e("AppNotificationManager", "getNotification context == null");
      return null;
    }
    Notification localNotification = new Notification();
    localNotification.tickerText = paramNoticeParam.jdField_b_of_type_JavaLangString;
    localNotification.when = paramNoticeParam.jdField_a_of_type_Long;
    RemoteViews localRemoteViews = new RemoteViews(CommonDataAdapter.a().a().getPackageName(), 2131559772);
    Object localObject = IntentFactory.a(1, paramNoticeParam);
    a(localRemoteViews);
    localRemoteViews.setInt(2131372418, "setBackgroundColor", -1);
    localRemoteViews.setInt(2131372420, "setTextColor", -16777216);
    localRemoteViews.setInt(2131372414, "setTextColor", -12303292);
    localRemoteViews.setInt(2131372408, "setTextColor", -12303292);
    localRemoteViews.setTextViewText(2131372420, StringAddition.a(paramNoticeParam.jdField_b_of_type_JavaLangString, 18, true, true));
    if (paramNoticeParam.jdField_b_of_type_Int == 1)
    {
      localNotification.icon = 2130844530;
      localRemoteViews.setImageViewResource(2131372409, 2130844526);
      localRemoteViews.setViewVisibility(2131372408, 8);
      localRemoteViews.setViewVisibility(2131372403, 0);
      if (Build.VERSION.SDK_INT > 10) {
        localRemoteViews.setOnClickPendingIntent(2131372418, (PendingIntent)localObject);
      }
    }
    for (;;)
    {
      localNotification.contentView = localRemoteViews;
      QQNotificationManager.addChannelIfNeed(localNotification, "CHANNEL_ID_HIDE_BADGE");
      return localNotification;
      localNotification.contentIntent = ((PendingIntent)localObject);
      continue;
      if ((paramNoticeParam.jdField_b_of_type_Int == 0) || (paramNoticeParam.jdField_b_of_type_Int == 2) || (paramNoticeParam.jdField_b_of_type_Int == 3))
      {
        localNotification.icon = 2130844530;
        if (paramNoticeParam.jdField_b_of_type_Int == 0)
        {
          localRemoteViews.setTextViewText(2131372408, CommonDataAdapter.a().a().getString(2131694536));
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localRemoteViews.setImageViewResource(2131372409, 2130844526);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 2)
        {
          localRemoteViews.setTextViewText(2131372408, CommonDataAdapter.a().a().getString(2131694539));
          localObject = AppUtil.a(paramNoticeParam.d);
          if (localObject != null) {
            localRemoteViews.setImageViewBitmap(2131372409, (Bitmap)localObject);
          }
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localObject = IntentFactory.a(6, paramNoticeParam);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 3)
        {
          localRemoteViews.setTextViewText(2131372408, CommonDataAdapter.a().a().getString(2131694536));
          localObject = IntentFactory.a(4, paramNoticeParam);
          Bitmap localBitmap = ImageUtil.a(paramNoticeParam.jdField_a_of_type_JavaLangString);
          if (localBitmap == null) {
            break label476;
          }
          localRemoteViews.setImageViewBitmap(2131372409, localBitmap);
        }
        for (;;)
        {
          if (paramNoticeParam.jdField_b_of_type_Int == 0)
          {
            if (Build.VERSION.SDK_INT > 10)
            {
              localRemoteViews.setOnClickPendingIntent(2131372418, (PendingIntent)localObject);
              break;
              label476:
              LogUtility.b("AppNotificationManager", ">>download icon fail,so we use default notification icon");
              localRemoteViews.setImageViewResource(2131372409, 2130844526);
              continue;
            }
            localNotification.contentIntent = ((PendingIntent)localObject);
            break;
          }
        }
        localNotification.contentIntent = ((PendingIntent)localObject);
      }
      else if (paramNoticeParam.jdField_b_of_type_Int == 4)
      {
        localNotification.icon = 2130844530;
        localRemoteViews.setImageViewResource(2131372409, 2130844526);
        localRemoteViews.setTextViewText(2131372408, CommonDataAdapter.a().a().getString(2131694535));
        localRemoteViews.setViewVisibility(2131372408, 0);
        localRemoteViews.setViewVisibility(2131372403, 8);
        paramNoticeParam = IntentFactory.a(5, paramNoticeParam);
        localNotification.flags |= 0x10;
        localNotification.contentIntent = paramNoticeParam;
      }
      else
      {
        localNotification.icon = 2130842043;
        localRemoteViews.setImageViewResource(2131372409, 2130842044);
        localRemoteViews.setTextViewText(2131372408, paramNoticeParam.c);
        localNotification.contentIntent = ((PendingIntent)localObject);
      }
    }
  }
  
  public ConcurrentHashMap<String, AppNotificationManager.NoticeIdentity> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a(int paramInt, Notification paramNotification)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {}
    try
    {
      BadgeUtils.a(CommonDataAdapter.a().a(), 0, paramNotification);
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("AppNotificationManagernotify2", paramInt, paramNotification);
      return;
    }
    catch (Exception paramNotification)
    {
      LogUtility.c("AppNotificationManager", "notify>>>", paramNotification);
    }
  }
  
  public void a(RemoteViews paramRemoteViews)
  {
    if ((this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover == null) || (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a() == null)) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover = new AppNotificationManager.NotificationStyleDiscover(this, CommonDataAdapter.a().a());
    }
    LogUtility.b("notificationtest", "title color:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.b());
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.b() != null) {
      paramRemoteViews.setTextColor(2131372420, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.b().intValue());
    }
    LogUtility.b("notificationtest", "text color:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a());
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a() != null) {
      paramRemoteViews.setTextColor(2131372408, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a().intValue());
    }
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a() != null) {
      paramRemoteViews.setTextColor(2131372414, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a().intValue());
    }
    LogUtility.b("notificationtest", "text size:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a());
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a() > 0.0F) {
      paramRemoteViews.setFloat(2131372408, "setTextSize", this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a());
    }
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a() > 0.0F) {
      paramRemoteViews.setFloat(2131372414, "setTextSize", this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a());
    }
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.b() > 0.0F) {
      paramRemoteViews.setFloat(2131372420, "setTextSize", this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.b());
    }
    ApplicationInfo localApplicationInfo = CommonDataAdapter.a().a().getApplicationInfo();
    if ((localApplicationInfo != null) && (localApplicationInfo.targetSdkVersion < 10) && (Build.VERSION.SDK_INT > 10)) {}
    try
    {
      int i = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.b().intValue();
      paramRemoteViews.setInt(2131372418, "setBackgroundColor", (i & 0xFF000000) + (-1 - i));
      return;
    }
    catch (Exception paramRemoteViews) {}
  }
  
  public void a(NoticeParam paramNoticeParam)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null)
    {
      Notification localNotification = a(paramNoticeParam);
      if (localNotification != null)
      {
        BadgeUtils.a(CommonDataAdapter.a().a(), 0, localNotification);
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("AppNotificationManagernotify1", a(paramNoticeParam.f, paramNoticeParam.jdField_b_of_type_Int, paramNoticeParam.jdField_a_of_type_JavaLangString), localNotification);
      }
    }
  }
  
  public void a(String paramString)
  {
    LogUtility.a("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null))
    {
      AppNotificationManager.NoticeIdentity localNoticeIdentity = (AppNotificationManager.NoticeIdentity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localNoticeIdentity != null) {
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelBySendTime", localNoticeIdentity.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void b(String paramString)
  {
    LogUtility.a("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelNotRemoveId", ((AppNotificationManager.NoticeIdentity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.AppNotificationManager
 * JD-Core Version:    0.7.0.1
 */