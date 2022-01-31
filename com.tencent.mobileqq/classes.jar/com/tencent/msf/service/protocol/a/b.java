package com.tencent.msf.service.protocol.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class b
  extends JceStruct
{
  public byte a;
  public String b = "";
  public long c;
  public long d;
  public long e;
  
  public b() {}
  
  public b(byte paramByte, String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    this.a = paramByte;
    this.b = paramString;
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.readString(1, false);
    this.c = paramJceInputStream.read(this.c, 2, false);
    this.d = paramJceInputStream.read(this.d, 3, false);
    this.e = paramJceInputStream.read(this.e, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    if (this.b != null) {
      paramJceOutputStream.write(this.b, 1);
    }
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.a.b
 * JD-Core Version:    0.7.0.1
 */