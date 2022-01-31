package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class f
  extends JceStruct
{
  static byte[] d;
  public int a;
  public byte[] b;
  public long c;
  
  public f() {}
  
  public f(int paramInt, byte[] paramArrayOfByte, long paramLong)
  {
    this.a = paramInt;
    this.b = paramArrayOfByte;
    this.c = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 1, true);
    if (d == null)
    {
      d = (byte[])new byte[1];
      ((byte[])d)[0] = 0;
    }
    this.b = ((byte[])paramJceInputStream.read(d, 2, true));
    this.c = paramJceInputStream.read(this.c, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.f
 * JD-Core Version:    0.7.0.1
 */