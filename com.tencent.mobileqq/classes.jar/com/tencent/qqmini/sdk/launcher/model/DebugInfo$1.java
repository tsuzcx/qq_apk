package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class DebugInfo$1
  implements Parcelable.Creator<DebugInfo>
{
  public DebugInfo createFromParcel(Parcel paramParcel)
  {
    DebugInfo localDebugInfo = new DebugInfo();
    localDebugInfo.roomId = paramParcel.readString();
    localDebugInfo.wsUrl = paramParcel.readString();
    return localDebugInfo;
  }
  
  public DebugInfo[] newArray(int paramInt)
  {
    return new DebugInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.DebugInfo.1
 * JD-Core Version:    0.7.0.1
 */