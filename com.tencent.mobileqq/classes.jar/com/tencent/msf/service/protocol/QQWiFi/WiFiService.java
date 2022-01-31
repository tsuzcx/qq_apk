package com.tencent.msf.service.protocol.QQWiFi;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class WiFiService
  extends JceStruct
{
  static d cache_wifi;
  public int autoConnFlag = 0;
  public byte fee = 0;
  public String pkgid = "";
  public byte type = 0;
  public d wifi = null;
  
  public WiFiService() {}
  
  public WiFiService(byte paramByte1, byte paramByte2, String paramString, d paramd, int paramInt)
  {
    this.type = paramByte1;
    this.fee = paramByte2;
    this.pkgid = paramString;
    this.wifi = paramd;
    this.autoConnFlag = paramInt;
  }
  
  public String getBssid()
  {
    if (this.wifi != null) {
      return this.wifi.b;
    }
    return "";
  }
  
  public short getSignal()
  {
    if (this.wifi != null) {
      return this.wifi.c;
    }
    return 0;
  }
  
  public String getSsid()
  {
    if (this.wifi != null) {
      return this.wifi.a;
    }
    return "";
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, true);
    this.fee = paramJceInputStream.read(this.fee, 1, true);
    this.pkgid = paramJceInputStream.readString(2, false);
    if (cache_wifi == null) {
      cache_wifi = new d();
    }
    this.wifi = ((d)paramJceInputStream.read(cache_wifi, 3, false));
    this.autoConnFlag = paramJceInputStream.read(this.autoConnFlag, 4, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[pkgid=").append(this.pkgid);
    if (this.wifi != null)
    {
      localStringBuilder.append(", ssid=").append(this.wifi.a);
      localStringBuilder.append(", bssid=").append(this.wifi.b).append("]");
    }
    for (;;)
    {
      localStringBuilder.append("autoConnFlag=" + this.autoConnFlag);
      return localStringBuilder.toString();
      localStringBuilder.append("]");
    }
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.fee, 1);
    if (this.pkgid != null) {
      paramJceOutputStream.write(this.pkgid, 2);
    }
    if (this.wifi != null) {
      paramJceOutputStream.write(this.wifi, 3);
    }
    paramJceOutputStream.write(this.autoConnFlag, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.QQWiFi.WiFiService
 * JD-Core Version:    0.7.0.1
 */