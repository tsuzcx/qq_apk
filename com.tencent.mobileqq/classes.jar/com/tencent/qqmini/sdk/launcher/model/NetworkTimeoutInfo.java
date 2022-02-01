package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class NetworkTimeoutInfo
  implements Parcelable
{
  public static final Parcelable.Creator<NetworkTimeoutInfo> CREATOR = new NetworkTimeoutInfo.1();
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
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NetworkTimeoutInfo{request='");
    localStringBuilder.append(this.request);
    localStringBuilder.append('\'');
    localStringBuilder.append(", connectSocket='");
    localStringBuilder.append(this.connectSocket);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uploadFile='");
    localStringBuilder.append(this.uploadFile);
    localStringBuilder.append('\'');
    localStringBuilder.append(", downloadFile='");
    localStringBuilder.append(this.downloadFile);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.request);
    paramParcel.writeInt(this.connectSocket);
    paramParcel.writeInt(this.uploadFile);
    paramParcel.writeInt(this.downloadFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.NetworkTimeoutInfo
 * JD-Core Version:    0.7.0.1
 */