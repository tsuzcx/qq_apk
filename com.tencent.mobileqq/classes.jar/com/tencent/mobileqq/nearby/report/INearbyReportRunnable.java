package com.tencent.mobileqq.nearby.report;

import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface INearbyReportRunnable
  extends QRouteApi
{
  public static final int METHOD_ID_ENTRY_CLK_RED = 2;
  public static final int METHOD_ID_ENTRY_EXP = 1;
  
  public abstract void init(Object paramObject, int paramInt);
  
  public abstract void setCardManager(INearbyCardManager paramINearbyCardManager);
  
  public abstract void setExtraValues(String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.report.INearbyReportRunnable
 * JD-Core Version:    0.7.0.1
 */