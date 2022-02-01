package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class NetworkTimeoutInfo$1
  implements Parcelable.Creator<NetworkTimeoutInfo>
{
  public NetworkTimeoutInfo createFromParcel(Parcel paramParcel)
  {
    NetworkTimeoutInfo localNetworkTimeoutInfo = new NetworkTimeoutInfo();
    localNetworkTimeoutInfo.request = paramParcel.readInt();
    localNetworkTimeoutInfo.connectSocket = paramParcel.readInt();
    localNetworkTimeoutInfo.uploadFile = paramParcel.readInt();
    localNetworkTimeoutInfo.downloadFile = paramParcel.readInt();
    return localNetworkTimeoutInfo;
  }
  
  public NetworkTimeoutInfo[] newArray(int paramInt)
  {
    return new NetworkTimeoutInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.NetworkTimeoutInfo.1
 * JD-Core Version:    0.7.0.1
 */