package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class Net
  extends JceStruct
  implements Cloneable
{
  public String extNetworkOperator = "";
  public int extNetworkType = 0;
  public byte isWap = 0;
  public byte netType = 0;
  public String wifiBssid = "";
  public String wifiSsid = "";
  
  static
  {
    if (!Net.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
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
  
  public String className()
  {
    return "jce.Net";
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
    paramStringBuilder.display(this.netType, "netType");
    paramStringBuilder.display(this.extNetworkOperator, "extNetworkOperator");
    paramStringBuilder.display(this.extNetworkType, "extNetworkType");
    paramStringBuilder.display(this.isWap, "isWap");
    paramStringBuilder.display(this.wifiSsid, "wifiSsid");
    paramStringBuilder.display(this.wifiBssid, "wifiBssid");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.netType, true);
    paramStringBuilder.displaySimple(this.extNetworkOperator, true);
    paramStringBuilder.displaySimple(this.extNetworkType, true);
    paramStringBuilder.displaySimple(this.isWap, true);
    paramStringBuilder.displaySimple(this.wifiSsid, true);
    paramStringBuilder.displaySimple(this.wifiBssid, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (Net)paramObject;
    } while ((!JceUtil.equals(this.netType, paramObject.netType)) || (!JceUtil.equals(this.extNetworkOperator, paramObject.extNetworkOperator)) || (!JceUtil.equals(this.extNetworkType, paramObject.extNetworkType)) || (!JceUtil.equals(this.isWap, paramObject.isWap)) || (!JceUtil.equals(this.wifiSsid, paramObject.wifiSsid)) || (!JceUtil.equals(this.wifiBssid, paramObject.wifiBssid)));
    return true;
  }
  
  public String fullClassName()
  {
    return "com.tencent.tmassistant.common.jce.Net";
  }
  
  public String getExtNetworkOperator()
  {
    return this.extNetworkOperator;
  }
  
  public int getExtNetworkType()
  {
    return this.extNetworkType;
  }
  
  public byte getIsWap()
  {
    return this.isWap;
  }
  
  public byte getNetType()
  {
    return this.netType;
  }
  
  public String getWifiBssid()
  {
    return this.wifiBssid;
  }
  
  public String getWifiSsid()
  {
    return this.wifiSsid;
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
    this.netType = paramJceInputStream.read(this.netType, 0, true);
    this.extNetworkOperator = paramJceInputStream.readString(1, false);
    this.extNetworkType = paramJceInputStream.read(this.extNetworkType, 2, false);
    this.isWap = paramJceInputStream.read(this.isWap, 3, false);
    this.wifiSsid = paramJceInputStream.readString(4, false);
    this.wifiBssid = paramJceInputStream.readString(5, false);
  }
  
  public void setExtNetworkOperator(String paramString)
  {
    this.extNetworkOperator = paramString;
  }
  
  public void setExtNetworkType(int paramInt)
  {
    this.extNetworkType = paramInt;
  }
  
  public void setIsWap(byte paramByte)
  {
    this.isWap = paramByte;
  }
  
  public void setNetType(byte paramByte)
  {
    this.netType = paramByte;
  }
  
  public void setWifiBssid(String paramString)
  {
    this.wifiBssid = paramString;
  }
  
  public void setWifiSsid(String paramString)
  {
    this.wifiSsid = paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.Net
 * JD-Core Version:    0.7.0.1
 */