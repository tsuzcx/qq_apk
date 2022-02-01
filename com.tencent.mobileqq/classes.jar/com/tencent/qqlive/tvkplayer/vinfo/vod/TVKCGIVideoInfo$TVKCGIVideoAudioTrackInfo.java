package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class TVKCGIVideoInfo$TVKCGIVideoAudioTrackInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TVKCGIVideoAudioTrackInfo> CREATOR = new TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo.1();
  private String action;
  private int audio;
  private String keyid;
  private int lmt;
  private String name;
  private int preview;
  private int sl;
  private String track;
  private ArrayList<String> urlList = null;
  
  public TVKCGIVideoInfo$TVKCGIVideoAudioTrackInfo() {}
  
  private TVKCGIVideoInfo$TVKCGIVideoAudioTrackInfo(Parcel paramParcel)
  {
    this();
    readFromParcel(paramParcel);
  }
  
  public void addUrlList(String paramString)
  {
    if (this.urlList == null) {
      this.urlList = new ArrayList();
    }
    this.urlList.add(paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAction()
  {
    return this.action;
  }
  
  public int getAudio()
  {
    return this.audio;
  }
  
  public String getKeyid()
  {
    return this.keyid;
  }
  
  public int getLmt()
  {
    return this.lmt;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getPreview()
  {
    return this.preview;
  }
  
  public int getSl()
  {
    return this.sl;
  }
  
  public String getTrack()
  {
    return this.track;
  }
  
  public ArrayList<String> getUrlList()
  {
    return this.urlList;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.sl = paramParcel.readInt();
    this.action = paramParcel.readString();
    this.audio = paramParcel.readInt();
    this.keyid = paramParcel.readString();
    this.lmt = paramParcel.readInt();
    this.name = paramParcel.readString();
    this.preview = paramParcel.readInt();
    this.track = paramParcel.readString();
    this.urlList = paramParcel.readArrayList(TVKCGIVideoAudioTrackInfo.class.getClassLoader());
  }
  
  public void setAction(String paramString)
  {
    this.action = paramString;
  }
  
  public void setAudio(int paramInt)
  {
    this.audio = paramInt;
  }
  
  public void setKeyid(String paramString)
  {
    this.keyid = paramString;
  }
  
  public void setLmt(int paramInt)
  {
    this.lmt = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPreview(int paramInt)
  {
    this.preview = paramInt;
  }
  
  public void setSl(int paramInt)
  {
    this.sl = paramInt;
  }
  
  public void setTrack(String paramString)
  {
    this.track = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.sl);
    paramParcel.writeString(this.action);
    paramParcel.writeInt(this.audio);
    paramParcel.writeString(this.keyid);
    paramParcel.writeInt(this.lmt);
    paramParcel.writeString(this.name);
    paramParcel.writeInt(this.preview);
    paramParcel.writeString(this.track);
    paramParcel.writeList(this.urlList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo
 * JD-Core Version:    0.7.0.1
 */