package com.tencent.qqlive.module.videoreport.dtreport.video.data;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoSession
{
  private static final long INVALID_PLAY_TIME = -1L;
  private ActionRecorder actionRecorder = new ActionRecorder();
  private String contentId;
  private int contentType;
  private Map<String, Object> curPage;
  private Map<String, Object> customParamsMap = new ConcurrentHashMap();
  private boolean isBizReady;
  private boolean isForceReportStart;
  private long playEndPosition;
  private int playEndReason;
  private int playStartReason;
  private long playStartTime;
  private int playType;
  private long playedTime;
  private Map<String, Object> startParams;
  private long startPosition;
  private long videoEndTime;
  private VideoBaseEntity videoEntity;
  private int videoPlayerObject;
  private long videoStartTime;
  
  public VideoSession(@NonNull VideoEntity paramVideoEntity, @NonNull int paramInt)
  {
    this.videoEntity = paramVideoEntity;
    this.contentId = paramVideoEntity.getContentId();
    this.contentType = paramVideoEntity.getContentType();
    this.customParamsMap.putAll(paramVideoEntity.getVideoCustomParams());
    this.isBizReady = paramVideoEntity.isBizReady();
    this.videoPlayerObject = paramInt;
  }
  
  public void bizReady()
  {
    this.isBizReady = true;
  }
  
  public void bufferEnd()
  {
    this.playStartTime = SystemClock.elapsedRealtime();
  }
  
  public void bufferStart()
  {
    try
    {
      long l = this.playStartTime;
      if (l == -1L) {
        return;
      }
      this.playedTime += SystemClock.elapsedRealtime() - this.playStartTime;
      this.playStartTime = -1L;
      return;
    }
    finally {}
  }
  
  public void end(long paramLong, int paramInt)
  {
    try
    {
      if (this.playStartTime != -1L)
      {
        this.playedTime += SystemClock.elapsedRealtime() - this.playStartTime;
        this.playStartTime = -1L;
      }
      this.playEndPosition = paramLong;
      this.playEndReason = paramInt;
      this.videoEndTime = System.currentTimeMillis();
      this.actionRecorder.end(paramLong);
      VideoPlayRecorder.dealSumPlayDuration(this);
      return;
    }
    finally {}
  }
  
  public String getContentId()
  {
    return this.contentId;
  }
  
  public int getContentType()
  {
    return this.contentType;
  }
  
  public Map<String, Object> getCurPage()
  {
    return this.curPage;
  }
  
  public Map<String, Object> getCustomParams()
  {
    return this.customParamsMap;
  }
  
  public long getEndPosition()
  {
    return this.playEndPosition;
  }
  
  public String getIdentifier()
  {
    return this.videoEntity.getIdentifier();
  }
  
  public int getPageId()
  {
    return this.videoEntity.getPageId();
  }
  
  public String getPlayEndReason()
  {
    return String.valueOf(this.playEndReason);
  }
  
  public String getPlayedTime()
  {
    return String.valueOf(this.playedTime);
  }
  
  public String getSeekRecord()
  {
    return this.actionRecorder.getSeekRecord();
  }
  
  public String getSpeedRatioRecord()
  {
    return this.actionRecorder.getSpeedRatioRecord();
  }
  
  public Map<String, Object> getStartParams()
  {
    return this.startParams;
  }
  
  public String getStartPlayReason()
  {
    return String.valueOf(this.playStartReason);
  }
  
  public String getStartPlayType()
  {
    return String.valueOf(this.playType);
  }
  
  public long getStartPosition()
  {
    return this.startPosition;
  }
  
  public String getVideoDuration()
  {
    return String.valueOf(this.videoEntity.getVideoDuration());
  }
  
  public long getVideoEndTime()
  {
    return this.videoEndTime;
  }
  
  public int getVideoPlayerObject()
  {
    return this.videoPlayerObject;
  }
  
  public long getVideoStartTime()
  {
    return this.videoStartTime;
  }
  
  public WeakReference<View> getVideoView()
  {
    return this.videoEntity.getVideoView();
  }
  
  public boolean isBizReady()
  {
    return this.isBizReady;
  }
  
  public boolean isForceReportStart()
  {
    return this.isForceReportStart;
  }
  
  public boolean isIgnoreReport()
  {
    return this.videoEntity.isIgnoreReport;
  }
  
  public void seekTo(long paramLong1, long paramLong2)
  {
    this.actionRecorder.seekTo(paramLong1, paramLong2);
  }
  
  public void setContentType(int paramInt)
  {
    this.contentType = paramInt;
  }
  
  public void setCurPage(Map<String, Object> paramMap)
  {
    this.curPage = paramMap;
  }
  
  public void setForceReportStart(boolean paramBoolean)
  {
    this.isForceReportStart = paramBoolean;
  }
  
  public void setPlayedTime(long paramLong)
  {
    this.playedTime = paramLong;
  }
  
  public void setStartParams(Map<String, Object> paramMap)
  {
    this.startParams = paramMap;
  }
  
  public void setStartPosition(long paramLong)
  {
    this.startPosition = paramLong;
  }
  
  public void setVideoEndTime(long paramLong)
  {
    this.videoEndTime = paramLong;
  }
  
  public void setVideoStartTime(long paramLong)
  {
    this.videoStartTime = paramLong;
  }
  
  public void speedRatioPlay(float paramFloat, long paramLong)
  {
    this.actionRecorder.speedRatioPlay(paramFloat, paramLong);
  }
  
  public void stagingEnd(long paramLong, int paramInt)
  {
    try
    {
      if (this.playStartTime != -1L)
      {
        this.playedTime += SystemClock.elapsedRealtime() - this.playStartTime;
        this.playStartTime = SystemClock.elapsedRealtime();
      }
      this.playEndPosition = paramLong;
      this.playEndReason = paramInt;
      this.videoEndTime = System.currentTimeMillis();
      return;
    }
    finally {}
  }
  
  public void start(int paramInt1, long paramLong, int paramInt2)
  {
    this.playStartReason = paramInt1;
    this.startPosition = paramLong;
    this.playStartTime = SystemClock.elapsedRealtime();
    this.playedTime = 0L;
    this.playType = paramInt2;
    this.videoStartTime = System.currentTimeMillis();
    this.actionRecorder.start();
    VideoPlayRecorder.dealVideoIndex(this);
  }
  
  public void updateVideoEntity(VideoBaseEntity paramVideoBaseEntity)
  {
    this.videoEntity = paramVideoBaseEntity;
    this.customParamsMap.putAll(paramVideoBaseEntity.getVideoCustomParams());
    this.contentType = paramVideoBaseEntity.getContentType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession
 * JD-Core Version:    0.7.0.1
 */