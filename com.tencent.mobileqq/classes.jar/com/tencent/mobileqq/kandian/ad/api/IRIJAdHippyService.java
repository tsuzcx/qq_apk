package com.tencent.mobileqq.kandian.ad.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRIJAdHippyService
  extends QRouteApi
{
  public abstract Object createReadinjoyAdHippyFragment(int paramInt, String paramString1, String paramString2);
  
  public abstract boolean instanceOfReadinjoyAdHippyFragment(Object paramObject);
  
  public abstract void setHippyUrl(Object paramObject, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJAdHippyService
 * JD-Core Version:    0.7.0.1
 */