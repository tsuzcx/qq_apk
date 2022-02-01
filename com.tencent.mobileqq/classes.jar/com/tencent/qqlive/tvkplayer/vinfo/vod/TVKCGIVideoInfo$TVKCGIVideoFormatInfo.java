package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TVKCGIVideoInfo$TVKCGIVideoFormatInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TVKCGIVideoFormatInfo> CREATOR = new TVKCGIVideoInfo.TVKCGIVideoFormatInfo.1();
  private int audio;
  private int br;
  private String cname;
  private int drm;
  private long fs;
  private int hdr10enh;
  private int id;
  private int lmt;
  private String name;
  private int profile;
  private String resolution;
  private int sb;
  private int sl;
  private String sname;
  private int superNode;
  private int video;
  
  public TVKCGIVideoInfo$TVKCGIVideoFormatInfo() {}
  
  public TVKCGIVideoInfo$TVKCGIVideoFormatInfo(Parcel paramParcel)
  {
    this();
    readFromParce(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getAudio()
  {
    return this.audio;
  }
  
  public int getBr()
  {
    return this.br;
  }
  
  public String getCname()
  {
    return this.cname;
  }
  
  public int getDrm()
  {
    return this.drm;
  }
  
  public long getFs()
  {
    return this.fs;
  }
  
  public int getHdr10enh()
  {
    return this.hdr10enh;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public int getLmt()
  {
    return this.lmt;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getProfile()
  {
    return this.profile;
  }
  
  public String getResolution()
  {
    return this.resolution;
  }
  
  public int getSb()
  {
    return this.sb;
  }
  
  public int getSl()
  {
    return this.sl;
  }
  
  public String getSname()
  {
    return this.sname;
  }
  
  public int getSuper()
  {
    return this.superNode;
  }
  
  public int getVideo()
  {
    return this.video;
  }
  
  public void readFromParce(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    this.cname = paramParcel.readString();
    this.id = paramParcel.readInt();
    this.sl = paramParcel.readInt();
    this.lmt = paramParcel.readInt();
    this.sb = paramParcel.readInt();
    this.drm = paramParcel.readInt();
    this.video = paramParcel.readInt();
    this.audio = paramParcel.readInt();
    this.profile = paramParcel.readInt();
    this.superNode = paramParcel.readInt();
    this.br = paramParcel.readInt();
    this.fs = paramParcel.readLong();
    this.hdr10enh = paramParcel.readInt();
    this.sname = paramParcel.readString();
    this.resolution = paramParcel.readString();
  }
  
  public void setAudio(int paramInt)
  {
    this.audio = paramInt;
  }
  
  public void setBr(int paramInt)
  {
    this.br = paramInt;
  }
  
  public void setCname(String paramString)
  {
    this.cname = paramString;
  }
  
  public void setDrm(int paramInt)
  {
    this.drm = paramInt;
  }
  
  public void setFs(long paramLong)
  {
    this.fs = paramLong;
  }
  
  public void setHdr10enh(int paramInt)
  {
    this.hdr10enh = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setLmt(int paramInt)
  {
    this.lmt = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setProfile(int paramInt)
  {
    this.profile = paramInt;
  }
  
  public void setResolution(String paramString)
  {
    this.resolution = paramString;
  }
  
  public void setSb(int paramInt)
  {
    this.sb = paramInt;
  }
  
  public void setSl(int paramInt)
  {
    this.sl = paramInt;
  }
  
  public void setSname(String paramString)
  {
    this.sname = paramString;
  }
  
  public void setSuper(int paramInt)
  {
    this.superNode = paramInt;
  }
  
  public void setVideo(int paramInt)
  {
    this.video = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.cname);
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.sl);
    paramParcel.writeInt(this.lmt);
    paramParcel.writeInt(this.sb);
    paramParcel.writeInt(this.drm);
    paramParcel.writeInt(this.video);
    paramParcel.writeInt(this.audio);
    paramParcel.writeInt(this.profile);
    paramParcel.writeInt(this.superNode);
    paramParcel.writeInt(this.br);
    paramParcel.writeLong(this.fs);
    paramParcel.writeInt(this.hdr10enh);
    paramParcel.writeString(this.sname);
    paramParcel.writeString(this.resolution);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo.TVKCGIVideoFormatInfo
 * JD-Core Version:    0.7.0.1
 */