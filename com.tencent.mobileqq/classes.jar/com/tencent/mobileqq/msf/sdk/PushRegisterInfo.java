package com.tencent.mobileqq.msf.sdk;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class PushRegisterInfo
  extends JceStruct
{
  static ArrayList cache_pushIds;
  public byte bKikPC;
  public byte bKikWeak;
  public long iLargeSeq;
  public int iStatus;
  public ArrayList pushIds;
  public long timeStamp;
  public String uin = "";
  
  public PushRegisterInfo() {}
  
  public PushRegisterInfo(String paramString, ArrayList paramArrayList, int paramInt, byte paramByte1, byte paramByte2, long paramLong1, long paramLong2)
  {
    this.uin = paramString;
    this.pushIds = paramArrayList;
    this.iStatus = paramInt;
    this.bKikPC = paramByte1;
    this.bKikWeak = paramByte2;
    this.timeStamp = paramLong1;
    this.iLargeSeq = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.readString(1, true);
    if (cache_pushIds == null)
    {
      cache_pushIds = new ArrayList();
      cache_pushIds.add(Long.valueOf(0L));
    }
    this.pushIds = ((ArrayList)paramJceInputStream.read(cache_pushIds, 2, true));
    this.iStatus = paramJceInputStream.read(this.iStatus, 3, true);
    this.bKikPC = paramJceInputStream.read(this.bKikPC, 4, true);
    this.bKikWeak = paramJceInputStream.read(this.bKikWeak, 5, true);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 6, true);
    this.iLargeSeq = paramJceInputStream.read(this.iLargeSeq, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.pushIds, 2);
    paramJceOutputStream.write(this.iStatus, 3);
    paramJceOutputStream.write(this.bKikPC, 4);
    paramJceOutputStream.write(this.bKikWeak, 5);
    paramJceOutputStream.write(this.timeStamp, 6);
    paramJceOutputStream.write(this.iLargeSeq, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.PushRegisterInfo
 * JD-Core Version:    0.7.0.1
 */