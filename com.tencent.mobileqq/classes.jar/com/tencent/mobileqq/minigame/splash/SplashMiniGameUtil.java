package com.tencent.mobileqq.minigame.splash;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SplashMiniGameUtil
{
  public static final String TAG = "SplashMiniGameUtil";
  
  private static void addConfig(int paramInt, SplashMiniGameData paramSplashMiniGameData)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0).edit();
    ((SharedPreferences.Editor)localObject).putString(Integer.toString(paramInt), paramSplashMiniGameData.appId);
    ((SharedPreferences.Editor)localObject).putInt("enable_" + paramSplashMiniGameData.appId, paramSplashMiniGameData.enable);
    ((SharedPreferences.Editor)localObject).putInt("guide_" + paramSplashMiniGameData.appId, paramSplashMiniGameData.guide);
    ((SharedPreferences.Editor)localObject).putString("video_url_" + paramSplashMiniGameData.appId, paramSplashMiniGameData.videoUrl);
    ((SharedPreferences.Editor)localObject).putInt("video_duration_" + paramSplashMiniGameData.appId, paramSplashMiniGameData.videoDuration);
    ((SharedPreferences.Editor)localObject).putInt("video_mute_" + paramSplashMiniGameData.appId, paramSplashMiniGameData.videoMute);
    ((SharedPreferences.Editor)localObject).putString("pic_url_" + paramSplashMiniGameData.appId, paramSplashMiniGameData.picUrl);
    ((SharedPreferences.Editor)localObject).putString("desc_" + paramSplashMiniGameData.appId, paramSplashMiniGameData.desc);
    ((SharedPreferences.Editor)localObject).putString("developer_desc_" + paramSplashMiniGameData.appId, paramSplashMiniGameData.developerDesc);
    ((SharedPreferences.Editor)localObject).putString("download_url_" + paramSplashMiniGameData.appId, paramSplashMiniGameData.downloadUrl);
    ((SharedPreferences.Editor)localObject).putInt("file_size_" + paramSplashMiniGameData.appId, paramSplashMiniGameData.fileSize);
    ((SharedPreferences.Editor)localObject).putString("icon_url_" + paramSplashMiniGameData.appId, paramSplashMiniGameData.iconUrl);
    ((SharedPreferences.Editor)localObject).putString("version_" + paramSplashMiniGameData.appId, paramSplashMiniGameData.version);
    ((SharedPreferences.Editor)localObject).putString("name_" + paramSplashMiniGameData.appId, paramSplashMiniGameData.name);
    ((SharedPreferences.Editor)localObject).putBoolean("isplayed_" + paramSplashMiniGameData.appId, false);
    ((SharedPreferences.Editor)localObject).putString("videoLocalPath_" + paramSplashMiniGameData.appId, "");
    ((SharedPreferences.Editor)localObject).putString("picLocalPath_" + paramSplashMiniGameData.appId, "");
    ((SharedPreferences.Editor)localObject).putLong("startTime_" + paramSplashMiniGameData.appId, paramSplashMiniGameData.startTime);
    ((SharedPreferences.Editor)localObject).putLong("endTime_" + paramSplashMiniGameData.appId, paramSplashMiniGameData.endTime);
    ((SharedPreferences.Editor)localObject).putInt("priority_" + paramSplashMiniGameData.appId, paramSplashMiniGameData.priority);
    if (paramSplashMiniGameData.requestDomianList != null) {
      ((SharedPreferences.Editor)localObject).putStringSet("request_DomainList_" + paramSplashMiniGameData.appId, new HashSet(paramSplashMiniGameData.requestDomianList));
    }
    if (paramSplashMiniGameData.downloadFileDomianList != null) {
      ((SharedPreferences.Editor)localObject).putStringSet("downloadFile_DomainList_" + paramSplashMiniGameData.appId, new HashSet(paramSplashMiniGameData.downloadFileDomianList));
    }
    ((SharedPreferences.Editor)localObject).commit();
    localObject = getFilePath(paramSplashMiniGameData.appId);
    if (localObject != null)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      File localFile = new File((String)localObject + File.separator + "splash.mp4");
      if (localFile.exists()) {
        localFile.delete();
      }
      SplashMiniGameDownloadManager.downloadRes(localQQAppInterface, paramSplashMiniGameData.appId, paramSplashMiniGameData.videoUrl, (String)localObject + File.separator + "splash.mp4", 1);
      if (new File((String)localObject + File.separator + "splash.zip").exists()) {
        localFile.delete();
      }
      SplashMiniGameDownloadManager.downloadRes(localQQAppInterface, paramSplashMiniGameData.appId, paramSplashMiniGameData.picUrl, (String)localObject + File.separator + "splash.zip", 0);
    }
    preloadMiniGame(paramSplashMiniGameData);
  }
  
  private static void deleteConfig(ArrayList<SplashMiniGameData> paramArrayList)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0).edit();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      SplashMiniGameData localSplashMiniGameData = (SplashMiniGameData)paramArrayList.next();
      localEditor.remove("enable_" + localSplashMiniGameData.appId);
      localEditor.remove("guide_" + localSplashMiniGameData.appId);
      localEditor.remove("video_url_" + localSplashMiniGameData.appId);
      localEditor.remove("video_duration_" + localSplashMiniGameData.appId);
      localEditor.remove("video_mute_" + localSplashMiniGameData.appId);
      localEditor.remove("pic_url_" + localSplashMiniGameData.appId);
      localEditor.remove("desc_" + localSplashMiniGameData.appId);
      localEditor.remove("developer_desc_" + localSplashMiniGameData.appId);
      localEditor.remove("download_url_" + localSplashMiniGameData.appId);
      localEditor.remove("file_size_" + localSplashMiniGameData.appId);
      localEditor.remove("icon_url_" + localSplashMiniGameData.appId);
      localEditor.remove("version_" + localSplashMiniGameData.appId);
      localEditor.remove("name_" + localSplashMiniGameData.appId);
      localEditor.remove("isplayed_" + localSplashMiniGameData.appId);
      localEditor.remove("videoLocalPath_" + localSplashMiniGameData.appId);
      localEditor.remove("picLocalPath_" + localSplashMiniGameData.appId);
      localEditor.remove("startTime_" + localSplashMiniGameData.appId);
      localEditor.remove("endTime_" + localSplashMiniGameData.appId);
      localEditor.remove("priority_" + localSplashMiniGameData.appId);
      localEditor.remove("request_DomainList_" + localSplashMiniGameData.appId);
      localEditor.remove("downloadFile_DomainList_" + localSplashMiniGameData.appId);
      FileUtils.a(getFilePath(localSplashMiniGameData.appId));
    }
    localEditor.commit();
  }
  
  public static void downloadSuccess(String paramString1, int paramInt, String paramString2)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0).edit();
    switch (paramInt)
    {
    }
    for (;;)
    {
      localEditor.commit();
      return;
      localEditor.putString("picLocalPath_" + paramString1, paramString2);
      continue;
      localEditor.putString("videoLocalPath_" + paramString1, paramString2);
    }
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
  
  private static boolean isListEqual(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    if (paramArrayList1 == paramArrayList2) {}
    do
    {
      do
      {
        return true;
      } while (((paramArrayList1 == null) && (paramArrayList2 != null) && (paramArrayList2.size() == 0)) || ((paramArrayList2 == null) && (paramArrayList1 != null) && (paramArrayList1.size() == 0)));
      if ((paramArrayList1 == null) || (paramArrayList2 == null)) {
        return false;
      }
      if (paramArrayList1.size() != paramArrayList2.size()) {
        return false;
      }
    } while (paramArrayList1.containsAll(paramArrayList2));
    return false;
  }
  
  private static void modifyConfig(int paramInt, SplashMiniGameData paramSplashMiniGameData1, SplashMiniGameData paramSplashMiniGameData2)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0);
    Object localObject2 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject2).putString(Integer.toString(paramInt), paramSplashMiniGameData2.appId);
    if (paramSplashMiniGameData1.enable != paramSplashMiniGameData2.enable) {
      ((SharedPreferences.Editor)localObject2).putInt("enable_" + paramSplashMiniGameData2.appId, paramSplashMiniGameData2.enable);
    }
    if (paramSplashMiniGameData1.guide != paramSplashMiniGameData2.guide) {
      ((SharedPreferences.Editor)localObject2).putInt("guide_" + paramSplashMiniGameData2.appId, paramSplashMiniGameData2.guide);
    }
    Object localObject3;
    if (!paramSplashMiniGameData1.videoUrl.equals(paramSplashMiniGameData2.videoUrl))
    {
      ((SharedPreferences.Editor)localObject2).putString("video_url_" + paramSplashMiniGameData2.appId, paramSplashMiniGameData2.videoUrl);
      ((SharedPreferences.Editor)localObject2).putString("videoLocalPath_" + paramSplashMiniGameData2.appId, "");
      if (paramSplashMiniGameData1.videoLocalPath != null)
      {
        localObject3 = new File(paramSplashMiniGameData1.videoLocalPath);
        if (((File)localObject3).exists()) {
          ((File)localObject3).delete();
        }
      }
    }
    if (paramSplashMiniGameData1.videoDuration != paramSplashMiniGameData2.videoDuration) {
      ((SharedPreferences.Editor)localObject2).putInt("video_duration_" + paramSplashMiniGameData2.appId, paramSplashMiniGameData2.videoDuration);
    }
    if (paramSplashMiniGameData1.videoMute != paramSplashMiniGameData2.videoMute) {
      ((SharedPreferences.Editor)localObject2).putInt("video_mute_" + paramSplashMiniGameData2.appId, paramSplashMiniGameData2.videoMute);
    }
    if (!paramSplashMiniGameData1.picUrl.equals(paramSplashMiniGameData2.picUrl))
    {
      ((SharedPreferences.Editor)localObject2).putString("pic_url_" + paramSplashMiniGameData2.appId, paramSplashMiniGameData2.picUrl);
      ((SharedPreferences.Editor)localObject2).putString("picLocalPath_" + paramSplashMiniGameData2.appId, "");
      if (paramSplashMiniGameData1.picLocalPath != null)
      {
        localObject3 = new File(paramSplashMiniGameData1.picLocalPath);
        if (((File)localObject3).exists()) {
          ((File)localObject3).delete();
        }
      }
    }
    if (!paramSplashMiniGameData1.desc.equals(paramSplashMiniGameData2.desc)) {
      ((SharedPreferences.Editor)localObject2).putString("desc_" + paramSplashMiniGameData2.appId, paramSplashMiniGameData2.desc);
    }
    if (!paramSplashMiniGameData1.developerDesc.equals(paramSplashMiniGameData2.developerDesc)) {
      ((SharedPreferences.Editor)localObject2).putString("developer_desc_" + paramSplashMiniGameData2.appId, paramSplashMiniGameData2.developerDesc);
    }
    if (!paramSplashMiniGameData1.downloadUrl.equals(paramSplashMiniGameData2.downloadUrl)) {
      ((SharedPreferences.Editor)localObject2).putString("download_url_" + paramSplashMiniGameData2.appId, paramSplashMiniGameData2.downloadUrl);
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramSplashMiniGameData1.fileSize != paramSplashMiniGameData2.fileSize) {
        ((SharedPreferences.Editor)localObject2).putInt("file_size_" + paramSplashMiniGameData2.appId, paramSplashMiniGameData2.fileSize);
      }
      if (!paramSplashMiniGameData1.iconUrl.equals(paramSplashMiniGameData2.iconUrl)) {
        ((SharedPreferences.Editor)localObject2).putString("icon_url_" + paramSplashMiniGameData2.appId, paramSplashMiniGameData2.iconUrl);
      }
      if (!paramSplashMiniGameData1.version.equals(paramSplashMiniGameData2.version)) {
        ((SharedPreferences.Editor)localObject2).putString("version_" + paramSplashMiniGameData2.appId, paramSplashMiniGameData2.version);
      }
      if (!paramSplashMiniGameData1.name.equals(paramSplashMiniGameData2.name)) {
        ((SharedPreferences.Editor)localObject2).putString("name_" + paramSplashMiniGameData2.appId, paramSplashMiniGameData2.name);
      }
      if (paramSplashMiniGameData1.startTime != paramSplashMiniGameData2.startTime) {
        ((SharedPreferences.Editor)localObject2).putLong("startTime_" + paramSplashMiniGameData2.appId, paramSplashMiniGameData2.startTime);
      }
      if (paramSplashMiniGameData1.endTime != paramSplashMiniGameData2.endTime) {
        ((SharedPreferences.Editor)localObject2).putLong("endTime_" + paramSplashMiniGameData2.appId, paramSplashMiniGameData2.endTime);
      }
      if (paramSplashMiniGameData1.priority != paramSplashMiniGameData2.priority) {
        ((SharedPreferences.Editor)localObject2).putInt("priority_" + paramSplashMiniGameData2.appId, paramSplashMiniGameData2.priority);
      }
      if (!isListEqual(paramSplashMiniGameData1.requestDomianList, paramSplashMiniGameData2.requestDomianList)) {
        ((SharedPreferences.Editor)localObject2).putStringSet("request_DomainList_" + paramSplashMiniGameData2.appId, new HashSet(paramSplashMiniGameData2.requestDomianList));
      }
      if (!isListEqual(paramSplashMiniGameData1.downloadFileDomianList, paramSplashMiniGameData2.downloadFileDomianList)) {
        ((SharedPreferences.Editor)localObject2).putStringSet("downloadFile_DomainList_" + paramSplashMiniGameData2.appId, new HashSet(paramSplashMiniGameData2.downloadFileDomianList));
      }
      ((SharedPreferences.Editor)localObject2).commit();
      localObject2 = ((SharedPreferences)localObject1).getString("videoLocalPath_" + paramSplashMiniGameData2.appId, "");
      localObject1 = ((SharedPreferences)localObject1).getString("picLocalPath_" + paramSplashMiniGameData2.appId, "");
      localObject3 = getFilePath(paramSplashMiniGameData2.appId);
      if ((localObject3 != null) && (!paramSplashMiniGameData1.isPlayed.booleanValue()))
      {
        paramSplashMiniGameData1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!new File((String)localObject3 + File.separator + "splash.mp4").exists())) {
          SplashMiniGameDownloadManager.downloadRes(paramSplashMiniGameData1, paramSplashMiniGameData2.appId, paramSplashMiniGameData2.videoUrl, (String)localObject3 + File.separator + "splash.mp4", 1);
        }
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!new File((String)localObject3 + File.separator + "splash.zip").exists())) {
          SplashMiniGameDownloadManager.downloadRes(paramSplashMiniGameData1, paramSplashMiniGameData2.appId, paramSplashMiniGameData2.picUrl, (String)localObject3 + File.separator + "splash.zip", 0);
        }
      }
      if (paramInt != 0) {
        preloadMiniGame(paramSplashMiniGameData2);
      }
      return;
    }
  }
  
  public static void preloadMiniGame(SplashMiniGameData paramSplashMiniGameData) {}
  
  public static void saveConfigData(String paramString)
  {
    if (!GameWnsUtils.gameEnable()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("minigame_splash");
      if ((paramString == null) || (paramString.length() <= 0))
      {
        BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0).edit().clear().commit();
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      Object localObject2;
      Object localObject3;
      int j;
      for (;;)
      {
        SplashMiniGameStarter.refresh();
        if (localArrayList.size() >= 1) {
          break;
        }
        BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0).edit().clear().commit();
        FileUtils.a("/data/data/com.tencent.mobileqq/files/minigame/splash/");
        return;
        i = 0;
        while (i < paramString.length())
        {
          localObject1 = new SplashMiniGameData();
          localObject2 = paramString.getJSONObject(i);
          ((SplashMiniGameData)localObject1).enable = ((JSONObject)localObject2).optInt("enable", 0);
          ((SplashMiniGameData)localObject1).guide = ((JSONObject)localObject2).optInt("guide", 0);
          ((SplashMiniGameData)localObject1).appId = ((JSONObject)localObject2).optString("appid");
          ((SplashMiniGameData)localObject1).videoUrl = ((JSONObject)localObject2).optString("video_url");
          ((SplashMiniGameData)localObject1).videoDuration = ((JSONObject)localObject2).optInt("video_duration");
          ((SplashMiniGameData)localObject1).videoMute = ((JSONObject)localObject2).optInt("video_mute", 1);
          ((SplashMiniGameData)localObject1).picUrl = ((JSONObject)localObject2).optString("pic_url");
          ((SplashMiniGameData)localObject1).desc = ((JSONObject)localObject2).optString("desc");
          ((SplashMiniGameData)localObject1).developerDesc = ((JSONObject)localObject2).optString("developer_desc");
          ((SplashMiniGameData)localObject1).downloadUrl = ((JSONObject)localObject2).optString("download_url");
          ((SplashMiniGameData)localObject1).fileSize = ((JSONObject)localObject2).optInt("file_size");
          ((SplashMiniGameData)localObject1).iconUrl = ((JSONObject)localObject2).optString("icon_url");
          ((SplashMiniGameData)localObject1).version = ((JSONObject)localObject2).optString("version");
          ((SplashMiniGameData)localObject1).name = ((JSONObject)localObject2).optString("name");
          ((SplashMiniGameData)localObject1).startTime = ((JSONObject)localObject2).optLong("startTime", 0L);
          ((SplashMiniGameData)localObject1).endTime = ((JSONObject)localObject2).optLong("endTime", 0L);
          ((SplashMiniGameData)localObject1).priority = ((JSONObject)localObject2).optInt("priority", 10);
          localObject3 = ((JSONObject)localObject2).optJSONArray("downloadFile_DomainList");
          if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
          {
            ((SplashMiniGameData)localObject1).downloadFileDomianList = new ArrayList();
            j = 0;
            while (j < ((JSONArray)localObject3).length())
            {
              ((SplashMiniGameData)localObject1).downloadFileDomianList.add(((JSONArray)localObject3).optString(j));
              j += 1;
            }
          }
          localObject2 = ((JSONObject)localObject2).optJSONArray("request_DomainList");
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
          {
            ((SplashMiniGameData)localObject1).requestDomianList = new ArrayList();
            j = 0;
            while (j < ((JSONArray)localObject2).length())
            {
              ((SplashMiniGameData)localObject1).requestDomianList.add(((JSONArray)localObject2).optString(j));
              j += 1;
            }
          }
          localArrayList.add(localObject1);
          i += 1;
        }
      }
      BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0).edit().putInt("size", localArrayList.size()).commit();
      Object localObject1 = SplashMiniGameStarter.dataMap;
      paramString = localArrayList.iterator();
      int i = 0;
      if (paramString.hasNext())
      {
        localObject2 = (SplashMiniGameData)paramString.next();
        if ((localObject1 != null) && (((HashMap)localObject1).containsKey(((SplashMiniGameData)localObject2).appId))) {
          modifyConfig(i, (SplashMiniGameData)((HashMap)localObject1).get(((SplashMiniGameData)localObject2).appId), (SplashMiniGameData)localObject2);
        }
        for (;;)
        {
          i += 1;
          break;
          addConfig(i, (SplashMiniGameData)localObject2);
        }
      }
      if (localObject1 != null)
      {
        paramString = new ArrayList();
        localObject1 = ((HashMap)localObject1).values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SplashMiniGameData)((Iterator)localObject1).next();
          i = 0;
          int k;
          for (j = 0; i < localArrayList.size(); j = k)
          {
            localObject3 = (SplashMiniGameData)localArrayList.get(i);
            k = j;
            if (localObject3 != null)
            {
              k = j;
              if (((SplashMiniGameData)localObject3).appId.equals(((SplashMiniGameData)localObject2).appId)) {
                k = 1;
              }
            }
            i += 1;
          }
          if (j == 0) {
            paramString.add(localObject2);
          }
        }
        if (paramString.size() > 0) {
          deleteConfig(paramString);
        }
      }
      BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0).edit().putString("appVersion", "8.5.5.5105").commit();
      SplashMiniGameStarter.refresh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.splash.SplashMiniGameUtil
 * JD-Core Version:    0.7.0.1
 */