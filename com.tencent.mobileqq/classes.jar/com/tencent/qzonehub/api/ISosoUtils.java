package com.tencent.qzonehub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import cooperation.qzone.LbsDataV2.GpsInfo;

@QAPI(process={"all"})
public abstract interface ISosoUtils
  extends QRouteApi
{
  public abstract LbsDataV2.GpsInfo convertFromSoso(SosoLocation paramSosoLocation);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qzonehub.api.ISosoUtils
 * JD-Core Version:    0.7.0.1
 */