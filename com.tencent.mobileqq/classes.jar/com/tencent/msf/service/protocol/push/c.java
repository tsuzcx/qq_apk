package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c
  extends JceStruct
{
  static byte[] q;
  public long a = 0L;
  public long b = 0L;
  public String c = "";
  public int d = 11;
  public byte e = 0;
  public byte f = 0;
  public byte g = 0;
  public int h = 0;
  public int i = 0;
  public int j = 0;
  public int k = 0;
  public int l = 0;
  public byte[] m = null;
  public String n = "";
  public String o = "";
  public String p = "";
  
  public c() {}
  
  public c(long paramLong1, long paramLong2, String paramString1, int paramInt1, byte paramByte1, byte paramByte2, byte paramByte3, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte, String paramString2, String paramString3, String paramString4)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramString1;
    this.d = paramInt1;
    this.e = paramByte1;
    this.f = paramByte2;
    this.g = paramByte3;
    this.h = paramInt2;
    this.i = paramInt3;
    this.j = paramInt4;
    this.k = paramInt5;
    this.l = paramInt6;
    this.m = paramArrayOfByte;
    this.n = paramString2;
    this.o = paramString3;
    this.p = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, true);
    this.c = paramJceInputStream.readString(2, true);
    this.d = paramJceInputStream.read(this.d, 3, false);
    this.e = paramJceInputStream.read(this.e, 4, false);
    this.f = paramJceInputStream.read(this.f, 5, false);
    this.g = paramJceInputStream.read(this.g, 6, false);
    this.h = paramJceInputStream.read(this.h, 7, false);
    this.i = paramJceInputStream.read(this.i, 8, false);
    this.j = paramJceInputStream.read(this.j, 9, false);
    this.k = paramJceInputStream.read(this.k, 10, false);
    this.l = paramJceInputStream.read(this.l, 11, false);
    if (q == null)
    {
      q = (byte[])new byte[1];
      ((byte[])q)[0] = 0;
    }
    this.m = ((byte[])paramJceInputStream.read(q, 12, false));
    this.n = paramJceInputStream.readString(13, false);
    this.o = paramJceInputStream.readString(14, false);
    this.p = paramJceInputStream.readString(15, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
    paramJceOutputStream.write(this.f, 5);
    paramJceOutputStream.write(this.g, 6);
    paramJceOutputStream.write(this.h, 7);
    paramJceOutputStream.write(this.i, 8);
    paramJceOutputStream.write(this.j, 9);
    paramJceOutputStream.write(this.k, 10);
    paramJceOutputStream.write(this.l, 11);
    if (this.m != null) {
      paramJceOutputStream.write(this.m, 12);
    }
    if (this.n != null) {
      paramJceOutputStream.write(this.n, 13);
    }
    if (this.o != null) {
      paramJceOutputStream.write(this.o, 14);
    }
    if (this.p != null) {
      paramJceOutputStream.write(this.p, 15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.c
 * JD-Core Version:    0.7.0.1
 */