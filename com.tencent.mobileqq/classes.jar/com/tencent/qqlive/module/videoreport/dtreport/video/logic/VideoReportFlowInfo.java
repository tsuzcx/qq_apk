package com.tencent.qqlive.module.videoreport.dtreport.video.logic;

import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;

public class VideoReportFlowInfo
{
  private boolean isLoopEnd;
  private long loopStartPositionMs;
  private int playerObject;
  private int reportManager;
  private long startPosition;
  private VideoSession videoSession;
  private volatile int videoState;
  
  public long getLoopStartPositionMs()
  {
    return this.loopStartPositionMs;
  }
  
  public int getPlayerObject()
  {
    return this.playerObject;
  }
  
  public int getReportManager()
  {
    return this.reportManager;
  }
  
  public long getStartPosition()
  {
    return this.startPosition;
  }
  
  public VideoSession getVideoSession()
  {
    return this.videoSession;
  }
  
  public int getVideoState()
  {
    return this.videoState;
  }
  
  public boolean isLoopEnd()
  {
    return this.isLoopEnd;
  }
  
  public void setLoopEnd(boolean paramBoolean)
  {
    this.isLoopEnd = paramBoolean;
  }
  
  public void setLoopStartPositionMs(long paramLong)
  {
    this.loopStartPositionMs = paramLong;
  }
  
  public void setPlayerObject(int paramInt)
  {
    this.playerObject = paramInt;
  }
  
  public void setReportManager(int paramInt)
  {
    this.reportManager = paramInt;
  }
  
  public void setStartPosition(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    this.startPosition = l;
  }
  
  public void setVideoSession(VideoSession paramVideoSession)
  {
    this.videoSession = paramVideoSession;
  }
  
  public void setVideoState(int paramInt)
  {
    this.videoState = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportFlowInfo
 * JD-Core Version:    0.7.0.1
 */