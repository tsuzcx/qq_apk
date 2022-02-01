package com.tencent.mobileqq.kandian.biz.video.playfeeds.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoInfo$SubscriptInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SubscriptInfo> CREATOR = new VideoInfo.SubscriptInfo.1();
  public String a;
  public int b;
  public int c;
  public int d;
  
  public VideoInfo$SubscriptInfo() {}
  
  protected VideoInfo$SubscriptInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SubscriptInfo{subscriptText='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", subscriptColor=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", backgroundColor=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", subscriptType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.SubscriptInfo
 * JD-Core Version:    0.7.0.1
 */