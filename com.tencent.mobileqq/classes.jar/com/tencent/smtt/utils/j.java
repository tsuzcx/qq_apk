package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.c;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

public class j
{
  private static SharedPreferences a;
  private static SharedPreferences.Editor b;
  
  private static String a()
  {
    try
    {
      String str = Build.SERIAL;
      if (!TextUtils.isEmpty(str)) {
        if (!str.contains("unknown")) {
          return str;
        }
      }
      str = b();
      return str;
    }
    catch (Exception localException)
    {
      return "unknown";
    }
    return localException;
  }
  
  public static String a(Context paramContext)
  {
    if (!c(paramContext)) {
      return "";
    }
    a = paramContext.getApplicationContext().getSharedPreferences("tsui", 0);
    Object localObject = a;
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).getString("tsui", "");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return localObject;
      }
    }
    localObject = new StringBuilder();
    String str1 = b();
    String str2 = b.k(paramContext);
    String str3 = a();
    String str4 = b(paramContext).replace("-", "");
    if ((str1 != null) && (str1.length() > 0))
    {
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append("|");
    }
    if ((str2 != null) && (str2.length() > 0))
    {
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append("|");
    }
    if ((str3 != null) && (str3.length() > 0))
    {
      ((StringBuilder)localObject).append(str3);
      ((StringBuilder)localObject).append("|");
    }
    if ((str4 != null) && (str4.length() > 0)) {
      ((StringBuilder)localObject).append(str4);
    }
    if (((StringBuilder)localObject).length() > 0) {}
    try
    {
      localObject = a(a(((StringBuilder)localObject).toString()));
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        a(paramContext, "tsui", (String)localObject);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      label219:
      break label219;
    }
    localObject = UUID.randomUUID().toString().replace("-", "");
    a(paramContext, "tsui", (String)localObject);
    return localObject;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString().toUpperCase(Locale.CHINA);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (a == null) {
      a = paramContext.getApplicationContext().getSharedPreferences("tsui", 0);
    }
    b = a.edit();
    b.putString(paramString1, paramString2);
    b.commit();
  }
  
  private static byte[] a(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      localMessageDigest.reset();
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = localMessageDigest.digest();
      return paramString;
    }
    catch (Exception paramString)
    {
      label27:
      break label27;
    }
    return "".getBytes();
  }
  
  private static String b()
  {
    int i = new Random().nextInt(2147483646);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.FINGERPRINT);
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  private static String b(Context paramContext)
  {
    try
    {
      paramContext = q.d(paramContext);
      int i = new Random().nextInt(2147483646);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      localStringBuilder.append(Build.BOARD.length() % 10);
      localStringBuilder.append(Build.BRAND.length() % 10);
      localStringBuilder.append(Build.DEVICE.length() % 10);
      localStringBuilder.append(Build.HARDWARE.length() % 10);
      localStringBuilder.append(Build.ID.length() % 10);
      localStringBuilder.append(paramContext.length() % 10);
      localStringBuilder.append(Build.PRODUCT.length() % 10);
      localStringBuilder.append(Build.SERIAL.length() % 10);
      paramContext = new UUID(localStringBuilder.toString().hashCode(), Build.SERIAL.hashCode()).toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  private static boolean c(Context paramContext)
  {
    boolean bool1 = true;
    try
    {
      boolean bool2 = paramContext.getSharedPreferences("sai", 0).getBoolean("sui", true);
      bool1 = bool2;
      localStringBuilder = new StringBuilder();
      bool1 = bool2;
      localStringBuilder.append("isSDKUIDEnable is ");
      bool1 = bool2;
      localStringBuilder.append(bool2);
      bool1 = bool2;
      Log.d("SDKUID", localStringBuilder.toString());
      bool1 = bool2;
      localStringBuilder = new StringBuilder();
      bool1 = bool2;
      localStringBuilder.append("isSDKUIDEnable is ");
      bool1 = bool2;
      localStringBuilder.append(bool2);
      bool1 = bool2;
      TbsLog.i("SDKUID", localStringBuilder.toString());
      bool1 = bool2;
      c.a().a(paramContext, Integer.valueOf(1002), new j.1(paramContext));
      return bool2;
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stack is ");
      localStringBuilder.append(Log.getStackTraceString(paramContext));
      TbsLog.i("SDKUID", localStringBuilder.toString());
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.utils.j
 * JD-Core Version:    0.7.0.1
 */