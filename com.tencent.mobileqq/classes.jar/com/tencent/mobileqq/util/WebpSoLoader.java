package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class WebpSoLoader
{
  public static int[] a;
  
  private static int a()
  {
    if ((!Build.CPU_ABI.equalsIgnoreCase("x86")) && (!Build.CPU_ABI2.equalsIgnoreCase("x86")) && (!Build.CPU_ABI.equalsIgnoreCase("mips")))
    {
      if (Build.CPU_ABI2.equalsIgnoreCase("mips")) {
        return -2;
      }
      String str = a(BaseApplication.getContext());
      if (str != null)
      {
        if (Build.VERSION.SDK_INT < 8) {
          return -2;
        }
        StringBuilder localStringBuilder;
        if (Build.VERSION.SDK_INT < 9)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("libwebp-");
          localStringBuilder.append("22.so");
          str = localStringBuilder.toString();
        }
        else if (Build.VERSION.SDK_INT < 11)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("libwebp-");
          localStringBuilder.append("23.so");
          str = localStringBuilder.toString();
        }
        else
        {
          if (Build.VERSION.SDK_INT >= 17) {
            break label274;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("libwebp-");
          localStringBuilder.append("41.so");
          str = localStringBuilder.toString();
        }
        if (new File(str).exists())
        {
          try
          {
            System.load(str);
            int i = nativeGetDecoderVersion();
            a = new int[4];
            a[0] = (i >> 16);
            a[1] = ((0xFF00 & i) >> 8);
            a[2] = (i & 0xFF);
            i = nativeSetup();
            return i;
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
        else
        {
          return -3;
          label274:
          return -2;
        }
      }
      return -1;
    }
    return -2;
  }
  
  public static String a(Context paramContext)
  {
    Object localObject = null;
    if (paramContext == null) {
      return null;
    }
    File localFile = paramContext.getFilesDir();
    paramContext = localObject;
    if (localFile != null)
    {
      paramContext = new StringBuilder();
      paramContext.append(localFile.getParent());
      paramContext.append("/txlib/");
      paramContext = paramContext.toString();
    }
    return paramContext;
  }
  
  public static void a(String paramString)
  {
    if ((a != null) && (paramString != null) && ((paramString.contains("libwebp-")) || (paramString.contains("libskia"))))
    {
      BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).edit().putBoolean("WebpHookSupported", false).commit();
      a = null;
      if (QLog.isColorLevel()) {
        QLog.d("WebpSoLoader", 2, String.format("Crash in libwebp support library at %s process!", new Object[] { MsfSdkUtils.getProcessName(BaseApplication.getContext()) }));
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT >= 8) && (Build.VERSION.SDK_INT < 17))
    {
      BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).edit().putBoolean("WebpHookEnabled", paramBoolean).commit();
      if (QLog.isColorLevel())
      {
        String str;
        if (paramBoolean) {
          str = "enable";
        } else {
          str = "disable";
        }
        QLog.d("WebpSoLoader", 2, String.format("Set WebpSoLoader %s", new Object[] { str }));
      }
    }
  }
  
  public static boolean a()
  {
    Object localObject = a;
    boolean bool = false;
    if (localObject == null)
    {
      localObject = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
      if ((((SharedPreferences)localObject).getBoolean("WebpHookEnabled", true)) && (((SharedPreferences)localObject).getBoolean("WebpHookSupported", true)))
      {
        int i = a();
        if (i != 0)
        {
          if (-3 != i)
          {
            a = null;
            ((SharedPreferences)localObject).edit().putBoolean("WebpHookSupported", false).commit();
            if (QLog.isColorLevel()) {
              if (-1 == i) {
                QLog.d("WebpSoLoader", 2, "WebP support library load failed!");
              } else {
                QLog.d("WebpSoLoader", 2, "No need to load WebP support library");
              }
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("WebpSoLoader", 2, "WebP support library not ready");
          }
        }
        else
        {
          if (!((SharedPreferences)localObject).contains("WebpHookEnabled")) {
            ((SharedPreferences)localObject).edit().putBoolean("WebpHookEnabled", true).commit();
          }
          if (QLog.isColorLevel()) {
            QLog.d("WebpSoLoader", 2, "WebP support library load success!");
          }
        }
      }
    }
    if (a != null) {
      bool = true;
    }
    return bool;
  }
  
  public static int[] a()
  {
    int[] arrayOfInt = a;
    if (arrayOfInt != null) {
      return arrayOfInt;
    }
    int i = Build.VERSION.SDK_INT;
    if ((i >= 14) && (i <= 15)) {
      return new int[] { 0, 1, 2, 0 };
    }
    if (16 == i) {
      return new int[] { 0, 1, 2, 0 };
    }
    if (17 == i) {
      return new int[] { 0, 2, 0, 0 };
    }
    if (18 == i) {
      return new int[] { 0, 2, 1, 0 };
    }
    if (19 == i) {
      return new int[] { 0, 3, 2, 0 };
    }
    if (i > 19) {
      return new int[] { 0, 4, 1, 0 };
    }
    return null;
  }
  
  public static boolean b()
  {
    if ((Build.VERSION.SDK_INT >= 8) && (Build.VERSION.SDK_INT < 17))
    {
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
      if ((localSharedPreferences.getBoolean("WebpHookEnabled", false)) && (localSharedPreferences.getBoolean("WebpHookSupported", true))) {
        return true;
      }
    }
    return false;
  }
  
  private static native int nativeGetDecoderVersion();
  
  private static native int nativeSetup();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.WebpSoLoader
 * JD-Core Version:    0.7.0.1
 */