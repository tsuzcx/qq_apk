package com.tencent.qqmini.sdk.launcher.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SongInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SongInfo> CREATOR = new SongInfo.1();
  public static final int TYPE_BROADCAST_FM = 9;
  public static final int TYPE_NEXT_RADIO = 6;
  public static final int TYPE_NEXT_RADIO_BACKGROUND = 8;
  public static final int TYPE_OUT_MUSIC = 7;
  public static final int TYPE_PROFILE_MUSIC = 10;
  public static final int TYPE_QQMUSIC = 4;
  public static final int TYPE_QQ_MUSIC_BACKGROUND = 3;
  public static final int TYPE_QZVIP_MUSIC_BACKGROUND = 11;
  public static final int TYPE_UNKNOWN = 0;
  public static final int TYPE_UPLOAD_BACKGROUND = 5;
  public String album;
  public String coverUrl;
  public String detailUrl;
  public long duration;
  public boolean fromMini;
  public long id;
  public String mid;
  public String singer;
  public long singerId;
  public int startTime;
  public String summary;
  public String title;
  public int type;
  public long uin;
  public String url;
  
  public SongInfo() {}
  
  public SongInfo(long paramLong, String paramString1, String paramString2)
  {
    this.id = paramLong;
    this.album = paramString1;
    this.url = paramString2;
  }
  
  private SongInfo(Parcel paramParcel)
  {
    this.url = paramParcel.readString();
    this.title = paramParcel.readString();
    this.summary = paramParcel.readString();
    this.coverUrl = paramParcel.readString();
    this.detailUrl = paramParcel.readString();
    this.id = paramParcel.readLong();
    this.album = paramParcel.readString();
    this.singer = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.singerId = paramParcel.readLong();
    this.startTime = paramParcel.readInt();
    if (paramParcel.readFloat() != 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      this.fromMini = bool;
      this.duration = paramParcel.readLong();
      this.uin = paramParcel.readLong();
      this.mid = paramParcel.readString();
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.summary);
    paramParcel.writeString(this.coverUrl);
    paramParcel.writeString(this.detailUrl);
    paramParcel.writeLong(this.id);
    paramParcel.writeString(this.album);
    paramParcel.writeString(this.singer);
    paramParcel.writeInt(this.type);
    paramParcel.writeLong(this.singerId);
    paramParcel.writeInt(this.startTime);
    if (this.fromMini) {}
    for (float f = 1.0F;; f = 0.0F)
    {
      paramParcel.writeFloat(f);
      paramParcel.writeLong(this.duration);
      paramParcel.writeLong(this.uin);
      paramParcel.writeString(this.mid);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.model.SongInfo
 * JD-Core Version:    0.7.0.1
 */