package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TVKCGIVideoInfo$TVKCGIVideoSubtitleInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TVKCGIVideoSubtitleInfo> CREATOR = new TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo.1();
  private String keyid;
  private String name;
  private String url;
  
  public TVKCGIVideoInfo$TVKCGIVideoSubtitleInfo() {}
  
  private TVKCGIVideoInfo$TVKCGIVideoSubtitleInfo(Parcel paramParcel)
  {
    this();
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getKeyid()
  {
    return this.keyid;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    this.url = paramParcel.readString();
    this.keyid = paramParcel.readString();
  }
  
  public void setKeyid(String paramString)
  {
    this.keyid = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.keyid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo
 * JD-Core Version:    0.7.0.1
 */