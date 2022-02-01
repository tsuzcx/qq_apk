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
    return getLibLoadPath() + File.separator + "animoji";
  }
  
  public static String getBodyLibMd5()
  {
    return VideoPrefsUtil.getSoPrefs().getString("body_lib_md5", "");
  }
  
  public static String getBodyLibPath()
  {
    return getLibLoadPath() + File.separator + "bodydetector";
  }
  
  public static String getBodyModelPath()
  {
    return getBodyLibPath() + File.separator + "model";
  }
  
  public static String getDownloadPath()
  {
    return AEModule.getContext().getFilesDir().getAbsolutePath() + File.separator + "downloadLib";
  }
  
  public static String getGestureLibMd5()
  {
    return VideoPrefsUtil.getSoPrefs().getString("gesture_lib_md5", "");
  }
  
  public static String getGestureLibPath()
  {
    return getLibLoadPath() + File.separator + "gesturedetector";
  }
  
  public static String getGestureModelPath()
  {
    return getGestureLibPath() + File.separator + "model";
  }
  
  public static String getLibLoadPath()
  {
    return AEModule.getContext().getFilesDir().getAbsolutePath() + File.separator + "ptLib";
  }
  
  public static String getOnlineResConfPath()
  {
    return AEModule.getContext().getFilesDir().getAbsolutePath() + File.separator + "resConf";
  }
  
  public static String getSegmentLibMd5()
  {
    return VideoPrefsUtil.getSoPrefs().getString("segment_lib_md5", "");
  }
  
  public static String getSegmentLibPath()
  {
    return getLibLoadPath() + File.separator + "segment";
  }
  
  public static String getSegmentModelPath()
  {
    return getSegmentLibPath() + File.separator + "model";
  }
  
  public static Boolean isBodyLibDownloaded()
  {
    return Boolean.valueOf(VideoPrefsUtil.getSoPrefs().getBoolean("body_lib_downloaded", false));
  }
  
  public static Boolean isBodyLibExist()
  {
    String str2 = getBodyLibPath() + File.separator;
    String str1 = str2 + "libxnet.so";
    str2 = str2 + "libbodydetector.so";
    if ((FileUtils.exists(str1)) && (FileUtils.exists(str2))) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
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
    String str2 = getGestureLibPath() + File.separator;
    String str1 = str2 + "libYTHandDetector.so";
    str2 = str2 + "libGestureDetectJni.so";
    if ((FileUtils.exists(str1)) && (FileUtils.exists(str2))) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
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
    String str = getSegmentLibPath() + File.separator;
    return Boolean.valueOf(FileUtils.exists(str + "libsegmentern.so"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.VideoPref.OnlineResPref
 * JD-Core Version:    0.7.0.1
 */