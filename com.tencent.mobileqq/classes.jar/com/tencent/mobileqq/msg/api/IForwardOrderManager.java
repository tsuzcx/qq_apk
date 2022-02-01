package com.tencent.mobileqq.msg.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IForwardOrderManager
  extends QRouteApi
{
  public abstract void mapUniSeqId(long paramLong1, long paramLong2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.IForwardOrderManager
 * JD-Core Version:    0.7.0.1
 */