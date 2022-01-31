package com.tencent.util.notification;

import android.app.Notification;
import android.app.Notification.Builder;
import android.support.v4.app.NotificationCompat.Builder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class NotificationFactory
{
  public static Notification.Builder a(String paramString)
  {
    if (QQNotificationManager.a())
    {
      if (paramString.isEmpty()) {
        return new Notification.Builder(BaseApplicationImpl.getContext());
      }
      return new Notification.Builder(BaseApplication.context, paramString);
    }
    return new Notification.Builder(BaseApplicationImpl.getContext());
  }
  
  public static Notification a(String paramString, int paramInt, CharSequence paramCharSequence, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createNotification:String channel ").append(paramString).append(", int icon ").append(paramInt).append(", CharSequence tickerText ").append(paramCharSequence).append(", long when").append(paramLong);
      QLog.d("NotificationFactory", 2, new Object[] { localStringBuilder });
    }
    if (QQNotificationManager.a())
    {
      if (paramString.isEmpty()) {}
      for (paramString = new Notification.Builder(BaseApplicationImpl.getContext());; paramString = new Notification.Builder(BaseApplicationImpl.getContext(), paramString))
      {
        paramString.setSmallIcon(paramInt).setTicker(paramCharSequence).setWhen(paramLong);
        return paramString.build();
      }
    }
    return new Notification(paramInt, paramCharSequence, paramLong);
  }
  
  public static NotificationCompat.Builder a(String paramString)
  {
    if (QQNotificationManager.a())
    {
      NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(BaseApplicationImpl.getContext());
      if (!paramString.isEmpty()) {
        localBuilder.setChannelId(paramString);
      }
      return localBuilder;
    }
    return new NotificationCompat.Builder(BaseApplicationImpl.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.util.notification.NotificationFactory
 * JD-Core Version:    0.7.0.1
 */