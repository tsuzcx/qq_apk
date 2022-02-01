package com.tencent.tav.core;

import android.support.annotation.NonNull;
import java.util.concurrent.ConcurrentHashMap;

public class AssetExtension
{
  public static final String SCENE_EXPORT = "export";
  public static final String SCENE_PLAY = "play";
  public static final String SCENE_THUMBNAIL = "thumbnail";
  private volatile ConcurrentHashMap<String, Object> extensionMap = new ConcurrentHashMap();
  private final String scene;
  
  public AssetExtension(@NonNull String paramString)
  {
    this.scene = paramString;
  }
  
  public void addExtension(@NonNull String paramString, @NonNull Object paramObject)
  {
    this.extensionMap.put(paramString, paramObject);
  }
  
  public boolean containsKey(@NonNull String paramString)
  {
    return this.extensionMap.containsKey(paramString);
  }
  
  public boolean containsValue(@NonNull String paramString)
  {
    return this.extensionMap.containsValue(paramString);
  }
  
  public String getScene()
  {
    return this.scene;
  }
  
  public Object remove(@NonNull String paramString)
  {
    return this.extensionMap.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.core.AssetExtension
 * JD-Core Version:    0.7.0.1
 */