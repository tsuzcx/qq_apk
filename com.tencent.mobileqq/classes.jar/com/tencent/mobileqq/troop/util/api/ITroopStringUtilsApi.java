package com.tencent.mobileqq.troop.util.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITroopStringUtilsApi
  extends QRouteApi
{
  public abstract String cutByteByUtf8(byte[] paramArrayOfByte, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.util.api.ITroopStringUtilsApi
 * JD-Core Version:    0.7.0.1
 */