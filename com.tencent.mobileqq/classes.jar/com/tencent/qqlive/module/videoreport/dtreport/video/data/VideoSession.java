package com.tencent.qqlive.module.videoreport.dtreport.video.data;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import java.util.Map;

public class VideoSession
{
  private static final long INVALID_PLAY_TIME = -1L;
  private int contentType;
  private long playEndPosition;
  private int playEndReason;
  private int playStartReason;
  private long playStartTime;
  private int playType;
  private long playedTime;
  private long startPosition;
  private VideoEntity videoEntity;
  
  public VideoSession(@NonNull VideoEntity paramVideoEntity)
  {
    this.videoEntity = paramVideoEntity;
    this.contentType = paramVideoEntity.getContentType();
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
    return this.videoEntity.getContentId();
  }
  
  public int getContentType()
  {
    return this.contentType;
  }
  
  public Map<String, Object> getCustomParams()
  {
    return this.videoEntity.getVideoCustomParams();
  }
  
  public long getEndPosition()
  {
    return this.playEndPosition;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession
 * JD-Core Version:    0.7.0.1
 */