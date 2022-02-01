package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleTabConfigChangeEvent
  extends SimpleBaseEvent
{
  private boolean mShowBottom;
  
  public QCircleTabConfigChangeEvent(boolean paramBoolean)
  {
    this.mShowBottom = paramBoolean;
  }
  
  public boolean isShowBottom()
  {
    return this.mShowBottom;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.event.QCircleTabConfigChangeEvent
 * JD-Core Version:    0.7.0.1
 */