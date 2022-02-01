package com.tencent.superplayer.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerSdkOption;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;

public class ConfigManager
{
  private static String GROUP_SEPARATOR = ".";
  public static final String RAIN_BOW_KEY = "07d79ecd-33f9-4b90-80cb-e12359816b34";
  private static String SP_FILE_NAME = "superPlayer-config";
  private static String SP_KEY_LAST_REQUEST_TIME = "last_request_time";
  private static final String TAG = "ConfigManager";
  private static ConfigManager mInstance = new ConfigManager();
  private CacheManager mCacheManager = new CacheManager();
  private ConfigManager.OnConfigCallback mCallback;
  private DataHandler mDataHandler = new DataHandler();
  private SharedPreferences mSharedPreferences;
  
  private ConfigManager()
  {
    this.mDataHandler.setCallback(new ConfigManager.1(this));
  }
  
  public static ConfigManager get()
  {
    return mInstance;
  }
  
  public static String groupName2OriginGroupName(String paramString)
  {
    return RequestRootGroup.getRequestRootGroup() + GROUP_SEPARATOR + paramString;
  }
  
  public static boolean needLoadConfig(int paramInt)
  {
    if (SuperPlayerSDKMgr.getContext() == null) {
      LogUtil.w("ConfigManager", "needLoadConfig false for context is null");
    }
    while ((SuperPlayerSDKMgr.getPlatform() == 170303) && (paramInt != 104)) {
      return false;
    }
    return true;
  }
  
  private boolean needRequest()
  {
    if (!CommonUtil.a())
    {
      LogUtil.w("ConfigManager", "This process is not main, not request.");
      return false;
    }
    if (!RequestRootGroup.needRequest())
    {
      LogUtil.w("ConfigManager", "Your app is not need to Request.");
      return false;
    }
    long l1 = (System.currentTimeMillis() - this.mSharedPreferences.getLong(SP_KEY_LAST_REQUEST_TIME, 0L)) / 1000L / 60L;
    long l2 = SuperPlayerSDKMgr.getSdkOption().configRequestIntervalInHour * 60;
    if (l1 < l2)
    {
      LogUtil.w("ConfigManager", "Your app is not need to Request. currentIntervalInMinute：" + l1 + ",    configRequestIntervalInMinute：" + l2);
      return false;
    }
    return true;
  }
  
  private void pullConfigFromServer()
  {
    new PullConfigRequest().executeRequest(RequestRootGroup.getRequestRootGroup(), new ConfigManager.2(this));
  }
  
  public CacheContent getCacheByOriginGroupName(String paramString)
  {
    return this.mCacheManager.get(paramString);
  }
  
  public CacheContent getConfig(String paramString)
  {
    paramString = groupName2OriginGroupName(paramString);
    return this.mCacheManager.get(paramString);
  }
  
  public void init()
  {
    if (SuperPlayerSDKMgr.getContext() == null) {}
    do
    {
      return;
      this.mSharedPreferences = SuperPlayerSDKMgr.getContext().getSharedPreferences(SP_FILE_NAME, 0);
    } while ((!SuperPlayerSDKMgr.getSdkOption().serverConfigEnable) || (!needRequest()));
    this.mSharedPreferences.edit().putLong(SP_KEY_LAST_REQUEST_TIME, System.currentTimeMillis()).apply();
    LogUtil.d("ConfigManager", "PullConfigFromServer from rainbow.");
    pullConfigFromServer();
  }
  
  public void setCallback(ConfigManager.OnConfigCallback paramOnConfigCallback)
  {
    this.mCallback = paramOnConfigCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.config.ConfigManager
 * JD-Core Version:    0.7.0.1
 */