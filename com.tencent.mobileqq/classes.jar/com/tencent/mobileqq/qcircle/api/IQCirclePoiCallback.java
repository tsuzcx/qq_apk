package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.LbsDataV2.PoiList;

@QAPI(process={"all"})
public abstract interface IQCirclePoiCallback
  extends QRouteApi
{
  public abstract void onPoiResultBack(LbsDataV2.PoiList paramPoiList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IQCirclePoiCallback
 * JD-Core Version:    0.7.0.1
 */