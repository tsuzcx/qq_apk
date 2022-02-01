package com.tencent.msf.service.protocol.g;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class h
  extends JceStruct
{
  static byte[] e;
  static byte[] f;
  public byte a = 0;
  public byte[] b = null;
  public byte[] c = null;
  public String d = "";
  
  public h() {}
  
  public h(byte paramByte, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    this.a = paramByte;
    this.b = paramArrayOfByte1;
    this.c = paramArrayOfByte2;
    this.d = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 1, true);
    if (e == null)
    {
      e = (byte[])new byte[1];
      ((byte[])e)[0] = 0;
    }
    this.b = ((byte[])paramJceInputStream.read(e, 2, true));
    if (f == null)
    {
      f = (byte[])new byte[1];
      ((byte[])f)[0] = 0;
    }
    this.c = ((byte[])paramJceInputStream.read(f, 3, true));
    this.d = paramJceInputStream.readString(4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
    paramJceOutputStream.write(this.d, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.msf.service.protocol.g.h
 * JD-Core Version:    0.7.0.1
 */