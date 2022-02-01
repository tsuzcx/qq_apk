package com.tencent.xweb.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.xweb.a;
import com.tencent.xweb.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

public class c
{
  static HashMap<String, Long> a = new HashMap();
  
  public static void a(String paramString)
  {
    try
    {
      XWalkEnvironment.getMMKVSharedPreferences("FREQUENT_LIMITER").edit().putLong(paramString, 0L).commit();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static boolean a(String paramString, long paramLong)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dis_");
      ((StringBuilder)localObject).append(paramString);
      boolean bool = "true".equals(a.g(((StringBuilder)localObject).toString()));
      if (bool) {
        return false;
      }
      localObject = XWalkEnvironment.getMMKVSharedPreferences("FREQUENT_LIMITER");
      long l2 = ((SharedPreferences)localObject).getLong(paramString, 0L);
      long l1 = System.currentTimeMillis();
      l2 = Math.abs(l1 - l2);
      if (l2 < paramLong) {
        return false;
      }
      ((SharedPreferences)localObject).edit().putLong(paramString, l1).commit();
      return true;
    }
    finally {}
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    try
    {
      SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("xweb_value_changed");
      String str2 = localSharedPreferences.getString(paramString1, "");
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      boolean bool = str1.equals(paramString2);
      if (bool) {
        return false;
      }
      localSharedPreferences.edit().putString(paramString1, paramString2).commit();
      return true;
    }
    finally {}
  }
  
  public static boolean b(String paramString)
  {
    try
    {
      SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedTransportOld("REPORT_DAILY");
      String str = new SimpleDateFormat("yyyyMMdd").format(new Date());
      boolean bool = str.equals(localSharedPreferences.getString(paramString, ""));
      if (bool) {
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dis_");
      localStringBuilder.append(paramString);
      bool = "true".equals(b.o(localStringBuilder.toString()));
      if (bool) {
        return false;
      }
      localSharedPreferences.edit().putString(paramString, str).commit();
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.internal.c
 * JD-Core Version:    0.7.0.1
 */