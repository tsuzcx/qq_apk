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
    if ((Build.VERSION.SDK_INT >= 23) && (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0)) {}
    for (;;)
    {
      if (paramInt == 0) {}
      for (;;)
      {
        try
        {
          InputStream localInputStream = paramContext.getAssets().open(paramString, 0);
          if (localInputStream == null) {
            return -10;
          }
          localInputStream.close();
          handle = nativeInitN(paramContext, paramInt, paramString, paramContext.getAssets(), paramString, bool1);
          YTLog.d("youtu-common", "handleinit: " + handle);
          return getCurrentAuthStatus(handle);
        }
        catch (Exception paramContext)
        {
          boolean bool2;
          return -10;
        }
        if (paramInt == 2)
        {
          bool2 = new File(paramString).exists();
          if (!bool2) {
            return -10;
          }
        }
      }
      bool1 = true;
    }
  }
  
  public static int init(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (licensePath.isEmpty())
    {
      licensePath = paramContext.getFilesDir().getPath() + File.separator + ".youtu_common.lic";
      if ((Build.VERSION.SDK_INT < 23) || (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
        break label207;
      }
    }
    label200:
    label207:
    for (boolean bool = false;; bool = true)
    {
      int i = (int)nativeGetLicense(paramContext, paramString1, paramString2, getLicensePath(), paramInt, bool, paramString3);
      paramInt = i;
      if (i == 0)
      {
        handle = nativeInitN(paramContext, 2, getLicensePath(), paramContext.getAssets(), getLicensePath(), bool);
        if (getCurrentAuthStatus(handle) == 0) {
          break label200;
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
      return getCurrentAuthStatus(handle);
    }
  }
  
  private static native boolean nativeCheck(long paramLong);
  
  private static native long nativeGetEndTime(long paramLong);
  
  private static native long nativeGetLicense(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean, String paramString4);
  
  private static native int nativeGetVersion();
  
  private static native long nativeInitN(Context paramContext, int paramInt, String paramString1, AssetManager paramAssetManager, String paramString2, boolean paramBoolean);
  
  public static void setLicensePath(String paramString)
  {
    licensePath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ytcommon.auth.Auth
 * JD-Core Version:    0.7.0.1
 */