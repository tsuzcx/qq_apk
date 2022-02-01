package com.tencent.tmassistant.appinfo.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AppParam
  implements Parcelable
{
  public static final Parcelable.Creator<AppParam> CREATOR = new c();
  public String channelId;
  public String packageName;
  
  public AppParam() {}
  
  protected AppParam(Parcel paramParcel)
  {
    this.channelId = paramParcel.readString();
    this.packageName = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.channelId);
    paramParcel.writeString(this.packageName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.appinfo.data.AppParam
 * JD-Core Version:    0.7.0.1
 */