package com.tencent.mobileqq.music;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import mqq.app.MobileQQ;

class QQPlayerService$NetInfoHandler
  implements INetInfoHandler
{
  long a = 0L;
  
  private void a(int paramInt)
  {
    if (System.currentTimeMillis() - this.a < 500L) {
      return;
    }
    this.a = System.currentTimeMillis();
    QQPlayerService.f(MobileQQ.getContext());
  }
  
  public void onNetMobile2None()
  {
    a(4);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    a(3);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    a(1);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    a(2);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    a(6);
  }
  
  public void onNetWifi2None()
  {
    a(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.NetInfoHandler
 * JD-Core Version:    0.7.0.1
 */