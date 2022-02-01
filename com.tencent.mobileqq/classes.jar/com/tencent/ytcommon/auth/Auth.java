package com.tencent.ytcommon.auth;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.File;
import java.io.InputStream;

public class Auth
{
  private static final String LIC_FILE_NAME = ".youtu_common.lic";
  private static final String TAG = "youtu-common";
  private static long handle = 0L;
  private static String licensePath = "";
  
  public static boolean check()
  {
    boolean bool = nativeCheck(handle);
    Log.d("sdk", "--------------check");
    return bool;
  }
  
  public static int getAuthResult()
  {
    long l = handle;
    if (l != 0L) {
      return getCurrentAuthStatus(l);
    }
    Log.w("sdk", "you should call YTCommonInterface.initAuth() first");
    return -1;
  }
  
  private static native int getCurrentAuthStatus(long paramLong);
  
  public static long getEndTime()
  {
    return nativeGetEndTime(handle);
  }
  
  public static native String getFailedReason(int paramInt);
  
  public static long getHandle()
  {
    return handle;
  }
  
  public static String getLicensePath()
  {
    return licensePath;
  }
  
  public static int getVersion()
  {
    return nativeGetVersion();
  }
  
  public static int init(Context paramContext, String paramString, int paramInt)
  {
    YTLog.d("youtu-common", "start init");
    if (Build.VERSION.SDK_INT >= 29) {}
    while ((Build.VERSION.SDK_INT >= 23) && (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0))
    {
      bool1 = false;
      break;
    }
    boolean bool1 = true;
    if (paramInt == 0) {}
    try
    {
      InputStream localInputStream = paramContext.getAssets().open(paramString, 0);
      if (localInputStream == null) {
        return -10;
      }
      localInputStream.close();
      break label99;
      if (paramInt == 2)
      {
        boolean bool2 = new File(paramString).exists();
        if (!bool2) {
          return -10;
        }
      }
      label99:
      handle = nativeInitN(paramContext, paramInt, paramString, paramContext.getAssets(), paramString, bool1);
      paramContext = new StringBuilder();
      paramContext.append("handleinit: ");
      paramContext.append(handle);
      YTLog.d("youtu-common", paramContext.toString());
      return getCurrentAuthStatus(handle);
    }
    catch (Exception paramContext) {}
    return -10;
  }
  
