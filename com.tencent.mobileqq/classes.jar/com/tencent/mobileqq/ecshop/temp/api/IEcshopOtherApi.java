package com.tencent.mobileqq.ecshop.temp.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IEcshopOtherApi
  extends QRouteApi
{
  public abstract void updateRecentList(AppInterface paramAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.temp.api.IEcshopOtherApi
 * JD-Core Version:    0.7.0.1
 */