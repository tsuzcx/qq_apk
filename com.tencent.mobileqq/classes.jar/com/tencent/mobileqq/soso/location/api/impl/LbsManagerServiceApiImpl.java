package com.tencent.mobileqq.soso.location.api.impl;

import com.tencent.mobileqq.soso.location.BGLocateMonitor;
import com.tencent.mobileqq.soso.location.LbsManagerService;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.SosoInterface;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

public class LbsManagerServiceApiImpl
  implements ILbsManagerServiceApi
{
  public String getBGLocateMonitorClassName()
  {
    return BGLocateMonitor.class.getName();
  }
  
  public SosoLbsInfo getCachedLbsInfo(String paramString)
  {
    return LbsManagerService.getCachedLbsInfo(paramString);
  }
  
  public String getCity()
  {
    return LbsManagerService.getCity();
  }
  
  public String getCityCode()
  {
    return LbsManagerService.getCityCode();
  }
  
  public String getProvince()
  {
    return LbsManagerService.getProvince();
  }
  
  public boolean isLastLocationSuccess()
  {
    return SosoInterface.isLastLocationSuccess();
  }
  
  public void onDestroy() {}
  
  public void pushBGLocateMonitorStart() {}
  
  public void removeListener(LbsManagerServiceOnLocationChangeListener paramLbsManagerServiceOnLocationChangeListener)
  {
    LbsManagerService.removeListener(paramLbsManagerServiceOnLocationChangeListener);
  }
  
  public void startLocation(LbsManagerServiceOnLocationChangeListener paramLbsManagerServiceOnLocationChangeListener)
  {
    LbsManagerService.startLocation(paramLbsManagerServiceOnLocationChangeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.api.impl.LbsManagerServiceApiImpl
 * JD-Core Version:    0.7.0.1
 */