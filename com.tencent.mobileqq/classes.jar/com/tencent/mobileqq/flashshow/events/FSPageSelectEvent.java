package com.tencent.mobileqq.flashshow.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class FSPageSelectEvent
  extends SimpleBaseEvent
{
  public int mSelectPosition;
  
  public FSPageSelectEvent(int paramInt)
  {
    this.mSelectPosition = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.events.FSPageSelectEvent
 * JD-Core Version:    0.7.0.1
 */