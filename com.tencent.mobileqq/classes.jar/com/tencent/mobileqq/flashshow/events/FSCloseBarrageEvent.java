package com.tencent.mobileqq.flashshow.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class FSCloseBarrageEvent
  extends SimpleBaseEvent
{
  private String mFeedId;
  
  public static FSCloseBarrageEvent build()
  {
    return new FSCloseBarrageEvent();
  }
  
  public String getFeedId()
  {
    return this.mFeedId;
  }
  
  public FSCloseBarrageEvent setFeedId(String paramString)
  {
    this.mFeedId = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.events.FSCloseBarrageEvent
 * JD-Core Version:    0.7.0.1
 */