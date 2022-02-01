package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleAddblackUpdateEvent
  extends SimpleBaseEvent
{
  public int blackstate;
  public String mUserId;
  
  public QCircleAddblackUpdateEvent(int paramInt, String paramString)
  {
    this.blackstate = paramInt;
    this.mUserId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.event.QCircleAddblackUpdateEvent
 * JD-Core Version:    0.7.0.1
 */