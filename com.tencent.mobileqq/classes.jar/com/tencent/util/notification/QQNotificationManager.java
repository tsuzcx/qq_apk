package com.tencent.util.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class QQNotificationManager
{
  private static QQNotificationManager jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager;
  private static final CharSequence jdField_a_of_type_JavaLangCharSequence = "消息通知";
  private static final CharSequence b = "通知栏显示QQ图标";
  private NotificationManager jdField_a_of_type_AndroidAppNotificationManager = (NotificationManager)BaseApplicationImpl.getContext().getSystemService("notification");
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private QQNotificationManager()
  {
    a();
  }
  
  public static QQNotificationManager a()
  {
    if (jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager == null) {
      jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager = new QQNotificationManager();
    }
    return jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager;
  }
  
  @Deprecated
  private void a(String paramString, CharSequence paramCharSequence)
  {
    if (a())
    {
      paramString = new NotificationChannelGroup(paramString, paramCharSequence);
      this.jdField_a_of_type_JavaUtilHashMap.put("GROUP_ID_TOP", paramString);
      this.jdField_a_of_type_AndroidAppNotificationManager.createNotificationChannelGroup(paramString);
    }
  }
  
  @Deprecated
  private void a(String paramString1, CharSequence paramCharSequence, int paramInt, String paramString2, boolean paramBoolean)
  {
    if (!a()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidAppNotificationManager.getNotificationChannelGroups();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext()) {
        ((NotificationChannelGroup)((Iterator)localObject).next()).getId().equals(paramString2);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (QLog.isColorLevel())) {
        QLog.i("QQNotification", 2, "please create NotificationChannelGroup First, create NotificationChannelGroup with id " + paramString2);
      }
      if (this.jdField_a_of_type_AndroidAppNotificationManager.getNotificationChannel(paramString1) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQNotification", 2, "NotificationChannel " + paramString1 + " has been create");
        }
        this.jdField_a_of_type_AndroidAppNotificationManager.deleteNotificationChannel(paramString1);
      }
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
      if (QLog.isColorLevel()) {
        QLog.i("QQNotification", 2, "NotificationChannel " + paramString1 + "canShowBadge " + paramCharSequence.canShowBadge());
      }
      this.jdField_a_of_type_AndroidAppNotificationManager.createNotificationChannel(paramCharSequence);
      return;
    }
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  private void b()
  {
    a("CHANNEL_ID_HIDE_BADGE", b, 2, "GROUP_ID_TOP", false);
  }
  
  private void c()
  {
    a("GROUP_ID_TOP", jdField_a_of_type_JavaLangCharSequence);
  }
  
  public NotificationManager a()
  {
    return this.jdField_a_of_type_AndroidAppNotificationManager;
  }
  
  public void a()
  {
    try
    {
      c();
      b();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QNotification", 2, paramString + " cancel id:" + paramInt);
    }
    if (this.jdField_a_of_type_AndroidAppNotificationManager != null) {
      this.jdField_a_of_type_AndroidAppNotificationManager.cancel(paramInt);
    }
  }
  
  public void a(String paramString, int paramInt, Notification paramNotification)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QNotification", 2, paramString + " notify DontUseTag id:" + paramInt + " " + paramNotification);
    }
    if (this.jdField_a_of_type_AndroidAppNotificationManager != null) {
      this.jdField_a_of_type_AndroidAppNotificationManager.notify(paramInt, paramNotification);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, Notification paramNotification)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QNotification", 2, paramString1 + " notify UseTag:" + paramString2 + " id:" + paramInt + " " + paramNotification);
    }
    if (this.jdField_a_of_type_AndroidAppNotificationManager != null) {
      this.jdField_a_of_type_AndroidAppNotificationManager.notify(paramString2, paramInt, paramNotification);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.util.notification.QQNotificationManager
 * JD-Core Version:    0.7.0.1
 */