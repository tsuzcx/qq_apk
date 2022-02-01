package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.NonNull;
import java.util.WeakHashMap;

public class VideoReportDataStorage<T>
{
  private final WeakHashMap<Object, T> mDataMap = new WeakHashMap();
  
  public T getData(@NonNull Object paramObject)
  {
    return this.mDataMap.get(paramObject);
  }
  
  public void removeData(@NonNull Object paramObject)
  {
    this.mDataMap.remove(paramObject);
  }
  
  public void setData(@NonNull Object paramObject, T paramT)
  {
    this.mDataMap.put(paramObject, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.data.VideoReportDataStorage
 * JD-Core Version:    0.7.0.1
 */