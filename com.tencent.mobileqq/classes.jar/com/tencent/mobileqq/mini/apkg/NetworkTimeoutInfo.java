package com.tencent.mobileqq.mini.apkg;

import org.json.JSONObject;

public class NetworkTimeoutInfo
{
  public static final int TIME_DEFAULT_MS = 60000;
  public int connectSocket = 60000;
  public int downloadFile = 60000;
  public int request = 60000;
  public int uploadFile = 60000;
  
  public static NetworkTimeoutInfo parse(JSONObject paramJSONObject)
  {
    NetworkTimeoutInfo localNetworkTimeoutInfo = new NetworkTimeoutInfo();
    int j = 60000;
    int i;
    if (paramJSONObject == null) {
      i = 60000;
    } else {
      i = paramJSONObject.optInt("request", 60000);
    }
    localNetworkTimeoutInfo.request = i;
    if (paramJSONObject == null) {
      i = 60000;
    } else {
      i = paramJSONObject.optInt("connectSocket", 60000);
    }
    localNetworkTimeoutInfo.connectSocket = i;
    if (paramJSONObject == null) {
      i = 60000;
    } else {
      i = paramJSONObject.optInt("uploadFile", 60000);
    }
    localNetworkTimeoutInfo.uploadFile = i;
    if (paramJSONObject == null) {
      i = j;
    } else {
      i = paramJSONObject.optInt("downloadFile", 60000);
    }
    localNetworkTimeoutInfo.downloadFile = i;
    return localNetworkTimeoutInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.NetworkTimeoutInfo
 * JD-Core Version:    0.7.0.1
 */