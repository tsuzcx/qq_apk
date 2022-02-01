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
    d locald = this.wifi;
    if (locald != null) {
      return locald.b;
    }
    return "";
  }
  
  public short getSignal()
  {
    d locald = this.wifi;
    if (locald != null) {
      return locald.c;
    }
    return 0;
  }
  
  public String getSsid()
  {
    d locald = this.wifi;
    if (locald != null) {
      return locald.a;
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
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("[pkgid=");
    localStringBuilder1.append(this.pkgid);
    if (this.wifi != null)
    {
      localStringBuilder1.append(", ssid=");
      localStringBuilder1.append(this.wifi.a);
      localStringBuilder1.append(", bssid=");
      localStringBuilder1.append(this.wifi.b);
      localStringBuilder1.append("]");
    }
    else
    {
      localStringBuilder1.append("]");
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("autoConnFlag=");
    localStringBuilder2.append(this.autoConnFlag);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.fee, 1);
    Object localObject = this.pkgid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.wifi;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    paramJceOutputStream.write(this.autoConnFlag, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.msf.service.protocol.QQWiFi.WiFiService
 * JD-Core Version:    0.7.0.1
 */