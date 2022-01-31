package com.tencent.mobileqq.olympic.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.InflaterInputStream;

public class OlympicUtil
{
  private static int jdField_a_of_type_Int = -1;
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private static int b = -1;
  
  public static long a(String paramString)
  {
    if (jdField_a_of_type_JavaTextSimpleDateFormat == null)
    {
      jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      jdField_a_of_type_JavaTextSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    long l2 = -1L;
    try
    {
      l1 = jdField_a_of_type_JavaTextSimpleDateFormat.parse(paramString).getTime();
      if (QLog.isColorLevel()) {
        QLog.d("OlympicUtil", 2, "data2Millis, date = " + paramString + ",millionSeconds = " + l1);
      }
      return l1;
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("OlympicUtil", 2, "", localParseException);
          l1 = l2;
        }
      }
    }
  }
  
  public static String a(long paramLong)
  {
    if (jdField_a_of_type_JavaTextSimpleDateFormat == null)
    {
      jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      jdField_a_of_type_JavaTextSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    Object localObject2 = null;
    try
    {
      localObject1 = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(paramLong));
      if (QLog.isColorLevel()) {
        QLog.d("OlympicUtil", 2, "millis2Date, milliseconds = " + paramLong + ",result = " + (String)localObject1);
      }
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("OlympicUtil", 2, "millis2Date, milliseconds = " + paramLong + ",exception = " + localException.getMessage());
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public static String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      if (paramString.startsWith("http://hb.url.cn/myapp/qq_desk/")) {
        return paramString.substring("http://hb.url.cn/myapp/qq_desk/".length());
      }
      str = paramString;
    } while (!paramString.startsWith("http://"));
    return paramString.substring("http://".length());
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("olympic", 0).edit().putLong(paramString, System.currentTimeMillis()).commit();
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (QLog.isColorLevel()))
    {
      int i = 0;
      while (i < paramVarArgs.length)
      {
        if (paramVarArgs[i] == null) {
          paramVarArgs[i] = "null";
        }
        i += 1;
      }
      QLog.d(paramString, 2, paramVarArgs);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    BaseApplicationImpl.getContext().getSharedPreferences("olympic", 0).edit().putBoolean("dpc_ar_entrance", paramBoolean).commit();
  }
  
  public static boolean a()
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("olympic", 0).getBoolean("dpc_ar_entrance", true);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    if (Math.abs(System.currentTimeMillis() - paramContext.getSharedPreferences("olympic", 0).getLong(paramString, -1L)) > 86400000L) {
      bool = true;
    }
    return bool;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("OlympicUtil", 2, "inflateConfigString");
        paramArrayOfByte.printStackTrace();
      }
      return null;
    }
    return paramArrayOfByte;
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString, 2, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.utils.OlympicUtil
 * JD-Core Version:    0.7.0.1
 */