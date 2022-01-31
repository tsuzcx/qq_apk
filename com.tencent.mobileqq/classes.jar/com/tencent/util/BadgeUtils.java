package com.tencent.util;

import amgo;
import amgp;
import android.app.Notification;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.push.BadgeUtilImpl;
import com.tencent.qphone.base.util.QLog;

public class BadgeUtils
{
  public static int a;
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private static Runnable jdField_a_of_type_JavaLangRunnable = new amgp();
  public static boolean a;
  public static boolean b;
  public static boolean c;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Int = -1;
  }
  
  public static int a()
  {
    String str = "";
    int i;
    if (jdField_a_of_type_Int != -1) {
      i = jdField_a_of_type_Int;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BadgeUtils", 2, "getLimitCount Limitcount" + i);
      }
      return i;
      try
      {
        Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1|999");
        if (QLog.isColorLevel()) {
          QLog.d("BadgeUtils", 2, "LimitConfig:" + (String)localObject);
        }
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 3) {
          str = localObject[3];
        }
        jdField_a_of_type_Int = Integer.valueOf(str).intValue();
        i = jdField_a_of_type_Int;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BadgeUtils", 2, "getLimitCount e:" + localException.toString());
        }
        jdField_a_of_type_Int = 999;
        i = jdField_a_of_type_Int;
      }
    }
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BadgeUtils", 2, "enableBadge mobileqq");
    }
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    BadgeUtilImpl.enableBadge(BaseApplicationImpl.sApplication);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if ((!jdField_a_of_type_Boolean) && (paramInt > 0)) {}
    int i;
    do
    {
      do
      {
        return;
      } while (!a(paramContext));
      i = a();
      QLog.d("BadgeUtils_UnreadMonitor", 1, "setBadge limit: " + i + ", count: " + paramInt);
      if (Looper.myLooper() == Looper.getMainLooper()) {
        break;
      }
      BadgeUtilImpl.setLimitCount(i);
      try
      {
        BadgeUtilImpl.setBadge(paramContext, paramInt);
        return;
      }
      catch (Exception paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.e("BadgeUtilImpl", 2, "badge not support");
    return;
    ThreadManager.executeOnSubThread(new amgo(i, paramContext, paramInt));
  }
  
  public static void a(Context paramContext, int paramInt, Notification paramNotification)
  {
    if (!c) {
      if (!b)
      {
        c = CommonBadgeUtilImpl.isMIUI6();
        b = true;
        if (c) {}
      }
      else
      {
        return;
      }
    }
    QLog.d("BadgeUtils_UnreadMonitor", 1, "setMIUI6Badge count: " + paramInt);
    BadgeUtilImpl.setLimitCount(a());
    BadgeUtilImpl.setMIUI6Badge(paramContext, paramInt, paramNotification);
  }
  
  public static boolean a(Context paramContext)
  {
    return BadgeUtilImpl.isSupportBadge(paramContext);
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BadgeUtils", 2, "disableBadge mobileqq");
    }
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    BadgeUtilImpl.disableBadge(BaseApplicationImpl.sApplication);
    jdField_a_of_type_AndroidOsHandler.postDelayed(jdField_a_of_type_JavaLangRunnable, 2000L);
  }
  
  public static void c()
  {
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.util.BadgeUtils
 * JD-Core Version:    0.7.0.1
 */