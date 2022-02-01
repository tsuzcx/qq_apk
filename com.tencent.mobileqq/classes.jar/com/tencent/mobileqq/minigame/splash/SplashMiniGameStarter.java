package com.tencent.mobileqq.minigame.splash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver;
import com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver3;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SplashMiniGameStarter
{
  public static final String PATH_SPLASH = "/data/data/com.tencent.mobileqq/files/minigame/splash/";
  public static final String SETTING_SPLASH = "minigame_splash_setting";
  public static final String TAG = "SplashMiniGameStarter";
  private static String appVersionInConfig;
  public static SplashMiniGameData curData;
  public static HashMap<String, SplashMiniGameData> dataMap;
  public static boolean hasClickJumpBtn = false;
  public static boolean hasJumped;
  public static boolean hasPreloaded;
  public static boolean needJump = false;
  private static ArrayList<String> syncPlayList = new ArrayList();
  
  static
  {
    hasPreloaded = false;
    hasJumped = false;
  }
  
  public static void clearAllConfig()
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0).edit().clear().commit();
  }
  
  private static String getFilePath(String paramString)
  {
    File localFile = new File("/data/data/com.tencent.mobileqq/files/minigame/splash/" + paramString);
    if (localFile.exists()) {
      return "/data/data/com.tencent.mobileqq/files/minigame/splash/" + paramString;
    }
    if (localFile.mkdirs()) {
      return "/data/data/com.tencent.mobileqq/files/minigame/splash/" + paramString;
    }
    return null;
  }
  
  private static HashMap<String, SplashMiniGameData> loadConfig()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0);
    int j = localSharedPreferences.getInt("size", 0);
    if (j == 0) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < j)
    {
      String str = localSharedPreferences.getString(Integer.toString(i), "");
      if (TextUtils.isEmpty(str)) {}
      for (;;)
      {
        i += 1;
        break;
        SplashMiniGameData localSplashMiniGameData = new SplashMiniGameData();
        localSplashMiniGameData.enable = localSharedPreferences.getInt("enable_" + str, 0);
        localSplashMiniGameData.guide = localSharedPreferences.getInt("guide_" + str, 0);
        localSplashMiniGameData.appId = str;
        localSplashMiniGameData.videoUrl = localSharedPreferences.getString("video_url_" + str, "");
        localSplashMiniGameData.videoDuration = localSharedPreferences.getInt("video_duration_" + str, 10);
        localSplashMiniGameData.videoMute = localSharedPreferences.getInt("video_mute_" + str, 1);
        localSplashMiniGameData.picUrl = localSharedPreferences.getString("pic_url_" + str, "");
        localSplashMiniGameData.desc = localSharedPreferences.getString("desc_" + str, "");
        localSplashMiniGameData.developerDesc = localSharedPreferences.getString("developer_desc_" + str, "");
        localSplashMiniGameData.downloadUrl = localSharedPreferences.getString("download_url_" + str, "");
        localSplashMiniGameData.fileSize = localSharedPreferences.getInt("file_size_" + str, 0);
        localSplashMiniGameData.iconUrl = localSharedPreferences.getString("icon_url_" + str, "");
        localSplashMiniGameData.version = localSharedPreferences.getString("version_" + str, "");
        localSplashMiniGameData.name = localSharedPreferences.getString("name_" + str, "");
        localSplashMiniGameData.isPlayed = Boolean.valueOf(localSharedPreferences.getBoolean("isplayed_" + str, false));
        localSplashMiniGameData.videoLocalPath = localSharedPreferences.getString("videoLocalPath_" + str, "");
        localSplashMiniGameData.picLocalPath = localSharedPreferences.getString("picLocalPath_" + str, "");
        localSplashMiniGameData.startTime = localSharedPreferences.getLong("startTime_" + str, 0L);
        localSplashMiniGameData.endTime = localSharedPreferences.getLong("endTime_" + str, 0L);
        localSplashMiniGameData.priority = localSharedPreferences.getInt("priority_" + str, 10);
        Set localSet = localSharedPreferences.getStringSet("request_DomainList_" + str, null);
        if (localSet != null) {
          localSplashMiniGameData.requestDomianList = new ArrayList(localSet);
        }
        localSet = localSharedPreferences.getStringSet("downloadFile_DomainList_" + str, null);
        if (localSet != null) {
          localSplashMiniGameData.downloadFileDomianList = new ArrayList(localSet);
        }
        localHashMap.put(str, localSplashMiniGameData);
      }
    }
    appVersionInConfig = localSharedPreferences.getString("appVersion", "");
    return localHashMap;
  }
  
  public static boolean needShow()
  {
    dataMap = loadConfig();
    if ((dataMap == null) || (dataMap.size() == 0)) {
      return false;
    }
    long l = System.currentTimeMillis() / 1000L;
    Iterator localIterator = dataMap.values().iterator();
    while (localIterator.hasNext())
    {
      SplashMiniGameData localSplashMiniGameData = (SplashMiniGameData)localIterator.next();
      if ((localSplashMiniGameData.enable == 1) && (l > localSplashMiniGameData.startTime) && (l < localSplashMiniGameData.endTime) && (!localSplashMiniGameData.isPlayed.booleanValue()) && (!TextUtils.isEmpty(localSplashMiniGameData.videoLocalPath)) && (!TextUtils.isEmpty(localSplashMiniGameData.picLocalPath)) && (new File(localSplashMiniGameData.videoLocalPath).exists()) && (new File(localSplashMiniGameData.picLocalPath).exists())) {
        if (curData == null)
        {
          curData = localSplashMiniGameData;
        }
        else if (curData.priority >= localSplashMiniGameData.priority)
        {
          syncPlayList.add(curData.appId);
          curData = localSplashMiniGameData;
        }
      }
    }
    if ((curData != null) && (curData.guide == 1)) {
      setNeedShowGuideInConf(false);
    }
    QLog.d("SplashMiniGameStarter", 2, "michael curData:" + curData);
    return curData != null;
  }
  
  public static boolean needShowGuide()
  {
    boolean bool1 = true;
    if ((hasJumped) && (curData != null) && (curData.guide == 1)) {}
    for (;;)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0).getBoolean("needshowguide", false);
      }
      return bool2;
      bool1 = false;
    }
  }
  
  public static void preloadGameProcess()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    Intent localIntent = new Intent();
    localIntent.setClass(localBaseApplicationImpl, AppBrandTaskPreloadReceiver3.class);
    localIntent.setAction("mini_preload__splash_game");
    localBaseApplicationImpl.sendBroadcast(localIntent);
  }
  
  public static void preloadMiniGame()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    Intent localIntent = new Intent();
    localIntent.setClass(localBaseApplicationImpl, AppBrandTaskPreloadReceiver3.class);
    localIntent.setAction("mini_preload__splash_game");
    localIntent.putExtra("splashData", curData);
    localBaseApplicationImpl.sendBroadcast(localIntent);
    hasPreloaded = true;
    needJump = true;
  }
  
  public static void preloadProcess()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    Intent localIntent = new Intent();
    localIntent.setClass(localBaseApplicationImpl, AppBrandTaskPreloadReceiver.class);
    localIntent.setAction("mini_preload_app");
    localIntent.putExtra("splashData", curData);
    localBaseApplicationImpl.sendBroadcast(localIntent);
  }
  
  public static void refresh()
  {
    dataMap = loadConfig();
  }
  
  public static void setHasJumped()
  {
    hasJumped = true;
    if ((curData != null) && (curData.guide == 1)) {
      setNeedShowGuideInConf(true);
    }
  }
  
  public static void setNeedShow(boolean paramBoolean)
  {
    if (curData != null)
    {
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0).edit();
      Object localObject = "isplayed_" + curData.appId;
      label68:
      String str;
      if (!paramBoolean)
      {
        bool = true;
        localEditor.putBoolean((String)localObject, bool);
        localObject = syncPlayList.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label139;
        }
        str = (String)((Iterator)localObject).next();
        str = "isplayed_" + str;
        if (paramBoolean) {
          break label134;
        }
      }
      label134:
      for (boolean bool = true;; bool = false)
      {
        localEditor.putBoolean(str, bool);
        break label68;
        bool = false;
        break;
      }
      label139:
      localEditor.commit();
    }
  }
  
  public static void setNeedShowGuideInConf(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0).edit();
    localEditor.putBoolean("needshowguide", paramBoolean);
    localEditor.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.splash.SplashMiniGameStarter
 * JD-Core Version:    0.7.0.1
 */