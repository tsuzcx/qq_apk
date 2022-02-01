package com.tencent.open.business.viareport;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.business.base.OpenConfig;

public class ReportConfig
  extends BaseReportConfig
{
  public static int a(int paramInt)
  {
    int i;
    if (paramInt == 0)
    {
      i = OpenConfig.a(CommonDataAdapter.a().b(), null).d("Common_ViaSuccessRatioFrequencySuccess");
      paramInt = i;
      if (i == 0) {
        return 20;
      }
    }
    else
    {
      i = OpenConfig.a(CommonDataAdapter.a().b(), null).d("Common_ViaSuccessRatioFrequencyFail");
      paramInt = i;
      if (i == 0) {
        paramInt = 50;
      }
    }
    return paramInt;
  }
  
  public static String a()
  {
    if (CommonDataAdapter.a().b() == null) {
      return "";
    }
    return b().getString("uin", "");
  }
  
  public static void a(long paramLong)
  {
    if (CommonDataAdapter.a().b() == null) {
      return;
    }
    SharedPreferences.Editor localEditor = b().edit();
    localEditor.putLong("lastTime", paramLong);
    localEditor.commit();
  }
  
  public static void a(String paramString)
  {
    if (CommonDataAdapter.a().b() == null) {
      return;
    }
    SharedPreferences.Editor localEditor = b().edit();
    localEditor.putString("uin", paramString);
    localEditor.commit();
  }
  
  public static int b(String paramString)
  {
    int j = OpenConfig.a(CommonDataAdapter.a().b(), paramString).d("Common_BusinessReportFrequency");
    int i = j;
    if (j == 0) {
      i = 100;
    }
    return i;
  }
  
  protected static SharedPreferences b()
  {
    return CommonDataAdapter.a().b().getSharedPreferences("reportConfig", 0);
  }
  
  public static long c()
  {
    return CommonDataAdapter.a().b().getSharedPreferences("reportConfig", 0).getLong("lastTime", 0L);
  }
  
  public static int d()
  {
    int j = OpenConfig.a(CommonDataAdapter.a().b(), null).d("Common_BusinessReportMaxcount");
    int i = j;
    if (j == 0) {
      i = 20;
    }
    return i;
  }
  
  public static long e()
  {
    long l2 = OpenConfig.a(CommonDataAdapter.a().b(), null).e("Common_BusinessReportTimeinterval");
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 3600L;
    }
    return l1;
  }
  
  public static int f()
  {
    int j = OpenConfig.a(CommonDataAdapter.a().b(), null).d("Common_HttpRetryCount");
    int i = j;
    if (j == 0) {
      i = 2;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportConfig
 * JD-Core Version:    0.7.0.1
 */