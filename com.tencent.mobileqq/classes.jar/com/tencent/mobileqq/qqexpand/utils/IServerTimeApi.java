package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IServerTimeApi
  extends QRouteApi
{
  public abstract long getServerTime();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.IServerTimeApi
 * JD-Core Version:    0.7.0.1
 */