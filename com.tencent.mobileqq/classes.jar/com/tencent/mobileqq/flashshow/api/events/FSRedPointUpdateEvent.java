package com.tencent.mobileqq.flashshow.api.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class FSRedPointUpdateEvent
  extends SimpleBaseEvent
{
  public boolean mShowRedPoint;
  
  public FSRedPointUpdateEvent(boolean paramBoolean)
  {
    this.mShowRedPoint = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.events.FSRedPointUpdateEvent
 * JD-Core Version:    0.7.0.1
 */