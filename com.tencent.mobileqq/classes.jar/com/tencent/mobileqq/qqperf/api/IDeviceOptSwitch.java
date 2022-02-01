package com.tencent.mobileqq.qqperf.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Set;

@QAPI(process={"all"})
public abstract interface IDeviceOptSwitch
  extends QRouteApi
{
  public abstract Set<Integer> getPreDownloadWhiteList();
  
  public abstract boolean isDisablePreDownload();
  
  public abstract void setDisablePreDownloadTime(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqperf.api.IDeviceOptSwitch
 * JD-Core Version:    0.7.0.1
 */