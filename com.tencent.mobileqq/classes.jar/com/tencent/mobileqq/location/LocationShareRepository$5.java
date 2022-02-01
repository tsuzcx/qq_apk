package com.tencent.mobileqq.location;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class LocationShareRepository$5
  implements INetInfoHandler
{
  LocationShareRepository$5(LocationShareRepository paramLocationShareRepository) {}
  
  public void onNetMobile2None()
  {
    LocationShareRepository.a(this.a).b();
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    LocationShareRepository.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationShareRepository.5
 * JD-Core Version:    0.7.0.1
 */