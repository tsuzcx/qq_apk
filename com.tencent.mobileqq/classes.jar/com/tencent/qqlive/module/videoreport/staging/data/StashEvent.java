package com.tencent.qqlive.module.videoreport.staging.data;

import com.tencent.qqlive.module.videoreport.storage.annotation.ClassId;
import java.util.Map;

@ClassId("stash_event")
public class StashEvent
{
  private String mAppKey;
  private String mEventKey;
  private Map<String, Object> mEventParams;
  
  public StashEvent(String paramString1, Map<String, Object> paramMap, String paramString2)
  {
    this.mEventKey = paramString1;
    this.mEventParams = paramMap;
    this.mAppKey = paramString2;
  }
  
  public String getAppKey()
  {
    return this.mAppKey;
  }
  
  public String getEventKey()
  {
    return this.mEventKey;
  }
  
  public Map<String, Object> getEventParams()
  {
    return this.mEventParams;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StashEvent{mEventKey='");
    localStringBuilder.append(this.mEventKey);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mEventParams=");
    localStringBuilder.append(this.mEventParams);
    localStringBuilder.append(", mAppKey='");
    localStringBuilder.append(this.mAppKey);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.staging.data.StashEvent
 * JD-Core Version:    0.7.0.1
 */