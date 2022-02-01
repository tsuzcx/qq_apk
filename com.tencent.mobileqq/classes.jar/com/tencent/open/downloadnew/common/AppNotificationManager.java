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
  
  protected AppNotificationManager()
  {
    this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
  }
  
  private int a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">genNextNotificationId key:");
    localStringBuilder.append(paramString);
    LogUtility.b("AppNotificationManager", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString)) {
      return 378;
    }
    int i = Math.abs(paramString.hashCode()) % 99;
    paramString = new StringBuilder();
    paramString.append(">genNextNotificationId mod:");
    paramString.append(i);
    LogUtility.b("AppNotificationManager", paramString.toString());
    i += 378;
    paramString = new StringBuilder();
    paramString.append(">genNextNotificationId id:");
    paramString.append(i);
    LogUtility.b("AppNotificationManager", paramString.toString());
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(">getNotificationId ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramString2);
    LogUtility.b("AppNotificationManager", ((StringBuilder)localObject).toString());
    localObject = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      localObject = paramString2;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject))
    {
      paramString1 = new AppNotificationManager.NoticeIdentity(this);
      paramString1.jdField_a_of_type_JavaLangString = ((String)localObject);
      paramString1.jdField_a_of_type_Int = a((String)localObject);
      paramString1.jdField_b_of_type_Int = paramInt;
      paramString1.jdField_b_of_type_JavaLangString = paramString2;
      paramString1.jdField_a_of_type_Long = (System.currentTimeMillis() + paramString1.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, paramString1);
    }
    return ((AppNotificationManager.NoticeIdentity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject)).jdField_a_of_type_Int;
  }
  
  public long a(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(">getNotificationWhen ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramString2);
    LogUtility.b("AppNotificationManager", ((StringBuilder)localObject).toString());
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      localObject = new AppNotificationManager.NoticeIdentity(this);
      ((AppNotificationManager.NoticeIdentity)localObject).jdField_a_of_type_JavaLangString = paramString1;
      ((AppNotificationManager.NoticeIdentity)localObject).jdField_a_of_type_Int = a(paramString1);
      ((AppNotificationManager.NoticeIdentity)localObject).jdField_b_of_type_Int = paramInt;
      ((AppNotificationManager.NoticeIdentity)localObject).jdField_b_of_type_JavaLangString = paramString2;
      ((AppNotificationManager.NoticeIdentity)localObject).jdField_a_of_type_Long = (System.currentTimeMillis() + ((AppNotificationManager.NoticeIdentity)localObject).jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localObject);
    }
    return ((AppNotificationManager.NoticeIdentity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1)).jdField_a_of_type_Long;
  }
  
  public Notification a(NoticeParam paramNoticeParam)
  {
    if ((CommonDataAdapter.a().a() != null) && (paramNoticeParam != null))
    {
      Notification localNotification = new Notification();
      localNotification.tickerText = paramNoticeParam.jdField_b_of_type_JavaLangString;
      localNotification.when = paramNoticeParam.jdField_a_of_type_Long;
      RemoteViews localRemoteViews = new RemoteViews(CommonDataAdapter.a().a().getPackageName(), 2131559649);
      Object localObject = IntentFactory.a(1, paramNoticeParam);
      a(localRemoteViews);
      localRemoteViews.setInt(2131372000, "setBackgroundColor", -1);
      localRemoteViews.setInt(2131372002, "setTextColor", -16777216);
      localRemoteViews.setInt(2131371996, "setTextColor", -12303292);
      localRemoteViews.setInt(2131371990, "setTextColor", -12303292);
      localRemoteViews.setTextViewText(2131372002, StringAddition.a(paramNoticeParam.jdField_b_of_type_JavaLangString, 18, true, true));
      if (paramNoticeParam.jdField_b_of_type_Int == 1)
      {
        localNotification.icon = 2130844436;
        localRemoteViews.setImageViewResource(2131371991, 2130844432);
        localRemoteViews.setViewVisibility(2131371990, 8);
        localRemoteViews.setViewVisibility(2131371985, 0);
        if (Build.VERSION.SDK_INT > 10) {
          localRemoteViews.setOnClickPendingIntent(2131372000, (PendingIntent)localObject);
        } else {
          localNotification.contentIntent = ((PendingIntent)localObject);
        }
      }
      else if ((paramNoticeParam.jdField_b_of_type_Int != 0) && (paramNoticeParam.jdField_b_of_type_Int != 2) && (paramNoticeParam.jdField_b_of_type_Int != 3))
      {
        if (paramNoticeParam.jdField_b_of_type_Int == 4)
        {
          localNotification.icon = 2130844436;
          localRemoteViews.setImageViewResource(2131371991, 2130844432);
          localRemoteViews.setTextViewText(2131371990, CommonDataAdapter.a().a().getString(2131694500));
          localRemoteViews.setViewVisibility(2131371990, 0);
          localRemoteViews.setViewVisibility(2131371985, 8);
          paramNoticeParam = IntentFactory.a(5, paramNoticeParam);
          localNotification.flags |= 0x10;
          localNotification.contentIntent = paramNoticeParam;
        }
        else
        {
          localNotification.icon = 2130841940;
          localRemoteViews.setImageViewResource(2131371991, 2130841941);
          localRemoteViews.setTextViewText(2131371990, paramNoticeParam.c);
          localNotification.contentIntent = ((PendingIntent)localObject);
        }
      }
      else
      {
        localNotification.icon = 2130844436;
        if (paramNoticeParam.jdField_b_of_type_Int == 0)
        {
          localRemoteViews.setTextViewText(2131371990, CommonDataAdapter.a().a().getString(2131694501));
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localRemoteViews.setImageViewResource(2131371991, 2130844432);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 2)
        {
          localRemoteViews.setTextViewText(2131371990, CommonDataAdapter.a().a().getString(2131694504));
          localObject = AppUtil.a(paramNoticeParam.d);
          if (localObject != null) {
            localRemoteViews.setImageViewBitmap(2131371991, (Bitmap)localObject);
          }
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localObject = IntentFactory.a(6, paramNoticeParam);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 3)
        {
          localRemoteViews.setTextViewText(2131371990, CommonDataAdapter.a().a().getString(2131694501));
          localObject = IntentFactory.a(4, paramNoticeParam);
          Bitmap localBitmap = ImageUtil.a(paramNoticeParam.jdField_a_of_type_JavaLangString);
          if (localBitmap != null)
          {
            localRemoteViews.setImageViewBitmap(2131371991, localBitmap);
          }
          else
          {
            LogUtility.b("AppNotificationManager", ">>download icon fail,so we use default notification icon");
            localRemoteViews.setImageViewResource(2131371991, 2130844432);
          }
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 0)
        {
          if (Build.VERSION.SDK_INT > 10) {
            localRemoteViews.setOnClickPendingIntent(2131372000, (PendingIntent)localObject);
          } else {
            localNotification.contentIntent = ((PendingIntent)localObject);
          }
        }
        else {
          localNotification.contentIntent = ((PendingIntent)localObject);
        }
      }
      localNotification.contentView = localRemoteViews;
      QQNotificationManager.addChannelIfNeed(localNotification, "CHANNEL_ID_HIDE_BADGE");
      return localNotification;
    }
    LogUtility.e("AppNotificationManager", "getNotification context == null");
    return null;
  }
  
  public ConcurrentHashMap<String, AppNotificationManager.NoticeIdentity> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a(int paramInt, Notification paramNotification)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
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
  }
  
  public void a(RemoteViews paramRemoteViews)
  {
    Object localObject = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover;
    if ((localObject == null) || (((AppNotificationManager.NotificationStyleDiscover)localObject).a() == null)) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover = new AppNotificationManager.NotificationStyleDiscover(this, CommonDataAdapter.a().a());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("title color:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.b());
    LogUtility.b("notificationtest", ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.b() != null) {
      paramRemoteViews.setTextColor(2131372002, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.b().intValue());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("text color:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a());
    LogUtility.b("notificationtest", ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a() != null) {
      paramRemoteViews.setTextColor(2131371990, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a().intValue());
    }
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a() != null) {
      paramRemoteViews.setTextColor(2131371996, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a().intValue());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("text size:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a());
    LogUtility.b("notificationtest", ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a() > 0.0F) {
      paramRemoteViews.setFloat(2131371990, "setTextSize", this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a());
    }
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a() > 0.0F) {
      paramRemoteViews.setFloat(2131371996, "setTextSize", this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a());
    }
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.b() > 0.0F) {
      paramRemoteViews.setFloat(2131372002, "setTextSize", this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.b());
    }
    localObject = CommonDataAdapter.a().a().getApplicationInfo();
    if ((localObject != null) && (((ApplicationInfo)localObject).targetSdkVersion < 10) && (Build.VERSION.SDK_INT > 10)) {}
    try
    {
      int i = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.b().intValue();
      paramRemoteViews.setInt(2131372000, "setBackgroundColor", -1 - i + (i & 0xFF000000));
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cancelBySendTime:");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.a("AppNotificationManager", ((StringBuilder)localObject).toString());
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null))
    {
      localObject = (AppNotificationManager.NoticeIdentity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelBySendTime", ((AppNotificationManager.NoticeIdentity)localObject).jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelBySendTime:");
    localStringBuilder.append(paramString);
    LogUtility.a("AppNotificationManager", localStringBuilder.toString());
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelNotRemoveId", ((AppNotificationManager.NoticeIdentity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.AppNotificationManager
 * JD-Core Version:    0.7.0.1
 */