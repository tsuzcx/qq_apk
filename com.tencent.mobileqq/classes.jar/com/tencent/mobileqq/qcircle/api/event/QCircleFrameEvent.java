package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleFrameEvent
  extends SimpleBaseEvent
{
  public String mBackgroundColor = "#FAFAFB";
  public boolean mIsHideSnapShot = false;
  public boolean mIsNeedExposeTab = false;
  public boolean mIsRefreshRedNum = false;
  public boolean mIsTabClickSelf = false;
  public boolean mTriggerSelectedQCircleTab = false;
  
  public QCircleFrameEvent() {}
  
  public QCircleFrameEvent(int paramInt, boolean paramBoolean)
  {
    this.mHashCode = paramInt;
    this.mIsTabClickSelf = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent
 * JD-Core Version:    0.7.0.1
 */