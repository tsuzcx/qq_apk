package com.tencent.util;

import android.app.Notification;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.core.push.BadgeUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class BadgeUtils
{
  public static int a;
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private static BadgeUtils jdField_a_of_type_ComTencentUtilBadgeUtils;
  private static Runnable jdField_a_of_type_JavaLangRunnable = new BadgeUtils.2();
  public static boolean a;
  public static boolean b;
  public static boolean c;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Int = -1;
    b = false;
    c = false;
  }
  
  public static int a()
  {
    int i = jdField_a_of_type_Int;
    if (i == -1) {
      try
      {
        Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1|999");
        if (QLog.isColorLevel())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("LimitConfig:");
          localStringBuilder2.append((String)localObject);
          QLog.d("BadgeUtils", 2, localStringBuilder2.toString());
        }
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 3) {
          localObject = localObject[3];
        } else {
          localObject = "";
        }
        jdField_a_of_type_Int = Integer.valueOf((String)localObject).intValue();
        i = jdField_a_of_type_Int;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2;
        if (QLog.isColorLevel())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("getLimitCount e:");
          localStringBuilder2.append(localException.toString());
          QLog.d("BadgeUtils", 2, localStringBuilder2.toString());
        }
        jdField_a_of_type_Int = 999;
        i = jdField_a_of_type_Int;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("getLimitCount Limitcount");
      localStringBuilder1.append(i);
      QLog.d("BadgeUtils", 2, localStringBuilder1.toString());
    }
    return i;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BadgeUtils", 2, "enableBadge mobileqq");
    }
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    BadgeUtilImpl.enableBadge(MobileQQ.sMobileQQ);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if ((!jdField_a_of_type_Boolean) && (paramInt > 0)) {
      return;
    }
    if (!a(paramContext)) {
      return;
    }
    int i = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setBadge limit: ");
    localStringBuilder.append(i);
    localStringBuilder.append(", count: ");
    localStringBuilder.append(paramInt);
    QLog.d("BadgeUtils_UnreadMonitor", 1, localStringBuilder.toString());
    if (Looper.myLooper() != Looper.getMainLooper()) {
      BadgeUtilImpl.setLimitCount(i);
    }
    try
    {
      BadgeUtilImpl.setBadge(paramContext, paramInt);
      return;
    }
    catch (Exception paramContext)
    {
      label86:
      break label86;
    }
    if (QLog.isColorLevel())
    {
      QLog.e("BadgeUtilImpl", 2, "badge not support");
      return;
      ThreadManager.executeOnSubThread(new BadgeUtils.1(i, paramContext, paramInt));
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setMIUI6Badge count: ");
    localStringBuilder.append(paramInt);
    QLog.d("BadgeUtils_UnreadMonitor", 1, localStringBuilder.toString());
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
    BadgeUtilImpl.disableBadge(MobileQQ.sMobileQQ);
    jdField_a_of_type_AndroidOsHandler.postDelayed(jdField_a_of_type_JavaLangRunnable, 2000L);
  }
  
  public static void c()
  {
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.BadgeUtils
 * JD-Core Version:    0.7.0.1
 */