package com.tencent.mobileqq.kandian.biz.video.playfeeds.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.kandian.repo.ad.SmallMiniGameInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;

public class VideoInfo$SoftAdDownloadBarInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VideoInfo.DownloadBarInfo> CREATOR = new VideoInfo.SoftAdDownloadBarInfo.1();
  public String a;
  public String b;
  public String c;
  public String d;
  public int e;
  public UrlJumpInfo f;
  public String g;
  public int h;
  public SmallMiniGameInfo i;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SoftAdDownloadBarInfo{title=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", subTitle='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", smallIconUrl='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bigIconUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", changeBiggerPositionPercent='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", urlJumpInfo=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeParcelable(this.f, paramInt);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.SoftAdDownloadBarInfo
 * JD-Core Version:    0.7.0.1
 */