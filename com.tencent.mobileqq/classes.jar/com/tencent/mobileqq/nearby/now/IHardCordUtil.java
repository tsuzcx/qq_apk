package com.tencent.mobileqq.nearby.now;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IHardCordUtil
  extends QRouteApi
{
  public abstract String qqStr(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.IHardCordUtil
 * JD-Core Version:    0.7.0.1
 */