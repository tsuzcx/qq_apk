package com.tencent.mobileqq.qqperf.api.impl;

import com.tencent.mobileqq.qqperf.api.IDeviceOptSwitch;
import com.tencent.qqperf.opt.suspendthread.DeviceOptSwitch;
import java.util.Set;

public class DeviceOptSwitchImpl
  implements IDeviceOptSwitch
{
  public Set<Integer> getPreDownloadWhiteList()
  {
    return DeviceOptSwitch.a;
  }
  
  public boolean isDisablePreDownload()
  {
    return DeviceOptSwitch.b;
  }
  
  public void setDisablePreDownloadTime(long paramLong)
  {
    DeviceOptSwitch.n = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqperf.api.impl.DeviceOptSwitchImpl
 * JD-Core Version:    0.7.0.1
 */