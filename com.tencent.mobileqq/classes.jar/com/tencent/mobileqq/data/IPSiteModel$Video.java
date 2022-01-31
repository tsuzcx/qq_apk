package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aozy;

public class IPSiteModel$Video
  implements Parcelable
{
  public static final Parcelable.Creator<Video> CREATOR = new aozy();
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
    return "Video{id='" + this.id + '\'' + ", buttonDesc='" + this.buttonDesc + '\'' + ", content='" + this.content + '\'' + ", cover='" + this.cover + '\'' + ", desc='" + this.desc + '\'' + ", name='" + this.name + '\'' + ", endTime='" + this.endTime + '\'' + ", isShow=" + this.isShow + ", newStartTime=" + this.newStartTime + ", newEndTime=" + this.newEndTime + ", redirectUrl='" + this.redirectUrl + '\'' + ", videoSource='" + this.videoSource + '\'' + ", showDate='" + this.showDate + '\'' + '}';
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.data.IPSiteModel.Video
 * JD-Core Version:    0.7.0.1
 */