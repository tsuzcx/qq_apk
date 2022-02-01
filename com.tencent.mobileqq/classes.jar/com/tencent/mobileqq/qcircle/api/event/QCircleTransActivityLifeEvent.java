package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleTransActivityLifeEvent
  extends SimpleBaseEvent
{
  public static final int EVENT_START = 0;
  public static final int EVENT_STOP = 1;
  private int mLifeEvent;
  
  public QCircleTransActivityLifeEvent(int paramInt)
  {
    this.mLifeEvent = paramInt;
  }
  
  public int getLifeEvent()
  {
    return this.mLifeEvent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.event.QCircleTransActivityLifeEvent
 * JD-Core Version:    0.7.0.1
 */