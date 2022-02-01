package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class VasExtensionManager$NetHandler
  implements INetInfoHandler
{
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    VasExtensionManager.a();
  }
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString)
  {
    VasExtensionManager.a();
  }
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasExtensionManager.NetHandler
 * JD-Core Version:    0.7.0.1
 */