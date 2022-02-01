package com.tencent.thumbplayer.config;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.thumbplayer.core.config.TPPlayerCoreConfig;
import com.tencent.thumbplayer.utils.TPLogUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class TPPlayerConfig
{
  private static String DOT = "\\.";
  private static final String HOST_CONFIG_KEY = "host_config";
  public static final boolean ISOTT = false;
  private static final String TAG = "TPPlayerConfig";
  public static final String VERSION = "2.8.0.1104";
  private static String appVersion = "";
  private static String appVersionName;
  public static String beacon_log_host;
  public static String beacon_policy_host;
  private static long buildNum = -1L;
  private static String host_config;
  private static String mGuid = "";
  private static String mOutNetIp;
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
    mOutNetIp = "";
    mUseP2P = true;
    mPlatform = -1;
    beacon_policy_host = "";
    beacon_log_host = "";
    host_config = "";
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
  
  public static String getOutNetIp()
  {
    return mOutNetIp;
  }
  
  public static int getPlatform()
  {
    return mPlatform;
  }
  
  public static String getProxyCacheDir(int paramInt)
  {
    return (String)mProxyCacheDirs.get(paramInt);
  }
  
  public static String getProxyConfigDir()
  {
    JSONObject localJSONObject = new JSONObject();
    if (!TextUtils.isEmpty(host_config)) {}
    try
    {
      localJSONObject.put("host_config", new JSONObject(host_config));
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        TPLogUtil.e("TPPlayerConfig", localJSONException);
      }
    }
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
  
  public static int getVideoMediaCodecCoexistMaxCnt()
  {
    return TPPlayerCoreConfig.getVideoMediaCodecCoexistMaxCnt();
  }
  
  public static boolean isUseP2P()
  {
    return mUseP2P;
  }
  
  public static boolean isUserIsVip()
  {
    return mUserIsVip;
  }
  
  public static void parseHostConfig(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      TPLogUtil.w("TPPlayerConfig", "parseHostConfig, config is null.");
    }
    for (;;)
    {
      return;
      host_config = paramString;
      TPLogUtil.i("TPPlayerConfig", "parseHostConfig:" + paramString);
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("player_host_config"))
        {
          paramString = paramString.getJSONObject("player_host_config");
          if (paramString.has("beacon_policy_host")) {
            beacon_policy_host = paramString.getString("beacon_policy_host");
          }
          if (paramString.has("beacon_log_host"))
          {
            beacon_log_host = paramString.getString("beacon_log_host");
            return;
          }
        }
      }
      catch (Throwable paramString)
      {
        TPLogUtil.w("TPPlayerConfig", "parseHostConfig exception: " + paramString.toString());
      }
    }
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    TPLogUtil.setDebugEnable(paramBoolean);
  }
  
  public static void setGuid(String paramString)
  {
    mGuid = paramString;
  }
  
  public static void setOutNetIp(String paramString)
  {
    mOutNetIp = paramString;
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
  
  public static void setVideoMediaCodecCoexistMaxCnt(int paramInt)
  {
    TPPlayerCoreConfig.setVideoMediaCodecCoexistMaxCnt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.config.TPPlayerConfig
 * JD-Core Version:    0.7.0.1
 */