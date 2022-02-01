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

public class SplashMiniGameStarter
{
  public static final String PATH_SPLASH = "/data/data/com.tencent.mobileqq/files/minigame/splash/";
  public static final String SETTING_SPLASH = "minigame_splash_setting";
  public static final String TAG = "SplashMiniGameStarter";
  private static String appVersionInConfig;
  public static SplashMiniGameData curData;
  public static HashMap<String, SplashMiniGameData> dataMap;
  public static boolean hasClickJumpBtn = false;
  public static boolean hasJumped = false;
  public static boolean hasPreloaded = false;
  public static boolean needJump = false;
  private static ArrayList<String> syncPlayList = new ArrayList();
  
  public static void clearAllConfig()
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0).edit().clear().commit();
  }
  
  private static String getFilePath(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/data/data/com.tencent.mobileqq/files/minigame/splash/");
    ((StringBuilder)localObject).append(paramString);
    localObject = new File(((StringBuilder)localObject).toString());
    if (((File)localObject).exists())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/data/data/com.tencent.mobileqq/files/minigame/splash/");
      ((StringBuilder)localObject).append(paramString);
      return ((StringBuilder)localObject).toString();
    }
    if (((File)localObject).mkdirs())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/data/data/com.tencent.mobileqq/files/minigame/splash/");
      ((StringBuilder)localObject).append(paramString);
      return ((StringBuilder)localObject).toString();
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
    while (i < j)
    {
      String str = localSharedPreferences.getString(Integer.toString(i), "");
      if (!TextUtils.isEmpty(str))
      {
        SplashMiniGameData localSplashMiniGameData = new SplashMiniGameData();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("enable_");
        ((StringBuilder)localObject).append(str);
        localSplashMiniGameData.enable = localSharedPreferences.getInt(((StringBuilder)localObject).toString(), 0);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("guide_");
        ((StringBuilder)localObject).append(str);
        localSplashMiniGameData.guide = localSharedPreferences.getInt(((StringBuilder)localObject).toString(), 0);
        localSplashMiniGameData.appId = str;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("video_url_");
        ((StringBuilder)localObject).append(str);
        localSplashMiniGameData.videoUrl = localSharedPreferences.getString(((StringBuilder)localObject).toString(), "");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("video_duration_");
        ((StringBuilder)localObject).append(str);
        localSplashMiniGameData.videoDuration = localSharedPreferences.getInt(((StringBuilder)localObject).toString(), 10);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("video_mute_");
        ((StringBuilder)localObject).append(str);
        localSplashMiniGameData.videoMute = localSharedPreferences.getInt(((StringBuilder)localObject).toString(), 1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("pic_url_");
        ((StringBuilder)localObject).append(str);
        localSplashMiniGameData.picUrl = localSharedPreferences.getString(((StringBuilder)localObject).toString(), "");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("desc_");
        ((StringBuilder)localObject).append(str);
        localSplashMiniGameData.desc = localSharedPreferences.getString(((StringBuilder)localObject).toString(), "");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("developer_desc_");
        ((StringBuilder)localObject).append(str);
        localSplashMiniGameData.developerDesc = localSharedPreferences.getString(((StringBuilder)localObject).toString(), "");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("download_url_");
        ((StringBuilder)localObject).append(str);
        localSplashMiniGameData.downloadUrl = localSharedPreferences.getString(((StringBuilder)localObject).toString(), "");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("file_size_");
        ((StringBuilder)localObject).append(str);
        localSplashMiniGameData.fileSize = localSharedPreferences.getInt(((StringBuilder)localObject).toString(), 0);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("icon_url_");
        ((StringBuilder)localObject).append(str);
        localSplashMiniGameData.iconUrl = localSharedPreferences.getString(((StringBuilder)localObject).toString(), "");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("version_");
        ((StringBuilder)localObject).append(str);
        localSplashMiniGameData.version = localSharedPreferences.getString(((StringBuilder)localObject).toString(), "");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("name_");
        ((StringBuilder)localObject).append(str);
        localSplashMiniGameData.name = localSharedPreferences.getString(((StringBuilder)localObject).toString(), "");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isplayed_");
        ((StringBuilder)localObject).append(str);
        localSplashMiniGameData.isPlayed = Boolean.valueOf(localSharedPreferences.getBoolean(((StringBuilder)localObject).toString(), false));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("videoLocalPath_");
        ((StringBuilder)localObject).append(str);
        localSplashMiniGameData.videoLocalPath = localSharedPreferences.getString(((StringBuilder)localObject).toString(), "");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("picLocalPath_");
        ((StringBuilder)localObject).append(str);
        localSplashMiniGameData.picLocalPath = localSharedPreferences.getString(((StringBuilder)localObject).toString(), "");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startTime_");
        ((StringBuilder)localObject).append(str);
        localSplashMiniGameData.startTime = localSharedPreferences.getLong(((StringBuilder)localObject).toString(), 0L);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("endTime_");
        ((StringBuilder)localObject).append(str);
        localSplashMiniGameData.endTime = localSharedPreferences.getLong(((StringBuilder)localObject).toString(), 0L);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("priority_");
        ((StringBuilder)localObject).append(str);
        localSplashMiniGameData.priority = localSharedPreferences.getInt(((StringBuilder)localObject).toString(), 10);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("request_DomainList_");
        ((StringBuilder)localObject).append(str);
        localObject = localSharedPreferences.getStringSet(((StringBuilder)localObject).toString(), null);
        if (localObject != null) {
          localSplashMiniGameData.requestDomianList = new ArrayList((Collection)localObject);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("downloadFile_DomainList_");
        ((StringBuilder)localObject).append(str);
        localObject = localSharedPreferences.getStringSet(((StringBuilder)localObject).toString(), null);
        if (localObject != null) {
          localSplashMiniGameData.downloadFileDomianList = new ArrayList((Collection)localObject);
        }
        localHashMap.put(str, localSplashMiniGameData);
      }
      i += 1;
    }
    appVersionInConfig = localSharedPreferences.getString("appVersion", "");
    return localHashMap;
  }
  
  public static boolean needShow()
  {
    dataMap = loadConfig();
    Object localObject = dataMap;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if (((HashMap)localObject).size() == 0) {
        return false;
      }
      long l = System.currentTimeMillis() / 1000L;
      localObject = dataMap.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        SplashMiniGameData localSplashMiniGameData1 = (SplashMiniGameData)((Iterator)localObject).next();
        if ((localSplashMiniGameData1.enable == 1) && (l > localSplashMiniGameData1.startTime) && (l < localSplashMiniGameData1.endTime) && (!localSplashMiniGameData1.isPlayed.booleanValue()) && (!TextUtils.isEmpty(localSplashMiniGameData1.videoLocalPath)) && (!TextUtils.isEmpty(localSplashMiniGameData1.picLocalPath)) && (new File(localSplashMiniGameData1.videoLocalPath).exists()) && (new File(localSplashMiniGameData1.picLocalPath).exists()))
        {
          SplashMiniGameData localSplashMiniGameData2 = curData;
          if (localSplashMiniGameData2 == null)
          {
            curData = localSplashMiniGameData1;
          }
          else if (localSplashMiniGameData2.priority >= localSplashMiniGameData1.priority)
          {
            syncPlayList.add(curData.appId);
            curData = localSplashMiniGameData1;
          }
        }
      }
      localObject = curData;
      if ((localObject != null) && (((SplashMiniGameData)localObject).guide == 1)) {
        setNeedShowGuideInConf(false);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("michael curData:");
      ((StringBuilder)localObject).append(curData);
      QLog.d("SplashMiniGameStarter", 2, ((StringBuilder)localObject).toString());
      bool1 = bool2;
      if (curData != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean needShowGuide()
  {
    boolean bool2 = hasJumped;
    boolean bool1 = true;
    if (bool2)
    {
      SplashMiniGameData localSplashMiniGameData = curData;
      if ((localSplashMiniGameData != null) && (localSplashMiniGameData.guide == 1)) {}
    }
    else
    {
      bool1 = false;
    }
    bool2 = bool1;
    if (!bool1) {
      bool2 = BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0).getBoolean("needshowguide", false);
    }
    return bool2;
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
    SplashMiniGameData localSplashMiniGameData = curData;
    if ((localSplashMiniGameData != null) && (localSplashMiniGameData.guide == 1)) {
      setNeedShowGuideInConf(true);
    }
  }
  
  public static void setNeedShow(boolean paramBoolean)
  {
    if (curData != null)
    {
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0).edit();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isplayed_");
      ((StringBuilder)localObject).append(curData.appId);
      localEditor.putBoolean(((StringBuilder)localObject).toString(), paramBoolean ^ true);
      localObject = syncPlayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isplayed_");
        localStringBuilder.append(str);
        localEditor.putBoolean(localStringBuilder.toString(), paramBoolean ^ true);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.splash.SplashMiniGameStarter
 * JD-Core Version:    0.7.0.1
 */