package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RealTimeLogItem
  implements Parcelable
{
  public static final Parcelable.Creator<RealTimeLogItem> CREATOR = new RealTimeLogItem.1();
  public int level;
  public String msg;
  public long time;
  
  public RealTimeLogItem(long paramLong, int paramInt, String paramString)
  {
    this.time = paramLong;
    this.level = paramInt;
    this.msg = paramString;
  }
  
  private RealTimeLogItem(Parcel paramParcel)
  {
    this.time = paramParcel.readLong();
    this.level = paramParcel.readInt();
    this.msg = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.time);
    paramParcel.writeInt(this.level);
    paramParcel.writeString(this.msg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem
 * JD-Core Version:    0.7.0.1
 */