package com.tencent.superplayer.vinfo;

import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.utils.LogUtil;
import java.util.concurrent.ConcurrentHashMap;

class VInfoCacheMgr
{
  private static final String TAG = "VInfoCacheMgr";
  private static final int VINFO_CACHE_SAVE_TIME_MILLIS = 7200000;
  private static ConcurrentHashMap<String, SuperPlayerVideoInfo> mVinfoCache = new ConcurrentHashMap();
  
  private static boolean checkVInfoIsValid(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    return (paramSuperPlayerVideoInfo != null) && (paramSuperPlayerVideoInfo.getVideoType() == 1) && (!TextUtils.isEmpty(getKeyFromVInfo(paramSuperPlayerVideoInfo))) && (!paramSuperPlayerVideoInfo.getIsDisableTVideoCache());
  }
  
  private static boolean checkVInfoUpdateTimeIsValid(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramSuperPlayerVideoInfo != null)
    {
      if (paramSuperPlayerVideoInfo.getTVideoNetInfo() == null) {
        return false;
      }
      long l = paramSuperPlayerVideoInfo.getTVideoNetInfo().getUpdateTimeMillis();
      bool1 = bool2;
      if (System.currentTimeMillis() - l < 7200000L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static String getKeyFromVInfo(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramSuperPlayerVideoInfo.getVid());
    localStringBuilder.append(paramSuperPlayerVideoInfo.getRequestDefinition());
    return localStringBuilder.toString();
  }
  
  static SuperPlayerVideoInfo getVInfoFromCache(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (!checkVInfoIsValid(paramSuperPlayerVideoInfo)) {
      return null;
    }
    String str = getKeyFromVInfo(paramSuperPlayerVideoInfo);
    paramSuperPlayerVideoInfo = (SuperPlayerVideoInfo)mVinfoCache.get(str);
    if (paramSuperPlayerVideoInfo == null) {
      return null;
    }
    if (checkVInfoUpdateTimeIsValid(paramSuperPlayerVideoInfo))
    {
      str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("腾讯视频换链命中本地缓存, cacheInfo = ");
      localStringBuilder.append(paramSuperPlayerVideoInfo.toString());
      LogUtil.d(str, localStringBuilder.toString());
      return paramSuperPlayerVideoInfo;
    }
    mVinfoCache.remove(str);
    return null;
  }
  
  static void saveVInfoToCache(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (!checkVInfoIsValid(paramSuperPlayerVideoInfo)) {
      return;
    }
    String str = getKeyFromVInfo(paramSuperPlayerVideoInfo);
    try
    {
      paramSuperPlayerVideoInfo = (SuperPlayerVideoInfo)paramSuperPlayerVideoInfo.clone();
      mVinfoCache.put(str, paramSuperPlayerVideoInfo);
      return;
    }
    catch (Exception paramSuperPlayerVideoInfo)
    {
      LogUtil.e(TAG, paramSuperPlayerVideoInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.vinfo.VInfoCacheMgr
 * JD-Core Version:    0.7.0.1
 */