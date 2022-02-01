package com.tencent.ttpic.VideoPref;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import java.io.File;

public class OnlineResPref
{
  public static final String ASSET_CONF = "DySoConf";
  public static final String BODY_LIB_ZIP = "bodydetector.zip";
  public static final String GESTURE_LIB_ZIP = "gesturedetector.zip";
  public static final String SEGMENT_LIB_ZIP = "segment.zip";
  
  public static String getAnimojiLibMd5()
  {
    return VideoPrefsUtil.getSoPrefs().getString("animoji_lib_md5", "");
  }
  
  public static String getAnimojiPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getLibLoadPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("animoji");
    return localStringBuilder.toString();
  }
  
  public static String getBodyLibMd5()
  {
    return VideoPrefsUtil.getSoPrefs().getString("body_lib_md5", "");
  }
  
  public static String getBodyLibPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getLibLoadPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("bodydetector");
    return localStringBuilder.toString();
  }
  
  public static String getBodyModelPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getBodyLibPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("model");
    return localStringBuilder.toString();
  }
  
  public static String getDownloadPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEModule.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("downloadLib");
    return localStringBuilder.toString();
  }
  
  public static String getGestureLibMd5()
  {
    return VideoPrefsUtil.getSoPrefs().getString("gesture_lib_md5", "");
  }
  
  public static String getGestureLibPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getLibLoadPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("gesturedetector");
    return localStringBuilder.toString();
  }
  
  public static String getGestureModelPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getGestureLibPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("model");
    return localStringBuilder.toString();
  }
  
  public static String getLibLoadPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEModule.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("ptLib");
    return localStringBuilder.toString();
  }
  
  public static String getOnlineResConfPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEModule.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("resConf");
    return localStringBuilder.toString();
  }
  
  public static String getSegmentLibMd5()
  {
    return VideoPrefsUtil.getSoPrefs().getString("segment_lib_md5", "");
  }
  
  public static String getSegmentLibPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getLibLoadPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("segment");
    return localStringBuilder.toString();
  }
  
  public static String getSegmentModelPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getSegmentLibPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("model");
    return localStringBuilder.toString();
  }
  
  public static Boolean isBodyLibDownloaded()
  {
    return Boolean.valueOf(VideoPrefsUtil.getSoPrefs().getBoolean("body_lib_downloaded", false));
  }
  
  public static Boolean isBodyLibExist()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getBodyLibPath());
    ((StringBuilder)localObject1).append(File.separator);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("libxnet.so");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("libbodydetector.so");
    localObject1 = localStringBuilder.toString();
    boolean bool;
    if ((FileUtils.exists((String)localObject2)) && (FileUtils.exists((String)localObject1))) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  public static Boolean isBodyLibNeedLoad()
  {
    return Boolean.valueOf(VideoPrefsUtil.getSoPrefs().getBoolean("body_lib_need_load", true));
  }
  
  public static Boolean isGestureLibDownloaded()
  {
    return Boolean.valueOf(VideoPrefsUtil.getSoPrefs().getBoolean("gesture_lib_downloaded", false));
  }
  
  public static Boolean isGestureLibExist()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getGestureLibPath());
    ((StringBuilder)localObject1).append(File.separator);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("libYTHandDetector.so");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("libGestureDetectJni.so");
    localObject1 = localStringBuilder.toString();
    boolean bool;
    if ((FileUtils.exists((String)localObject2)) && (FileUtils.exists((String)localObject1))) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  public static Boolean isGestureLibNeedLoad()
  {
    return Boolean.valueOf(VideoPrefsUtil.getSoPrefs().getBoolean("gesture_lib_need_load", true));
  }
  
  public static Boolean isSegmentLibDownloaded()
  {
    return Boolean.valueOf(VideoPrefsUtil.getSoPrefs().getBoolean("segment_lib_downloaded", false));
  }
  
  public static Boolean isSegmentLibExist()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getSegmentLibPath());
    ((StringBuilder)localObject).append(File.separator);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("libsegmentern.so");
    return Boolean.valueOf(FileUtils.exists(localStringBuilder.toString()));
  }
  
  public static Boolean isSegmentLibNeedLoad()
  {
    return Boolean.valueOf(VideoPrefsUtil.getSoPrefs().getBoolean("segment_lib_need_load", true));
  }
  
  public static void setAnimojiLibMd5(String paramString)
  {
    VideoPrefsUtil.getSoPrefs().edit().putString("animoji_lib_md5", paramString).apply();
  }
  
  public static void setBodyLibDownloaded(boolean paramBoolean)
  {
    VideoPrefsUtil.getSoPrefs().edit().putBoolean("body_lib_downloaded", paramBoolean).apply();
  }
  
  public static void setBodyLibMd5(String paramString)
  {
    VideoPrefsUtil.getSoPrefs().edit().putString("body_lib_md5", paramString).apply();
  }
  
  public static void setBodyLibNeedLoad(boolean paramBoolean)
  {
    VideoPrefsUtil.getSoPrefs().edit().putBoolean("body_lib_need_load", paramBoolean).apply();
  }
  
  public static void setGestureLibDownloaded(boolean paramBoolean)
  {
    VideoPrefsUtil.getSoPrefs().edit().putBoolean("gesture_lib_downloaded", paramBoolean).apply();
  }
  
  public static void setGestureLibMd5(String paramString)
  {
    VideoPrefsUtil.getSoPrefs().edit().putString("gesture_lib_md5", paramString).apply();
  }
  
  public static void setGestureLibNeedLoad(boolean paramBoolean)
  {
    VideoPrefsUtil.getSoPrefs().edit().putBoolean("gesture_lib_need_load", paramBoolean).apply();
  }
  
  public static void setSegmentLibDownloaded(boolean paramBoolean)
  {
    VideoPrefsUtil.getSoPrefs().edit().putBoolean("segment_lib_downloaded", paramBoolean).apply();
  }
  
  public static void setSegmentLibMd5(String paramString)
  {
    VideoPrefsUtil.getSoPrefs().edit().putString("segment_lib_md5", paramString).apply();
  }
  
  public static void setSegmentLibNeedLoad(boolean paramBoolean)
  {
    VideoPrefsUtil.getSoPrefs().edit().putBoolean("segment_lib_need_load", paramBoolean).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.VideoPref.OnlineResPref
 * JD-Core Version:    0.7.0.1
 */