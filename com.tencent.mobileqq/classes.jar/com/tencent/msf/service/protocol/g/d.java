package com.tencent.msf.service.protocol.g;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class d
  extends JceStruct
{
  static byte[] e;
  static byte[] f;
  public byte a = 0;
  public byte[] b = null;
  public String c = "";
  public byte[] d = null;
  
  public d() {}
  
  public d(byte paramByte, byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2)
  {
    this.a = paramByte;
    this.b = paramArrayOfByte1;
    this.c = paramString;
    this.d = paramArrayOfByte2;
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
    this.c = paramJceInputStream.readString(3, true);
    if (f == null)
    {
      f = (byte[])new byte[1];
      ((byte[])f)[0] = 0;
    }
    this.d = ((byte[])paramJceInputStream.read(f, 4, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
    paramJceOutputStream.write(this.d, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.msf.service.protocol.g.d
 * JD-Core Version:    0.7.0.1
 */