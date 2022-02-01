package com.tencent.mobileqq.flashshow.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class FSFeedLikeStateUpdateEvent
  extends SimpleBaseEvent
{
  private final String feedId;
  private final int likeState;
  
  public FSFeedLikeStateUpdateEvent(String paramString, int paramInt)
  {
    this.feedId = paramString;
    this.likeState = paramInt;
  }
  
  public String getFeedId()
  {
    return this.feedId;
  }
  
  public int getLikeState()
  {
    return this.likeState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.events.FSFeedLikeStateUpdateEvent
 * JD-Core Version:    0.7.0.1
 */