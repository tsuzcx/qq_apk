package com.tencent.mobileqq.wink.editor.music;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import qqcircle.QQCircleSmartMatchMusic.AlbumInfo;
import qqcircle.QQCircleSmartMatchMusic.ConfInfo;
import qqcircle.QQCircleSmartMatchMusic.LyricInfo;
import qqcircle.QQCircleSmartMatchMusic.MusicInfo;
import qqcircle.QQCircleSmartMatchMusic.SingerInfo;
import qqcircle.QQCircleSmartMatchMusic.SongInfo;

public class VsMusicItemInfo
  extends MusicItemInfo
{
  public static final Parcelable.Creator<VsMusicItemInfo> CREATOR = new VsMusicItemInfo.1();
  public String a;
  public String b;
  public long c;
  public int d = 1;
  
  public VsMusicItemInfo() {}
  
  protected VsMusicItemInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.b = paramParcel.readString();
    this.a = paramParcel.readString();
  }
  
  public VsMusicItemInfo(QQCircleSmartMatchMusic.MusicInfo paramMusicInfo)
  {
    if (paramMusicInfo == null) {
      return;
    }
    a(paramMusicInfo);
  }
  
  public void a(QQCircleSmartMatchMusic.MusicInfo paramMusicInfo)
  {
    this.mSongMid = paramMusicInfo.songInfo.MID.get();
    this.mType = 5;
    this.mUrl = paramMusicInfo.songInfo.PlayUrl.get();
    int i = paramMusicInfo.songInfo.Copyright.get();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.mHasCopyright = bool;
    this.mSingername = paramMusicInfo.singerInfo.name.get();
    this.mMusicName = paramMusicInfo.songInfo.name.get();
    this.c = paramMusicInfo.songInfo.ID.get();
    this.mAlbumUrl = paramMusicInfo.albumInfo.picURL.get();
    this.b = paramMusicInfo.lyricInfo.strLyric.get();
    this.musicStart = paramMusicInfo.confInfo.startPos.get();
    this.musicEnd = 0;
    this.a = paramMusicInfo.lyricInfo.strFormat.get();
    this.mItemId = ((int)paramMusicInfo.lyricInfo.uiSongId.get());
    this.musicDuration = (paramMusicInfo.songInfo.IPlayTime.get() * 1000);
    this.fileSize = paramMusicInfo.songInfo.ISize.get();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.VsMusicItemInfo
 * JD-Core Version:    0.7.0.1
 */