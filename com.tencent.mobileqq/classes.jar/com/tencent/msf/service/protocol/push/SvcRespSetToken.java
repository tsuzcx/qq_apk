package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcRespSetToken
  extends JceStruct
{
  static ArrayList cache_vTokenID = new ArrayList();
  static byte[] cache_vVoipCookie;
  public byte cReplyCode = 0;
  public long lUin = 0L;
  public String strResult = "";
  public ArrayList vTokenID = null;
  public byte[] vVoipCookie = null;
  
  static
  {
    cache_vTokenID.add(Integer.valueOf(0));
    cache_vVoipCookie = (byte[])new byte[1];
    ((byte[])cache_vVoipCookie)[0] = 0;
  }
  
  public SvcRespSetToken() {}
  
  public SvcRespSetToken(long paramLong, ArrayList paramArrayList, byte paramByte, String paramString, byte[] paramArrayOfByte)
  {
    this.lUin = paramLong;
    this.vTokenID = paramArrayList;
    this.cReplyCode = paramByte;
    this.strResult = paramString;
    this.vVoipCookie = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.vTokenID = ((ArrayList)paramJceInputStream.read(cache_vTokenID, 1, true));
    this.cReplyCode = paramJceInputStream.read(this.cReplyCode, 2, true);
    this.strResult = paramJceInputStream.readString(3, true);
    this.vVoipCookie = ((byte[])paramJceInputStream.read(cache_vVoipCookie, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.vTokenID, 1);
    paramJceOutputStream.write(this.cReplyCode, 2);
    paramJceOutputStream.write(this.strResult, 3);
    byte[] arrayOfByte = this.vVoipCookie;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.SvcRespSetToken
 * JD-Core Version:    0.7.0.1
 */