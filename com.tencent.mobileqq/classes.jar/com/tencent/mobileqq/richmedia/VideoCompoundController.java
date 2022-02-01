package com.tencent.mobileqq.richmedia;

import java.util.concurrent.ConcurrentHashMap;

public class VideoCompoundController
{
  public ConcurrentHashMap<String, CompoundProcessor> a = new ConcurrentHashMap(10);
  
  public boolean a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeProcessor, key = ");
    localStringBuilder.append(paramString);
    LOG.a("VideoCompoundController", localStringBuilder.toString());
    boolean bool = false;
    if (paramString == null) {
      return false;
    }
    if (this.a.remove(paramString) != null) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.VideoCompoundController
 * JD-Core Version:    0.7.0.1
 */