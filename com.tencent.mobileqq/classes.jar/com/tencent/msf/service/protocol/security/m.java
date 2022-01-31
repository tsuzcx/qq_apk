package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class m
  extends JceStruct
{
  static byte[] i;
  static byte[] j;
  static byte[] k;
  public byte[] a = null;
  public String b = "";
  public String c = "";
  public byte d = 0;
  public String e = "";
  public byte f = 0;
  public byte[] g = null;
  public byte[] h = null;
  
  public m() {}
  
  public m(byte[] paramArrayOfByte1, String paramString1, String paramString2, byte paramByte1, String paramString3, byte paramByte2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    this.a = paramArrayOfByte1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramByte1;
    this.e = paramString3;
    this.f = paramByte2;
    this.g = paramArrayOfByte2;
    this.h = paramArrayOfByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (i == null)
    {
      i = (byte[])new byte[1];
      ((byte[])i)[0] = 0;
    }
    this.a = ((byte[])paramJceInputStream.read(i, 0, true));
    this.b = paramJceInputStream.readString(1, true);
    this.c = paramJceInputStream.readString(2, true);
    this.d = paramJceInputStream.read(this.d, 3, false);
    this.e = paramJceInputStream.readString(4, false);
    this.f = paramJceInputStream.read(this.f, 5, false);
    if (j == null)
    {
      j = (byte[])new byte[1];
      ((byte[])j)[0] = 0;
    }
    this.g = ((byte[])paramJceInputStream.read(j, 6, false));
    if (k == null)
    {
      k = (byte[])new byte[1];
      ((byte[])k)[0] = 0;
    }
    this.h = ((byte[])paramJceInputStream.read(k, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
    if (this.e != null) {
      paramJceOutputStream.write(this.e, 4);
    }
    paramJceOutputStream.write(this.f, 5);
    if (this.g != null) {
      paramJceOutputStream.write(this.g, 6);
    }
    if (this.h != null) {
      paramJceOutputStream.write(this.h, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.security.m
 * JD-Core Version:    0.7.0.1
 */