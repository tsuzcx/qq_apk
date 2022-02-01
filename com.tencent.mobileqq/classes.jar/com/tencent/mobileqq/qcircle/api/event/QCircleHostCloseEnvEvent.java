package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleHostCloseEnvEvent
  extends SimpleBaseEvent
{
  public static final int NEGATIVE = 0;
  public static final int POSITIVE = 1;
  public int ret;
  
  public QCircleHostCloseEnvEvent(int paramInt)
  {
    this.ret = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.event.QCircleHostCloseEnvEvent
 * JD-Core Version:    0.7.0.1
 */