package com.tencent.mobileqq.gamecenter.protocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GmpEnterInfoReq
  extends JceStruct
{
  public long appid = 0L;
  public int tt = 0;
  public int version = 0;
  
  public GmpEnterInfoReq() {}
  
  public GmpEnterInfoReq(long paramLong, int paramInt1, int paramInt2)
  {
    this.appid = paramLong;
    this.tt = paramInt1;
    this.version = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.tt = paramJceInputStream.read(this.tt, 1, false);
    this.version = paramJceInputStream.read(this.version, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.tt, 1);
    paramJceOutputStream.write(this.version, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoReq
 * JD-Core Version:    0.7.0.1
 */