package com.tencent.qqlive.tvkplayer.vinfo;

import android.support.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.playerwrapper.player.TVKMediaSource;

public class TVKPlaybackInfo
{
  private int mBufferPercent;
  private String mCurAudioTrack;
  private int mDownloadSpeedKBps;
  private boolean mEnableDrm;
  private int mEnableHDREnhance;
  private boolean mIsPrePlay;
  private long mLastPosition;
  private int mLivePlayType;
  private int mMediaFormat;
  private TVKPlaybackInfo.MediaInfo mMediaInfo;
  private int mMediaPayType;
  private TVKMediaSource mMediaSource;
  private TVKNetVideoInfo mNetVideoInfo;
  private long mPlayedTime;
  private TVKPlaybackInfo.PlayerInfo mPlayerInfo;
  private TVKPlaybackInfo.RequestInfo mRequestInfo;
  private int mSeekModWhenPrepared;
  private long mSeekPosWhenPrepared;
  
  public TVKPlaybackInfo()
  {
    init();
  }
  
  private void init()
  {
    this.mMediaInfo = new TVKPlaybackInfo.MediaInfo();
    this.mPlayerInfo = new TVKPlaybackInfo.PlayerInfo();
    this.mMediaFormat = 0;
    this.mMediaSource = null;
    this.mMediaPayType = 1;
    this.mNetVideoInfo = new TVKNetVideoInfo();
    this.mRequestInfo = new TVKPlaybackInfo.RequestInfo();
    this.mPlayedTime = 0L;
    this.mCurAudioTrack = null;
    this.mSeekPosWhenPrepared = 0L;
    this.mSeekModWhenPrepared = 0;
    this.mEnableHDREnhance = 0;
    this.mIsPrePlay = false;
  }
  
  void clear()
  {
    init();
  }
  
  String currentAudioTrack()
  {
    return this.mCurAudioTrack;
  }
  
  void currentAudioTrack(String paramString)
  {
    this.mCurAudioTrack = paramString;
  }
  
  void enableDrm(boolean paramBoolean)
  {
    this.mEnableDrm = paramBoolean;
  }
  
  boolean enableDrm()
  {
    return this.mEnableDrm;
  }
  
  int enableHDREnhance()
  {
    return this.mEnableHDREnhance;
  }
  
  void enableHDREnhance(int paramInt)
  {
    this.mEnableHDREnhance = paramInt;
  }
  
  public int getBufferPercent()
  {
    return this.mBufferPercent;
  }
  
  public int getDownloadSpeedKBps()
  {
    return this.mDownloadSpeedKBps;
  }
  
  boolean isHDR10()
  {
    TVKNetVideoInfo localTVKNetVideoInfo = this.mNetVideoInfo;
    return (localTVKNetVideoInfo != null) && (localTVKNetVideoInfo.getCurDefinition() != null) && (this.mNetVideoInfo.getCurDefinition().getDefn().equals("hdr10")) && (this.mNetVideoInfo.getCurDefinition().getVideoCodec() == 3);
  }
  
  boolean isHevc()
  {
    TVKNetVideoInfo localTVKNetVideoInfo = this.mNetVideoInfo;
    return (localTVKNetVideoInfo != null) && (localTVKNetVideoInfo.isHevc());
  }
  
  boolean isPrePlay()
  {
    return this.mIsPrePlay;
  }
  
  void isPreplay(boolean paramBoolean)
  {
    this.mIsPrePlay = paramBoolean;
  }
  
  long lastPosition()
  {
    return this.mLastPosition;
  }
  
  void lastPosition(long paramLong)
  {
    this.mLastPosition = paramLong;
  }
  
  int livePlayType()
  {
    return this.mLivePlayType;
  }
  
  void livePlayType(int paramInt)
  {
    this.mLivePlayType = paramInt;
  }
  
  int mediaFormat()
  {
    return this.mMediaFormat;
  }
  
  void mediaFormat(int paramInt)
  {
    this.mMediaFormat = paramInt;
  }
  
  TVKPlaybackInfo.MediaInfo mediaInfo()
  {
    return this.mMediaInfo;
  }
  
  int mediaPayType()
  {
    return this.mMediaPayType;
  }
  
  void mediaPayType(int paramInt)
  {
    this.mMediaPayType = paramInt;
  }
  
  TVKMediaSource mediaSource()
  {
    return this.mMediaSource;
  }
  
  void mediaSource(@NonNull TVKMediaSource paramTVKMediaSource)
  {
    this.mMediaSource = paramTVKMediaSource;
  }
  
  TVKNetVideoInfo netVideoInfo()
  {
    return this.mNetVideoInfo;
  }
  
  void netVideoInfo(TVKNetVideoInfo paramTVKNetVideoInfo)
  {
    this.mNetVideoInfo = paramTVKNetVideoInfo;
  }
  
  long playedTime()
  {
    return this.mPlayedTime;
  }
  
  void playedTime(long paramLong)
  {
    this.mPlayedTime = paramLong;
  }
  
  TVKPlaybackInfo.PlayerInfo playerInfo()
  {
    return this.mPlayerInfo;
  }
  
  public TVKPlaybackInfo.RequestInfo requestInfo()
  {
    return this.mRequestInfo;
  }
  
  int seekModWhenPrepared()
  {
    return this.mSeekModWhenPrepared;
  }
  
  void seekModWhenPrepared(int paramInt)
  {
    this.mSeekModWhenPrepared = paramInt;
  }
  
  long seekPosWhenPrepared()
  {
    return this.mSeekPosWhenPrepared;
  }
  
  void seekPosWhenPrepared(long paramLong)
  {
    this.mSeekPosWhenPrepared = paramLong;
  }
  
  public void setBufferPercent(int paramInt)
  {
    this.mBufferPercent = paramInt;
  }
  
  public void setDownloadSpeedKBps(int paramInt)
  {
    this.mDownloadSpeedKBps = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKPlaybackInfo
 * JD-Core Version:    0.7.0.1
 */