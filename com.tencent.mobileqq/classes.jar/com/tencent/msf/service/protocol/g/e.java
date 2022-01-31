package com.tencent.msf.service.protocol.g;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class e
  extends JceStruct
{
  static byte[] d;
  public String a = "";
  public String b = "";
  public byte[] c;
  
  public e() {}
  
  public e(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(1, true);
    this.b = paramJceInputStream.readString(2, true);
    if (d == null)
    {
      d = (byte[])new byte[1];
      ((byte[])d)[0] = 0;
    }
    this.c = ((byte[])paramJceInputStream.read(d, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.g.e
 * JD-Core Version:    0.7.0.1
 */