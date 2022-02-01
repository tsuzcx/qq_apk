package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class b
  extends JceStruct
{
  static byte[] g;
  static byte[] h;
  static byte[] i;
  public byte[] a = null;
  public int b = 0;
  public int c = 0;
  public byte[] d = null;
  public int e = 0;
  public byte[] f = null;
  
  public b() {}
  
  public b(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, byte[] paramArrayOfByte3)
  {
    this.a = paramArrayOfByte1;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramArrayOfByte2;
    this.e = paramInt3;
    this.f = paramArrayOfByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (g == null)
    {
      g = (byte[])new byte[1];
      ((byte[])g)[0] = 0;
    }
    this.a = ((byte[])paramJceInputStream.read(g, 0, true));
    this.b = paramJceInputStream.read(this.b, 1, true);
    this.c = paramJceInputStream.read(this.c, 2, true);
    if (h == null)
    {
      h = (byte[])new byte[1];
      ((byte[])h)[0] = 0;
    }
    this.d = ((byte[])paramJceInputStream.read(h, 3, true));
    this.e = paramJceInputStream.read(this.e, 4, true);
    if (i == null)
    {
      i = (byte[])new byte[1];
      ((byte[])i)[0] = 0;
    }
    this.f = ((byte[])paramJceInputStream.read(i, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
    byte[] arrayOfByte = this.f;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.msf.service.protocol.security.b
 * JD-Core Version:    0.7.0.1
 */