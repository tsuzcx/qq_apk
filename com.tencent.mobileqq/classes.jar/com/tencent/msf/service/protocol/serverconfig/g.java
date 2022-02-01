package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class g
  extends JceStruct
{
  static byte[] d;
  public int a = 0;
  public long b = 0L;
  public byte[] c = null;
  
  public g() {}
  
  public g(int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    this.a = paramInt;
    this.b = paramLong;
    this.c = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 1, true);
    this.b = paramJceInputStream.read(this.b, 2, true);
    if (d == null)
    {
      d = (byte[])new byte[1];
      ((byte[])d)[0] = 0;
    }
    this.c = ((byte[])paramJceInputStream.read(d, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    byte[] arrayOfByte = this.c;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.g
 * JD-Core Version:    0.7.0.1
 */