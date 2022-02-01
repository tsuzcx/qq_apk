package com.tencent.mobileqq.subaccount.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.NewIntent;

@QAPI(process={"all"})
public abstract interface ISubAccountServlet
  extends QRouteApi
{
  public abstract NewIntent fetchOneTroopNewMsg(AppInterface paramAppInterface, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.ISubAccountServlet
 * JD-Core Version:    0.7.0.1
 */