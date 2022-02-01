package com.tencent.mobileqq.msf.sdk;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class QNotificationManager
{
  public static final String CHANNEL_ID_OFFLINEMSG = "CHANNEL_ID_OFFLINEMSG";
  public static final String CHANNEL_ID_OTHER = "CHANNEL_ID_MSF";
  private static final CharSequence CHANNEL_NAME_OFFLINEMSG = "离线消息";
  private static final CharSequence CHANNEL_NAME_OTHER;
  private static final String GROUP_ID_TOP = "GROUP_ID_TOP";
  private static final CharSequence GROUP_NAME_TOP = "消息通知";
  public static final String TAG = "QNotificationMsf";
  private NotificationManager localManager = null;
  private HashMap mChannelGroups = new HashMap();
  
  static
  {
    CHANNEL_NAME_OTHER = "其它通知";
  }
  
  public QNotificationManager(Context paramContext)
  {
    this.localManager = ((NotificationManager)paramContext.getSystemService("notification"));
    initOreo(paramContext);
  }
  
  private void createNotificationChannelGroup(String paramString, CharSequence paramCharSequence)
  {
    if (isOreo())
    {
      paramString = new NotificationChannelGroup(paramString, paramCharSequence);
      this.mChannelGroups.put("GROUP_ID_TOP", paramString);
      this.localManager.createNotificationChannelGroup(paramString);
    }
  }
  
  public static boolean isOreo()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  public static void setProperty(Object paramObject1, Class paramClass, String paramString, Object paramObject2)
  {
    paramClass = paramClass.getDeclaredField(paramString);
    paramClass.setAccessible(true);
    paramClass.set(paramObject1, paramObject2);
  }
  
  public void addChannelIfNeed(Notification paramNotification)
  {
    addChannelIfNeed(paramNotification, "CHANNEL_ID_MSF");
  }
  
  public void addChannelIfNeed(Notification paramNotification, CharSequence paramCharSequence)
  {
    if ((isOreo()) && (BaseApplication.getContext().getApplicationInfo().targetSdkVersion >= 26) && (paramNotification.getChannelId() == null)) {
      try
      {
        setProperty(paramNotification, Notification.class, "mChannelId", paramCharSequence);
        return;
      }
      catch (Exception paramNotification)
      {
        paramNotification.printStackTrace();
      }
    }
  }
  
  public void cancel(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" cancel id:");
    localStringBuilder.append(paramInt);
    QLog.i("QNotificationMsf", 1, localStringBuilder.toString());
    paramString = this.localManager;
    if (paramString != null) {
      paramString.cancel(paramInt);
    }
  }
  
  public void cancelAll()
  {
    QLog.i("QNotificationMsf", 1, "clearAll");
    NotificationManager localNotificationManager = this.localManager;
    if (localNotificationManager != null) {
      localNotificationManager.cancelAll();
    }
  }
  
  public void cancelUseTag(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" cancel UseTag:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" id:");
    localStringBuilder.append(paramInt);
    QLog.i("QNotificationMsf", 1, localStringBuilder.toString());
    paramString1 = this.localManager;
    if (paramString1 != null) {
      paramString1.cancel(paramString2, paramInt);
    }
  }
  
  public void createNotificationChannel(String paramString1, CharSequence paramCharSequence, int paramInt, String paramString2, boolean paramBoolean)
  {
    if (!isOreo()) {
      return;
    }
    Object localObject = this.localManager.getNotificationChannelGroups();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        ((NotificationChannelGroup)((Iterator)localObject).next()).getId().equals(paramString2);
        i = 1;
        break label68;
      }
    }
    int i = 0;
    label68:
    if ((i == 0) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("please create NotificationChannelGroup First, create NotificationChannelGroup with id ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.i("QNotificationMsf", 2, ((StringBuilder)localObject).toString());
    }
    if (this.localManager.getNotificationChannel(paramString1) != null)
    {
      if (QLog.isColorLevel())
      {
        paramCharSequence = new StringBuilder();
        paramCharSequence.append("NotificationChannel ");
        paramCharSequence.append(paramString1);
        paramCharSequence.append(" has been create");
        QLog.i("QNotificationMsf", 2, paramCharSequence.toString());
      }
    }
    else
    {
      paramCharSequence = new NotificationChannel(paramString1, paramCharSequence, paramInt);
      paramCharSequence.setShowBadge(paramBoolean);
      paramCharSequence.setGroup(paramString2);
      if (paramInt > 3)
      {
        paramCharSequence.enableLights(true);
        paramCharSequence.enableVibration(true);
        paramCharSequence.setLightColor(-16711936);
        paramCharSequence.setLockscreenVisibility(0);
        paramCharSequence.setBypassDnd(true);
        paramCharSequence.setVibrationPattern(new long[] { 100L });
      }
      paramCharSequence.setSound(null, null);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("NotificationChannel ");
        paramString2.append(paramString1);
        paramString2.append("canShowBadge ");
        paramString2.append(paramCharSequence.canShowBadge());
        QLog.i("QNotificationMsf", 2, paramString2.toString());
      }
      this.localManager.createNotificationChannel(paramCharSequence);
    }
  }
  
  public NotificationManager getNotificationManager()
  {
    return this.localManager;
  }
  
  public void initOreo(Context paramContext)
  {
    if ((isOreo()) && (paramContext.getApplicationContext().getApplicationInfo().targetSdkVersion >= 26))
    {
      createNotificationChannelGroup("GROUP_ID_TOP", GROUP_NAME_TOP);
      createNotificationChannel("CHANNEL_ID_MSF", CHANNEL_NAME_OTHER, 3, "GROUP_ID_TOP", false);
      createNotificationChannel("CHANNEL_ID_OFFLINEMSG", CHANNEL_NAME_OFFLINEMSG, 3, "GROUP_ID_TOP", false);
    }
  }
  
  public void notify(String paramString, int paramInt, Notification paramNotification)
  {
    addChannelIfNeed(paramNotification);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" notify DontUseTag id:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramNotification);
    QLog.i("QNotificationMsf", 1, localStringBuilder.toString());
    paramString = this.localManager;
    if (paramString != null) {
      paramString.notify(paramInt, paramNotification);
    }
  }
  
  public void notifyUseTag(String paramString1, String paramString2, int paramInt, Notification paramNotification)
  {
    addChannelIfNeed(paramNotification);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" notify UseTag:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" id:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramNotification);
    QLog.i("QNotificationMsf", 1, localStringBuilder.toString());
    paramString1 = this.localManager;
    if (paramString1 != null) {
      paramString1.notify(paramString2, paramInt, paramNotification);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.QNotificationManager
 * JD-Core Version:    0.7.0.1
 */