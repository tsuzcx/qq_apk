package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class ShortVideoResourceManager$1
  implements INetInfoHandler
{
  ShortVideoResourceManager$1(ShortVideoResourceManager paramShortVideoResourceManager) {}
  
  public void onNetMobile2None()
  {
    ShortVideoResourceManager.a(this.a);
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    ShortVideoResourceManager.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.1
 * JD-Core Version:    0.7.0.1
 */