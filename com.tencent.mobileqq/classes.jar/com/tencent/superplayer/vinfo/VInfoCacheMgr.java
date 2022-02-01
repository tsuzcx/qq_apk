package com.tencent.superplayer.vinfo;

import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.utils.LogUtil;
import java.util.concurrent.ConcurrentHashMap;

class VInfoCacheMgr
{
  private static final String TAG = VInfoCacheMgr.class.getSimpleName();
  private static final int VINFO_CACHE_SAVE_TIME_MILLIS = 7200000;
  private static ConcurrentHashMap<String, SuperPlayerVideoInfo> mVinfoCache = new ConcurrentHashMap();
  
  private static boolean checkVInfoIsValid(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    return (paramSuperPlayerVideoInfo != null) && (paramSuperPlayerVideoInfo.getVideoType() == 1) && (!TextUtils.isEmpty(getKeyFromVInfo(paramSuperPlayerVideoInfo))) && (!paramSuperPlayerVideoInfo.getIsDisableTVideoCache());
  }
  
  private static boolean checkVInfoUpdateTimeIsValid(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if ((paramSuperPlayerVideoInfo == null) || (paramSuperPlayerVideoInfo.getTVideoNetInfo() == null)) {}
    long l;
    do
    {
      return false;
      l = paramSuperPlayerVideoInfo.getTVideoNetInfo().getUpdateTimeMillis();
    } while (System.currentTimeMillis() - l >= 7200000L);
    return true;
  }
  
  private static String getKeyFromVInfo(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    return paramSuperPlayerVideoInfo.getVid() + paramSuperPlayerVideoInfo.getRequestDefinition();
  }
  
  static SuperPlayerVideoInfo getVInfoFromCache(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (!checkVInfoIsValid(paramSuperPlayerVideoInfo)) {
      return null;
    }
    paramSuperPlayerVideoInfo = getKeyFromVInfo(paramSuperPlayerVideoInfo);
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = (SuperPlayerVideoInfo)mVinfoCache.get(paramSuperPlayerVideoInfo);
    if (localSuperPlayerVideoInfo == null) {
      return null;
    }
    if (checkVInfoUpdateTimeIsValid(localSuperPlayerVideoInfo))
    {
      LogUtil.d(TAG, "腾讯视频换链命中本地缓存, cacheInfo = " + localSuperPlayerVideoInfo.toString());
      return localSuperPlayerVideoInfo;
    }
    mVinfoCache.remove(paramSuperPlayerVideoInfo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.vinfo.VInfoCacheMgr
 * JD-Core Version:    0.7.0.1
 */