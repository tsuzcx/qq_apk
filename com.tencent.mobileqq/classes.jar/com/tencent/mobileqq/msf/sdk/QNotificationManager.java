package com.tencent.mobileqq.msf.sdk;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import com.tencent.qphone.base.util.QLog;

public final class QNotificationManager
{
  public static final String TAG = "QNotification";
  private NotificationManager localManager;
  
  public QNotificationManager(NotificationManager paramNotificationManager)
  {
    this.localManager = paramNotificationManager;
  }
  
  public QNotificationManager(Context paramContext)
  {
    this.localManager = ((NotificationManager)paramContext.getSystemService("notification"));
  }
  
  public void cancel(String paramString, int paramInt)
  {
    QLog.i("QNotification", 1, paramString + " cancel id:" + paramInt);
    if (this.localManager != null) {
      this.localManager.cancel(paramInt);
    }
  }
  
  public void cancelAll()
  {
    QLog.i("QNotification", 1, "clearAll");
    if (this.localManager != null) {
      this.localManager.cancelAll();
    }
  }
  
  public void cancelUseTag(String paramString1, String paramString2, int paramInt)
  {
    QLog.i("QNotification", 1, paramString1 + " cancel UseTag:" + paramString2 + " id:" + paramInt);
    if (this.localManager != null) {
      this.localManager.cancel(paramString2, paramInt);
    }
  }
  
  public NotificationManager getNotificationManager()
  {
    return this.localManager;
  }
  
  public void notify(String paramString, int paramInt, Notification paramNotification)
  {
    QLog.i("QNotification", 1, paramString + " notify DontUseTag id:" + paramInt + " " + paramNotification);
    if (this.localManager != null) {
      this.localManager.notify(paramInt, paramNotification);
    }
  }
  
  public void notifyUseTag(String paramString1, String paramString2, int paramInt, Notification paramNotification)
  {
    QLog.i("QNotification", 1, paramString1 + " notify UseTag:" + paramString2 + " id:" + paramInt + " " + paramNotification);
    if (this.localManager != null) {
      this.localManager.notify(paramString2, paramInt, paramNotification);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.QNotificationManager
 * JD-Core Version:    0.7.0.1
 */