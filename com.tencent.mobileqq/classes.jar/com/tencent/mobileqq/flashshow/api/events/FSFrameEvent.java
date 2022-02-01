package com.tencent.mobileqq.flashshow.api.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class FSFrameEvent
  extends SimpleBaseEvent
{
  public static final int ACTIVATE_FRAME = 4;
  public static final int REFRESH_ALL_TAB = 3;
  public static final int REFRESH_TAB_CURRENT_TAB = 0;
  public static final int REFRESH_TAB_INDEX_FOLLOW = 2;
  public static final int REFRESH_TAB_INDEX_RECOMMEND = 1;
  public int mRefreshTab = -1;
  
  public FSFrameEvent(int paramInt1, int paramInt2)
  {
    this.mHashCode = paramInt1;
    this.mRefreshTab = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.events.FSFrameEvent
 * JD-Core Version:    0.7.0.1
 */