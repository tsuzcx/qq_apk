package com.tencent.mobileqq.highway.protocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class HttpFmtServerListReq
  extends JceStruct
{
  public byte bLinkType = 1;
  public int netType;
  public String sImei = "";
  public String sImsi = "46000";
  public long uAppid;
  public long uCellid;
  public long uiLastTime;
  public long uin;
  public long uintype;
  
  public HttpFmtServerListReq() {}
  
  public HttpFmtServerListReq(long paramLong1, long paramLong2, long paramLong3, byte paramByte, String paramString1, int paramInt, long paramLong4, String paramString2, long paramLong5)
  {
    this.uin = paramLong1;
    this.uintype = paramLong2;
    this.uiLastTime = paramLong3;
    this.bLinkType = paramByte;
    this.sImsi = paramString1;
    this.netType = paramInt;
    this.uAppid = paramLong4;
    this.sImei = paramString2;
    this.uCellid = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.uintype = paramJceInputStream.read(this.uintype, 1, true);
    this.uiLastTime = paramJceInputStream.read(this.uiLastTime, 2, true);
    this.bLinkType = paramJceInputStream.read(this.bLinkType, 3, true);
    this.sImsi = paramJceInputStream.readString(4, true);
    this.netType = paramJceInputStream.read(this.netType, 5, true);
    this.uAppid = paramJceInputStream.read(this.uAppid, 6, true);
    this.sImei = paramJceInputStream.readString(7, true);
    this.uCellid = paramJceInputStream.read(this.uCellid, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.uintype, 1);
    paramJceOutputStream.write(this.uiLastTime, 2);
    paramJceOutputStream.write(this.bLinkType, 3);
    paramJceOutputStream.write(this.sImsi, 4);
    paramJceOutputStream.write(this.netType, 5);
    paramJceOutputStream.write(this.uAppid, 6);
    paramJceOutputStream.write(this.sImei, 7);
    paramJceOutputStream.write(this.uCellid, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.HttpFmtServerListReq
 * JD-Core Version:    0.7.0.1
 */