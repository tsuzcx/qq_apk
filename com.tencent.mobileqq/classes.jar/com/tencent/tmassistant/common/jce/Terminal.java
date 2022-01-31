package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class Terminal
  extends JceStruct
  implements Cloneable
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
  
  static
  {
    if (!Terminal.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
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
  
  public String className()
  {
    return "jce.Terminal";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (a) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.imei, "imei");
    paramStringBuilder.display(this.macAdress, "macAdress");
    paramStringBuilder.display(this.androidId, "androidId");
    paramStringBuilder.display(this.androidIdSdCard, "androidIdSdCard");
    paramStringBuilder.display(this.imsi, "imsi");
    paramStringBuilder.display(this.imei2, "imei2");
    paramStringBuilder.display(this.imsi2, "imsi2");
    paramStringBuilder.display(this.xResolution, "xResolution");
    paramStringBuilder.display(this.yResolution, "yResolution");
    paramStringBuilder.display(this.brand, "brand");
    paramStringBuilder.display(this.mode, "mode");
    paramStringBuilder.display(this.manufacture, "manufacture");
    paramStringBuilder.display(this.product, "product");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.imei, true);
    paramStringBuilder.displaySimple(this.macAdress, true);
    paramStringBuilder.displaySimple(this.androidId, true);
    paramStringBuilder.displaySimple(this.androidIdSdCard, true);
    paramStringBuilder.displaySimple(this.imsi, true);
    paramStringBuilder.displaySimple(this.imei2, true);
    paramStringBuilder.displaySimple(this.imsi2, true);
    paramStringBuilder.displaySimple(this.xResolution, true);
    paramStringBuilder.displaySimple(this.yResolution, true);
    paramStringBuilder.displaySimple(this.brand, true);
    paramStringBuilder.displaySimple(this.mode, true);
    paramStringBuilder.displaySimple(this.manufacture, true);
    paramStringBuilder.displaySimple(this.product, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (Terminal)paramObject;
    } while ((!JceUtil.equals(this.imei, paramObject.imei)) || (!JceUtil.equals(this.macAdress, paramObject.macAdress)) || (!JceUtil.equals(this.androidId, paramObject.androidId)) || (!JceUtil.equals(this.androidIdSdCard, paramObject.androidIdSdCard)) || (!JceUtil.equals(this.imsi, paramObject.imsi)) || (!JceUtil.equals(this.imei2, paramObject.imei2)) || (!JceUtil.equals(this.imsi2, paramObject.imsi2)) || (!JceUtil.equals(this.xResolution, paramObject.xResolution)) || (!JceUtil.equals(this.yResolution, paramObject.yResolution)) || (!JceUtil.equals(this.brand, paramObject.brand)) || (!JceUtil.equals(this.mode, paramObject.mode)) || (!JceUtil.equals(this.manufacture, paramObject.manufacture)) || (!JceUtil.equals(this.product, paramObject.product)));
    return true;
  }
  
  public String fullClassName()
  {
    return "com.tencent.tmassistant.common.jce.Terminal";
  }
  
  public String getAndroidId()
  {
    return this.androidId;
  }
  
  public String getAndroidIdSdCard()
  {
    return this.androidIdSdCard;
  }
  
  public String getBrand()
  {
    return this.brand;
  }
  
  public String getImei()
  {
    return this.imei;
  }
  
  public String getImei2()
  {
    return this.imei2;
  }
  
  public String getImsi()
  {
    return this.imsi;
  }
  
  public String getImsi2()
  {
    return this.imsi2;
  }
  
  public String getMacAdress()
  {
    return this.macAdress;
  }
  
  public String getManufacture()
  {
    return this.manufacture;
  }
  
  public String getMode()
  {
    return this.mode;
  }
  
  public String getProduct()
  {
    return this.product;
  }
  
  public int getXResolution()
  {
    return this.xResolution;
  }
  
  public int getYResolution()
  {
    return this.yResolution;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
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
  
  public void setAndroidId(String paramString)
  {
    this.androidId = paramString;
  }
  
  public void setAndroidIdSdCard(String paramString)
  {
    this.androidIdSdCard = paramString;
  }
  
  public void setBrand(String paramString)
  {
    this.brand = paramString;
  }
  
  public void setImei(String paramString)
  {
    this.imei = paramString;
  }
  
  public void setImei2(String paramString)
  {
    this.imei2 = paramString;
  }
  
  public void setImsi(String paramString)
  {
    this.imsi = paramString;
  }
  
  public void setImsi2(String paramString)
  {
    this.imsi2 = paramString;
  }
  
  public void setMacAdress(String paramString)
  {
    this.macAdress = paramString;
  }
  
  public void setManufacture(String paramString)
  {
    this.manufacture = paramString;
  }
  
  public void setMode(String paramString)
  {
    this.mode = paramString;
  }
  
  public void setProduct(String paramString)
  {
    this.product = paramString;
  }
  
  public void setXResolution(int paramInt)
  {
    this.xResolution = paramInt;
  }
  
  public void setYResolution(int paramInt)
  {
    this.yResolution = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.Terminal
 * JD-Core Version:    0.7.0.1
 */