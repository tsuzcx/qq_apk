package com.tencent.mobileqq.kandian.biz.video.playfeeds.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.diandian.IEntranceButtonDataSource;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;

public class VideoInfo$EntranceDownloadInfo
  implements Parcelable, IEntranceButtonDataSource
{
  public static final Parcelable.Creator<EntranceDownloadInfo> CREATOR = new VideoInfo.EntranceDownloadInfo.1();
  public String a;
  public String b;
  public boolean c;
  public String d;
  public UrlJumpInfo e;
  
  public VideoInfo$EntranceDownloadInfo() {}
  
  protected VideoInfo$EntranceDownloadInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.c = bool;
    this.d = paramParcel.readString();
    this.e = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public boolean c()
  {
    return TextUtils.isEmpty(this.a) ^ true;
  }
  
  public String d()
  {
    return this.a;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    return TextUtils.isEmpty(this.b) ^ true;
  }
  
  public String f()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EntranceDownloadInfo{iconUrl='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", smallIconUrl='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isUseGif='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", commonData='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpInfo='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeByte((byte)this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeParcelable(this.e, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.EntranceDownloadInfo
 * JD-Core Version:    0.7.0.1
 */