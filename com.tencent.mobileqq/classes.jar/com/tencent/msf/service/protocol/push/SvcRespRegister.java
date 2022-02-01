package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRespRegister
  extends JceStruct
{
  static byte[] cache_bytes_0x769_rspbody = (byte[])new byte[1];
  public byte bCrashFlag = 0;
  public byte bLargeSeqUpdate = 0;
  public byte bLogQQ = 0;
  public byte bNeedKik = 0;
  public byte bUpdateFlag = 0;
  public byte[] bytes_0x769_rspbody = null;
  public byte cReplyCode = 0;
  public int iClientPort = 0;
  public int iHelloInterval = 300;
  public long iLargeSeq = 0L;
  public int iStatus = 0;
  public long lBid = 0L;
  public long lServerTime = 0L;
  public long lUin = 0L;
  public String strClientIP = "";
  public String strResult = "";
  public long timeStamp = 0L;
  public long uClientAutoStatusInterval = 600L;
  public long uClientBatteryGetInterval = 86400L;
  public long uExtOnlineStatus = 0L;
  
  static
  {
    ((byte[])cache_bytes_0x769_rspbody)[0] = 0;
  }
  
  public SvcRespRegister() {}
  
  public SvcRespRegister(long paramLong1, long paramLong2, byte paramByte1, String paramString1, long paramLong3, byte paramByte2, byte paramByte3, byte paramByte4, long paramLong4, byte paramByte5, String paramString2, int paramInt1, int paramInt2, long paramLong5, byte paramByte6, byte[] paramArrayOfByte, int paramInt3, long paramLong6, long paramLong7, long paramLong8)
  {
    this.lUin = paramLong1;
    this.lBid = paramLong2;
    this.cReplyCode = paramByte1;
    this.strResult = paramString1;
    this.lServerTime = paramLong3;
    this.bLogQQ = paramByte2;
    this.bNeedKik = paramByte3;
    this.bUpdateFlag = paramByte4;
    this.timeStamp = paramLong4;
    this.bCrashFlag = paramByte5;
    this.strClientIP = paramString2;
    this.iClientPort = paramInt1;
    this.iHelloInterval = paramInt2;
    this.iLargeSeq = paramLong5;
    this.bLargeSeqUpdate = paramByte6;
    this.bytes_0x769_rspbody = paramArrayOfByte;
    this.iStatus = paramInt3;
    this.uExtOnlineStatus = paramLong6;
    this.uClientBatteryGetInterval = paramLong7;
    this.uClientAutoStatusInterval = paramLong8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.lBid = paramJceInputStream.read(this.lBid, 1, true);
    this.cReplyCode = paramJceInputStream.read(this.cReplyCode, 2, true);
    this.strResult = paramJceInputStream.readString(3, true);
    this.lServerTime = paramJceInputStream.read(this.lServerTime, 4, false);
    this.bLogQQ = paramJceInputStream.read(this.bLogQQ, 5, false);
    this.bNeedKik = paramJceInputStream.read(this.bNeedKik, 6, false);
    this.bUpdateFlag = paramJceInputStream.read(this.bUpdateFlag, 7, false);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 8, false);
    this.bCrashFlag = paramJceInputStream.read(this.bCrashFlag, 9, false);
    this.strClientIP = paramJceInputStream.readString(10, false);
    this.iClientPort = paramJceInputStream.read(this.iClientPort, 11, false);
    this.iHelloInterval = paramJceInputStream.read(this.iHelloInterval, 12, false);
    this.iLargeSeq = paramJceInputStream.read(this.iLargeSeq, 13, false);
    this.bLargeSeqUpdate = paramJceInputStream.read(this.bLargeSeqUpdate, 14, false);
    this.bytes_0x769_rspbody = ((byte[])paramJceInputStream.read(cache_bytes_0x769_rspbody, 15, false));
    this.iStatus = paramJceInputStream.read(this.iStatus, 16, false);
    this.uExtOnlineStatus = paramJceInputStream.read(this.uExtOnlineStatus, 17, false);
    this.uClientBatteryGetInterval = paramJceInputStream.read(this.uClientBatteryGetInterval, 18, false);
    this.uClientAutoStatusInterval = paramJceInputStream.read(this.uClientAutoStatusInterval, 19, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.lBid, 1);
    paramJceOutputStream.write(this.cReplyCode, 2);
    paramJceOutputStream.write(this.strResult, 3);
    paramJceOutputStream.write(this.lServerTime, 4);
    paramJceOutputStream.write(this.bLogQQ, 5);
    paramJceOutputStream.write(this.bNeedKik, 6);
    paramJceOutputStream.write(this.bUpdateFlag, 7);
    paramJceOutputStream.write(this.timeStamp, 8);
    paramJceOutputStream.write(this.bCrashFlag, 9);
    if (this.strClientIP != null) {
      paramJceOutputStream.write(this.strClientIP, 10);
    }
    paramJceOutputStream.write(this.iClientPort, 11);
    paramJceOutputStream.write(this.iHelloInterval, 12);
    paramJceOutputStream.write(this.iLargeSeq, 13);
    paramJceOutputStream.write(this.bLargeSeqUpdate, 14);
    if (this.bytes_0x769_rspbody != null) {
      paramJceOutputStream.write(this.bytes_0x769_rspbody, 15);
    }
    paramJceOutputStream.write(this.iStatus, 16);
    paramJceOutputStream.write(this.uExtOnlineStatus, 17);
    paramJceOutputStream.write(this.uClientBatteryGetInterval, 18);
    paramJceOutputStream.write(this.uClientAutoStatusInterval, 19);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.SvcRespRegister
 * JD-Core Version:    0.7.0.1
 */