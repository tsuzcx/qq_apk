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
  public static boolean a = true;
  public static int b = -1;
  public static boolean c = false;
  public static boolean d = false;
  private static BadgeUtils e;
  private static Handler f = new Handler(Looper.getMainLooper());
  private static Runnable g = new BadgeUtils.2();
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BadgeUtils", 2, "enableBadge mobileqq");
    }
    f.removeCallbacksAndMessages(null);
    BadgeUtilImpl.enableBadge(MobileQQ.sMobileQQ);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if ((!a) && (paramInt > 0)) {
      return;
    }
    if (!a(paramContext)) {
      return;
    }
    int i = d();
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
    if (!d) {
      if (!c)
      {
        d = CommonBadgeUtilImpl.isMIUI6();
        c = true;
        if (d) {}
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
    BadgeUtilImpl.setLimitCount(d());
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
    f.removeCallbacksAndMessages(null);
    BadgeUtilImpl.disableBadge(MobileQQ.sMobileQQ);
    f.postDelayed(g, 2000L);
  }
  
  public static void c()
  {
    f.removeCallbacksAndMessages(null);
  }
  
  public static int d()
  {
    int i = b;
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
        b = Integer.valueOf((String)localObject).intValue();
        i = b;
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
        b = 999;
        i = b;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.BadgeUtils
 * JD-Core Version:    0.7.0.1
 */