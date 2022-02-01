package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TVKCGIVideoInfo$TVKCGIVideoUrlInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TVKCGIVideoUrlInfo> CREATOR = new TVKCGIVideoInfo.TVKCGIVideoUrlInfo.1();
  private String hk;
  private String path;
  private String pt;
  private String spip;
  private String spport;
  private String url = "";
  private int vt;
  
  public TVKCGIVideoInfo$TVKCGIVideoUrlInfo() {}
  
  private TVKCGIVideoInfo$TVKCGIVideoUrlInfo(Parcel paramParcel)
  {
    this();
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getHk()
  {
    return this.hk;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public String getPt()
  {
    return this.pt;
  }
  
  public String getSpip()
  {
    return this.spip;
  }
  
  public String getSpport()
  {
    return this.spport;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public int getVt()
  {
    return this.vt;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.vt = paramParcel.readInt();
    this.url = paramParcel.readString();
    this.spip = paramParcel.readString();
    this.spport = paramParcel.readString();
    this.path = paramParcel.readString();
    this.hk = paramParcel.readString();
    this.pt = paramParcel.readString();
  }
  
  public void setHk(String paramString)
  {
    this.hk = paramString;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public void setPt(String paramString)
  {
    this.pt = paramString;
  }
  
  public void setSpip(String paramString)
  {
    this.spip = paramString;
  }
  
  public void setSpport(String paramString)
  {
    this.spport = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setVt(int paramInt)
  {
    this.vt = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.vt);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.spip);
    paramParcel.writeString(this.spport);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.hk);
    paramParcel.writeString(this.pt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo.TVKCGIVideoUrlInfo
 * JD-Core Version:    0.7.0.1
 */