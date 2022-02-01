package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCirclePublishButtonEvent
  extends SimpleBaseEvent
{
  public byte[] mData;
  
  public QCirclePublishButtonEvent(byte[] paramArrayOfByte)
  {
    this.mData = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.event.QCirclePublishButtonEvent
 * JD-Core Version:    0.7.0.1
 */