package com.tencent.qzonehub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.model.GpsInfo4LocalImage;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IQzoneLbsServiceApi
  extends QRouteApi
{
  public abstract void getBatchPoiFromServer(ArrayList<GpsInfo4LocalImage> paramArrayList, boolean paramBoolean);
  
  public abstract void refreshPoiList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.IQzoneLbsServiceApi
 * JD-Core Version:    0.7.0.1
 */