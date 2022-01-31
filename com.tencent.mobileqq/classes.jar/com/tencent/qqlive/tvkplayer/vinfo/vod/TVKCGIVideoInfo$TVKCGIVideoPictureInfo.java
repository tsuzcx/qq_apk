package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TVKCGIVideoInfo$TVKCGIVideoPictureInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TVKCGIVideoPictureInfo> CREATOR = new TVKCGIVideoInfo.TVKCGIVideoPictureInfo.1();
  private int c;
  private int cd;
  private int fmt;
  private String fn;
  private int h;
  private int r;
  private String url;
  private int w;
  
  public TVKCGIVideoInfo$TVKCGIVideoPictureInfo() {}
  
  private TVKCGIVideoInfo$TVKCGIVideoPictureInfo(Parcel paramParcel)
  {
    this();
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getC()
  {
    return this.c;
  }
  
  public int getCd()
  {
    return this.cd;
  }
  
  public int getFmt()
  {
    return this.fmt;
  }
  
  public String getFn()
  {
    return this.fn;
  }
  
  public int getH()
  {
    return this.h;
  }
  
  public int getR()
  {
    return this.r;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public int getW()
  {
    return this.w;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.fmt = paramParcel.readInt();
    this.cd = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.w = paramParcel.readInt();
    this.r = paramParcel.readInt();
    this.url = paramParcel.readString();
    this.fn = paramParcel.readString();
  }
  
  public void setC(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setCd(int paramInt)
  {
    this.cd = paramInt;
  }
  
  public void setFmt(int paramInt)
  {
    this.fmt = paramInt;
  }
  
  public void setFn(String paramString)
  {
    this.fn = paramString;
  }
  
  public void setH(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setR(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setW(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.fmt);
    paramParcel.writeInt(this.cd);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.w);
    paramParcel.writeInt(this.r);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.fn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo.TVKCGIVideoPictureInfo
 * JD-Core Version:    0.7.0.1
 */