package com.tencent.msf.service.protocol.push.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class a
  extends JceStruct
{
  public long a;
  public int b;
  public String c = "";
  
  public a() {}
  
  public a(long paramLong, int paramInt, String paramString)
  {
    this.a = paramLong;
    this.b = paramInt;
    this.c = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, false);
    this.b = paramJceInputStream.read(this.b, 1, false);
    this.c = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.a.a
 * JD-Core Version:    0.7.0.1
 */