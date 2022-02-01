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
  public static int a;
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString;
  public static boolean a;
  static String[] jdField_a_of_type_ArrayOfJavaLangString = { jdField_e_of_type_JavaLangString, jdField_f_of_type_JavaLangString, jdField_g_of_type_JavaLangString, jdField_h_of_type_JavaLangString, i, j, k };
  private static long jdField_b_of_type_Long = 0L;
  private static String jdField_b_of_type_JavaLangString;
  private static long jdField_c_of_type_Long = 0L;
  private static String jdField_c_of_type_JavaLangString;
  private static long jdField_d_of_type_Long = 0L;
  private static String jdField_d_of_type_JavaLangString;
  private static long jdField_e_of_type_Long = 0L;
  private static String jdField_e_of_type_JavaLangString;
  private static long jdField_f_of_type_Long = 0L;
  private static String jdField_f_of_type_JavaLangString;
  private static long jdField_g_of_type_Long = 0L;
  private static String jdField_g_of_type_JavaLangString;
  private static long jdField_h_of_type_Long = 0L;
  private static String jdField_h_of_type_JavaLangString;
  private static String i;
  private static String j;
  private static String k;
  private static String l;
  private static String m;
  private static String n;
  private static String o;
  private static String p;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_Long = 14400000L;
    jdField_a_of_type_JavaLangString = "uiswitchinterval";
    jdField_b_of_type_JavaLangString = "uiswitchflag";
    jdField_c_of_type_JavaLangString = "fpsinterval";
    jdField_d_of_type_JavaLangString = "fpsflag";
    jdField_e_of_type_JavaLangString = "actUISwitchC2C";
    jdField_f_of_type_JavaLangString = "actUISwitchGroup";
    jdField_g_of_type_JavaLangString = "actUISwitchDiscuss";
    jdField_h_of_type_JavaLangString = "actUISwitchQzone";
    i = "actUISwitchUserAlbum";
    j = "actUISwitchQunAlbum";
    k = "actUISwitchUserHome";
    l = "actUISwitchPushBannerMyfeed";
    m = "actUISwitchNotificationMyfeed";
    n = "actUISwitchMyfeed";
    o = "actUISwitchAioPreload";
    p = "";
  }
  
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
    if (QLog.isDevelopLevel()) {
      QLog.d("PerformanceReportUtils", 4, "reportFPS saveCompleteTime ：tag:" + paramString + ",time:" + paramLong);
    }
    if ("actFPSAIO".equals(paramString)) {
      jdField_b_of_type_Long = paramLong;
    }
    do
    {
      return;
      if ("actFPSRecent".equals(paramString))
      {
        jdField_c_of_type_Long = paramLong;
        return;
      }
      if ("actFPSFriend".equals(paramString))
      {
        jdField_d_of_type_Long = paramLong;
        return;
      }
      if ("actFPSQZoneFriendFeed".equals(paramString))
      {
        jdField_e_of_type_Long = paramLong;
        return;
      }
      if ("actFPSQZoneMyFeed".equals(paramString))
      {
        jdField_f_of_type_Long = paramLong;
        return;
      }
      if ("actFPSQZoneUserHome".equals(paramString))
      {
        jdField_g_of_type_Long = paramLong;
        return;
      }
    } while (!"actFPSQZoneMoodList".equals(paramString));
    jdField_h_of_type_Long = paramLong;
  }
  
  private static SharedPreferences b()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i1 = 4;; i1 = 0) {
      return localBaseApplication.getSharedPreferences("PerformanceReportUtils", i1);
    }
  }
  
  private static boolean b(String paramString)
  {
    long l1;
    if ("actFPSAIO".equals(paramString)) {
      l1 = jdField_b_of_type_Long;
    }
    for (;;)
    {
      if (l1 == 0L) {}
      while ((float)(SystemClock.uptimeMillis() - l1) / 1000.0F >= 10.0F)
      {
        return false;
        if ("actFPSRecent".equals(paramString))
        {
          l1 = jdField_c_of_type_Long;
          break;
        }
        if (!"actFPSFriend".equals(paramString)) {
          break label70;
        }
        l1 = jdField_d_of_type_Long;
        break;
      }
      return true;
      label70:
      l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.tools.PerformanceReportUtils
 * JD-Core Version:    0.7.0.1
 */