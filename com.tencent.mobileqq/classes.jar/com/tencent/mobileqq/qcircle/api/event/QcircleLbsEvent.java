package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import cooperation.qzone.LbsDataV2.PoiList;

public class QcircleLbsEvent
  extends SimpleBaseEvent
{
  public LbsDataV2.PoiList mPoiList;
  
  public QcircleLbsEvent(LbsDataV2.PoiList paramPoiList)
  {
    this.mPoiList = paramPoiList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.event.QcircleLbsEvent
 * JD-Core Version:    0.7.0.1
 */