package com.tencent.mobileqq.weiyun.sdk.download;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class WyDownloader$2
  implements INetInfoHandler
{
  WyDownloader$2(WyDownloader paramWyDownloader) {}
  
  public void onNetMobile2None()
  {
    this.a.a(false, false);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    this.a.a(true, true);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    this.a.a(false, true);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    this.a.a(true, true);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    this.a.a(false, true);
  }
  
  public void onNetWifi2None()
  {
    this.a.a(false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.WyDownloader.2
 * JD-Core Version:    0.7.0.1
 */