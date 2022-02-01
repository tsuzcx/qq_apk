package com.tencent.mobileqq.kandian.biz.video.playfeeds.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoInfo$LocationInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LocationInfo> CREATOR = new VideoInfo.LocationInfo.1();
  public boolean a;
  public String b;
  
  public VideoInfo$LocationInfo() {}
  
  protected VideoInfo$LocationInfo(Parcel paramParcel)
  {
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.a = bool;
    this.b = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocationInfo{location=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isCreatedByUser=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByte((byte)this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.LocationInfo
 * JD-Core Version:    0.7.0.1
 */