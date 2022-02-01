package com.tencent.util;

import android.app.Notification;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.core.push.BadgeUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class BadgeUtils
{
  public static int a;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static BadgeUtils jdField_a_of_type_ComTencentUtilBadgeUtils = null;
  private static Runnable jdField_a_of_type_JavaLangRunnable = new BadgeUtils.2();
  public static boolean a;
  public static boolean b;
  public static boolean c;
  
  static
  {
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Int = -1;
    b = false;
    c = false;
  }
  
  public static int a()
  {
    int i;
    if (jdField_a_of_type_Int != -1)
    {
      i = jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("BadgeUtils", 2, "getLimitCount Limitcount" + i);
      }
      return i;
    }
    for (;;)
    {
      try
      {
        Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1|999");
        if (QLog.isColorLevel()) {
          QLog.d("BadgeUtils", 2, "LimitConfig:" + (String)localObject);
        }
        localObject = ((String)localObject).split("\\|");
        if (localObject.length <= 3) {
          break label179;
        }
        localObject = localObject[3];
        jdField_a_of_type_Int = Integer.valueOf((String)localObject).intValue();
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
      break;
      label179:
      String str = "";
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
    ThreadManager.executeOnSubThread(new BadgeUtils.1(i, paramContext, paramInt));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.util.BadgeUtils
 * JD-Core Version:    0.7.0.1
 */