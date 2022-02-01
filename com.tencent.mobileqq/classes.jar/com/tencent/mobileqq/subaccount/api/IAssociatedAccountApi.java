package com.tencent.mobileqq.subaccount.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IAssociatedAccountApi
  extends QRouteApi
{
  public abstract Class<?> getAssociatedAccountActivity();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.IAssociatedAccountApi
 * JD-Core Version:    0.7.0.1
 */