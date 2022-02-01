package com.tencent.mobileqq.flashshow.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class FSOpenBarrageEvent
  extends SimpleBaseEvent
{
  private String mFeedId;
  
  public static FSOpenBarrageEvent build()
  {
    return new FSOpenBarrageEvent();
  }
  
  public String getFeedId()
  {
    return this.mFeedId;
  }
  
  public FSOpenBarrageEvent setFeedId(String paramString)
  {
    this.mFeedId = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.events.FSOpenBarrageEvent
 * JD-Core Version:    0.7.0.1
 */