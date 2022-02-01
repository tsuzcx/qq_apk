package com.tencent.mobileqq.nearby.api.impl;

import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class NearbyAppInterfaceImpl$MyNetInfoHandler
  implements INetInfoHandler
{
  private NearbyAppInterfaceImpl$MyNetInfoHandler(NearbyAppInterfaceImpl paramNearbyAppInterfaceImpl) {}
  
  public void onNetMobile2None()
  {
    if (NearbyAppInterfaceImpl.access$800(this.a) != null) {
      NearbyAppInterfaceImpl.access$900(this.a).onNetMobile2None();
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (NearbyAppInterfaceImpl.access$600(this.a) != null) {
      NearbyAppInterfaceImpl.access$700(this.a).onNetMobile2Wifi(paramString);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (NearbyAppInterfaceImpl.access$000(this.a) != null) {
      NearbyAppInterfaceImpl.access$100(this.a).onNetNone2Mobile(paramString);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (NearbyAppInterfaceImpl.access$400(this.a) != null) {
      NearbyAppInterfaceImpl.access$500(this.a).onNetNone2Wifi(paramString);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (NearbyAppInterfaceImpl.access$200(this.a) != null) {
      NearbyAppInterfaceImpl.access$300(this.a).onNetWifi2Mobile(paramString);
    }
  }
  
  public void onNetWifi2None()
  {
    if (NearbyAppInterfaceImpl.access$1000(this.a) != null) {
      NearbyAppInterfaceImpl.access$1100(this.a).onNetWifi2None();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.NearbyAppInterfaceImpl.MyNetInfoHandler
 * JD-Core Version:    0.7.0.1
 */