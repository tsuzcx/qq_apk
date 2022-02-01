package com.yolo.esports.download.common;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.timi.game.utils.Logger;

class HalleyDownloaderProxy$1
  implements INetInfoHandler
{
  HalleyDownloaderProxy$1(HalleyDownloaderProxy paramHalleyDownloaderProxy) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNetNone2Mobile ");
    localStringBuilder.append(paramString);
    Logger.a("HalleyDownloaderProxy_", localStringBuilder.toString());
    this.a.c();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNetNone2Wifi ");
    localStringBuilder.append(paramString);
    Logger.a("HalleyDownloaderProxy_", localStringBuilder.toString());
    this.a.c();
  }
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.download.common.HalleyDownloaderProxy.1
 * JD-Core Version:    0.7.0.1
 */