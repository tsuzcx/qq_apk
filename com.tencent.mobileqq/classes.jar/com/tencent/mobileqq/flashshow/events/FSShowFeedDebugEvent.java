package com.tencent.mobileqq.flashshow.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class FSShowFeedDebugEvent
  extends SimpleBaseEvent
{
  private final boolean mShowFeedInfo;
  
  public FSShowFeedDebugEvent(boolean paramBoolean)
  {
    this.mShowFeedInfo = paramBoolean;
  }
  
  public boolean isShowFeedInfo()
  {
    return this.mShowFeedInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.events.FSShowFeedDebugEvent
 * JD-Core Version:    0.7.0.1
 */