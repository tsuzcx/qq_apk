package com.tencent.open.appcircle.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ConfigItem
  extends JceStruct
{
  static byte[] cache_configuration = (byte[])new byte[1];
  public byte[] configuration;
  public int type;
  
  static
  {
    ((byte[])cache_configuration)[0] = 0;
  }
  
  public ConfigItem() {}
  
  public ConfigItem(int paramInt, byte[] paramArrayOfByte)
  {
    this.type = paramInt;
    this.configuration = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, true);
    this.configuration = ((byte[])paramJceInputStream.read(cache_configuration, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.configuration, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.appcircle.common.jce.ConfigItem
 * JD-Core Version:    0.7.0.1
 */