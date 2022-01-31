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
    int j = 60000;
    NetworkTimeoutInfo localNetworkTimeoutInfo = new NetworkTimeoutInfo();
    if (paramJSONObject == null)
    {
      i = 60000;
      localNetworkTimeoutInfo.request = i;
      if (paramJSONObject != null) {
        break label72;
      }
      i = 60000;
      label30:
      localNetworkTimeoutInfo.connectSocket = i;
      if (paramJSONObject != null) {
        break label84;
      }
      i = 60000;
      label42:
      localNetworkTimeoutInfo.uploadFile = i;
      if (paramJSONObject != null) {
        break label96;
      }
    }
    label72:
    label84:
    label96:
    for (int i = j;; i = paramJSONObject.optInt("downloadFile", 60000))
    {
      localNetworkTimeoutInfo.downloadFile = i;
      return localNetworkTimeoutInfo;
      i = paramJSONObject.optInt("request", 60000);
      break;
      i = paramJSONObject.optInt("connectSocket", 60000);
      break label30;
      i = paramJSONObject.optInt("uploadFile", 60000);
      break label42;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.NetworkTimeoutInfo
 * JD-Core Version:    0.7.0.1
 */