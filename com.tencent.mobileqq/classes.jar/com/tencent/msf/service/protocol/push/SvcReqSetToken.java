package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcReqSetToken
  extends JceStruct
{
  static byte[] cache_vNewToken;
  static byte[] cache_vNewVoipToken;
  static ArrayList cache_vTokenID = new ArrayList();
  static ArrayList cache_vVoipToken;
  public byte bEnterVersion = 0;
  public byte bOnlinePush = 0;
  public byte bPhotoPush = 0;
  public byte bPushMsg = 1;
  public byte bPushQZone = 1;
  public byte bPushWithoutContent = 0;
  public byte bScenes = 0;
  public byte bVoipFlag = 0;
  public long lUin = 0L;
  public String sEmptySound = "";
  public String sExtends = "";
  public String sPushSound = "";
  public String sSound = "";
  public String sVideoSound = "";
  public byte[] vNewToken = null;
  public byte[] vNewVoipToken = null;
  public ArrayList vTokenID = null;
  public ArrayList vVoipToken = null;
  
  static
  {
    cache_vTokenID.add(Integer.valueOf(0));
    cache_vVoipToken = new ArrayList();
    cache_vVoipToken.add(Integer.valueOf(0));
    cache_vNewToken = (byte[])new byte[1];
    ((byte[])cache_vNewToken)[0] = 0;
    cache_vNewVoipToken = (byte[])new byte[1];
    ((byte[])cache_vNewVoipToken)[0] = 0;
  }
  
  public SvcReqSetToken() {}
  
  public SvcReqSetToken(long paramLong, ArrayList paramArrayList1, String paramString1, String paramString2, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, String paramString3, String paramString4, String paramString5, byte paramByte7, ArrayList paramArrayList2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte paramByte8)
  {
    this.lUin = paramLong;
    this.vTokenID = paramArrayList1;
    this.sSound = paramString1;
    this.sExtends = paramString2;
    this.bPushMsg = paramByte1;
    this.bPushQZone = paramByte2;
    this.bOnlinePush = paramByte3;
    this.bEnterVersion = paramByte4;
    this.bPhotoPush = paramByte5;
    this.bPushWithoutContent = paramByte6;
    this.sPushSound = paramString3;
    this.sEmptySound = paramString4;
    this.sVideoSound = paramString5;
    this.bVoipFlag = paramByte7;
    this.vVoipToken = paramArrayList2;
    this.vNewToken = paramArrayOfByte1;
    this.vNewVoipToken = paramArrayOfByte2;
    this.bScenes = paramByte8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.vTokenID = ((ArrayList)paramJceInputStream.read(cache_vTokenID, 1, true));
    this.sSound = paramJceInputStream.readString(2, true);
    this.sExtends = paramJceInputStream.readString(3, true);
    this.bPushMsg = paramJceInputStream.read(this.bPushMsg, 4, false);
    this.bPushQZone = paramJceInputStream.read(this.bPushQZone, 5, false);
    this.bOnlinePush = paramJceInputStream.read(this.bOnlinePush, 6, false);
    this.bEnterVersion = paramJceInputStream.read(this.bEnterVersion, 7, false);
    this.bPhotoPush = paramJceInputStream.read(this.bPhotoPush, 8, false);
    this.bPushWithoutContent = paramJceInputStream.read(this.bPushWithoutContent, 9, false);
    this.sPushSound = paramJceInputStream.readString(10, false);
    this.sEmptySound = paramJceInputStream.readString(11, false);
    this.sVideoSound = paramJceInputStream.readString(12, false);
    this.bVoipFlag = paramJceInputStream.read(this.bVoipFlag, 13, false);
    this.vVoipToken = ((ArrayList)paramJceInputStream.read(cache_vVoipToken, 14, false));
    this.vNewToken = ((byte[])paramJceInputStream.read(cache_vNewToken, 15, false));
    this.vNewVoipToken = ((byte[])paramJceInputStream.read(cache_vNewVoipToken, 16, false));
    this.bScenes = paramJceInputStream.read(this.bScenes, 17, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.vTokenID, 1);
    paramJceOutputStream.write(this.sSound, 2);
    paramJceOutputStream.write(this.sExtends, 3);
    paramJceOutputStream.write(this.bPushMsg, 4);
    paramJceOutputStream.write(this.bPushQZone, 5);
    paramJceOutputStream.write(this.bOnlinePush, 6);
    paramJceOutputStream.write(this.bEnterVersion, 7);
    paramJceOutputStream.write(this.bPhotoPush, 8);
    paramJceOutputStream.write(this.bPushWithoutContent, 9);
    if (this.sPushSound != null) {
      paramJceOutputStream.write(this.sPushSound, 10);
    }
    if (this.sEmptySound != null) {
      paramJceOutputStream.write(this.sEmptySound, 11);
    }
    if (this.sVideoSound != null) {
      paramJceOutputStream.write(this.sVideoSound, 12);
    }
    paramJceOutputStream.write(this.bVoipFlag, 13);
    if (this.vVoipToken != null) {
      paramJceOutputStream.write(this.vVoipToken, 14);
    }
    if (this.vNewToken != null) {
      paramJceOutputStream.write(this.vNewToken, 15);
    }
    if (this.vNewVoipToken != null) {
      paramJceOutputStream.write(this.vNewVoipToken, 16);
    }
    paramJceOutputStream.write(this.bScenes, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.SvcReqSetToken
 * JD-Core Version:    0.7.0.1
 */