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
  public static int a = 0;
  private static long jdField_a_of_type_Long = 14400000L;
  private static String jdField_a_of_type_JavaLangString = "uiswitchinterval";
  public static boolean a = false;
  static String[] jdField_a_of_type_ArrayOfJavaLangString = { jdField_e_of_type_JavaLangString, jdField_f_of_type_JavaLangString, jdField_g_of_type_JavaLangString, jdField_h_of_type_JavaLangString, i, j, k };
  private static long jdField_b_of_type_Long = 0L;
  private static String jdField_b_of_type_JavaLangString = "uiswitchflag";
  private static long jdField_c_of_type_Long = 0L;
  private static String jdField_c_of_type_JavaLangString = "fpsinterval";
  private static long jdField_d_of_type_Long = 0L;
  private static String jdField_d_of_type_JavaLangString = "fpsflag";
  private static long jdField_e_of_type_Long = 0L;
  private static String jdField_e_of_type_JavaLangString = "actUISwitchC2C";
  private static long jdField_f_of_type_Long = 0L;
  private static String jdField_f_of_type_JavaLangString = "actUISwitchGroup";
  private static long jdField_g_of_type_Long = 0L;
  private static String jdField_g_of_type_JavaLangString = "actUISwitchDiscuss";
  private static long jdField_h_of_type_Long = 0L;
  private static String jdField_h_of_type_JavaLangString = "actUISwitchQzone";
  private static String i = "actUISwitchUserAlbum";
  private static String j = "actUISwitchQunAlbum";
  private static String k = "actUISwitchUserHome";
  private static String l = "actUISwitchPushBannerMyfeed";
  private static String m = "actUISwitchNotificationMyfeed";
  private static String n = "actUISwitchMyfeed";
  private static String o = "actUISwitchAioPreload";
  private static String p = "";
  
  static
  {
    b = 0L;
    c = 0L;
    d = 0L;
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
      b = paramLong;
      return;
    }
    if ("actFPSRecent".equals(paramString))
    {
      c = paramLong;
      return;
    }
    if ("actFPSFriend".equals(paramString))
    {
      d = paramLong;
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
    if ("actFPSQZoneMoodList".equals(paramString)) {
      jdField_h_of_type_Long = paramLong;
    }
  }
  
  private static SharedPreferences b()
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
  
  private static boolean b(String paramString)
  {
    long l1;
    if ("actFPSAIO".equals(paramString)) {
      l1 = b;
    } else if ("actFPSRecent".equals(paramString)) {
      l1 = c;
    } else if ("actFPSFriend".equals(paramString)) {
      l1 = d;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.tools.PerformanceReportUtils
 * JD-Core Version:    0.7.0.1
 */