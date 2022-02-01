package com.tencent.qzonehub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITrueTypeResult
  extends QRouteApi
{
  public abstract void result(int paramInt, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.ITrueTypeResult
 * JD-Core Version:    0.7.0.1
 */