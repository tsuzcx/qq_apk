package com.tencent.mobileqq.flashshow.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class FSBottomTabEvent
  extends SimpleBaseEvent
{
  private boolean mIsSelected;
  
  public FSBottomTabEvent(boolean paramBoolean)
  {
    this.mIsSelected = paramBoolean;
  }
  
  public boolean hasSelected()
  {
    return this.mIsSelected;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.events.FSBottomTabEvent
 * JD-Core Version:    0.7.0.1
 */