package com.tencent.qqlive.module.videoreport.dtreport.video.logic;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatSpUtils;
import com.tencent.qqlive.module.videoreport.utils.JsonUtils;
import java.util.HashMap;
import java.util.Map;

public class VideoHeartBeatSpUtils
{
  private static final String TAG = "VideoHeartBeatSpUtils";
  private static final String VIDEO_STAGING_END_EVENT_KEY = "video_staging_end_event_key";
  private static final String VIDEO_STAGING_STARTED_EVENT_KEY = "video_staging_started_event_key";
  
  public static void clearEndEvents()
  {
    Log.i("VideoHeartBeatSpUtils", "clearEndEvents");
    HeartBeatSpUtils.clearLastHeartBeat("video_staging_end_event_key");
  }
  
  public static void clearStartedEvents()
  {
    Log.i("VideoHeartBeatSpUtils", "clearStartedEvents");
    HeartBeatSpUtils.clearLastHeartBeat("video_staging_started_event_key");
  }
  
  public static Map<String, Object> getEndEvent()
  {
    Log.i("VideoHeartBeatSpUtils", "getEndEvent");
    return HeartBeatSpUtils.getLastHeartBeat("video_staging_end_event_key");
  }
  
  public static Map<String, Object> getStartedEvent()
  {
    Log.i("VideoHeartBeatSpUtils", "getStartedEvent");
    return HeartBeatSpUtils.getLastHeartBeat("video_staging_started_event_key");
  }
  
  public static void removeEndEvent(String paramString)
  {
    removeEvent("video_staging_end_event_key", paramString);
  }
  
  private static void removeEvent(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("removeEvent ,stagingEventKey:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" ,sessionId:");
    ((StringBuilder)localObject).append(paramString2);
    Log.i("VideoHeartBeatSpUtils", ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    localObject = HeartBeatSpUtils.getLastHeartBeat(paramString1);
    if (localObject != null)
    {
      if (((Map)localObject).isEmpty()) {
        return;
      }
      ((Map)localObject).remove(paramString2);
      HeartBeatSpUtils.saveLastHeartBeat(paramString1, (Map)localObject);
    }
  }
  
  public static void removeStartedEvent(String paramString)
  {
    removeEvent("video_staging_started_event_key", paramString);
  }
  
  public static void saveEndEvent(Map<String, Object> paramMap)
  {
    saveEvent("video_staging_end_event_key", paramMap);
  }
  
  private static void saveEvent(String paramString, Map<String, Object> paramMap)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("saveEvent, stagingEventKey: ");
    ((StringBuilder)localObject1).append(paramString);
    Log.i("VideoHeartBeatSpUtils", ((StringBuilder)localObject1).toString());
    if (paramMap == null) {
      return;
    }
    Object localObject2 = HeartBeatSpUtils.getLastHeartBeat(paramString);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new HashMap();
    }
    localObject2 = String.valueOf(paramMap.get("dt_video_contentid"));
    paramMap = JsonUtils.getJsonFromMap(paramMap);
    ((Map)localObject1).put(localObject2, paramMap);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveEvent,sessionKey: ");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(" ,sessionJson: ");
    localStringBuilder.append(paramMap);
    Log.i("VideoHeartBeatSpUtils", localStringBuilder.toString());
    HeartBeatSpUtils.saveLastHeartBeat(paramString, (Map)localObject1);
  }
  
  public static void saveStartedEvent(Map<String, Object> paramMap)
  {
    saveEvent("video_staging_started_event_key", paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoHeartBeatSpUtils
 * JD-Core Version:    0.7.0.1
 */