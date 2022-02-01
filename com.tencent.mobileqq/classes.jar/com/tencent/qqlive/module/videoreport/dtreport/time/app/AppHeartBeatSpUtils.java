package com.tencent.qqlive.module.videoreport.dtreport.time.app;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatSpUtils;
import java.util.HashMap;
import java.util.Map;

public class AppHeartBeatSpUtils
{
  public static void clearSessionHeartBeat()
  {
    try
    {
      HeartBeatSpUtils.clearLastHeartBeat("last_app_heart_beat_map");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static Map<String, Object> getLastHeartBeatMap()
  {
    return HeartBeatSpUtils.getLastHeartBeat("last_app_heart_beat_map");
  }
  
  public static void removeSessionHeartBeat(String paramString)
  {
    saveSessionLastHeartBeat(paramString, "");
  }
  
  public static void saveSessionLastHeartBeat(String paramString1, String paramString2)
  {
    try
    {
      Map localMap = getLastHeartBeatMap();
      Object localObject = localMap;
      if (localMap == null) {
        localObject = new HashMap();
      }
      if (TextUtils.isEmpty(paramString2))
      {
        boolean bool = ((Map)localObject).containsKey(paramString1);
        if (!bool) {
          return;
        }
        ((Map)localObject).remove(paramString1);
      }
      else
      {
        ((Map)localObject).put(paramString1, paramString2);
      }
      saveSessionLastHeartBeat((Map)localObject);
      return;
    }
    finally {}
  }
  
  public static void saveSessionLastHeartBeat(Map<String, Object> paramMap)
  {
    try
    {
      HeartBeatSpUtils.saveLastHeartBeat("last_app_heart_beat_map", paramMap);
      return;
    }
    finally
    {
      paramMap = finally;
      throw paramMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.app.AppHeartBeatSpUtils
 * JD-Core Version:    0.7.0.1
 */