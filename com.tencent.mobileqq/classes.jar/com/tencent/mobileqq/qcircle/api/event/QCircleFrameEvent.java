package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleFrameEvent
  extends SimpleBaseEvent
{
  public static final int REFRESH_ALL_TAB = 4;
  public static final int REFRESH_TAB_CURRENT_TAB = 0;
  public static final int REFRESH_TAB_INDEX_FOLLOW = 2;
  public static final int REFRESH_TAB_INDEX_NEARBY = 3;
  public static final int REFRESH_TAB_INDEX_RECOMMEND = 1;
  public String mBackgroundColor = "#FAFAFB";
  public boolean mIsNeedExposeTab = false;
  public boolean mIsRefreshRedNum = false;
  public int mRefreshTab = -1;
  public boolean mTriggerSelectedQCircleTab = false;
  
  public QCircleFrameEvent() {}
  
  public QCircleFrameEvent(int paramInt1, int paramInt2)
  {
    this.mHashCode = paramInt1;
    this.mRefreshTab = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent
 * JD-Core Version:    0.7.0.1
 */