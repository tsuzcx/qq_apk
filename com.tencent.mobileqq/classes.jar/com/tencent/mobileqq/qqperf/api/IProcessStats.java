package com.tencent.mobileqq.qqperf.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IProcessStats
  extends QRouteApi
{
  public abstract double getCpuUsage();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqperf.api.IProcessStats
 * JD-Core Version:    0.7.0.1
 */