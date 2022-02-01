package com.tencent.youtu.sdkkitframework.net;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

public class YtSDKKitNetHelper
{
  private static final String TAG = "YtSDKKitNetHelper";
  private static final int TIME_OUT = 10000;
  private static YtSDKKitNetHelper _instane;
  private HttpsURLConnection conn;
  private Thread networkThread;
  private HashMap<Integer, Thread> runningMap = new HashMap();
  
  public static void clearInstance()
  {
    try
    {
      if (_instane != null) {
        _instane.stopNetworkRequest();
      }
      _instane = null;
      return;
    }
    finally {}
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
    this.networkThread = new Thread(new YtSDKKitNetHelper.1(this, paramString1, paramHashMap, paramString2, paramIYtSDKKitNetResponseParser));
    this.networkThread.setName("YtNetworkRequestThread");
    this.networkThread.start();
  }
  
  public void sendNetworkRequestEncry(String paramString1, String paramString2, HashMap<String, String> paramHashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser)
  {
    this.networkThread = new Thread(new YtSDKKitNetHelper.2(this, paramString1, paramHashMap, paramString2, paramIYtSDKKitNetResponseParser));
    this.networkThread.setName("YtNetworkRequestThread");
    this.networkThread.start();
  }
  
  public void stopNetworkRequest()
  {
    Object localObject = this.runningMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (localEntry.getValue() == this.networkThread)
      {
        this.runningMap.remove(localEntry.getKey());
        localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("network remove ");
        localStringBuilder.append(localEntry.getKey());
        YtLogger.d((String)localObject, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.net.YtSDKKitNetHelper
 * JD-Core Version:    0.7.0.1
 */