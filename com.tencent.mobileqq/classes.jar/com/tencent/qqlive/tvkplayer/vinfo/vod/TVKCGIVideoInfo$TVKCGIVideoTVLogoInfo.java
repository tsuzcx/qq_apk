package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TVKCGIVideoInfo$TVKCGIVideoTVLogoInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TVKCGIVideoTVLogoInfo> CREATOR = new TVKCGIVideoInfo.TVKCGIVideoTVLogoInfo.1();
  private int tvLogoH;
  private int tvLogoShow;
  private int tvLogoW;
  private int tvLogoX;
  private int tvLogoY;
  
  public TVKCGIVideoInfo$TVKCGIVideoTVLogoInfo() {}
  
  private TVKCGIVideoInfo$TVKCGIVideoTVLogoInfo(Parcel paramParcel)
  {
    this();
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getTvLogoH()
  {
    return this.tvLogoH;
  }
  
  public int getTvLogoShow()
  {
    return this.tvLogoShow;
  }
  
  public int getTvLogoW()
  {
    return this.tvLogoW;
  }
  
  public int getTvLogoX()
  {
    return this.tvLogoX;
  }
  
  public int getTvLogoY()
  {
    return this.tvLogoY;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.tvLogoH = paramParcel.readInt();
    this.tvLogoW = paramParcel.readInt();
    this.tvLogoX = paramParcel.readInt();
    this.tvLogoY = paramParcel.readInt();
    this.tvLogoShow = paramParcel.readInt();
  }
  
  public void setTvLogoH(int paramInt)
  {
    this.tvLogoH = paramInt;
  }
  
  public void setTvLogoShow(int paramInt)
  {
    this.tvLogoShow = paramInt;
  }
  
  public void setTvLogoW(int paramInt)
  {
    this.tvLogoW = paramInt;
  }
  
  public void setTvLogoX(int paramInt)
  {
    this.tvLogoX = paramInt;
  }
  
  public void setTvLogoY(int paramInt)
  {
    this.tvLogoY = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.tvLogoH);
    paramParcel.writeInt(this.tvLogoW);
    paramParcel.writeInt(this.tvLogoX);
    paramParcel.writeInt(this.tvLogoY);
    paramParcel.writeInt(this.tvLogoShow);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo.TVKCGIVideoTVLogoInfo
 * JD-Core Version:    0.7.0.1
 */