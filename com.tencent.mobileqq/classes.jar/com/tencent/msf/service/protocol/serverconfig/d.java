package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class d
  extends JceStruct
{
  public long a;
  public long b;
  public byte c = 1;
  public String d = "46000";
  public int e;
  public long f;
  public String g = "";
  public long h;
  public long i;
  public long j;
  public byte k;
  
  public d() {}
  
  public d(long paramLong1, long paramLong2, byte paramByte1, String paramString1, int paramInt, long paramLong3, String paramString2, long paramLong4, long paramLong5, long paramLong6, byte paramByte2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramByte1;
    this.d = paramString1;
    this.e = paramInt;
    this.f = paramLong3;
    this.g = paramString2;
    this.h = paramLong4;
    this.i = paramLong5;
    this.j = paramLong6;
    this.k = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 1, true);
    this.b = paramJceInputStream.read(this.b, 2, true);
    this.c = paramJceInputStream.read(this.c, 3, true);
    this.d = paramJceInputStream.readString(4, true);
    this.e = paramJceInputStream.read(this.e, 5, true);
    this.f = paramJceInputStream.read(this.f, 6, true);
    this.g = paramJceInputStream.readString(7, true);
    this.h = paramJceInputStream.read(this.h, 8, false);
    this.i = paramJceInputStream.read(this.i, 9, false);
    this.j = paramJceInputStream.read(this.j, 10, false);
    this.k = paramJceInputStream.read(this.k, 11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
    paramJceOutputStream.write(this.d, 4);
    paramJceOutputStream.write(this.e, 5);
    paramJceOutputStream.write(this.f, 6);
    paramJceOutputStream.write(this.g, 7);
    paramJceOutputStream.write(this.h, 8);
    paramJceOutputStream.write(this.i, 9);
    paramJceOutputStream.write(this.j, 10);
    paramJceOutputStream.write(this.k, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.d
 * JD-Core Version:    0.7.0.1
 */