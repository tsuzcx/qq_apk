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
    if (handle != 0L) {
      return getCurrentAuthStatus(handle);
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
    boolean bool1 = false;
    YTLog.d("youtu-common", "start init");
    if ((Build.VERSION.SDK_INT < 29) || (paramInt == 0)) {}
    do
    {
      do
      {
        boolean bool2;
        try
        {
          InputStream localInputStream = paramContext.getAssets().open(paramString, 0);
          if (localInputStream == null)
          {
            return -10;
            if ((Build.VERSION.SDK_INT >= 23) && (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0)) {
              break;
            }
            bool1 = true;
            break;
          }
          localInputStream.close();
          handle = nativeInitN(paramContext, paramInt, paramString, paramContext.getAssets(), paramString, bool1);
          YTLog.d("youtu-common", "handleinit: " + handle);
          return getCurrentAuthStatus(handle);
        }
        catch (Exception paramContext) {}
      } while (paramInt != 2);
      bool2 = new File(paramString).exists();
    } while (bool2);
    return -10;
    return -10;
  }
  
  public static int init(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool = false;
    if (licensePath.isEmpty())
    {
      licensePath = paramContext.getFilesDir().getPath() + File.separator + ".youtu_common.lic";
      if (Build.VERSION.SDK_INT < 29) {
        break label191;
      }
    }
    for (;;)
    {
      int i = (int)nativeGetLicense(paramContext, paramString1, paramString2, getLicensePath(), paramInt, bool, paramString3);
      paramInt = i;
      if (i == 0)
      {
        handle = nativeInitN(paramContext, 2, getLicensePath(), paramContext.getAssets(), getLicensePath(), bool);
        if (getCurrentAuthStatus(handle) == 0) {
          break label214;
        }
        i = (int)nativeGetLicense(paramContext, paramString1, paramString2, getLicensePath(), 1, bool, paramString3);
        paramInt = i;
        if (i == 0)
        {
          handle = nativeInitN(paramContext, 2, getLicensePath(), paramContext.getAssets(), getLicensePath(), bool);
          paramInt = getCurrentAuthStatus(handle);
        }
      }
      return paramInt;
      if ((Build.VERSION.SDK_INT < 23) || (paramContext.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
        break;
      }
      Log.e("youtu-common", "WRITE_EXTERNAL_STORAGE permission required.");
      return 2004;
      label191:
      if ((Build.VERSION.SDK_INT < 23) || (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
        bool = true;
      }
    }
    label214:
    return getCurrentAuthStatus(handle);
  }
  
  public static int initAuthForQQ(Context paramContext)
  {
    boolean bool = false;
    YTLog.d("youtu-common", "start init");
    if (Build.VERSION.SDK_INT >= 29) {}
    for (;;)
    {
      handle = nativeInitN(paramContext, 1, "oWxLt1xJmA2/uaL5b3J2OoXQuppLT0Su2szcfjfKvPiuDF40cJoVL+9UUfHwStdYs6QEDV1cYTR4i/S2HAQurX+asnVcb4AW+O5XfqUMBdN/mrJ1XG+AFhqs/yTHjNBNvmckDgBPCL/vrpjjD7plQjxYvUs2iVQEbpBaXarIXV08WL1LNolUBFs8CRb9zOHrZJQ6DQN60oe+XZVkgYkU63CUs7duFYmHZJQ6DQN60oe+XZVkgYkU63CUs7duFYmHeJyPkwbK322b8YymrUh2ls8g0VH/nH5kDsvY1CWKAle+ZyQOAE8Ivxo3SsZQSeHUmh3cVajW+kOm9qMOF5WIwIGnICZWiBx8PFi9SzaJVASDGTlJVChdTmfCCgpLkdLXRcwQnvqHFVXxZYDjK9TEFo/OQptjkTvwTmOwMbacnJ0E8l3uYLZ8IKQkrbUL8A/NpZ32SXyB4MqSA6oIJS7ygp1o8RUPT2hPw7ViurRuxSLDtWK6tG7FIsO1Yrq0bsUiLYiW0fpoPV0vMxAmJlT9Hi8zECYmVP0eLzMQJiZU/R7iHhNgzhesl4rkPMbKDg0m/0tvBQ5nJ5w1WHaXQvj4Iw==", paramContext.getAssets(), "oWxLt1xJmA2/uaL5b3J2OoXQuppLT0Su2szcfjfKvPiuDF40cJoVL+9UUfHwStdYs6QEDV1cYTR4i/S2HAQurX+asnVcb4AW+O5XfqUMBdN/mrJ1XG+AFhqs/yTHjNBNvmckDgBPCL/vrpjjD7plQjxYvUs2iVQEbpBaXarIXV08WL1LNolUBFs8CRb9zOHrZJQ6DQN60oe+XZVkgYkU63CUs7duFYmHZJQ6DQN60oe+XZVkgYkU63CUs7duFYmHeJyPkwbK322b8YymrUh2ls8g0VH/nH5kDsvY1CWKAle+ZyQOAE8Ivxo3SsZQSeHUmh3cVajW+kOm9qMOF5WIwIGnICZWiBx8PFi9SzaJVASDGTlJVChdTmfCCgpLkdLXRcwQnvqHFVXxZYDjK9TEFo/OQptjkTvwTmOwMbacnJ0E8l3uYLZ8IKQkrbUL8A/NpZ32SXyB4MqSA6oIJS7ygp1o8RUPT2hPw7ViurRuxSLDtWK6tG7FIsO1Yrq0bsUiLYiW0fpoPV0vMxAmJlT9Hi8zECYmVP0eLzMQJiZU/R7iHhNgzhesl4rkPMbKDg0m/0tvBQ5nJ5w1WHaXQvj4Iw==", bool);
      YTLog.d("youtu-common", "handleinit: " + handle);
      return getCurrentAuthStatus(handle);
      if ((Build.VERSION.SDK_INT < 23) || (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
        bool = true;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.ytcommon.auth.Auth
 * JD-Core Version:    0.7.0.1
 */