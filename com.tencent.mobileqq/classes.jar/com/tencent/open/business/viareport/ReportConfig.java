package com.tencent.open.business.viareport;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.business.base.OpenConfig;

public class ReportConfig
  extends BaseReportConfig
{
  public static int a()
  {
    int j = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_BusinessReportMaxcount");
    int i = j;
    if (j == 0) {
      i = 20;
    }
    return i;
  }
  
  public static int a(int paramInt)
  {
    int i;
    if (paramInt == 0)
    {
      i = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_ViaSuccessRatioFrequencySuccess");
      paramInt = i;
      if (i == 0) {
        return 20;
      }
    }
    else
    {
      i = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_ViaSuccessRatioFrequencyFail");
      paramInt = i;
      if (i == 0) {
        paramInt = 50;
      }
    }
    return paramInt;
  }
  
  public static int a(String paramString)
  {
    int j = OpenConfig.a(CommonDataAdapter.a().a(), paramString).b("Common_BusinessReportFrequency");
    int i = j;
    if (j == 0) {
      i = 100;
    }
    return i;
  }
  
  public static long a()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("reportConfig", 0).getLong("lastTime", 0L);
  }
  
  protected static SharedPreferences a()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("reportConfig", 0);
  }
  
  public static String a()
  {
    if (CommonDataAdapter.a().a() == null) {
      return "";
    }
    return a().getString("uin", "");
  }
  
  public static void a(long paramLong)
  {
    if (CommonDataAdapter.a().a() == null) {
      return;
    }
    SharedPreferences.Editor localEditor = a().edit();
    localEditor.putLong("lastTime", paramLong);
    localEditor.commit();
  }
  
  public static void a(String paramString)
  {
    if (CommonDataAdapter.a().a() == null) {
      return;
    }
    SharedPreferences.Editor localEditor = a().edit();
    localEditor.putString("uin", paramString);
    localEditor.commit();
  }
  
  public static int b()
  {
    int j = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_HttpRetryCount");
    int i = j;
    if (j == 0) {
      i = 2;
    }
    return i;
  }
  
  public static long b()
  {
    long l2 = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_BusinessReportTimeinterval");
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 3600L;
    }
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportConfig
 * JD-Core Version:    0.7.0.1
 */