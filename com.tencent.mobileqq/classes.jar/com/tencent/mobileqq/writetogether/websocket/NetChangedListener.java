package com.tencent.mobileqq.writetogether.websocket;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public abstract class NetChangedListener
  implements INetInfoHandler
{
  protected abstract void a();
  
  protected abstract void b();
  
  public void onNetMobile2None()
  {
    b();
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    a();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    a();
  }
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.NetChangedListener
 * JD-Core Version:    0.7.0.1
 */