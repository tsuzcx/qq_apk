package com.tencent.youtu.sdkkitframework.net;

import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.util.HashMap;

public class YtSDKKitNetHelper
{
  private static final String TAG = YtSDKKitNetHelper.class.getSimpleName();
  private static final int TIME_OUT = 10000;
  private static YtSDKKitNetHelper _instane;
  
  public static void clearInstance()
  {
    try
    {
      _instane = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static YtSDKKitNetHelper getInstance()
  {
    try
    {
      if (_instane == null) {
        _instane = new YtSDKKitNetHelper();
      }
      YtSDKKitNetHelper localYtSDKKitNetHelper = _instane;
      return localYtSDKKitNetHelper;
    }
    finally {}
  }
  
  public void sendNetworkRequest(String paramString1, String paramString2, HashMap<String, String> paramHashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser)
  {
    new Thread(new YtSDKKitNetHelper.1(this, paramString1, paramHashMap, paramString2, paramIYtSDKKitNetResponseParser)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.net.YtSDKKitNetHelper
 * JD-Core Version:    0.7.0.1
 */