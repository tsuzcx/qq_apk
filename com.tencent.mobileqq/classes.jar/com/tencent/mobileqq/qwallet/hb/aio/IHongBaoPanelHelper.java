package com.tencent.mobileqq.qwallet.hb.aio;

import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IHongBaoPanelHelper
  extends ILifeCycleHelper, QRouteApi
{
  public abstract IHongBaoPanelHelper init(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.IHongBaoPanelHelper
 * JD-Core Version:    0.7.0.1
 */