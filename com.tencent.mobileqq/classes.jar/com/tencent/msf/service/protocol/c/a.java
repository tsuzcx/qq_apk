package com.tencent.msf.service.protocol.c;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class a
  extends JceStruct
{
  static byte[] e;
  public long a = 0L;
  public long b = 0L;
  public short c = 0;
  public byte[] d = null;
  
  public a() {}
  
  public a(long paramLong1, long paramLong2, short paramShort, byte[] paramArrayOfByte)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramShort;
    this.d = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, true);
    this.c = paramJceInputStream.read(this.c, 2, true);
    if (e == null)
    {
      e = (byte[])new byte[1];
      ((byte[])e)[0] = 0;
    }
    this.d = ((byte[])paramJceInputStream.read(e, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    byte[] arrayOfByte = this.d;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.msf.service.protocol.c.a
 * JD-Core Version:    0.7.0.1
 */