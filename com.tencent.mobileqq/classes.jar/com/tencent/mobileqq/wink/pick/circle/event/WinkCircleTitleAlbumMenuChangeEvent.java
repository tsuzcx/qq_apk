package com.tencent.mobileqq.wink.pick.circle.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class WinkCircleTitleAlbumMenuChangeEvent
  extends SimpleBaseEvent
{
  private boolean isShow;
  
  public WinkCircleTitleAlbumMenuChangeEvent(boolean paramBoolean)
  {
    this.isShow = paramBoolean;
  }
  
  public boolean getIsShow()
  {
    return this.isShow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.event.WinkCircleTitleAlbumMenuChangeEvent
 * JD-Core Version:    0.7.0.1
 */