package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.NonNull;
import java.util.WeakHashMap;

public class VideoReportDataStorage<T>
{
  private final WeakHashMap<Object, T> DATA_MAP = new WeakHashMap();
  
  public T getData(@NonNull Object paramObject)
  {
    return this.DATA_MAP.get(paramObject);
  }
  
  public void removeData(@NonNull Object paramObject)
  {
    this.DATA_MAP.remove(paramObject);
  }
  
  public void setData(@NonNull Object paramObject, T paramT)
  {
    this.DATA_MAP.put(paramObject, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.data.VideoReportDataStorage
 * JD-Core Version:    0.7.0.1
 */