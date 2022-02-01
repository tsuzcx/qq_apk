package org.light.listener;

import java.util.HashMap;

public abstract interface LightAssetListener
{
  public abstract void OnAssetProcessing(HashMap<String, String> paramHashMap);
  
  public abstract void OnLoadAssetError(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.listener.LightAssetListener
 * JD-Core Version:    0.7.0.1
 */