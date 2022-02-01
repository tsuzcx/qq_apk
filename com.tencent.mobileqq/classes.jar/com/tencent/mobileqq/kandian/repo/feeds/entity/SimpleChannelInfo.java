package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SimpleChannelInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SimpleChannelInfo> CREATOR = new SimpleChannelInfo.1();
  public String a;
  public long b;
  public long c;
  
  public SimpleChannelInfo() {}
  
  protected SimpleChannelInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readLong();
    this.c = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeLong(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.SimpleChannelInfo
 * JD-Core Version:    0.7.0.1
 */