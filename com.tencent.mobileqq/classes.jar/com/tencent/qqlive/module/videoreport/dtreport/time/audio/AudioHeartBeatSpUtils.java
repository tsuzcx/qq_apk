package com.tencent.qqlive.module.videoreport.dtreport.time.audio;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.utils.JsonUtils;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.SPUtils;
import java.util.HashMap;
import java.util.Map;

public class AudioHeartBeatSpUtils
{
  public static void clearLastHeartBeatMap()
  {
    try
    {
      SPUtils.put(ReportUtils.getContext(), "last_audio_heart_beat_map", "");
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
    String str = (String)SPUtils.get(ReportUtils.getContext(), "last_audio_heart_beat_map", "");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return JsonUtils.getMapForJson(str);
  }
  
  public static void saveAudioSessionLastHeartBeat(String paramString1, String paramString2)
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
      paramString1 = JsonUtils.getJsonFromMap((Map)localObject);
      SPUtils.put(ReportUtils.getContext(), "last_audio_heart_beat_map", paramString1);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.audio.AudioHeartBeatSpUtils
 * JD-Core Version:    0.7.0.1
 */