package com.tencent.qqlive.module.videoreport.staging;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StashKeyExtractor
{
  static final Set<String> VIDEO_KEY_SET = new HashSet();
  
  static
  {
    VIDEO_KEY_SET.add("dt_video_start");
    VIDEO_KEY_SET.add("dt_video_end");
  }
  
  public static String getStashKey(String paramString, Map<String, Object> paramMap)
  {
    if (VIDEO_KEY_SET.contains(paramString))
    {
      String str = (String)paramMap.get("dt_content_type");
      paramMap = (String)paramMap.get("dt_video_contentid");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append(str);
      localStringBuilder.append("_");
      localStringBuilder.append(paramMap);
      return localStringBuilder.toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.staging.StashKeyExtractor
 * JD-Core Version:    0.7.0.1
 */