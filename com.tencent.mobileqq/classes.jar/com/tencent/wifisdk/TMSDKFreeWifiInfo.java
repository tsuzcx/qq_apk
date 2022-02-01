package com.tencent.wifisdk;

public class TMSDKFreeWifiInfo
{
  public String bssid = "";
  public boolean isBestWiFi = false;
  public String poi = "";
  public String recommendReason = "";
  public int security = -1;
  public int signalLevel = 0;
  public String ssid = "";
  public int starLevel = 0;
  
  public TMSDKFreeWifiInfo() {}
  
  public TMSDKFreeWifiInfo(String paramString, int paramInt)
  {
    this.ssid = paramString;
    this.security = paramInt;
  }
  
  public String toString()
  {
    return "[ssid:" + this.ssid + ",bssid:" + this.bssid + ",security:" + this.security + ",poi:" + this.poi + ",signalLevel:" + this.signalLevel + ",isBestWifi:" + this.isBestWiFi + ",recommendReason:" + this.recommendReason;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.wifisdk.TMSDKFreeWifiInfo
 * JD-Core Version:    0.7.0.1
 */