package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TVKCGIVideoInfo$TVKCGIVideoWatermarkInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TVKCGIVideoWatermarkInfo> CREATOR = new TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo.1();
  private int a;
  private int h;
  private int id;
  private String md5;
  private String surl;
  private String url;
  private int w;
  private int x;
  private int y;
  
  public TVKCGIVideoInfo$TVKCGIVideoWatermarkInfo() {}
  
  private TVKCGIVideoInfo$TVKCGIVideoWatermarkInfo(Parcel paramParcel)
  {
    this();
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getA()
  {
    return this.a;
  }
  
  public int getH()
  {
    return this.h;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getMd5()
  {
    return this.md5;
  }
  
  public String getSurl()
  {
    return this.surl;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public int getW()
  {
    return this.w;
  }
  
  public int getX()
  {
    return this.x;
  }
  
  public int getY()
  {
    return this.y;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.x = paramParcel.readInt();
    this.y = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.w = paramParcel.readInt();
    this.a = paramParcel.readInt();
    this.md5 = paramParcel.readString();
    this.url = paramParcel.readString();
    this.surl = paramParcel.readString();
  }
  
  public void setA(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setH(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setMd5(String paramString)
  {
    this.md5 = paramString;
  }
  
  public void setSurl(String paramString)
  {
    this.surl = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setW(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void setX(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setY(int paramInt)
  {
    this.y = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.x);
    paramParcel.writeInt(this.y);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.w);
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.md5);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.surl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo
 * JD-Core Version:    0.7.0.1
 */