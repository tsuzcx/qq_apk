package com.tencent.mobileqq.qqcommon.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface INetworkUtilApi
  extends QRouteApi
{
  public abstract int getConnRetryTimes(int paramInt);
  
  public abstract boolean is4G();
  
  public abstract boolean is5G();
  
  public abstract boolean isNetworkAvailable();
  
  public abstract boolean isWifi();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqcommon.api.INetworkUtilApi
 * JD-Core Version:    0.7.0.1
 */