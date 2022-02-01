package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleRewardAdResultEvent
  extends SimpleBaseEvent
{
  public String mToast;
  
  public QCircleRewardAdResultEvent(String paramString)
  {
    this.mToast = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.event.QCircleRewardAdResultEvent
 * JD-Core Version:    0.7.0.1
 */