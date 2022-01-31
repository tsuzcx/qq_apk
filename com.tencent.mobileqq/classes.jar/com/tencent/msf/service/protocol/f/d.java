package com.tencent.msf.service.protocol.f;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class d
  extends JceStruct
{
  public String a = "";
  public long b;
  public short c;
  public short d;
  public byte e;
  public long f;
  public byte g;
  public byte h;
  public int i = 64;
  
  public d() {}
  
  public d(String paramString, long paramLong1, short paramShort1, short paramShort2, byte paramByte1, long paramLong2, byte paramByte2, byte paramByte3, int paramInt)
  {
    this.a = paramString;
    this.b = paramLong1;
    this.c = paramShort1;
    this.d = paramShort2;
    this.e = paramByte1;
    this.f = paramLong2;
    this.g = paramByte2;
    this.h = paramByte3;
    this.i = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(1, true);
    this.b = paramJceInputStream.read(this.b, 2, true);
    this.c = paramJceInputStream.read(this.c, 3, true);
    this.d = paramJceInputStream.read(this.d, 4, true);
    this.e = paramJceInputStream.read(this.e, 5, true);
    this.f = paramJceInputStream.read(this.f, 6, false);
    this.g = paramJceInputStream.read(this.g, 7, false);
    this.h = paramJceInputStream.read(this.h, 8, false);
    this.i = paramJceInputStream.read(this.i, 9, false);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.f.d
 * JD-Core Version:    0.7.0.1
 */