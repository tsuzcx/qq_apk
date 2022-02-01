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
  protected QQNotificationManager b = null;
  protected final ConcurrentHashMap<String, AppNotificationManager.NoticeIdentity> c = new ConcurrentHashMap();
  protected AppNotificationManager.NotificationStyleDiscover d;
  
  public static AppNotificationManager a()
  {
    if (a == null) {
      a = new AppNotificationManager();
    }
    return a;
  }
  
  private int c(String paramString)
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
    if (!this.c.containsKey(localObject))
    {
      paramString1 = new AppNotificationManager.NoticeIdentity(this);
      paramString1.a = ((String)localObject);
      paramString1.c = c((String)localObject);
      paramString1.d = paramInt;
      paramString1.b = paramString2;
      paramString1.e = (System.currentTimeMillis() + paramString1.c);
      this.c.put(localObject, paramString1);
    }
    return ((AppNotificationManager.NoticeIdentity)this.c.get(localObject)).c;
  }
  
  public void a(int paramInt, Notification paramNotification)
  {
    if (this.b != null) {
      try
      {
        BadgeUtils.a(CommonDataAdapter.a().b(), 0, paramNotification);
        this.b.notify("AppNotificationManagernotify2", paramInt, paramNotification);
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
    Object localObject = this.d;
    if ((localObject == null) || (((AppNotificationManager.NotificationStyleDiscover)localObject).a() == null)) {
      this.d = new AppNotificationManager.NotificationStyleDiscover(this, CommonDataAdapter.a().b());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("title color:");
    ((StringBuilder)localObject).append(this.d.c());
    LogUtility.b("notificationtest", ((StringBuilder)localObject).toString());
    if (this.d.c() != null) {
      paramRemoteViews.setTextColor(2131439460, this.d.c().intValue());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("text color:");
    ((StringBuilder)localObject).append(this.d.a());
    LogUtility.b("notificationtest", ((StringBuilder)localObject).toString());
    if (this.d.a() != null) {
      paramRemoteViews.setTextColor(2131439447, this.d.a().intValue());
    }
    if (this.d.a() != null) {
      paramRemoteViews.setTextColor(2131439454, this.d.a().intValue());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("text size:");
    ((StringBuilder)localObject).append(this.d.b());
    LogUtility.b("notificationtest", ((StringBuilder)localObject).toString());
    if (this.d.b() > 0.0F) {
      paramRemoteViews.setFloat(2131439447, "setTextSize", this.d.b());
    }
    if (this.d.b() > 0.0F) {
      paramRemoteViews.setFloat(2131439454, "setTextSize", this.d.b());
    }
    if (this.d.d() > 0.0F) {
      paramRemoteViews.setFloat(2131439460, "setTextSize", this.d.d());
    }
    localObject = CommonDataAdapter.a().b().getApplicationInfo();
    if ((localObject != null) && (((ApplicationInfo)localObject).targetSdkVersion < 10) && (Build.VERSION.SDK_INT > 10)) {}
    try
    {
      int i = this.d.c().intValue();
      paramRemoteViews.setInt(2131439458, "setBackgroundColor", -1 - i + (i & 0xFF000000));
      return;
    }
    catch (Exception paramRemoteViews) {}
  }
  
  public void a(NoticeParam paramNoticeParam)
  {
    if (this.b != null)
    {
      Notification localNotification = b(paramNoticeParam);
      if (localNotification != null)
      {
        BadgeUtils.a(CommonDataAdapter.a().b(), 0, localNotification);
        this.b.notify("AppNotificationManagernotify1", a(paramNoticeParam.h, paramNoticeParam.g, paramNoticeParam.a), localNotification);
      }
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cancelBySendTime:");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.a("AppNotificationManager", ((StringBuilder)localObject).toString());
    if ((this.b != null) && (this.c.containsKey(paramString)) && (this.c.get(paramString) != null))
    {
      localObject = (AppNotificationManager.NoticeIdentity)this.c.get(paramString);
      if (localObject != null) {
        this.b.cancel("AppNotificationManager_cancelBySendTime", ((AppNotificationManager.NoticeIdentity)localObject).c);
      }
      this.c.remove(paramString);
    }
  }
  
  public long b(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(">getNotificationWhen ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramString2);
    LogUtility.b("AppNotificationManager", ((StringBuilder)localObject).toString());
    if (!this.c.containsKey(paramString1))
    {
      localObject = new AppNotificationManager.NoticeIdentity(this);
      ((AppNotificationManager.NoticeIdentity)localObject).a = paramString1;
      ((AppNotificationManager.NoticeIdentity)localObject).c = c(paramString1);
      ((AppNotificationManager.NoticeIdentity)localObject).d = paramInt;
      ((AppNotificationManager.NoticeIdentity)localObject).b = paramString2;
      ((AppNotificationManager.NoticeIdentity)localObject).e = (System.currentTimeMillis() + ((AppNotificationManager.NoticeIdentity)localObject).c);
      this.c.put(paramString1, localObject);
    }
    return ((AppNotificationManager.NoticeIdentity)this.c.get(paramString1)).e;
  }
  
  public Notification b(NoticeParam paramNoticeParam)
  {
    if ((CommonDataAdapter.a().b() != null) && (paramNoticeParam != null))
    {
      Notification localNotification = new Notification();
      localNotification.tickerText = paramNoticeParam.b;
      localNotification.when = paramNoticeParam.i;
      RemoteViews localRemoteViews = new RemoteViews(CommonDataAdapter.a().b().getPackageName(), 2131625678);
      Object localObject = IntentFactory.a(1, paramNoticeParam);
      a(localRemoteViews);
      localRemoteViews.setInt(2131439458, "setBackgroundColor", -1);
      localRemoteViews.setInt(2131439460, "setTextColor", -16777216);
      localRemoteViews.setInt(2131439454, "setTextColor", -12303292);
      localRemoteViews.setInt(2131439447, "setTextColor", -12303292);
      localRemoteViews.setTextViewText(2131439460, StringAddition.a(paramNoticeParam.b, 18, true, true));
      if (paramNoticeParam.g == 1)
      {
        localNotification.icon = 2130845754;
        localRemoteViews.setImageViewResource(2131439448, 2130845750);
        localRemoteViews.setViewVisibility(2131439447, 8);
        localRemoteViews.setViewVisibility(2131439441, 0);
        if (Build.VERSION.SDK_INT > 10) {
          localRemoteViews.setOnClickPendingIntent(2131439458, (PendingIntent)localObject);
        } else {
          localNotification.contentIntent = ((PendingIntent)localObject);
        }
      }
      else if ((paramNoticeParam.g != 0) && (paramNoticeParam.g != 2) && (paramNoticeParam.g != 3))
      {
        if (paramNoticeParam.g == 4)
        {
          localNotification.icon = 2130845754;
          localRemoteViews.setImageViewResource(2131439448, 2130845750);
          localRemoteViews.setTextViewText(2131439447, CommonDataAdapter.a().b().getString(2131892183));
          localRemoteViews.setViewVisibility(2131439447, 0);
          localRemoteViews.setViewVisibility(2131439441, 8);
          paramNoticeParam = IntentFactory.a(5, paramNoticeParam);
          localNotification.flags |= 0x10;
          localNotification.contentIntent = paramNoticeParam;
        }
        else
        {
          localNotification.icon = 2130842857;
          localRemoteViews.setImageViewResource(2131439448, 2130842858);
          localRemoteViews.setTextViewText(2131439447, paramNoticeParam.c);
          localNotification.contentIntent = ((PendingIntent)localObject);
        }
      }
      else
      {
        localNotification.icon = 2130845754;
        if (paramNoticeParam.g == 0)
        {
          localRemoteViews.setTextViewText(2131439447, CommonDataAdapter.a().b().getString(2131892184));
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localRemoteViews.setImageViewResource(2131439448, 2130845750);
        }
        if (paramNoticeParam.g == 2)
        {
          localRemoteViews.setTextViewText(2131439447, CommonDataAdapter.a().b().getString(2131892187));
          localObject = AppUtil.b(paramNoticeParam.d);
          if (localObject != null) {
            localRemoteViews.setImageViewBitmap(2131439448, (Bitmap)localObject);
          }
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localObject = IntentFactory.a(6, paramNoticeParam);
        }
        if (paramNoticeParam.g == 3)
        {
          localRemoteViews.setTextViewText(2131439447, CommonDataAdapter.a().b().getString(2131892184));
          localObject = IntentFactory.a(4, paramNoticeParam);
          Bitmap localBitmap = ImageUtil.a(paramNoticeParam.a);
          if (localBitmap != null)
          {
            localRemoteViews.setImageViewBitmap(2131439448, localBitmap);
          }
          else
          {
            LogUtility.b("AppNotificationManager", ">>download icon fail,so we use default notification icon");
            localRemoteViews.setImageViewResource(2131439448, 2130845750);
          }
        }
        if (paramNoticeParam.g == 0)
        {
          if (Build.VERSION.SDK_INT > 10) {
            localRemoteViews.setOnClickPendingIntent(2131439458, (PendingIntent)localObject);
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
  
  public ConcurrentHashMap<String, AppNotificationManager.NoticeIdentity> b()
  {
    return this.c;
  }
  
  public void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelBySendTime:");
    localStringBuilder.append(paramString);
    LogUtility.a("AppNotificationManager", localStringBuilder.toString());
    if ((this.b != null) && (this.c.containsKey(paramString))) {
      this.b.cancel("AppNotificationManager_cancelNotRemoveId", ((AppNotificationManager.NoticeIdentity)this.c.get(paramString)).c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.AppNotificationManager
 * JD-Core Version:    0.7.0.1
 */