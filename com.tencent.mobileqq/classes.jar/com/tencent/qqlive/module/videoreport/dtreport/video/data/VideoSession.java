package com.tencent.qqlive.module.videoreport.dtreport.video.data;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

public class VideoSession
{
  private static final long INVALID_PLAY_TIME = -1L;
  private String contentId;
  private int contentType;
  private HashMap<String, Object> customParamsMap = new HashMap();
  private boolean isBizReady;
  private long playEndPosition;
  private int playEndReason;
  private int playStartReason;
  private long playStartTime;
  private int playType;
  private long playedTime;
  private long startPosition;
  private VideoBaseEntity videoEntity;
  private int videoPlayerObject;
  
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
    if (this.playStartTime == -1L) {
      return;
    }
    this.playedTime += SystemClock.elapsedRealtime() - this.playStartTime;
    this.playStartTime = -1L;
  }
  
  public void end(long paramLong, int paramInt)
  {
    if (this.playStartTime != -1L)
    {
      this.playedTime += SystemClock.elapsedRealtime() - this.playStartTime;
      this.playStartTime = -1L;
    }
    this.playEndPosition = paramLong;
    this.playEndReason = paramInt;
  }
  
  public String getContentId()
  {
    return this.contentId;
  }
  
  public int getContentType()
  {
    return this.contentType;
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
  
  public int getVideoPlayerObject()
  {
    return this.videoPlayerObject;
  }
  
  public boolean isBizReady()
  {
    return this.isBizReady;
  }
  
  public boolean isIgnoreReport()
  {
    return this.videoEntity.isIgnoreReport;
  }
  
  public void setContentType(int paramInt)
  {
    this.contentType = paramInt;
  }
  
  public void start(int paramInt1, long paramLong, int paramInt2)
  {
    this.playStartReason = paramInt1;
    this.startPosition = paramLong;
    this.playStartTime = SystemClock.elapsedRealtime();
    this.playedTime = 0L;
    this.playType = paramInt2;
  }
  
  public void updateVideoEntity(VideoBaseEntity paramVideoBaseEntity)
  {
    this.videoEntity = paramVideoBaseEntity;
    this.customParamsMap.putAll(paramVideoBaseEntity.getVideoCustomParams());
    this.contentType = paramVideoBaseEntity.getContentType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession
 * JD-Core Version:    0.7.0.1
 */