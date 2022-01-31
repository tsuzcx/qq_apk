package com.tencent.mobileqq.pluginsdk;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PluginBaseInfo$1
  implements Parcelable.Creator<PluginBaseInfo>
{
  public PluginBaseInfo createFromParcel(Parcel paramParcel)
  {
    return new PluginBaseInfo(paramParcel);
  }
  
  public PluginBaseInfo[] newArray(int paramInt)
  {
    return new PluginBaseInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginBaseInfo.1
 * JD-Core Version:    0.7.0.1
 */