package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespondCustomSig
  extends JceStruct
{
  static ArrayList cache_SigList;
  static byte[] cache_reserved;
  public ArrayList SigList = null;
  public byte[] reserved = null;
  public long ulCustumFlag = 0L;
  public long ulSType = 0L;
  
  public RespondCustomSig() {}
  
  public RespondCustomSig(long paramLong1, long paramLong2, ArrayList paramArrayList, byte[] paramArrayOfByte)
  {
    this.ulCustumFlag = paramLong1;
    this.ulSType = paramLong2;
    this.SigList = paramArrayList;
    this.reserved = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ulCustumFlag = paramJceInputStream.read(this.ulCustumFlag, 0, true);
    this.ulSType = paramJceInputStream.read(this.ulSType, 1, true);
    if (cache_SigList == null)
    {
      cache_SigList = new ArrayList();
      CustomSigContent localCustomSigContent = new CustomSigContent();
      cache_SigList.add(localCustomSigContent);
    }
    this.SigList = ((ArrayList)paramJceInputStream.read(cache_SigList, 2, true));
    if (cache_reserved == null)
    {
      cache_reserved = (byte[])new byte[1];
      ((byte[])cache_reserved)[0] = 0;
    }
    this.reserved = ((byte[])paramJceInputStream.read(cache_reserved, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ulCustumFlag, 0);
    paramJceOutputStream.write(this.ulSType, 1);
    paramJceOutputStream.write(this.SigList, 2);
    paramJceOutputStream.write(this.reserved, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.security.RespondCustomSig
 * JD-Core Version:    0.7.0.1
 */