package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleFlutterUpdateFuelEvent
  extends SimpleBaseEvent
{
  public int fuelCount;
  public String uin;
  
  public QCircleFlutterUpdateFuelEvent(String paramString, int paramInt)
  {
    this.uin = paramString;
    this.fuelCount = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.event.QCircleFlutterUpdateFuelEvent
 * JD-Core Version:    0.7.0.1
 */