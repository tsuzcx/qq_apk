package com.tencent.mobileqq.minigame.splash;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class SplashMiniGameData
  implements Parcelable
{
  public static final Parcelable.Creator<SplashMiniGameData> CREATOR = new SplashMiniGameData.1();
  public String appId;
  public String desc;
  public String developerDesc;
  public ArrayList<String> downloadFileDomianList;
  public String downloadUrl;
  public int enable;
  public long endTime;
  public int fileSize;
  public int guide;
  public String iconUrl;
  public Boolean isPlayed;
  public String name;
  public String picLocalPath;
  public String picUrl;
  public int priority;
  public ArrayList<String> requestDomianList;
  public long startTime;
  public String version;
  public int videoDuration;
  public String videoLocalPath;
  public int videoMute;
  public String videoUrl;
  
  public SplashMiniGameData() {}
  
  protected SplashMiniGameData(Parcel paramParcel)
  {
    int i = paramParcel.readByte();
    Boolean localBoolean;
    if (i == 0)
    {
      localBoolean = null;
    }
    else
    {
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      localBoolean = Boolean.valueOf(bool);
    }
    this.isPlayed = localBoolean;
    this.videoUrl = paramParcel.readString();
    this.videoDuration = paramParcel.readInt();
    this.videoMute = paramParcel.readInt();
    this.videoLocalPath = paramParcel.readString();
    this.picUrl = paramParcel.readString();
    this.picLocalPath = paramParcel.readString();
    this.enable = paramParcel.readInt();
    this.guide = paramParcel.readInt();
    this.startTime = paramParcel.readLong();
    this.endTime = paramParcel.readLong();
    this.priority = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.version = paramParcel.readString();
    this.downloadUrl = paramParcel.readString();
    this.fileSize = paramParcel.readInt();
    this.iconUrl = paramParcel.readString();
    this.name = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.developerDesc = paramParcel.readString();
    this.downloadFileDomianList = paramParcel.createStringArrayList();
    this.requestDomianList = paramParcel.createStringArrayList();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SplashMiniGameData{isPlayed=");
    localStringBuilder.append(this.isPlayed);
    localStringBuilder.append(", videoUrl='");
    localStringBuilder.append(this.videoUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoDuration=");
    localStringBuilder.append(this.videoDuration);
    localStringBuilder.append(", videoMute=");
    localStringBuilder.append(this.videoMute);
    localStringBuilder.append(", videoLocalPath='");
    localStringBuilder.append(this.videoLocalPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", picUrl='");
    localStringBuilder.append(this.picUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", picLocalPath='");
    localStringBuilder.append(this.picLocalPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", enable=");
    localStringBuilder.append(this.enable);
    localStringBuilder.append(", guide=");
    localStringBuilder.append(this.guide);
    localStringBuilder.append(", startTime=");
    localStringBuilder.append(this.startTime);
    localStringBuilder.append(", endTime=");
    localStringBuilder.append(this.endTime);
    localStringBuilder.append(", priority=");
    localStringBuilder.append(this.priority);
    localStringBuilder.append(", appId='");
    localStringBuilder.append(this.appId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", version='");
    localStringBuilder.append(this.version);
    localStringBuilder.append('\'');
    localStringBuilder.append(", downloadUrl='");
    localStringBuilder.append(this.downloadUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileSize=");
    localStringBuilder.append(this.fileSize);
    localStringBuilder.append(", iconUrl='");
    localStringBuilder.append(this.iconUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", desc='");
    localStringBuilder.append(this.desc);
    localStringBuilder.append('\'');
    localStringBuilder.append(", developerDesc='");
    localStringBuilder.append(this.developerDesc);
    localStringBuilder.append('\'');
    localStringBuilder.append(", downloadFileDomianList=");
    localStringBuilder.append(this.downloadFileDomianList);
    localStringBuilder.append(", requestDomianList=");
    localStringBuilder.append(this.requestDomianList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Boolean localBoolean = this.isPlayed;
    if (localBoolean == null) {
      paramInt = 0;
    } else if (localBoolean.booleanValue()) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    paramParcel.writeByte((byte)paramInt);
    paramParcel.writeString(this.videoUrl);
    paramParcel.writeInt(this.videoDuration);
    paramParcel.writeInt(this.videoMute);
    paramParcel.writeString(this.videoLocalPath);
    paramParcel.writeString(this.picUrl);
    paramParcel.writeString(this.picLocalPath);
    paramParcel.writeInt(this.enable);
    paramParcel.writeInt(this.guide);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.endTime);
    paramParcel.writeInt(this.priority);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.downloadUrl);
    paramParcel.writeInt(this.fileSize);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.developerDesc);
    paramParcel.writeStringList(this.downloadFileDomianList);
    paramParcel.writeStringList(this.requestDomianList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.splash.SplashMiniGameData
 * JD-Core Version:    0.7.0.1
 */