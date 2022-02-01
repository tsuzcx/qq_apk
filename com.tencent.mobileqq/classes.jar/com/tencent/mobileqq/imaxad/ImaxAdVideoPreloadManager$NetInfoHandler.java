package com.tencent.mobileqq.imaxad;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class ImaxAdVideoPreloadManager$NetInfoHandler
  implements INetInfoHandler
{
  ImaxAdVideoPreloadManager a;
  
  public ImaxAdVideoPreloadManager$NetInfoHandler(ImaxAdVideoPreloadManager paramImaxAdVideoPreloadManager1, ImaxAdVideoPreloadManager paramImaxAdVideoPreloadManager2)
  {
    this.a = paramImaxAdVideoPreloadManager2;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onNetMobile2None()
  {
    ImaxAdUtil.b("onNetMobile2None");
    ImaxAdVideoPreloadManager localImaxAdVideoPreloadManager = this.a;
    if (localImaxAdVideoPreloadManager != null) {
      ImaxAdVideoPreloadManager.c(localImaxAdVideoPreloadManager);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    ImaxAdUtil.b("onNetMobile2Wifi");
    paramString = this.a;
    if (paramString != null) {
      ImaxAdVideoPreloadManager.c(paramString);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    ImaxAdUtil.b("onNetNone2Mobile");
    paramString = this.a;
    if (paramString != null) {
      ImaxAdVideoPreloadManager.c(paramString);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    ImaxAdUtil.b("onNetNone2Wifi");
    paramString = this.a;
    if (paramString != null) {
      ImaxAdVideoPreloadManager.c(paramString);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    ImaxAdUtil.b("onNetWifi2Mobile");
    paramString = this.a;
    if (paramString != null) {
      ImaxAdVideoPreloadManager.c(paramString);
    }
  }
  
  public void onNetWifi2None()
  {
    ImaxAdUtil.b("onNetWifi2None");
    ImaxAdVideoPreloadManager localImaxAdVideoPreloadManager = this.a;
    if (localImaxAdVideoPreloadManager != null) {
      ImaxAdVideoPreloadManager.c(localImaxAdVideoPreloadManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager.NetInfoHandler
 * JD-Core Version:    0.7.0.1
 */