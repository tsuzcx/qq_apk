package com.tencent.mobileqq.mini.api;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IMiniCmdService
  extends QRouteApi
{
  public abstract void createUpdatableMsg(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4, byte[] paramArrayOfByte, MiniAppCmdInterface paramMiniAppCmdInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.IMiniCmdService
 * JD-Core Version:    0.7.0.1
 */