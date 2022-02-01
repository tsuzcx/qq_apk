package com.tencent.qqperf.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class PerformanceReportUtils
{
  private static long A = 0L;
  public static boolean a = false;
  public static int b = 0;
  static String[] c = { i, j, k, l, m, n, o };
  private static long d = 14400000L;
  private static String e = "uiswitchinterval";
  private static String f = "uiswitchflag";
  private static String g = "fpsinterval";
  private static String h = "fpsflag";
  private static String i = "actUISwitchC2C";
  private static String j = "actUISwitchGroup";
  private static String k = "actUISwitchDiscuss";
  private static String l = "actUISwitchQzone";
  private static String m = "actUISwitchUserAlbum";
  private static String n = "actUISwitchQunAlbum";
  private static String o = "actUISwitchUserHome";
  private static String p = "actUISwitchPushBannerMyfeed";
  private static String q = "actUISwitchNotificationMyfeed";
  private static String r = "actUISwitchMyfeed";
  private static String s = "actUISwitchAioPreload";
  private static String t = "";
  private static long u = 0L;
  private static long v = 0L;
  private static long w = 0L;
  private static long x = 0L;
  private static long y = 0L;
  private static long z = 0L;
  
  public static void a(Context paramContext, String paramString, int paramInt, long paramLong)
  {
    ThreadManager.post(new PerformanceReportUtils.1(paramInt, paramLong, paramString), 8, null, false);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    new PerformanceReportUtils.2(paramString1, paramInt, paramString2).execute(new Void[0]);
  }
  
  public static void a(String paramString, long paramLong)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportFPS saveCompleteTime ：tag:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",time:");
      localStringBuilder.append(paramLong);
      QLog.d("PerformanceReportUtils", 4, localStringBuilder.toString());
    }
    if ("actFPSAIO".equals(paramString))
    {
      u = paramLong;
      return;
    }
    if ("actFPSRecent".equals(paramString))
    {
      v = paramLong;
      return;
    }
    if ("actFPSFriend".equals(paramString))
    {
      w = paramLong;
      return;
    }
    if ("actFPSQZoneFriendFeed".equals(paramString))
    {
      x = paramLong;
      return;
    }
    if ("actFPSQZoneMyFeed".equals(paramString))
    {
      y = paramLong;
      return;
    }
    if ("actFPSQZoneUserHome".equals(paramString))
    {
      z = paramLong;
      return;
    }
    if ("actFPSQZoneMoodList".equals(paramString)) {
      A = paramLong;
    }
  }
  
  private static String b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000)
        {
          switch (paramInt)
          {
          default: 
            return null;
          case 10: 
            return s;
          case 9: 
            return r;
          case 8: 
            return q;
          case 7: 
            return p;
          case 6: 
            return o;
          case 5: 
            return n;
          case 4: 
            return m;
          }
          return l;
        }
        return k;
      }
      return j;
    }
    return i;
  }
  
  private static boolean b(String paramString)
  {
    long l1;
    if ("actFPSAIO".equals(paramString)) {
      l1 = u;
    } else if ("actFPSRecent".equals(paramString)) {
      l1 = v;
    } else if ("actFPSFriend".equals(paramString)) {
      l1 = w;
    } else {
      l1 = 0L;
    }
    boolean bool = false;
    if (l1 == 0L) {
      return false;
    }
    if ((float)(SystemClock.uptimeMillis() - l1) / 1000.0F < 10.0F) {
      bool = true;
    }
    return bool;
  }
  
  private static SharedPreferences d()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    int i1;
    if (Build.VERSION.SDK_INT > 10) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    return localBaseApplication.getSharedPreferences("PerformanceReportUtils", i1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.tools.PerformanceReportUtils
 * JD-Core Version:    0.7.0.1
 */