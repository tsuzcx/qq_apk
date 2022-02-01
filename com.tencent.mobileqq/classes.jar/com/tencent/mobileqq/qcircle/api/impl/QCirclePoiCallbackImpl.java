package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.IQCirclePoiCallback;
import com.tencent.mobileqq.qcircle.api.event.QcircleLbsEvent;
import cooperation.qzone.LbsDataV2.PoiList;

public class QCirclePoiCallbackImpl
  implements IQCirclePoiCallback
{
  public void onPoiResultBack(LbsDataV2.PoiList paramPoiList)
  {
    SimpleEventBus.getInstance().dispatchEvent(new QcircleLbsEvent(paramPoiList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCirclePoiCallbackImpl
 * JD-Core Version:    0.7.0.1
 */