  public static int init(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (licensePath.isEmpty())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getFilesDir().getPath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append(".youtu_common.lic");
      licensePath = localStringBuilder.toString();
    }
    else if ((Build.VERSION.SDK_INT >= 23) && (paramContext.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))
    {
      Log.e("youtu-common", "WRITE_EXTERNAL_STORAGE permission required.");
      return 2004;
    }
    if (Build.VERSION.SDK_INT >= 29) {}
    while ((Build.VERSION.SDK_INT >= 23) && (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0))
    {
      bool = false;
      break;
    }
    boolean bool = true;
    paramInt = (int)nativeGetLicense(paramContext, paramString1, paramString2, getLicensePath(), paramInt, bool, paramString3);
    if (paramInt == 0)
    {
      handle = nativeInitN(paramContext, 2, getLicensePath(), paramContext.getAssets(), getLicensePath(), bool);
      if (getCurrentAuthStatus(handle) != 0)
      {
        paramInt = (int)nativeGetLicense(paramContext, paramString1, paramString2, getLicensePath(), 1, bool, paramString3);
        if (paramInt == 0)
        {
          handle = nativeInitN(paramContext, 2, getLicensePath(), paramContext.getAssets(), getLicensePath(), bool);
          return getCurrentAuthStatus(handle);
        }
        return paramInt;
      }
      return getCurrentAuthStatus(handle);
    }
    return paramInt;
  }
  
  public static int initAuthForQQ(Context paramContext)
  {
    YTLog.d("youtu-common", "start init");
    if (Build.VERSION.SDK_INT >= 29) {}
    while ((Build.VERSION.SDK_INT >= 23) && (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0))
    {
      bool = false;
      break;
    }
    boolean bool = true;
    handle = nativeInitN(paramContext, 1, "oWxLt1xJmA2/uaL5b3J2OoXQuppLT0Su2szcfjfKvPiuDF40cJoVL+9UUfHwStdYs6QEDV1cYTR4i/S2HAQurX+asnVcb4AW+O5XfqUMBdN/mrJ1XG+AFhqs/yTHjNBNvmckDgBPCL/vrpjjD7plQjxYvUs2iVQEbpBaXarIXV08WL1LNolUBFs8CRb9zOHrZJQ6DQN60oe+XZVkgYkU63CUs7duFYmHZJQ6DQN60oe+XZVkgYkU63CUs7duFYmHeJyPkwbK322b8YymrUh2ls8g0VH/nH5kDsvY1CWKAle+ZyQOAE8Ivxo3SsZQSeHUmh3cVajW+kOm9qMOF5WIwIGnICZWiBx8PFi9SzaJVASDGTlJVChdTmfCCgpLkdLXRcwQnvqHFVXxZYDjK9TEFo/OQptjkTvwTmOwMbacnJ0E8l3uYLZ8IKQkrbUL8A/NpZ32SXyB4MqSA6oIJS7ygp1o8RUPT2hPw7ViurRuxSLDtWK6tG7FIsO1Yrq0bsUiLYiW0fpoPV0vMxAmJlT9Hi8zECYmVP0eLzMQJiZU/R7iHhNgzhesl4rkPMbKDg0m/0tvBQ5nJ5w1WHaXQvj4Iw==", paramContext.getAssets(), "oWxLt1xJmA2/uaL5b3J2OoXQuppLT0Su2szcfjfKvPiuDF40cJoVL+9UUfHwStdYs6QEDV1cYTR4i/S2HAQurX+asnVcb4AW+O5XfqUMBdN/mrJ1XG+AFhqs/yTHjNBNvmckDgBPCL/vrpjjD7plQjxYvUs2iVQEbpBaXarIXV08WL1LNolUBFs8CRb9zOHrZJQ6DQN60oe+XZVkgYkU63CUs7duFYmHZJQ6DQN60oe+XZVkgYkU63CUs7duFYmHeJyPkwbK322b8YymrUh2ls8g0VH/nH5kDsvY1CWKAle+ZyQOAE8Ivxo3SsZQSeHUmh3cVajW+kOm9qMOF5WIwIGnICZWiBx8PFi9SzaJVASDGTlJVChdTmfCCgpLkdLXRcwQnvqHFVXxZYDjK9TEFo/OQptjkTvwTmOwMbacnJ0E8l3uYLZ8IKQkrbUL8A/NpZ32SXyB4MqSA6oIJS7ygp1o8RUPT2hPw7ViurRuxSLDtWK6tG7FIsO1Yrq0bsUiLYiW0fpoPV0vMxAmJlT9Hi8zECYmVP0eLzMQJiZU/R7iHhNgzhesl4rkPMbKDg0m/0tvBQ5nJ5w1WHaXQvj4Iw==", bool);
    paramContext = new StringBuilder();
    paramContext.append("handleinit: ");
    paramContext.append(handle);
    YTLog.d("youtu-common", paramContext.toString());
    return getCurrentAuthStatus(handle);
  }
  
  private static native boolean nativeCheck(long paramLong);
  
  private static native long nativeGetEndTime(long paramLong);
  
  private static native long nativeGetLicense(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean, String paramString4);
  
  private static native int nativeGetVersion();
  
  private static native long nativeInitN(Context paramContext, int paramInt, String paramString1, AssetManager paramAssetManager, String paramString2, boolean paramBoolean);
  
  private static native int nativeSetSerial(String paramString);
  
  public static void setLicensePath(String paramString)
  {
    licensePath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.ytcommon.auth.Auth
 * JD-Core Version:    0.7.0.1
 */