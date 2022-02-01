package com.tencent.mobileqq.subaccount.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface ISubAccountConfigApi
  extends QRouteApi
{
  public abstract boolean getIsHideSubAccountTroopMsg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.ISubAccountConfigApi
 * JD-Core Version:    0.7.0.1
 */