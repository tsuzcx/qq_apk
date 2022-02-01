package com.tencent.mobileqq.kandian.biz.follow.popup;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class RIJFollowRecommendPopupEvent
  extends SimpleBaseEvent
{
  public boolean showing;
  
  public RIJFollowRecommendPopupEvent(boolean paramBoolean)
  {
    this.showing = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.popup.RIJFollowRecommendPopupEvent
 * JD-Core Version:    0.7.0.1
 */