package com.tencent.qqlive.module.videoreport.staging;

import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.Map;

public class CustomEventStagingData
{
  private final String eventId;
  private final Map<String, ?> map;
  private final WeakReference<Object> object;
  
  public CustomEventStagingData(String paramString, @Nullable Object paramObject, Map<String, ?> paramMap)
  {
    this.eventId = paramString;
    if (paramObject != null) {
      this.object = new WeakReference(paramObject);
    } else {
      this.object = null;
    }
    this.map = paramMap;
  }
  
  public String getEventId()
  {
    return this.eventId;
  }
  
  public Map<String, ?> getMap()
  {
    return this.map;
  }
  
  public Object getObject()
  {
    WeakReference localWeakReference = this.object;
    if (localWeakReference != null) {
      return localWeakReference.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.staging.CustomEventStagingData
 * JD-Core Version:    0.7.0.1
 */