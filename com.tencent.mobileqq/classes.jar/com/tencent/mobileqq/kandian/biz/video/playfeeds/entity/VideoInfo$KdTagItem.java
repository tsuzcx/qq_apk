package com.tencent.mobileqq.kandian.biz.video.playfeeds.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoInfo$KdTagItem
  implements Parcelable
{
  public static final Parcelable.Creator<KdTagItem> CREATOR = new VideoInfo.KdTagItem.1();
  public String a = "";
  public long b = 0L;
  
  public VideoInfo$KdTagItem() {}
  
  protected VideoInfo$KdTagItem(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeLong(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.KdTagItem
 * JD-Core Version:    0.7.0.1
 */