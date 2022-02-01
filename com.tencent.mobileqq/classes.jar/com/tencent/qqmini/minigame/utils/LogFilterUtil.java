package com.tencent.qqmini.minigame.utils;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LogFilterUtil
{
  public static final Map<String, Set<String>> DEFAULT_BLACK_LIST;
  public static final Map<String, Set<String>> DEFAULT_WHITE_LIST = new HashMap();
  private static final String TAG = "LogFilterUtil";
  private static Map<String, Set<String>> mLogBlackList;
  private static Map<String, Set<String>> mLogWhiteList;
  
  static
  {
    DEFAULT_BLACK_LIST = new HashMap();
    Object localObject = new LogFilterUtil.1();
    DEFAULT_WHITE_LIST.put("onAudioStateChange", localObject);
    localObject = new LogFilterUtil.2();
    DEFAULT_WHITE_LIST.put("onSocketTaskStateChange", localObject);
    localObject = new LogFilterUtil.3();
    DEFAULT_WHITE_LIST.put("onDownloadTaskStateChange", localObject);
    localObject = new LogFilterUtil.4();
    DEFAULT_WHITE_LIST.put("onRequestTaskStateChange", localObject);
    DEFAULT_BLACK_LIST.put("createAudioInstance", null);
    DEFAULT_BLACK_LIST.put("setAudioState", null);
    DEFAULT_BLACK_LIST.put("getAudioState", null);
    DEFAULT_BLACK_LIST.put("operateAudio", null);
    DEFAULT_BLACK_LIST.put("destroyAudioInstance", null);
    DEFAULT_BLACK_LIST.put("onAudioStateChange", null);
    DEFAULT_BLACK_LIST.put("setInnerAudioOptionQGame", null);
    DEFAULT_BLACK_LIST.put("getAvailableAudioSources", null);
    DEFAULT_BLACK_LIST.put("loadFont", null);
    DEFAULT_BLACK_LIST.put("getTextLineHeight", null);
    DEFAULT_BLACK_LIST.put("showKeyboard", null);
    DEFAULT_BLACK_LIST.put("hideKeyboard", null);
    DEFAULT_BLACK_LIST.put("updateKeyboard", null);
    DEFAULT_BLACK_LIST.put("onKeyboardInput", null);
    DEFAULT_BLACK_LIST.put("onKeyboardConfirm", null);
    DEFAULT_BLACK_LIST.put("onKeyboardComplete", null);
    DEFAULT_BLACK_LIST.put("onDeviceOrientationChange", null);
    DEFAULT_BLACK_LIST.put("reportDataToDC", null);
    DEFAULT_BLACK_LIST.put("reportRealtimeAction", null);
    DEFAULT_BLACK_LIST.put("api_report", null);
    DEFAULT_BLACK_LIST.put("insertVideoPlayer", null);
    DEFAULT_BLACK_LIST.put("updateVideoPlayer", null);
    DEFAULT_BLACK_LIST.put("removeVideoPlayer", null);
    DEFAULT_BLACK_LIST.put("operateVideoPlayer", null);
    DEFAULT_BLACK_LIST.put("login", null);
    DEFAULT_BLACK_LIST.put("refreshSession", null);
    DEFAULT_BLACK_LIST.put("showShareMenu", null);
    DEFAULT_BLACK_LIST.put("showShareMenuWithShareTicket", null);
    DEFAULT_BLACK_LIST.put("hideShareMenu", null);
    DEFAULT_BLACK_LIST.put("updateShareMenuShareTicket", null);
    DEFAULT_BLACK_LIST.put("getShareInfo", null);
    DEFAULT_BLACK_LIST.put("profile", null);
    DEFAULT_BLACK_LIST.put("navigateToMiniProgramConfig", null);
    DEFAULT_BLACK_LIST.put("recordOffLineResourceState", null);
    DEFAULT_BLACK_LIST.put("private_openUrl", null);
    DEFAULT_BLACK_LIST.put("authorize", null);
    DEFAULT_BLACK_LIST.put("operateWXData", null);
    DEFAULT_BLACK_LIST.put("reportSubmitForm", null);
    DEFAULT_BLACK_LIST.put("getNativeUserInfo", null);
    DEFAULT_BLACK_LIST.put("getOpenDataUserInfo", null);
    DEFAULT_BLACK_LIST.put("getQua", null);
    DEFAULT_BLACK_LIST.put("notifyNative", null);
    DEFAULT_BLACK_LIST.put("getStoreAppList", null);
    DEFAULT_BLACK_LIST.put("wnsRequest", null);
    DEFAULT_BLACK_LIST.put("getNetworkType", null);
    DEFAULT_BLACK_LIST.put("onNetworkStatusChange", null);
    DEFAULT_BLACK_LIST.put("showToast", null);
    DEFAULT_BLACK_LIST.put("hideToast", null);
    DEFAULT_BLACK_LIST.put("showLoading", null);
    DEFAULT_BLACK_LIST.put("hideLoading", null);
    DEFAULT_BLACK_LIST.put("showModal", null);
    DEFAULT_BLACK_LIST.put("showActionSheet", null);
    DEFAULT_BLACK_LIST.put("setScreenBrightness", null);
    DEFAULT_BLACK_LIST.put("getScreenBrightness", null);
    DEFAULT_BLACK_LIST.put("setKeepScreenOn", null);
    DEFAULT_BLACK_LIST.put("getBatteryInfo", null);
    DEFAULT_BLACK_LIST.put("getBatteryInfoSync", null);
    DEFAULT_BLACK_LIST.put("getClipboardData", null);
    DEFAULT_BLACK_LIST.put("setClipboardData", null);
    DEFAULT_BLACK_LIST.put("enableAccelerometer", null);
    DEFAULT_BLACK_LIST.put("enableCompass", null);
    DEFAULT_BLACK_LIST.put("enableGyroscope", null);
    DEFAULT_BLACK_LIST.put("enableDeviceMotionChangeListening", null);
    DEFAULT_BLACK_LIST.put("vibrateShort", null);
    DEFAULT_BLACK_LIST.put("vibrateLong", null);
    DEFAULT_BLACK_LIST.put("onAccelerometerChange", null);
    DEFAULT_BLACK_LIST.put("onCompassChange", null);
    DEFAULT_BLACK_LIST.put("onGyroscopeChange", null);
    DEFAULT_BLACK_LIST.put("onDeviceMotionChange", null);
    DEFAULT_BLACK_LIST.put("removeStorage", null);
    DEFAULT_BLACK_LIST.put("removeStorageSync", null);
    DEFAULT_BLACK_LIST.put("setStorage", null);
    DEFAULT_BLACK_LIST.put("setStorageSync", null);
    DEFAULT_BLACK_LIST.put("clearStorage", null);
    DEFAULT_BLACK_LIST.put("clearStorageSync", null);
    DEFAULT_BLACK_LIST.put("getStorage", null);
    DEFAULT_BLACK_LIST.put("getStorageSync", null);
    DEFAULT_BLACK_LIST.put("getStorageInfo", null);
    DEFAULT_BLACK_LIST.put("getStorageInfoSync", null);
    DEFAULT_BLACK_LIST.put("getGlobalStorage", null);
    DEFAULT_BLACK_LIST.put("setGlobalStorage", null);
    DEFAULT_BLACK_LIST.put("createRewardedVideoAd", null);
    DEFAULT_BLACK_LIST.put("operateRewardedAd", null);
    DEFAULT_BLACK_LIST.put("onRewardedVideoStateChange", null);
    DEFAULT_BLACK_LIST.put("createBannerAd", null);
    DEFAULT_BLACK_LIST.put("operateBannerAd", null);
    DEFAULT_BLACK_LIST.put("updateBannerAdSize", null);
    DEFAULT_BLACK_LIST.put("onBannerAdStateChange", null);
    DEFAULT_BLACK_LIST.put("onBannerAdShowDone", null);
    DEFAULT_BLACK_LIST.put("setEnableDebug", null);
    DEFAULT_BLACK_LIST.put("onMemoryWarning", null);
    DEFAULT_BLACK_LIST.put("setStatusBarStyle", null);
    DEFAULT_BLACK_LIST.put("setMenuStyle", null);
    DEFAULT_BLACK_LIST.put("getOpenDataContext", null);
    DEFAULT_BLACK_LIST.put("onMessage", null);
    DEFAULT_BLACK_LIST.put("onDownloadTaskStateChange", null);
    DEFAULT_BLACK_LIST.put("onSocketTaskStateChange", null);
    DEFAULT_BLACK_LIST.put("onRequestTaskStateChange", null);
  }
  
  public static Map<String, Set<String>> getLogBlackList()
  {
    if (mLogBlackList == null)
    {
      mLogBlackList = new HashMap(DEFAULT_BLACK_LIST);
      Object localObject = WnsConfig.getConfig("qqtriton", "MiniGameAPILogBlackList");
      GameLog.getInstance().i("LogFilterUtil", "wns config black list: " + (String)localObject);
      localObject = parseConfigString2Set((String)localObject);
      if (localObject != null)
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (!TextUtils.isEmpty(str)) {
            mLogBlackList.put(str, null);
          }
        }
      }
    }
    return mLogBlackList;
  }
  
  public static Map<String, Set<String>> getLogWhiteList()
  {
    if (mLogWhiteList == null)
    {
      mLogWhiteList = new HashMap(DEFAULT_WHITE_LIST);
      Object localObject = WnsConfig.getConfig("qqtriton", "MiniGameAPILogWhiteList");
      GameLog.getInstance().i("LogFilterUtil", "wns config white list: " + (String)localObject);
      localObject = parseConfigString2Set((String)localObject);
      if (localObject != null)
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (!TextUtils.isEmpty(str)) {
            mLogWhiteList.put(str, null);
          }
        }
      }
    }
    return mLogWhiteList;
  }
  
  private static Set<String> parseConfigString2Set(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    HashSet localHashSet;
    String[] arrayOfString;
    do
    {
      do
      {
        return paramString;
        localHashSet = new HashSet();
        arrayOfString = paramString.split(",");
        paramString = localHashSet;
      } while (arrayOfString == null);
      paramString = localHashSet;
    } while (arrayOfString.length <= 0);
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramString = localHashSet;
      if (i >= j) {
        break;
      }
      paramString = arrayOfString[i].trim();
      if (!TextUtils.isEmpty(paramString)) {
        localHashSet.add(paramString);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.utils.LogFilterUtil
 * JD-Core Version:    0.7.0.1
 */