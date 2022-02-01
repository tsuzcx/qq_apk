package com.tencent.mobileqq.wink.pick.circle.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class WinkCircleSelectChangeEvent
  extends SimpleBaseEvent
{
  boolean mCanShowBottomTab;
  boolean mImageDragEventFlag = false;
  
  public boolean getCanShowBottomTab()
  {
    return this.mCanShowBottomTab;
  }
  
  public boolean getImageDragEventFlag()
  {
    return this.mImageDragEventFlag;
  }
  
  public void setCanShowBottomTab(boolean paramBoolean)
  {
    this.mCanShowBottomTab = paramBoolean;
  }
  
  public void setImageDragEventFlag(boolean paramBoolean)
  {
    this.mImageDragEventFlag = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.event.WinkCircleSelectChangeEvent
 * JD-Core Version:    0.7.0.1
 */