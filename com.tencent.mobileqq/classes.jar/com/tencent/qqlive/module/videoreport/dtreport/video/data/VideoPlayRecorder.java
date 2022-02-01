package com.tencent.qqlive.module.videoreport.dtreport.video.data;

import android.support.annotation.NonNull;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoPlayRecorder
{
  private static Map<String, Long> sDTSumPlayDurationMap = new ConcurrentHashMap();
  private static Map<String, Integer> sDTVideoIndexMap = new ConcurrentHashMap();
  
  public static void dealSumPlayDuration(VideoSession paramVideoSession)
  {
    for (;;)
    {
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramVideoSession.getContentId());
        ((StringBuilder)localObject).append(paramVideoSession.getContentType());
        localObject = ((StringBuilder)localObject).toString();
        Long localLong = (Long)sDTSumPlayDurationMap.get(localObject);
        long l2 = Long.parseLong(paramVideoSession.getPlayedTime());
        if (localLong != null)
        {
          l1 = localLong.longValue();
          sDTSumPlayDurationMap.put(localObject, Long.valueOf(l2 + l1));
          return;
        }
      }
      finally {}
      long l1 = 0L;
    }
  }
  
  public static void dealVideoIndex(VideoSession paramVideoSession)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramVideoSession.getContentId());
      ((StringBuilder)localObject).append(paramVideoSession.getContentType());
      paramVideoSession = ((StringBuilder)localObject).toString();
      localObject = (Integer)sDTVideoIndexMap.get(paramVideoSession);
      int i = 1;
      if (localObject != null) {
        i = 1 + ((Integer)localObject).intValue();
      }
      sDTVideoIndexMap.put(paramVideoSession, Integer.valueOf(i));
      return;
    }
    finally {}
  }
  
  public static long getSumPlayDuration(@NonNull VideoSession paramVideoSession)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramVideoSession.getContentId());
    localStringBuilder.append(paramVideoSession.getContentType());
    paramVideoSession = localStringBuilder.toString();
    paramVideoSession = (Long)sDTSumPlayDurationMap.get(paramVideoSession);
    if (paramVideoSession != null) {
      return paramVideoSession.longValue();
    }
    return 0L;
  }
  
  public static int getVideoIndex(@NonNull VideoSession paramVideoSession)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramVideoSession.getContentId());
    localStringBuilder.append(paramVideoSession.getContentType());
    paramVideoSession = localStringBuilder.toString();
    paramVideoSession = (Integer)sDTVideoIndexMap.get(paramVideoSession);
    if (paramVideoSession != null) {
      return paramVideoSession.intValue();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoPlayRecorder
 * JD-Core Version:    0.7.0.1
 */