package com.tencent.mobileqq.qqlive.data.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;

public class ConfigData
  implements Parcelable
{
  public static final Parcelable.Creator<ConfigData> CREATOR = new ConfigData.1();
  private String liveAppId = "";
  private String liveAppKey = "";
  private int liveClientType = 0;
  private String openSDKAppId = "";
  private String smartEyeAppId = "";
  private String trtcSDKAppId = "";
  
  public static ConfigData.Builder createBuilder()
  {
    return new ConfigData.Builder(null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (((paramObject instanceof ConfigData)) && (((ConfigData)paramObject).liveAppId.equalsIgnoreCase(this.liveAppId))) {
      return true;
    }
    return super.equals(paramObject);
  }
  
  public String getLiveAppId()
  {
    return this.liveAppId;
  }
  
  public String getLiveAppKey()
  {
    return this.liveAppKey;
  }
  
  public int getLiveClientType()
  {
    return this.liveClientType;
  }
  
  public String getOpenSDKAppId()
  {
    return this.openSDKAppId;
  }
  
  public String getSmartEyeAppId()
  {
    return this.smartEyeAppId;
  }
  
  public String getTrtcSDKAppId()
  {
    return this.trtcSDKAppId;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.liveAppId = paramParcel.readString();
    this.liveAppKey = paramParcel.readString();
    this.liveClientType = paramParcel.readInt();
    this.openSDKAppId = paramParcel.readString();
    this.trtcSDKAppId = paramParcel.readString();
    this.smartEyeAppId = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.liveAppId);
    paramParcel.writeString(this.liveAppKey);
    paramParcel.writeInt(this.liveClientType);
    paramParcel.writeString(this.openSDKAppId);
    paramParcel.writeString(this.trtcSDKAppId);
    paramParcel.writeString(this.smartEyeAppId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.config.ConfigData
 * JD-Core Version:    0.7.0.1
 */