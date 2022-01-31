package com.tencent.msf.service.protocol.e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class j
  extends JceStruct
{
  public int a;
  public byte b;
  public int c;
  public int d;
  public String e = "";
  public String f = "";
  public String g = "";
  public int h;
  public byte i = 1;
  public int j;
  public String k = "";
  
  public j() {}
  
  public j(int paramInt1, byte paramByte1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, int paramInt4, byte paramByte2, int paramInt5, String paramString4)
  {
    this.a = paramInt1;
    this.b = paramByte1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramString3;
    this.h = paramInt4;
    this.i = paramByte2;
    this.j = paramInt5;
    this.k = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 1, true);
    this.b = paramJceInputStream.read(this.b, 2, true);
    this.c = paramJceInputStream.read(this.c, 3, true);
    this.d = paramJceInputStream.read(this.d, 4, true);
    this.e = paramJceInputStream.readString(5, false);
    this.f = paramJceInputStream.readString(6, false);
    this.g = paramJceInputStream.readString(7, false);
    this.h = paramJceInputStream.read(this.h, 8, false);
    this.i = paramJceInputStream.read(this.i, 9, false);
    this.j = paramJceInputStream.read(this.j, 10, false);
    this.k = paramJceInputStream.readString(11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
    paramJceOutputStream.write(this.d, 4);
    if (this.e != null) {
      paramJceOutputStream.write(this.e, 5);
    }
    if (this.f != null) {
      paramJceOutputStream.write(this.f, 6);
    }
    if (this.g != null) {
      paramJceOutputStream.write(this.g, 7);
    }
    paramJceOutputStream.write(this.h, 8);
    paramJceOutputStream.write(this.i, 9);
    paramJceOutputStream.write(this.j, 10);
    if (this.k != null) {
      paramJceOutputStream.write(this.k, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.e.j
 * JD-Core Version:    0.7.0.1
 */