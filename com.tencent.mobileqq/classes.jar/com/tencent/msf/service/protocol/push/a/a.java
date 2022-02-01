package com.tencent.msf.service.protocol.push.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class a
  extends JceStruct
{
  public long a = 0L;
  public int b = 0;
  public String c = "";
  public byte[] d = null;
  
  public a() {}
  
  public a(long paramLong, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    this.a = paramLong;
    this.b = paramInt;
    this.c = paramString;
    this.d = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, false);
    this.b = paramJceInputStream.read(this.b, 1, false);
    this.c = paramJceInputStream.readString(2, false);
    this.d = ((byte[])paramJceInputStream.read(this.d, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    Object localObject = this.c;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.d;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.a.a
 * JD-Core Version:    0.7.0.1
 */