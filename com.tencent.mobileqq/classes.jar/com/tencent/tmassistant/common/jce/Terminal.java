package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Terminal
  extends JceStruct
{
  public String androidId = "";
  public String androidIdSdCard = "";
  public String brand = "";
  public String imei = "";
  public String imei2 = "";
  public String imsi = "";
  public String imsi2 = "";
  public String macAdress = "";
  public String manufacture = "";
  public String mode = "";
  public String product = "";
  public int xResolution = 0;
  public int yResolution = 0;
  
  public Terminal() {}
  
  public Terminal(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, int paramInt2, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    this.imei = paramString1;
    this.macAdress = paramString2;
    this.androidId = paramString3;
    this.androidIdSdCard = paramString4;
    this.imsi = paramString5;
    this.imei2 = paramString6;
    this.imsi2 = paramString7;
    this.xResolution = paramInt1;
    this.yResolution = paramInt2;
    this.brand = paramString8;
    this.mode = paramString9;
    this.manufacture = paramString10;
    this.product = paramString11;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.imei = paramJceInputStream.readString(0, false);
    this.macAdress = paramJceInputStream.readString(1, false);
    this.androidId = paramJceInputStream.readString(2, false);
    this.androidIdSdCard = paramJceInputStream.readString(3, false);
    this.imsi = paramJceInputStream.readString(4, false);
    this.imei2 = paramJceInputStream.readString(5, false);
    this.imsi2 = paramJceInputStream.readString(6, false);
    this.xResolution = paramJceInputStream.read(this.xResolution, 7, false);
    this.yResolution = paramJceInputStream.read(this.yResolution, 8, false);
    this.brand = paramJceInputStream.readString(9, false);
    this.mode = paramJceInputStream.readString(10, false);
    this.manufacture = paramJceInputStream.readString(11, false);
    this.product = paramJceInputStream.readString(12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.imei != null) {
      paramJceOutputStream.write(this.imei, 0);
    }
    if (this.macAdress != null) {
      paramJceOutputStream.write(this.macAdress, 1);
    }
    if (this.androidId != null) {
      paramJceOutputStream.write(this.androidId, 2);
    }
    if (this.androidIdSdCard != null) {
      paramJceOutputStream.write(this.androidIdSdCard, 3);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 4);
    }
    if (this.imei2 != null) {
      paramJceOutputStream.write(this.imei2, 5);
    }
    if (this.imsi2 != null) {
      paramJceOutputStream.write(this.imsi2, 6);
    }
    paramJceOutputStream.write(this.xResolution, 7);
    paramJceOutputStream.write(this.yResolution, 8);
    if (this.brand != null) {
      paramJceOutputStream.write(this.brand, 9);
    }
    if (this.mode != null) {
      paramJceOutputStream.write(this.mode, 10);
    }
    if (this.manufacture != null) {
      paramJceOutputStream.write(this.manufacture, 11);
    }
    if (this.product != null) {
      paramJceOutputStream.write(this.product, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.Terminal
 * JD-Core Version:    0.7.0.1
 */