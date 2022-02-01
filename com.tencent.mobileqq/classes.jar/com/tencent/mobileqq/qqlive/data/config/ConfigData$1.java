package com.tencent.mobileqq.qqlive.data.config;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ConfigData$1
  implements Parcelable.Creator<ConfigData>
{
  public ConfigData createFromParcel(Parcel paramParcel)
  {
    ConfigData localConfigData = new ConfigData();
    localConfigData.readFromParcel(paramParcel);
    return localConfigData;
  }
  
  public ConfigData[] newArray(int paramInt)
  {
    return new ConfigData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.config.ConfigData.1
 * JD-Core Version:    0.7.0.1
 */