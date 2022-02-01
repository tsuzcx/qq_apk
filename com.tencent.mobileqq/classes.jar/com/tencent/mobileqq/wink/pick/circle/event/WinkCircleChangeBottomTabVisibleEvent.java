package com.tencent.mobileqq.wink.pick.circle.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class WinkCircleChangeBottomTabVisibleEvent
  extends SimpleBaseEvent
{
  public Boolean mShowBottomTab;
  
  public WinkCircleChangeBottomTabVisibleEvent(Boolean paramBoolean)
  {
    this.mShowBottomTab = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.event.WinkCircleChangeBottomTabVisibleEvent
 * JD-Core Version:    0.7.0.1
 */