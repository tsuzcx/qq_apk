package com.tencent.msf.service.protocol.d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class a
  extends JceStruct
{
  static byte[] f;
  static byte[] g;
  public byte[] a;
  public int b;
  public int c;
  public byte[] d;
  public byte e;
  
  public a() {}
  
  public a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, byte paramByte)
  {
    this.a = paramArrayOfByte1;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramArrayOfByte2;
    this.e = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (f == null)
    {
      f = (byte[])new byte[1];
      ((byte[])f)[0] = 0;
    }
    this.a = ((byte[])paramJceInputStream.read(f, 0, true));
    this.b = paramJceInputStream.read(this.b, 1, true);
    this.c = paramJceInputStream.read(this.c, 2, true);
    if (g == null)
    {
      g = (byte[])new byte[1];
      ((byte[])g)[0] = 0;
    }
    this.d = ((byte[])paramJceInputStream.read(g, 3, true));
    this.e = paramJceInputStream.read(this.e, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.d.a
 * JD-Core Version:    0.7.0.1
 */