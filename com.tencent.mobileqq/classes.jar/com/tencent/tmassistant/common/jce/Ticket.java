package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Ticket
  extends JceStruct
{
  static byte[] cache_value = (byte[])new byte[1];
  public byte type = 0;
  public byte[] value = null;
  
  static
  {
    ((byte[])cache_value)[0] = 0;
  }
  
  public Ticket() {}
  
  public Ticket(byte paramByte, byte[] paramArrayOfByte)
  {
    this.type = paramByte;
    this.value = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, true);
    this.value = ((byte[])paramJceInputStream.read(cache_value, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.value, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.Ticket
 * JD-Core Version:    0.7.0.1
 */