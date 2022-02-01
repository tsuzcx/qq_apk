package com.vivo.push.util;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.Builder;
import android.app.Notification.Style;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.vivo.push.b.p;
import com.vivo.push.c.r.a;
import com.vivo.push.e;
import com.vivo.push.model.InsideNotificationItem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NotifyAdapterUtil
{
  private static final int HIDE_TITLE = 1;
  public static final int NOTIFY_MULTITERM_STYLE = 1;
  public static final int NOTIFY_SINGLE_STYLE = 0;
  public static final String PRIMARY_CHANNEL = "vivo_push_channel";
  private static final String PUSH_EN = "PUSH";
  private static final String PUSH_ZH = "推送通知";
  private static final String TAG = "NotifyManager";
  private static NotificationManager sNotificationManager;
  private static int sNotifyId = 20000000;
  
  public static void cancelNotify(Context paramContext)
  {
    cancelNotify(paramContext, sNotifyId);
  }
  
  private static boolean cancelNotify(Context paramContext, int paramInt)
  {
    initAdapter(paramContext);
    paramContext = sNotificationManager;
    if (paramContext != null)
    {
      paramContext.cancel(paramInt);
      return true;
    }
    return false;
  }
  
  private static void initAdapter(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (sNotificationManager == null) {
          sNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
        }
        if ((Build.VERSION.SDK_INT >= 26) && (sNotificationManager != null))
        {
          Object localObject = sNotificationManager.getNotificationChannel("default");
          if (localObject != null)
          {
            localObject = ((NotificationChannel)localObject).getName();
            if (("推送通知".equals(localObject)) || ("PUSH".equals(localObject))) {
              sNotificationManager.deleteNotificationChannel("default");
            }
          }
          if (isZh(paramContext))
          {
            paramContext = "推送通知";
            paramContext = new NotificationChannel("vivo_push_channel", paramContext, 4);
            paramContext.setLightColor(-16711936);
            paramContext.enableVibration(true);
            paramContext.setLockscreenVisibility(1);
            sNotificationManager.createNotificationChannel(paramContext);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      paramContext = "PUSH";
    }
  }
  
  private static boolean isZh(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().locale.getLanguage().endsWith("zh");
  }
  
  public static void pushNotification(Context paramContext, List<Bitmap> paramList, InsideNotificationItem paramInsideNotificationItem, long paramLong, int paramInt, r.a parama)
  {
    o.d("NotifyManager", "pushNotification");
    initAdapter(paramContext);
    int j = NotifyUtil.getNotifyDataAdapter(paramContext).getNotifyMode(paramInsideNotificationItem);
    int i = j;
    if (!TextUtils.isEmpty(paramInsideNotificationItem.getPurePicUrl()))
    {
      i = j;
      if (paramList != null)
      {
        i = j;
        if (paramList.size() > 1)
        {
          i = j;
          if (paramList.get(1) != null) {
            i = 1;
          }
        }
      }
    }
    if (i == 2)
    {
      pushNotificationBySystem(paramContext, paramList, paramInsideNotificationItem, paramLong, paramInt, parama);
      return;
    }
    if (i == 1) {
      pushNotificationByCustom(paramContext, paramList, paramInsideNotificationItem, paramLong, parama);
    }
  }
  
  private static void pushNotificationByCustom(Context paramContext, List<Bitmap> paramList, InsideNotificationItem paramInsideNotificationItem, long paramLong, r.a parama)
  {
    Resources localResources = paramContext.getResources();
    String str = paramContext.getPackageName();
    Object localObject2 = paramInsideNotificationItem.getTitle();
    int k = NotifyUtil.getNotifyDataAdapter(paramContext).getDefaultNotifyIcon();
    int i = paramContext.getApplicationInfo().icon;
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 26)
    {
      localObject1 = new Notification.Builder(paramContext, "vivo_push_channel");
      if (k > 0)
      {
        localObject3 = new Bundle();
        ((Bundle)localObject3).putInt("vivo.summaryIconRes", k);
        ((Notification.Builder)localObject1).setExtras((Bundle)localObject3);
      }
      localObject1 = ((Notification.Builder)localObject1).build();
    }
    else
    {
      localObject1 = new Notification();
    }
    ((Notification)localObject1).priority = 2;
    ((Notification)localObject1).flags = 16;
    ((Notification)localObject1).tickerText = ((CharSequence)localObject2);
    int m = NotifyUtil.getNotifyDataAdapter(paramContext).getDefaultSmallIconId();
    int j = m;
    if (m <= 0) {
      j = i;
    }
    ((Notification)localObject1).icon = j;
    RemoteViews localRemoteViews = new RemoteViews(str, NotifyUtil.getNotifyLayoutAdapter(paramContext).getNotificationLayout());
    localRemoteViews.setTextViewText(localResources.getIdentifier("notify_title", "id", str), (CharSequence)localObject2);
    localRemoteViews.setTextColor(localResources.getIdentifier("notify_title", "id", str), NotifyUtil.getNotifyLayoutAdapter(paramContext).getTitleColor());
    localRemoteViews.setTextViewText(localResources.getIdentifier("notify_msg", "id", str), paramInsideNotificationItem.getContent());
    if (paramInsideNotificationItem.isShowTime())
    {
      localObject2 = new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date());
      localRemoteViews.setTextViewText(localResources.getIdentifier("notify_when", "id", str), (CharSequence)localObject2);
      localRemoteViews.setViewVisibility(localResources.getIdentifier("notify_when", "id", str), 0);
    }
    else
    {
      localRemoteViews.setViewVisibility(localResources.getIdentifier("notify_when", "id", str), 8);
    }
    m = NotifyUtil.getNotifyLayoutAdapter(paramContext).getSuitIconId();
    localRemoteViews.setViewVisibility(m, 0);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject2 = (Bitmap)paramList.get(0);
      if (localObject2 != null)
      {
        localRemoteViews.setImageViewBitmap(m, (Bitmap)localObject2);
        break label425;
      }
    }
    j = k;
    if (k <= 0) {
      j = i;
    }
    localRemoteViews.setImageViewResource(m, j);
    label425:
    Object localObject3 = null;
    localObject2 = localObject3;
    if (paramList != null)
    {
      localObject2 = localObject3;
      if (paramList.size() > 1) {
        localObject2 = (Bitmap)paramList.get(1);
      }
    }
    if (localObject2 != null)
    {
      if (!TextUtils.isEmpty(paramInsideNotificationItem.getPurePicUrl()))
      {
        localRemoteViews.setViewVisibility(localResources.getIdentifier("notify_content", "id", str), 8);
        localRemoteViews.setViewVisibility(localResources.getIdentifier("notify_cover", "id", str), 8);
        localRemoteViews.setViewVisibility(localResources.getIdentifier("notify_pure_cover", "id", str), 0);
        localRemoteViews.setImageViewBitmap(localResources.getIdentifier("notify_pure_cover", "id", str), (Bitmap)localObject2);
      }
      else
      {
        localRemoteViews.setViewVisibility(localResources.getIdentifier("notify_cover", "id", str), 0);
        localRemoteViews.setImageViewBitmap(localResources.getIdentifier("notify_cover", "id", str), (Bitmap)localObject2);
      }
    }
    else {
      localRemoteViews.setViewVisibility(localResources.getIdentifier("notify_cover", "id", str), 8);
    }
    ((Notification)localObject1).contentView = localRemoteViews;
    if ((Build.VERSION.SDK_INT >= 16) && (TextUtils.isEmpty(paramInsideNotificationItem.getPurePicUrl()))) {
      ((Notification)localObject1).bigContentView = localRemoteViews;
    }
    paramList = (AudioManager)paramContext.getSystemService("audio");
    i = paramList.getRingerMode();
    j = paramList.getVibrateSetting(0);
    paramList = new StringBuilder("ringMode=");
    paramList.append(i);
    paramList.append(" callVibrateSetting=");
    paramList.append(j);
    o.d("NotifyManager", paramList.toString());
    k = paramInsideNotificationItem.getNotifyType();
    if (k != 2)
    {
      if (k != 3)
      {
        if (k == 4)
        {
          if (i == 2) {
            ((Notification)localObject1).defaults = 1;
          }
          if (j == 1)
          {
            ((Notification)localObject1).defaults |= 0x2;
            ((Notification)localObject1).vibrate = new long[] { 0L, 100L, 200L, 300L };
          }
        }
      }
      else if (j == 1)
      {
        ((Notification)localObject1).defaults = 2;
        ((Notification)localObject1).vibrate = new long[] { 0L, 100L, 200L, 300L };
      }
    }
    else if (i == 2) {
      ((Notification)localObject1).defaults = 1;
    }
    paramList = new Intent("com.vivo.pushservice.action.RECEIVE");
    paramList.setPackage(paramContext.getPackageName());
    paramList.setClassName(paramContext.getPackageName(), "com.vivo.push.sdk.service.CommandService");
    paramList.putExtra("command_type", "reflect_receiver");
    try
    {
      paramList.putExtra("security_avoid_pull", a.a(paramContext).a("com.vivo.pushservice"));
    }
    catch (Exception localException)
    {
      localObject3 = new StringBuilder("pushNotificationByCustom encrypt ：");
      ((StringBuilder)localObject3).append(localException.getMessage());
      o.a("NotifyManager", ((StringBuilder)localObject3).toString());
    }
    new p(str, paramLong, paramInsideNotificationItem).b(paramList);
    ((Notification)localObject1).contentIntent = PendingIntent.getService(paramContext, (int)SystemClock.uptimeMillis(), paramList, 268435456);
    if (sNotificationManager != null)
    {
      i = e.a().k();
      if (i != 0) {}
    }
    try
    {
      sNotificationManager.notify(sNotifyId, (Notification)localObject1);
      if (parama != null)
      {
        parama.a();
        return;
        if (i == 1)
        {
          sNotificationManager.notify((int)paramLong, (Notification)localObject1);
          if (parama != null) {
            parama.a();
          }
        }
        else
        {
          o.a("NotifyManager", "unknow notify style ".concat(String.valueOf(i)));
        }
      }
      return;
    }
    catch (Exception paramContext)
    {
      label1089:
      break label1089;
    }
    o.a("NotifyManager", paramContext);
    if (parama != null) {
      parama.b();
    }
  }
  
  private static void pushNotificationBySystem(Context paramContext, List<Bitmap> paramList, InsideNotificationItem paramInsideNotificationItem, long paramLong, int paramInt, r.a parama)
  {
    String str1 = paramContext.getPackageName();
    String str2 = paramInsideNotificationItem.getTitle();
    String str3 = paramInsideNotificationItem.getContent();
    int j = paramContext.getApplicationInfo().icon;
    boolean bool = paramInsideNotificationItem.isShowTime();
    AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
    int i = NotifyUtil.getNotifyDataAdapter(paramContext).getDefaultNotifyIcon();
    Object localObject1;
    Object localObject2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject1 = (Bitmap)paramList.get(0);
      if ((localObject1 != null) && (i > 0))
      {
        localObject2 = BitmapFactory.decodeResource(paramContext.getResources(), i);
        if (localObject2 != null)
        {
          k = ((Bitmap)localObject2).getWidth();
          int m = ((Bitmap)localObject2).getHeight();
          ((Bitmap)localObject2).recycle();
          localObject1 = c.a((Bitmap)localObject1, k, m);
          break label146;
        }
      }
    }
    else
    {
      localObject1 = null;
    }
    label146:
    Object localObject3;
    if (Build.VERSION.SDK_INT >= 26)
    {
      localObject3 = new Notification.Builder(paramContext, "vivo_push_channel");
      if (i > 0)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("vivo.summaryIconRes", i);
        ((Notification.Builder)localObject3).setExtras((Bundle)localObject2);
      }
      localObject2 = localObject3;
      if (localObject1 != null)
      {
        ((Notification.Builder)localObject3).setLargeIcon((Bitmap)localObject1);
        localObject2 = localObject3;
      }
    }
    else
    {
      localObject3 = new Notification.Builder(paramContext);
      if (localObject1 != null)
      {
        ((Notification.Builder)localObject3).setLargeIcon((Bitmap)localObject1);
        localObject2 = localObject3;
      }
      else
      {
        localObject2 = localObject3;
        if (Build.VERSION.SDK_INT <= 22)
        {
          ((Notification.Builder)localObject3).setLargeIcon(BitmapFactory.decodeResource(paramContext.getResources(), j));
          localObject2 = localObject3;
        }
      }
    }
    int k = NotifyUtil.getNotifyDataAdapter(paramContext).getDefaultSmallIconId();
    i = k;
    if (k <= 0) {
      i = j;
    }
    ((Notification.Builder)localObject2).setSmallIcon(i);
    if (paramInsideNotificationItem.getCompatibleType() != 1) {
      ((Notification.Builder)localObject2).setContentTitle(str2);
    }
    ((Notification.Builder)localObject2).setPriority(2);
    ((Notification.Builder)localObject2).setContentText(str3);
    long l;
    if (bool) {
      l = System.currentTimeMillis();
    } else {
      l = 0L;
    }
    ((Notification.Builder)localObject2).setWhen(l);
    ((Notification.Builder)localObject2).setShowWhen(bool);
    ((Notification.Builder)localObject2).setTicker(str2);
    i = localAudioManager.getRingerMode();
    j = paramInsideNotificationItem.getNotifyType();
    if (j != 2)
    {
      if (j != 3)
      {
        if (j == 4) {
          if (i == 2)
          {
            ((Notification.Builder)localObject2).setDefaults(3);
            ((Notification.Builder)localObject2).setVibrate(new long[] { 0L, 100L, 200L, 300L });
          }
          else if (i == 1)
          {
            ((Notification.Builder)localObject2).setDefaults(2);
            ((Notification.Builder)localObject2).setVibrate(new long[] { 0L, 100L, 200L, 300L });
          }
        }
      }
      else if (i == 2)
      {
        ((Notification.Builder)localObject2).setDefaults(2);
        ((Notification.Builder)localObject2).setVibrate(new long[] { 0L, 100L, 200L, 300L });
      }
    }
    else if (i == 2) {
      ((Notification.Builder)localObject2).setDefaults(1);
    }
    if ((paramList != null) && (paramList.size() > 1)) {
      paramList = (Bitmap)paramList.get(1);
    } else {
      paramList = null;
    }
    if ((paramInt != 1) && (paramList != null))
    {
      localObject1 = new Notification.BigPictureStyle();
      ((Notification.BigPictureStyle)localObject1).setBigContentTitle(str2);
      ((Notification.BigPictureStyle)localObject1).setSummaryText(str3);
      ((Notification.BigPictureStyle)localObject1).bigPicture(paramList);
      ((Notification.Builder)localObject2).setStyle((Notification.Style)localObject1);
    }
    ((Notification.Builder)localObject2).setAutoCancel(true);
    paramList = new Intent("com.vivo.pushservice.action.RECEIVE");
    paramList.setPackage(paramContext.getPackageName());
    paramList.setClassName(paramContext.getPackageName(), "com.vivo.push.sdk.service.CommandService");
    paramList.putExtra("command_type", "reflect_receiver");
    try
    {
      paramList.putExtra("security_avoid_pull", a.a(paramContext).a("com.vivo.pushservice"));
    }
    catch (Exception localException)
    {
      localObject3 = new StringBuilder("pushNotificationBySystem encrypt ：");
      ((StringBuilder)localObject3).append(localException.getMessage());
      o.a("NotifyManager", ((StringBuilder)localObject3).toString());
    }
    new p(str1, paramLong, paramInsideNotificationItem).b(paramList);
    ((Notification.Builder)localObject2).setContentIntent(PendingIntent.getService(paramContext, (int)SystemClock.uptimeMillis(), paramList, 268435456));
    paramContext = ((Notification.Builder)localObject2).build();
    paramInt = e.a().k();
    paramList = sNotificationManager;
    if ((paramList == null) || (paramInt == 0)) {}
    try
    {
      paramList.notify(sNotifyId, paramContext);
      if (parama != null)
      {
        parama.a();
        return;
        if (paramInt == 1)
        {
          paramList.notify((int)paramLong, paramContext);
          if (parama != null) {
            parama.a();
          }
        }
        else
        {
          o.a("NotifyManager", "unknow notify style ".concat(String.valueOf(paramInt)));
        }
      }
      return;
    }
    catch (Exception paramContext)
    {
      label885:
      break label885;
    }
    o.a("NotifyManager", paramContext);
    if (parama != null) {
      parama.b();
    }
  }
  
  public static boolean repealNotifyById(Context paramContext, long paramLong)
  {
    int i = e.a().k();
    if (i == 0)
    {
      long l = w.b().b("com.vivo.push.notify_key", -1L);
      if (l == paramLong)
      {
        o.d("NotifyManager", "undo showed message ".concat(String.valueOf(paramLong)));
        o.a(paramContext, "回收已展示的通知： ".concat(String.valueOf(paramLong)));
        return cancelNotify(paramContext, sNotifyId);
      }
      StringBuilder localStringBuilder = new StringBuilder("current showing message id ");
      localStringBuilder.append(l);
      localStringBuilder.append(" not match ");
      localStringBuilder.append(paramLong);
      o.d("NotifyManager", localStringBuilder.toString());
      localStringBuilder = new StringBuilder("与已展示的通知");
      localStringBuilder.append(l);
      localStringBuilder.append("与待回收的通知");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("不匹配");
      o.a(paramContext, localStringBuilder.toString());
      return false;
    }
    if (i == 1) {
      return cancelNotify(paramContext, (int)paramLong);
    }
    o.a("NotifyManager", "unknow cancle notify style ".concat(String.valueOf(i)));
    return false;
  }
  
  public static void setNotifyId(int paramInt)
  {
    sNotifyId = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.NotifyAdapterUtil
 * JD-Core Version:    0.7.0.1
 */