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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[ssid:");
    localStringBuilder.append(this.ssid);
    localStringBuilder.append(",bssid:");
    localStringBuilder.append(this.bssid);
    localStringBuilder.append(",security:");
    localStringBuilder.append(this.security);
    localStringBuilder.append(",poi:");
    localStringBuilder.append(this.poi);
    localStringBuilder.append(",signalLevel:");
    localStringBuilder.append(this.signalLevel);
    localStringBuilder.append(",isBestWifi:");
    localStringBuilder.append(this.isBestWiFi);
    localStringBuilder.append(",recommendReason:");
    localStringBuilder.append(this.recommendReason);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.wifisdk.TMSDKFreeWifiInfo
 * JD-Core Version:    0.7.0.1
 */