package com.tencent.qqlive.module.videoreport;

import java.util.Map;

public abstract interface IEventDynamicParams
{
  public abstract void setEventDynamicParams(String paramString, Map<String, Object> paramMap);
  
  public abstract void setNonRealtimePublicDynamicParams(Map<String, Object> paramMap);
  
  public abstract void setRealtimePublicDynamicParams(Map<String, Object> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.IEventDynamicParams
 * JD-Core Version:    0.7.0.1
 */