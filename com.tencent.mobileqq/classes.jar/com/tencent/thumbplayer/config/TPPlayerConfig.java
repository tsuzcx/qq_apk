package com.tencent.thumbplayer.config;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.thumbplayer.utils.TPLogUtil;

public class TPPlayerConfig
{
  private static String DOT = "\\.";
  public static final boolean ISOTT = false;
  private static final String TAG = "TPPlayerConfig";
  public static final String VERSION = "1.3.0.1023";
  private static String appVersion = "";
  private static String appVersionName;
  private static long buildNum = -1L;
  private static String mGuid = "";
  private static int mPlatform;
  private static SparseArray<String> mProxyCacheDirs = new SparseArray(1);
  private static SparseArray<String> mProxyConfigStrs;
  private static SparseArray<String> mProxyDataDirs = new SparseArray(1);
  private static int mProxyServiceType;
  private static boolean mUseP2P;
  private static boolean mUserIsVip;
  private static String mUserUin;
  private static String mUserUpc;
  private static int mUserUpcState;
  
  static
  {
    mProxyConfigStrs = new SparseArray(1);
    mProxyServiceType = -1;
    mUserUpc = "";
    mUserUpcState = 0;
    mUseP2P = true;
    mPlatform = -1;
  }
  
  public static void addProxyCacheDir(int paramInt, String paramString)
  {
    mProxyCacheDirs.put(paramInt, paramString);
  }
  
  public static void addProxyConfigStr(int paramInt, String paramString)
  {
    mProxyConfigStrs.put(paramInt, paramString);
  }
  
  public static void addProxyDataDir(int paramInt, String paramString)
  {
    mProxyDataDirs.put(paramInt, paramString);
  }
  
  public static String getAppBigVersion(Context paramContext)
  {
    if (!TextUtils.isEmpty(appVersion)) {
      return appVersion;
    }
    String str = getAppVersionName(paramContext);
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = str.split(DOT);
      paramContext = str;
      if (arrayOfString != null)
      {
        paramContext = str;
        if (arrayOfString.length != 4) {}
      }
    }
    for (paramContext = str.substring(0, str.lastIndexOf("."));; paramContext = "0.0.0")
    {
      appVersion = paramContext;
      return paramContext;
    }
  }
  
  public static String getAppVersionName(Context paramContext)
  {
    Object localObject;
    if (!TextUtils.isEmpty(appVersionName)) {
      localObject = appVersionName;
    }
    for (;;)
    {
      return localObject;
      localObject = "";
      if (paramContext != null) {
        try
        {
          appVersionName = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
          paramContext = appVersionName;
          localObject = paramContext;
          if (paramContext == null) {
            return "";
          }
        }
        catch (Throwable paramContext) {}
      }
    }
    return "";
  }
  
  public static long getBuildNumber(Context paramContext)
  {
    if (-1L != buildNum) {
      return buildNum;
    }
    try
    {
      buildNum = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).getLongVersionCode();
      long l = buildNum;
      return l;
    }
    catch (Throwable paramContext)
    {
      TPLogUtil.e("TPPlayerConfig", "getLongVersionCode less api 28");
    }
    return buildNum;
  }
  
  public static String getGuid()
  {
    return mGuid;
  }
  
  public static int getPlatform()
  {
    return mPlatform;
  }
  
  public static String getProxyCacheDir(int paramInt)
  {
    return (String)mProxyCacheDirs.get(paramInt);
  }
  
  public static String getProxyConfigStr(int paramInt)
  {
    return (String)mProxyConfigStrs.get(paramInt);
  }
  
  public static String getProxyDataDir(int paramInt)
  {
    return (String)mProxyDataDirs.get(paramInt);
  }
  
  public static int getProxyServiceType()
  {
    if ((mProxyServiceType == -1) && (mPlatform != -1)) {
      return mPlatform;
    }
    return mProxyServiceType;
  }
  
  public static String getUserUin()
  {
    return mUserUin;
  }
  
  public static String getUserUpc()
  {
    return mUserUpc;
  }
  
  public static int getUserUpcState()
  {
    return mUserUpcState;
  }
  
  public static boolean isUseP2P()
  {
    return mUseP2P;
  }
  
  public static boolean isUserIsVip()
  {
    return mUserIsVip;
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    TPLogUtil.setDebugEnable(paramBoolean);
  }
  
  public static void setGuid(String paramString)
  {
    mGuid = paramString;
  }
  
  public static void setP2PEnable(boolean paramBoolean)
  {
    mUseP2P = paramBoolean;
  }
  
  public static void setPlatform(int paramInt)
  {
    mPlatform = paramInt;
  }
  
  public static void setProxyServiceType(int paramInt)
  {
    mProxyServiceType = paramInt;
  }
  
  public static void setUserIsVip(boolean paramBoolean)
  {
    mUserIsVip = paramBoolean;
  }
  
  public static void setUserUin(String paramString)
  {
    mUserUin = paramString;
  }
  
  public static void setUserUpc(String paramString)
  {
    mUserUpc = paramString;
  }
  
  public static void setUserUpcState(int paramInt)
  {
    mUserUpcState = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.config.TPPlayerConfig
 * JD-Core Version:    0.7.0.1
 */