package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class d
  extends JceStruct
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public String e = "";
  public int f = 0;
  public String g = "";
  public String h = "";
  public int i = 0;
  
  public d() {}
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int paramInt5, String paramString2, String paramString3, int paramInt6)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramString1;
    this.f = paramInt5;
    this.g = paramString2;
    this.h = paramString3;
    this.i = paramInt6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, true);
    this.c = paramJceInputStream.read(this.c, 2, true);
    this.d = paramJceInputStream.read(this.d, 3, true);
    this.e = paramJceInputStream.readString(4, true);
    this.f = paramJceInputStream.read(this.f, 5, true);
    this.g = paramJceInputStream.readString(6, true);
    this.h = paramJceInputStream.readString(7, true);
    this.i = paramJceInputStream.read(this.i, 8, true);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.security.d
 * JD-Core Version:    0.7.0.1
 */