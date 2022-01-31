package com.tencent.mobileqq.data;

import NS_QQ_STORY_META.META.StMusic;
import atmo;
import atnz;
import atoc;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;

public class FlowMusic
  extends atmo
  implements Comparable<FlowMusic>
{
  public static final int SOURCE_CUSTOM_ADD = 0;
  public static final int SOURCE_QQ_MUSIC_AUTO = 1;
  public int albumId;
  public String albumMid;
  public String albumName;
  public String albumUrl;
  public int duration = -1;
  public String path;
  @atnz
  public int playable = 1;
  public int singerId;
  public String singerMid;
  public String singerName;
  @atnz
  public long size = -1L;
  @atoc
  public int songId;
  public String songMid;
  public String songName;
  public int songPlayTime;
  public int sourceType = 0;
  public long storeTimeStamp = -1L;
  public int tryBegin = -1;
  public int tryEnd = -1;
  @atnz
  public String url;
  public int userOwnRule;
  
  public FlowMusic() {}
  
  public FlowMusic(META.StMusic paramStMusic)
  {
    this.albumId = ((int)paramStMusic.uiAlbumId.get());
    this.albumMid = paramStMusic.strAlbumMid.get();
    this.albumName = paramStMusic.strAlbumName.get();
    this.albumUrl = paramStMusic.strAlbumPic.get();
    this.singerId = ((int)paramStMusic.uiSingerId.get());
    this.singerMid = paramStMusic.strSingerMid.get();
    this.singerName = paramStMusic.strSingerName.get();
    this.songId = ((int)paramStMusic.uiSongId.get());
    this.songMid = paramStMusic.strSongMid.get();
    this.songName = paramStMusic.strSongName.get();
    this.songPlayTime = paramStMusic.iPlayTime.get();
    if (paramStMusic.iTrySize.get() > 0) {}
    for (;;)
    {
      this.userOwnRule = i;
      this.url = paramStMusic.strPlayUrl.get();
      this.size = paramStMusic.iSize.get();
      this.playable = paramStMusic.copyright.get();
      this.storeTimeStamp = System.currentTimeMillis();
      return;
      i = 0;
    }
  }
  
  public FlowMusic(MusicItemInfo paramMusicItemInfo)
  {
    this.songId = paramMusicItemInfo.mItemId;
    this.singerName = paramMusicItemInfo.mSingername;
    this.songName = paramMusicItemInfo.mMusicName;
    this.url = paramMusicItemInfo.mUrl;
    this.tryBegin = paramMusicItemInfo.musicStart;
    this.tryEnd = paramMusicItemInfo.musicEnd;
    this.songMid = paramMusicItemInfo.mSongMid;
    this.duration = paramMusicItemInfo.musicDuration;
    this.storeTimeStamp = System.currentTimeMillis();
    this.albumUrl = paramMusicItemInfo.mAlbumUrl;
  }
  
  public int compareTo(FlowMusic paramFlowMusic)
  {
    if (paramFlowMusic == null) {}
    long l;
    do
    {
      return 1;
      if ((this == paramFlowMusic) || (this.songId == paramFlowMusic.songId)) {
        return 0;
      }
      if (this.sourceType != paramFlowMusic.sourceType) {
        return this.sourceType - paramFlowMusic.sourceType;
      }
      l = paramFlowMusic.storeTimeStamp - this.storeTimeStamp;
    } while (l > 0L);
    if (l < 0L) {
      return -1;
    }
    return 0;
  }
  
  public void copyFrom(FlowMusic paramFlowMusic)
  {
    this.albumId = paramFlowMusic.albumId;
    this.albumMid = paramFlowMusic.albumMid;
    this.albumName = paramFlowMusic.albumName;
    this.albumUrl = paramFlowMusic.albumUrl;
    this.singerId = paramFlowMusic.singerId;
    this.singerMid = paramFlowMusic.singerMid;
    this.singerName = paramFlowMusic.singerName;
    this.songId = paramFlowMusic.songId;
    this.songMid = paramFlowMusic.songMid;
    this.songName = paramFlowMusic.songName;
    this.songPlayTime = paramFlowMusic.songPlayTime;
    this.userOwnRule = paramFlowMusic.userOwnRule;
    this.tryBegin = paramFlowMusic.tryBegin;
    this.tryEnd = paramFlowMusic.tryEnd;
    this.duration = paramFlowMusic.duration;
    this.path = paramFlowMusic.path;
    this.url = paramFlowMusic.url;
    this.size = paramFlowMusic.size;
    this.sourceType = paramFlowMusic.sourceType;
    this.playable = paramFlowMusic.playable;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (FlowMusic)paramObject;
    } while (this.songId == paramObject.songId);
    return false;
  }
  
  public int hashCode()
  {
    return this.songId;
  }
  
  public String toString()
  {
    return "FlowMusic{url='" + this.url + '\'' + ", songMid='" + this.songMid + '\'' + ", songName='" + this.songName + '\'' + ", playable=" + this.playable + ", albumId=" + this.albumId + ", albumMid='" + this.albumMid + '\'' + ", albumName='" + this.albumName + '\'' + ", albumUrl='" + this.albumUrl + '\'' + ", singerId=" + this.singerId + ", singerMid='" + this.singerMid + '\'' + ", singerName='" + this.singerName + '\'' + ", songId=" + this.songId + ", songPlayTime=" + this.songPlayTime + ", userOwnRule=" + this.userOwnRule + ", tryBegin=" + this.tryBegin + ", tryEnd=" + this.tryEnd + ", duration=" + this.duration + ", path='" + this.path + '\'' + ", size=" + this.size + ", sourceType=" + this.sourceType + ", storeTimeStamp=" + this.storeTimeStamp + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.FlowMusic
 * JD-Core Version:    0.7.0.1
 */