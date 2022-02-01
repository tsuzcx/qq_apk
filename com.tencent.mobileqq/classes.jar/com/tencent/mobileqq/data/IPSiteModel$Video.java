package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPSiteModel$Video
  implements Parcelable
{
  public static final Parcelable.Creator<Video> CREATOR = new IPSiteModel.Video.1();
  public String buttonDesc;
  public String content;
  public String cover;
  public String desc;
  public String endTime;
  public String id;
  public int isShow;
  public String name;
  public long newEndTime;
  public long newStartTime;
  public String redirectUrl;
  public String showDate;
  public String videoSource;
  
  public IPSiteModel$Video() {}
  
  public IPSiteModel$Video(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, long paramLong1, long paramLong2, String paramString8, String paramString9, String paramString10)
  {
    this.id = paramString1;
    this.buttonDesc = paramString2;
    this.content = paramString3;
    this.cover = paramString4;
    this.desc = paramString5;
    this.name = paramString6;
    this.endTime = paramString7;
    this.isShow = paramInt;
    this.newStartTime = paramLong1;
    this.newEndTime = paramLong2;
    this.redirectUrl = paramString8;
    this.videoSource = paramString9;
    this.showDate = paramString10;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Video{id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", buttonDesc='");
    localStringBuilder.append(this.buttonDesc);
    localStringBuilder.append('\'');
    localStringBuilder.append(", content='");
    localStringBuilder.append(this.content);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cover='");
    localStringBuilder.append(this.cover);
    localStringBuilder.append('\'');
    localStringBuilder.append(", desc='");
    localStringBuilder.append(this.desc);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", endTime='");
    localStringBuilder.append(this.endTime);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isShow=");
    localStringBuilder.append(this.isShow);
    localStringBuilder.append(", newStartTime=");
    localStringBuilder.append(this.newStartTime);
    localStringBuilder.append(", newEndTime=");
    localStringBuilder.append(this.newEndTime);
    localStringBuilder.append(", redirectUrl='");
    localStringBuilder.append(this.redirectUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoSource='");
    localStringBuilder.append(this.videoSource);
    localStringBuilder.append('\'');
    localStringBuilder.append(", showDate='");
    localStringBuilder.append(this.showDate);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.buttonDesc);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.cover);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.endTime);
    paramParcel.writeInt(this.isShow);
    paramParcel.writeLong(this.newStartTime);
    paramParcel.writeLong(this.newEndTime);
    paramParcel.writeString(this.redirectUrl);
    paramParcel.writeString(this.videoSource);
    paramParcel.writeString(this.showDate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.IPSiteModel.Video
 * JD-Core Version:    0.7.0.1
 */