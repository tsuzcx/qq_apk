package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SimpleOnlineFriendInfo
  extends JceStruct
{
  static int cache_eIconType;
  static int cache_eNetworkType;
  static byte[] cache_vecExtOnlineBusinessInfo;
  static byte[] cache_vecMusicInfo = (byte[])new byte[1];
  static byte[] cache_vecPoiInfo;
  public byte cNetwork = 0;
  public byte cSpecialFlag = 0;
  public byte detalStatusFlag = 0;
  public int eIconType = 0;
  public int eNetworkType = 0;
  public long friendUin = 0L;
  public int iBatteryStatus = 0;
  public int iTermType = 0;
  public byte isIphoneOnline = 0;
  public byte isMqqOnLine = 0;
  public String sShowName = "";
  public byte sqqOnLineState = 0;
  public byte sqqOnLineStateV2 = 0;
  public byte status = 20;
  public String strTermDesc = "";
  public long uAbiFlag = 0L;
  public long uExtOnlineStatus = 0L;
  public byte[] vecExtOnlineBusinessInfo = null;
  public byte[] vecMusicInfo = null;
  public byte[] vecPoiInfo = null;
  
  static
  {
    ((byte[])cache_vecMusicInfo)[0] = 0;
    cache_vecPoiInfo = (byte[])new byte[1];
    ((byte[])cache_vecPoiInfo)[0] = 0;
    cache_vecExtOnlineBusinessInfo = (byte[])new byte[1];
    ((byte[])cache_vecExtOnlineBusinessInfo)[0] = 0;
  }
  
  public SimpleOnlineFriendInfo() {}
  
  public SimpleOnlineFriendInfo(long paramLong1, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, String paramString1, byte paramByte7, int paramInt1, byte paramByte8, long paramLong2, int paramInt2, int paramInt3, String paramString2, long paramLong3, int paramInt4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    this.friendUin = paramLong1;
    this.status = paramByte1;
    this.isMqqOnLine = paramByte2;
    this.sqqOnLineState = paramByte3;
    this.isIphoneOnline = paramByte4;
    this.detalStatusFlag = paramByte5;
    this.sqqOnLineStateV2 = paramByte6;
    this.sShowName = paramString1;
    this.cSpecialFlag = paramByte7;
    this.iTermType = paramInt1;
    this.cNetwork = paramByte8;
    this.uAbiFlag = paramLong2;
    this.eNetworkType = paramInt2;
    this.eIconType = paramInt3;
    this.strTermDesc = paramString2;
    this.uExtOnlineStatus = paramLong3;
    this.iBatteryStatus = paramInt4;
    this.vecMusicInfo = paramArrayOfByte1;
    this.vecPoiInfo = paramArrayOfByte2;
    this.vecExtOnlineBusinessInfo = paramArrayOfByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.friendUin = paramJceInputStream.read(this.friendUin, 0, true);
    this.status = paramJceInputStream.read(this.status, 1, true);
    this.isMqqOnLine = paramJceInputStream.read(this.isMqqOnLine, 2, true);
    this.sqqOnLineState = paramJceInputStream.read(this.sqqOnLineState, 3, true);
    this.isIphoneOnline = paramJceInputStream.read(this.isIphoneOnline, 4, false);
    this.detalStatusFlag = paramJceInputStream.read(this.detalStatusFlag, 5, false);
    this.sqqOnLineStateV2 = paramJceInputStream.read(this.sqqOnLineStateV2, 6, false);
    this.sShowName = paramJceInputStream.readString(7, false);
    this.cSpecialFlag = paramJceInputStream.read(this.cSpecialFlag, 8, false);
    this.iTermType = paramJceInputStream.read(this.iTermType, 9, false);
    this.cNetwork = paramJceInputStream.read(this.cNetwork, 10, false);
    this.uAbiFlag = paramJceInputStream.read(this.uAbiFlag, 11, false);
    this.eNetworkType = paramJceInputStream.read(this.eNetworkType, 12, false);
    this.eIconType = paramJceInputStream.read(this.eIconType, 13, false);
    this.strTermDesc = paramJceInputStream.readString(14, false);
    this.uExtOnlineStatus = paramJceInputStream.read(this.uExtOnlineStatus, 15, false);
    this.iBatteryStatus = paramJceInputStream.read(this.iBatteryStatus, 16, false);
    this.vecMusicInfo = ((byte[])paramJceInputStream.read(cache_vecMusicInfo, 17, false));
    this.vecPoiInfo = ((byte[])paramJceInputStream.read(cache_vecPoiInfo, 18, false));
    this.vecExtOnlineBusinessInfo = ((byte[])paramJceInputStream.read(cache_vecExtOnlineBusinessInfo, 19, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.friendUin, 0);
    paramJceOutputStream.write(this.status, 1);
    paramJceOutputStream.write(this.isMqqOnLine, 2);
    paramJceOutputStream.write(this.sqqOnLineState, 3);
    paramJceOutputStream.write(this.isIphoneOnline, 4);
    paramJceOutputStream.write(this.detalStatusFlag, 5);
    paramJceOutputStream.write(this.sqqOnLineStateV2, 6);
    Object localObject = this.sShowName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    paramJceOutputStream.write(this.cSpecialFlag, 8);
    paramJceOutputStream.write(this.iTermType, 9);
    paramJceOutputStream.write(this.cNetwork, 10);
    paramJceOutputStream.write(this.uAbiFlag, 11);
    paramJceOutputStream.write(this.eNetworkType, 12);
    paramJceOutputStream.write(this.eIconType, 13);
    localObject = this.strTermDesc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 14);
    }
    paramJceOutputStream.write(this.uExtOnlineStatus, 15);
    paramJceOutputStream.write(this.iBatteryStatus, 16);
    localObject = this.vecMusicInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 17);
    }
    localObject = this.vecPoiInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 18);
    }
    localObject = this.vecExtOnlineBusinessInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 19);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     friendlist.SimpleOnlineFriendInfo
 * JD-Core Version:    0.7.0.1
 */