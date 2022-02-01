package com.tencent.mobileqq.gamecenter.protocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GmpEnterInfoReq
  extends JceStruct
{
  public long appid;
  public int tt;
  
  public GmpEnterInfoReq() {}
  
  public GmpEnterInfoReq(long paramLong, int paramInt)
  {
    this.appid = paramLong;
    this.tt = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.tt = paramJceInputStream.read(this.tt, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.tt, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoReq
 * JD-Core Version:    0.7.0.1
 */