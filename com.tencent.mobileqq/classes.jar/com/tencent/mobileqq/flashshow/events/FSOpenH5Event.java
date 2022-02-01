package com.tencent.mobileqq.flashshow.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class FSOpenH5Event
  extends SimpleBaseEvent
{
  private boolean mOpenH5EventFlag;
  
  public FSOpenH5Event(boolean paramBoolean)
  {
    this.mOpenH5EventFlag = paramBoolean;
  }
  
  public boolean getOpenH5EventFlag()
  {
    return this.mOpenH5EventFlag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.events.FSOpenH5Event
 * JD-Core Version:    0.7.0.1
 */