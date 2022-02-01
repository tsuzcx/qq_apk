package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CustomSigContent
  extends JceStruct
{
  static byte[] cache_SigContent;
  public byte[] SigContent = null;
  public long length = 0L;
  public short sResult = 0;
  public long ulSigType = 0L;
  
  public CustomSigContent() {}
  
  public CustomSigContent(long paramLong1, short paramShort, long paramLong2, byte[] paramArrayOfByte)
  {
    this.ulSigType = paramLong1;
    this.sResult = paramShort;
    this.length = paramLong2;
    this.SigContent = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ulSigType = paramJceInputStream.read(this.ulSigType, 0, true);
    this.sResult = paramJceInputStream.read(this.sResult, 1, true);
    this.length = paramJceInputStream.read(this.length, 2, true);
    if (cache_SigContent == null)
    {
      cache_SigContent = (byte[])new byte[1];
      ((byte[])cache_SigContent)[0] = 0;
    }
    this.SigContent = ((byte[])paramJceInputStream.read(cache_SigContent, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ulSigType, 0);
    paramJceOutputStream.write(this.sResult, 1);
    paramJceOutputStream.write(this.length, 2);
    paramJceOutputStream.write(this.SigContent, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.msf.service.protocol.security.CustomSigContent
 * JD-Core Version:    0.7.0.1
 */