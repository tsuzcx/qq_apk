package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;

public class FlowMusic
  extends Entity
  implements Comparable
{
  public static final int SOURCE_CUSTOM_ADD = 0;
  public static final int SOURCE_QQ_MUSIC_AUTO = 1;
  public int albumId;
  public String albumMid;
  public String albumName;
  public int duration = -1;
  public String path;
  @notColumn
  public int playable = 1;
  public int singerId;
  public String singerMid;
  public String singerName;
  @notColumn
  public long size = -1L;
  @unique
  public int songId;
  public String songMid;
  public String songName;
  public int songPlayTime;
  public int sourceType = 0;
  public long storeTimeStamp = -1L;
  public int tryBegin = -1;
  public int tryEnd = -1;
  @notColumn
  public String url;
  public int userOwnRule;
  
  public FlowMusic() {}
  
  public FlowMusic(MusicItemInfo paramMusicItemInfo)
  {
    this.songId = paramMusicItemInfo.jdField_a_of_type_Int;
    this.singerName = paramMusicItemInfo.b;
    this.songName = paramMusicItemInfo.jdField_a_of_type_JavaLangString;
    this.url = paramMusicItemInfo.c;
    this.tryBegin = paramMusicItemInfo.jdField_e_of_type_Int;
    this.tryEnd = paramMusicItemInfo.f;
    this.songMid = paramMusicItemInfo.jdField_e_of_type_JavaLangString;
    this.duration = paramMusicItemInfo.g;
    this.storeTimeStamp = System.currentTimeMillis();
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
    return "FlowMusic{albumId=" + this.albumId + ", albumMid='" + this.albumMid + '\'' + ", albumName='" + this.albumName + '\'' + ", singerId=" + this.singerId + ", singerMid='" + this.singerMid + '\'' + ", singerName='" + this.singerName + '\'' + ", songId=" + this.songId + ", songMid='" + this.songMid + '\'' + ", songName='" + this.songName + '\'' + ", songPlayTime=" + this.songPlayTime + ", userOwnRule=" + this.userOwnRule + ", tryBegin=" + this.tryBegin + ", tryEnd=" + this.tryEnd + ", duration=" + this.duration + ", path='" + this.path + '\'' + ", url='" + this.url + '\'' + ", size=" + this.size + ", sourceType=" + this.sourceType + ", playable=" + this.playable + ", storeTimeStamp=" + this.storeTimeStamp + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.FlowMusic
 * JD-Core Version:    0.7.0.1
 */