package com.tencent.mobileqq.qwallet.hb.aio;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IHongbaoPanelProvider
  extends QRouteApi
{
  public abstract IHongbaoPanelProvider init(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.IHongbaoPanelProvider
 * JD-Core Version:    0.7.0.1
 */