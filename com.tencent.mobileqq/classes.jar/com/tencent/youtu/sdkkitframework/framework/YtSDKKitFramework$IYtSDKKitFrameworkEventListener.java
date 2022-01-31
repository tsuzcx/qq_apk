package com.tencent.youtu.sdkkitframework.framework;

import java.util.HashMap;

public abstract interface YtSDKKitFramework$IYtSDKKitFrameworkEventListener
{
  public abstract void onFrameworkEvent(HashMap<String, Object> paramHashMap);
  
  public abstract void onNetworkRequestEvent(String paramString1, String paramString2, HashMap<String, String> paramHashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitFrameworkEventListener
 * JD-Core Version:    0.7.0.1
 */