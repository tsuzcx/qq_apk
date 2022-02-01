package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleSelectTabEvent
  extends SimpleBaseEvent
{
  public boolean needScrollTop = false;
  public int tabType;
  
  public QCircleSelectTabEvent(int paramInt)
  {
    this.tabType = paramInt;
  }
  
  public QCircleSelectTabEvent needScrollTop()
  {
    this.needScrollTop = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent
 * JD-Core Version:    0.7.0.1
 */