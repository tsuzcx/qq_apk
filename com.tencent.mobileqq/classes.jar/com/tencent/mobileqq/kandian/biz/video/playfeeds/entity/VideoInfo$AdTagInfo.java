package com.tencent.mobileqq.kandian.biz.video.playfeeds.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class VideoInfo$AdTagInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AdTagInfo> CREATOR = new VideoInfo.AdTagInfo.1();
  public String a = "";
  public ArrayList<VideoInfo.KdTagItem> b;
  public int c = 0;
  public int d;
  public VideoInfo.ClassInfo e;
  public String f = "";
  
  public VideoInfo$AdTagInfo() {}
  
  protected VideoInfo$AdTagInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.createTypedArrayList(VideoInfo.KdTagItem.CREATOR);
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = ((VideoInfo.ClassInfo)paramParcel.readParcelable(VideoInfo.ClassInfo.class.getClassLoader()));
    this.f = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeTypedList(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeParcelable(this.e, paramInt);
    paramParcel.writeString(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.AdTagInfo
 * JD-Core Version:    0.7.0.1
 */