package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestMSFForceOffline
  extends JceStruct
{
  static byte[] cache_vecSigKickData;
  public byte bKickType = 0;
  public byte bSameDevice = 0;
  public byte bSigKick = 0;
  public long iSeqno = 0L;
  public long lUin = 0L;
  public String strInfo = "";
  public String strTitle = "";
  public byte[] vecSigKickData = null;
  
  public RequestMSFForceOffline() {}
  
  public RequestMSFForceOffline(long paramLong1, long paramLong2, byte paramByte1, String paramString1, String paramString2, byte paramByte2, byte[] paramArrayOfByte, byte paramByte3)
  {
    this.lUin = paramLong1;
    this.iSeqno = paramLong2;
    this.bKickType = paramByte1;
    this.strInfo = paramString1;
    this.strTitle = paramString2;
    this.bSigKick = paramByte2;
    this.vecSigKickData = paramArrayOfByte;
    this.bSameDevice = paramByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.iSeqno = paramJceInputStream.read(this.iSeqno, 1, true);
    this.bKickType = paramJceInputStream.read(this.bKickType, 2, true);
    this.strInfo = paramJceInputStream.readString(3, true);
    this.strTitle = paramJceInputStream.readString(4, false);
    this.bSigKick = paramJceInputStream.read(this.bSigKick, 5, false);
    if (cache_vecSigKickData == null)
    {
      cache_vecSigKickData = (byte[])new byte[1];
      ((byte[])cache_vecSigKickData)[0] = 0;
    }
    this.vecSigKickData = ((byte[])paramJceInputStream.read(cache_vecSigKickData, 6, false));
    this.bSameDevice = paramJceInputStream.read(this.bSameDevice, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.iSeqno, 1);
    paramJceOutputStream.write(this.bKickType, 2);
    paramJceOutputStream.write(this.strInfo, 3);
    Object localObject = this.strTitle;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.bSigKick, 5);
    localObject = this.vecSigKickData;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 6);
    }
    paramJceOutputStream.write(this.bSameDevice, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.RequestMSFForceOffline
 * JD-Core Version:    0.7.0.1
 */