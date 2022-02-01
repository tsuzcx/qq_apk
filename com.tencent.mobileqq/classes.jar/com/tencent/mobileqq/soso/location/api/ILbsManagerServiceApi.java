package com.tencent.mobileqq.soso.location.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

@QAPI(process={"all"})
public abstract interface ILbsManagerServiceApi
  extends QRouteApi
{
  public abstract String getBGLocateMonitorClassName();
  
  public abstract SosoLbsInfo getCachedLbsInfo(String paramString);
  
  public abstract String getCity();
  
  public abstract String getCityCode();
  
  public abstract String getProvince();
  
  public abstract boolean isLastLocationSuccess();
  
  public abstract void onDestroy();
  
  public abstract void pushBGLocateMonitorStart();
  
  public abstract void removeListener(LbsManagerServiceOnLocationChangeListener paramLbsManagerServiceOnLocationChangeListener);
  
  public abstract void startLocation(LbsManagerServiceOnLocationChangeListener paramLbsManagerServiceOnLocationChangeListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi
 * JD-Core Version:    0.7.0.1
 */