package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Net
  extends JceStruct
{
  public String extNetworkOperator = "";
  public int extNetworkType = 0;
  public byte isWap = 0;
  public byte netType = 0;
  public String wifiBssid = "";
  public String wifiSsid = "";
  
  public Net() {}
  
  public Net(byte paramByte1, String paramString1, int paramInt, byte paramByte2, String paramString2, String paramString3)
  {
    this.netType = paramByte1;
    this.extNetworkOperator = paramString1;
    this.extNetworkType = paramInt;
    this.isWap = paramByte2;
    this.wifiSsid = paramString2;
    this.wifiBssid = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.netType = paramJceInputStream.read(this.netType, 0, true);
    this.extNetworkOperator = paramJceInputStream.readString(1, false);
    this.extNetworkType = paramJceInputStream.read(this.extNetworkType, 2, false);
    this.isWap = paramJceInputStream.read(this.isWap, 3, false);
    this.wifiSsid = paramJceInputStream.readString(4, false);
    this.wifiBssid = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.netType, 0);
    if (this.extNetworkOperator != null) {
      paramJceOutputStream.write(this.extNetworkOperator, 1);
    }
    paramJceOutputStream.write(this.extNetworkType, 2);
    paramJceOutputStream.write(this.isWap, 3);
    if (this.wifiSsid != null) {
      paramJceOutputStream.write(this.wifiSsid, 4);
    }
    if (this.wifiBssid != null) {
      paramJceOutputStream.write(this.wifiBssid, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.Net
 * JD-Core Version:    0.7.0.1
 */