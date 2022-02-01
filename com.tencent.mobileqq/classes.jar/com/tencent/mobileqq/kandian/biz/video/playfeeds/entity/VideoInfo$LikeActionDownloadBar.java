package com.tencent.mobileqq.kandian.biz.video.playfeeds.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;

public class VideoInfo$LikeActionDownloadBar
  implements Parcelable
{
  public static final Parcelable.Creator<LikeActionDownloadBar> CREATOR = new VideoInfo.LikeActionDownloadBar.1();
  public String a;
  public String b;
  public UrlJumpInfo c;
  public String d;
  
  public VideoInfo$LikeActionDownloadBar() {}
  
  protected VideoInfo$LikeActionDownloadBar(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
    this.d = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LikeActionDownloadBar{logoUrl=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", downloadBarText='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpInfo=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", commonData='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable(this.c, paramInt);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.LikeActionDownloadBar
 * JD-Core Version:    0.7.0.1
 */