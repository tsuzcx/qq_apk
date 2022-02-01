package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCirclePushToastEvent
  extends SimpleBaseEvent
{
  public byte[] mData;
  
  public QCirclePushToastEvent(byte[] paramArrayOfByte)
  {
    this.mData = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.event.QCirclePushToastEvent
 * JD-Core Version:    0.7.0.1
 */