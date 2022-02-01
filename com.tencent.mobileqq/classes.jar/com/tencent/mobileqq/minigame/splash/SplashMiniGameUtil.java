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
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0).edit();
    ((SharedPreferences.Editor)localObject1).putString(Integer.toString(paramInt), paramSplashMiniGameData.appId);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("enable_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
    ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject2).toString(), paramSplashMiniGameData.enable);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("guide_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
    ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject2).toString(), paramSplashMiniGameData.guide);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("video_url_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
    ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject2).toString(), paramSplashMiniGameData.videoUrl);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("video_duration_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
    ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject2).toString(), paramSplashMiniGameData.videoDuration);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("video_mute_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
    ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject2).toString(), paramSplashMiniGameData.videoMute);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("pic_url_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
    ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject2).toString(), paramSplashMiniGameData.picUrl);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("desc_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
    ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject2).toString(), paramSplashMiniGameData.desc);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("developer_desc_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
    ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject2).toString(), paramSplashMiniGameData.developerDesc);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("download_url_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
    ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject2).toString(), paramSplashMiniGameData.downloadUrl);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("file_size_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
    ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject2).toString(), paramSplashMiniGameData.fileSize);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("icon_url_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
    ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject2).toString(), paramSplashMiniGameData.iconUrl);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("version_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
    ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject2).toString(), paramSplashMiniGameData.version);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("name_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
    ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject2).toString(), paramSplashMiniGameData.name);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("isplayed_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
    ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject2).toString(), false);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("videoLocalPath_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
    ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject2).toString(), "");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("picLocalPath_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
    ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject2).toString(), "");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("startTime_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
    ((SharedPreferences.Editor)localObject1).putLong(((StringBuilder)localObject2).toString(), paramSplashMiniGameData.startTime);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("endTime_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
    ((SharedPreferences.Editor)localObject1).putLong(((StringBuilder)localObject2).toString(), paramSplashMiniGameData.endTime);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("priority_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
    ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject2).toString(), paramSplashMiniGameData.priority);
    if (paramSplashMiniGameData.requestDomianList != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("request_DomainList_");
      ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
      ((SharedPreferences.Editor)localObject1).putStringSet(((StringBuilder)localObject2).toString(), new HashSet(paramSplashMiniGameData.requestDomianList));
    }
    if (paramSplashMiniGameData.downloadFileDomianList != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("downloadFile_DomainList_");
      ((StringBuilder)localObject2).append(paramSplashMiniGameData.appId);
      ((SharedPreferences.Editor)localObject1).putStringSet(((StringBuilder)localObject2).toString(), new HashSet(paramSplashMiniGameData.downloadFileDomianList));
    }
    ((SharedPreferences.Editor)localObject1).commit();
    localObject1 = getFilePath(paramSplashMiniGameData.appId);
    if (localObject1 != null)
    {
      localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append("splash.mp4");
      localObject3 = new File(((StringBuilder)localObject3).toString());
      if (((File)localObject3).exists()) {
        ((File)localObject3).delete();
      }
      Object localObject4 = paramSplashMiniGameData.appId;
      Object localObject5 = paramSplashMiniGameData.videoUrl;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("splash.mp4");
      SplashMiniGameDownloadManager.downloadRes((QQAppInterface)localObject2, (String)localObject4, (String)localObject5, localStringBuilder.toString(), 1);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append(File.separator);
      ((StringBuilder)localObject4).append("splash.zip");
      if (new File(((StringBuilder)localObject4).toString()).exists()) {
        ((File)localObject3).delete();
      }
      localObject3 = paramSplashMiniGameData.appId;
      localObject4 = paramSplashMiniGameData.picUrl;
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append((String)localObject1);
      ((StringBuilder)localObject5).append(File.separator);
      ((StringBuilder)localObject5).append("splash.zip");
      SplashMiniGameDownloadManager.downloadRes((QQAppInterface)localObject2, (String)localObject3, (String)localObject4, ((StringBuilder)localObject5).toString(), 0);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enable_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("guide_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("video_url_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("video_duration_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("video_mute_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pic_url_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("desc_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("developer_desc_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("download_url_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("file_size_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("icon_url_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("version_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("name_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isplayed_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("videoLocalPath_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("picLocalPath_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startTime_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("endTime_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("priority_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("request_DomainList_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadFile_DomainList_");
      localStringBuilder.append(localSplashMiniGameData.appId);
      localEditor.remove(localStringBuilder.toString());
      FileUtils.deleteDirectory(getFilePath(localSplashMiniGameData.appId));
    }
    localEditor.commit();
  }
  
  public static void downloadSuccess(String paramString1, int paramInt, String paramString2)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0).edit();
    StringBuilder localStringBuilder;
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("videoLocalPath_");
        localStringBuilder.append(paramString1);
        localEditor.putString(localStringBuilder.toString(), paramString2);
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("picLocalPath_");
      localStringBuilder.append(paramString1);
      localEditor.putString(localStringBuilder.toString(), paramString2);
    }
    localEditor.commit();
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
  
  private static boolean isListEqual(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    if (paramArrayList1 == paramArrayList2) {
      return true;
    }
    if (((paramArrayList1 == null) && (paramArrayList2 != null) && (paramArrayList2.size() == 0)) || ((paramArrayList2 == null) && (paramArrayList1 != null) && (paramArrayList1.size() == 0))) {
      return true;
    }
    if (paramArrayList1 != null)
    {
      if (paramArrayList2 == null) {
        return false;
      }
      if (paramArrayList1.size() != paramArrayList2.size()) {
        return false;
      }
      return paramArrayList1.containsAll(paramArrayList2);
    }
    return false;
  }
  
  private static void modifyConfig(int paramInt, SplashMiniGameData paramSplashMiniGameData1, SplashMiniGameData paramSplashMiniGameData2)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0);
    Object localObject2 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject2).putString(Integer.toString(paramInt), paramSplashMiniGameData2.appId);
    if (paramSplashMiniGameData1.enable != paramSplashMiniGameData2.enable)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("enable_");
      ((StringBuilder)localObject3).append(paramSplashMiniGameData2.appId);
      ((SharedPreferences.Editor)localObject2).putInt(((StringBuilder)localObject3).toString(), paramSplashMiniGameData2.enable);
    }
    if (paramSplashMiniGameData1.guide != paramSplashMiniGameData2.guide)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("guide_");
      ((StringBuilder)localObject3).append(paramSplashMiniGameData2.appId);
      ((SharedPreferences.Editor)localObject2).putInt(((StringBuilder)localObject3).toString(), paramSplashMiniGameData2.guide);
    }
    if (!paramSplashMiniGameData1.videoUrl.equals(paramSplashMiniGameData2.videoUrl))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("video_url_");
      ((StringBuilder)localObject3).append(paramSplashMiniGameData2.appId);
      ((SharedPreferences.Editor)localObject2).putString(((StringBuilder)localObject3).toString(), paramSplashMiniGameData2.videoUrl);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("videoLocalPath_");
      ((StringBuilder)localObject3).append(paramSplashMiniGameData2.appId);
      ((SharedPreferences.Editor)localObject2).putString(((StringBuilder)localObject3).toString(), "");
      if (paramSplashMiniGameData1.videoLocalPath != null)
      {
        localObject3 = new File(paramSplashMiniGameData1.videoLocalPath);
        if (((File)localObject3).exists()) {
          ((File)localObject3).delete();
        }
      }
    }
    if (paramSplashMiniGameData1.videoDuration != paramSplashMiniGameData2.videoDuration)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("video_duration_");
      ((StringBuilder)localObject3).append(paramSplashMiniGameData2.appId);
      ((SharedPreferences.Editor)localObject2).putInt(((StringBuilder)localObject3).toString(), paramSplashMiniGameData2.videoDuration);
    }
    if (paramSplashMiniGameData1.videoMute != paramSplashMiniGameData2.videoMute)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("video_mute_");
      ((StringBuilder)localObject3).append(paramSplashMiniGameData2.appId);
      ((SharedPreferences.Editor)localObject2).putInt(((StringBuilder)localObject3).toString(), paramSplashMiniGameData2.videoMute);
    }
    if (!paramSplashMiniGameData1.picUrl.equals(paramSplashMiniGameData2.picUrl))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("pic_url_");
      ((StringBuilder)localObject3).append(paramSplashMiniGameData2.appId);
      ((SharedPreferences.Editor)localObject2).putString(((StringBuilder)localObject3).toString(), paramSplashMiniGameData2.picUrl);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("picLocalPath_");
      ((StringBuilder)localObject3).append(paramSplashMiniGameData2.appId);
      ((SharedPreferences.Editor)localObject2).putString(((StringBuilder)localObject3).toString(), "");
      if (paramSplashMiniGameData1.picLocalPath != null)
      {
        localObject3 = new File(paramSplashMiniGameData1.picLocalPath);
        if (((File)localObject3).exists()) {
          ((File)localObject3).delete();
        }
      }
    }
    if (!paramSplashMiniGameData1.desc.equals(paramSplashMiniGameData2.desc))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("desc_");
      ((StringBuilder)localObject3).append(paramSplashMiniGameData2.appId);
      ((SharedPreferences.Editor)localObject2).putString(((StringBuilder)localObject3).toString(), paramSplashMiniGameData2.desc);
    }
    if (!paramSplashMiniGameData1.developerDesc.equals(paramSplashMiniGameData2.developerDesc))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("developer_desc_");
      ((StringBuilder)localObject3).append(paramSplashMiniGameData2.appId);
      ((SharedPreferences.Editor)localObject2).putString(((StringBuilder)localObject3).toString(), paramSplashMiniGameData2.developerDesc);
    }
    if (!paramSplashMiniGameData1.downloadUrl.equals(paramSplashMiniGameData2.downloadUrl))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("download_url_");
      ((StringBuilder)localObject3).append(paramSplashMiniGameData2.appId);
      ((SharedPreferences.Editor)localObject2).putString(((StringBuilder)localObject3).toString(), paramSplashMiniGameData2.downloadUrl);
      paramInt = 1;
    }
    else
    {
      paramInt = 0;
    }
    if (paramSplashMiniGameData1.fileSize != paramSplashMiniGameData2.fileSize)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("file_size_");
      ((StringBuilder)localObject3).append(paramSplashMiniGameData2.appId);
      ((SharedPreferences.Editor)localObject2).putInt(((StringBuilder)localObject3).toString(), paramSplashMiniGameData2.fileSize);
    }
    if (!paramSplashMiniGameData1.iconUrl.equals(paramSplashMiniGameData2.iconUrl))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("icon_url_");
      ((StringBuilder)localObject3).append(paramSplashMiniGameData2.appId);
      ((SharedPreferences.Editor)localObject2).putString(((StringBuilder)localObject3).toString(), paramSplashMiniGameData2.iconUrl);
    }
    if (!paramSplashMiniGameData1.version.equals(paramSplashMiniGameData2.version))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("version_");
      ((StringBuilder)localObject3).append(paramSplashMiniGameData2.appId);
      ((SharedPreferences.Editor)localObject2).putString(((StringBuilder)localObject3).toString(), paramSplashMiniGameData2.version);
    }
    if (!paramSplashMiniGameData1.name.equals(paramSplashMiniGameData2.name))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("name_");
      ((StringBuilder)localObject3).append(paramSplashMiniGameData2.appId);
      ((SharedPreferences.Editor)localObject2).putString(((StringBuilder)localObject3).toString(), paramSplashMiniGameData2.name);
    }
    if (paramSplashMiniGameData1.startTime != paramSplashMiniGameData2.startTime)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("startTime_");
      ((StringBuilder)localObject3).append(paramSplashMiniGameData2.appId);
      ((SharedPreferences.Editor)localObject2).putLong(((StringBuilder)localObject3).toString(), paramSplashMiniGameData2.startTime);
    }
    if (paramSplashMiniGameData1.endTime != paramSplashMiniGameData2.endTime)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("endTime_");
      ((StringBuilder)localObject3).append(paramSplashMiniGameData2.appId);
      ((SharedPreferences.Editor)localObject2).putLong(((StringBuilder)localObject3).toString(), paramSplashMiniGameData2.endTime);
    }
    if (paramSplashMiniGameData1.priority != paramSplashMiniGameData2.priority)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("priority_");
      ((StringBuilder)localObject3).append(paramSplashMiniGameData2.appId);
      ((SharedPreferences.Editor)localObject2).putInt(((StringBuilder)localObject3).toString(), paramSplashMiniGameData2.priority);
    }
    if (!isListEqual(paramSplashMiniGameData1.requestDomianList, paramSplashMiniGameData2.requestDomianList))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("request_DomainList_");
      ((StringBuilder)localObject3).append(paramSplashMiniGameData2.appId);
      ((SharedPreferences.Editor)localObject2).putStringSet(((StringBuilder)localObject3).toString(), new HashSet(paramSplashMiniGameData2.requestDomianList));
    }
    if (!isListEqual(paramSplashMiniGameData1.downloadFileDomianList, paramSplashMiniGameData2.downloadFileDomianList))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("downloadFile_DomainList_");
      ((StringBuilder)localObject3).append(paramSplashMiniGameData2.appId);
      ((SharedPreferences.Editor)localObject2).putStringSet(((StringBuilder)localObject3).toString(), new HashSet(paramSplashMiniGameData2.downloadFileDomianList));
    }
    ((SharedPreferences.Editor)localObject2).commit();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("videoLocalPath_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData2.appId);
    Object localObject3 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), "");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("picLocalPath_");
    ((StringBuilder)localObject2).append(paramSplashMiniGameData2.appId);
    localObject2 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), "");
    localObject1 = getFilePath(paramSplashMiniGameData2.appId);
    if ((localObject1 != null) && (!paramSplashMiniGameData1.isPlayed.booleanValue()))
    {
      paramSplashMiniGameData1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject4;
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(File.separator);
        ((StringBuilder)localObject3).append("splash.mp4");
        if (new File(((StringBuilder)localObject3).toString()).exists()) {}
      }
      else
      {
        localObject3 = paramSplashMiniGameData2.appId;
        localObject4 = paramSplashMiniGameData2.videoUrl;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(File.separator);
        localStringBuilder.append("splash.mp4");
        SplashMiniGameDownloadManager.downloadRes(paramSplashMiniGameData1, (String)localObject3, (String)localObject4, localStringBuilder.toString(), 1);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append("splash.zip");
        if (new File(((StringBuilder)localObject2).toString()).exists()) {}
      }
      else
      {
        localObject2 = paramSplashMiniGameData2.appId;
        localObject3 = paramSplashMiniGameData2.picUrl;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject1);
        ((StringBuilder)localObject4).append(File.separator);
        ((StringBuilder)localObject4).append("splash.zip");
        SplashMiniGameDownloadManager.downloadRes(paramSplashMiniGameData1, (String)localObject2, (String)localObject3, ((StringBuilder)localObject4).toString(), 0);
      }
    }
    if (paramInt != 0) {
      preloadMiniGame(paramSplashMiniGameData2);
    }
  }
  
  public static void preloadMiniGame(SplashMiniGameData paramSplashMiniGameData) {}
  
  public static void saveConfigData(String paramString)
  {
    if (!GameWnsUtils.gameEnable()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("minigame_splash");
        if (paramString != null)
        {
          if (paramString.length() > 0) {
            break label809;
          }
          continue;
          if (i >= paramString.length()) {
            continue;
          }
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
            if (j < ((JSONArray)localObject3).length())
            {
              ((SplashMiniGameData)localObject1).downloadFileDomianList.add(((JSONArray)localObject3).optString(j));
              j += 1;
              continue;
            }
          }
          localObject2 = ((JSONObject)localObject2).optJSONArray("request_DomainList");
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
          {
            ((SplashMiniGameData)localObject1).requestDomianList = new ArrayList();
            j = 0;
            if (j < ((JSONArray)localObject2).length())
            {
              ((SplashMiniGameData)localObject1).requestDomianList.add(((JSONArray)localObject2).optString(j));
              j += 1;
              continue;
            }
          }
          localArrayList.add(localObject1);
          i += 1;
          continue;
        }
        BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0).edit().clear().commit();
        return;
      }
      catch (JSONException paramString)
      {
        Object localObject2;
        Object localObject3;
        int j;
        paramString.printStackTrace();
        SplashMiniGameStarter.refresh();
        if (localArrayList.size() < 1)
        {
          BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0).edit().clear().commit();
          FileUtils.deleteDirectory("/data/data/com.tencent.mobileqq/files/minigame/splash/");
          return;
        }
        BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0).edit().putInt("size", localArrayList.size()).commit();
        Object localObject1 = SplashMiniGameStarter.dataMap;
        paramString = localArrayList.iterator();
        i = 0;
        if (paramString.hasNext())
        {
          localObject2 = (SplashMiniGameData)paramString.next();
          if ((localObject1 != null) && (((HashMap)localObject1).containsKey(((SplashMiniGameData)localObject2).appId))) {
            modifyConfig(i, (SplashMiniGameData)((HashMap)localObject1).get(((SplashMiniGameData)localObject2).appId), (SplashMiniGameData)localObject2);
          } else {
            addConfig(i, (SplashMiniGameData)localObject2);
          }
          i += 1;
          continue;
        }
        if (localObject1 != null)
        {
          paramString = new ArrayList();
          localObject1 = ((HashMap)localObject1).values().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (SplashMiniGameData)((Iterator)localObject1).next();
            i = 0;
            j = 0;
            if (i < localArrayList.size())
            {
              localObject3 = (SplashMiniGameData)localArrayList.get(i);
              int k = j;
              if (localObject3 != null)
              {
                k = j;
                if (((SplashMiniGameData)localObject3).appId.equals(((SplashMiniGameData)localObject2).appId)) {
                  k = 1;
                }
              }
              i += 1;
              j = k;
              continue;
            }
            if (j != 0) {
              continue;
            }
            paramString.add(localObject2);
            continue;
          }
          if (paramString.size() > 0) {
            deleteConfig(paramString);
          }
        }
        BaseApplicationImpl.getApplication().getSharedPreferences("minigame_splash_setting", 0).edit().putString("appVersion", "8.7.0.5295").commit();
        SplashMiniGameStarter.refresh();
        return;
      }
      label809:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.splash.SplashMiniGameUtil
 * JD-Core Version:    0.7.0.1
 */