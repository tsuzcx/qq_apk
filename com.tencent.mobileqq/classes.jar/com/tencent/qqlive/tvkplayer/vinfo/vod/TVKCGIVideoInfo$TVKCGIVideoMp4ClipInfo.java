package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;

public class TVKCGIVideoInfo$TVKCGIVideoMp4ClipInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TVKCGIVideoMp4ClipInfo> CREATOR = new TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo.1();
  private String cmd5;
  private double duration;
  private int idx;
  private String keyid;
  private long size;
  private String url;
  private ArrayList<String> urlList = new ArrayList();
  private String vkey;
  
  public TVKCGIVideoInfo$TVKCGIVideoMp4ClipInfo() {}
  
  private TVKCGIVideoInfo$TVKCGIVideoMp4ClipInfo(Parcel paramParcel)
  {
    this();
    readFromParcel(paramParcel);
  }
  
  public void addUrlList(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.urlList.add(paramString);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCmd5()
  {
    return this.cmd5;
  }
  
  public double getDuration()
  {
    return this.duration;
  }
  
  public int getIdx()
  {
    return this.idx;
  }
  
  public String getKeyid()
  {
    return this.keyid;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public ArrayList<String> getUrlList()
  {
    return this.urlList;
  }
  
  public String getVkey()
  {
    return this.vkey;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.duration = paramParcel.readDouble();
    this.size = paramParcel.readLong();
    this.idx = paramParcel.readInt();
    this.cmd5 = paramParcel.readString();
    this.keyid = paramParcel.readString();
    this.url = paramParcel.readString();
    this.vkey = paramParcel.readString();
    this.urlList = paramParcel.readArrayList(TVKCGIVideoMp4ClipInfo.class.getClassLoader());
  }
  
  public void setCmd5(String paramString)
  {
    this.cmd5 = paramString;
  }
  
  public void setDuration(double paramDouble)
  {
    this.duration = paramDouble;
  }
  
  public void setIdx(int paramInt)
  {
    this.idx = paramInt;
  }
  
  public void setKeyid(String paramString)
  {
    this.keyid = paramString;
  }
  
  public void setSize(long paramLong)
  {
    this.size = paramLong;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setVkey(String paramString)
  {
    this.vkey = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.duration);
    paramParcel.writeLong(this.size);
    paramParcel.writeInt(this.idx);
    paramParcel.writeString(this.cmd5);
    paramParcel.writeString(this.keyid);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.vkey);
    paramParcel.writeList(this.urlList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo
 * JD-Core Version:    0.7.0.1
 */