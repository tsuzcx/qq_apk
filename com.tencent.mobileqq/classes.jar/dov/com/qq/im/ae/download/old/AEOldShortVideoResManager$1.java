package dov.com.qq.im.ae.download.old;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class AEOldShortVideoResManager$1
  implements INetInfoHandler
{
  AEOldShortVideoResManager$1(AEOldShortVideoResManager paramAEOldShortVideoResManager) {}
  
  public void onNetMobile2None()
  {
    AEOldShortVideoResManager.b(this.a);
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    AEOldShortVideoResManager.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.1
 * JD-Core Version:    0.7.0.1
 */