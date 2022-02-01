package com.tencent.mobileqq.relation.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={""})
public abstract interface IIceBreakingMsg
  extends QRouteApi
{
  public abstract void handleGetIceBreakHotPicResponse(AppRuntime paramAppRuntime, byte[] paramArrayOfByte, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.IIceBreakingMsg
 * JD-Core Version:    0.7.0.1
 */