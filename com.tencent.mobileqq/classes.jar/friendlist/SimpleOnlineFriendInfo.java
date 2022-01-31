package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SimpleOnlineFriendInfo
  extends JceStruct
{
  static int cache_eIconType;
  static int cache_eNetworkType;
  public byte cNetwork;
  public byte cSpecialFlag;
  public byte detalStatusFlag;
  public int eIconType = 0;
  public int eNetworkType = 0;
  public long friendUin;
  public int iTermType;
  public byte isIphoneOnline;
  public byte isMqqOnLine;
  public String sShowName = "";
  public byte sqqOnLineState;
  public byte sqqOnLineStateV2;
  public byte status = 20;
  public String strTermDesc = "";
  public long uAbiFlag;
  
  public SimpleOnlineFriendInfo() {}
  
  public SimpleOnlineFriendInfo(long paramLong1, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, String paramString1, byte paramByte7, int paramInt1, byte paramByte8, long paramLong2, int paramInt2, int paramInt3, String paramString2)
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
    if (this.sShowName != null) {
      paramJceOutputStream.write(this.sShowName, 7);
    }
    paramJceOutputStream.write(this.cSpecialFlag, 8);
    paramJceOutputStream.write(this.iTermType, 9);
    paramJceOutputStream.write(this.cNetwork, 10);
    paramJceOutputStream.write(this.uAbiFlag, 11);
    paramJceOutputStream.write(this.eNetworkType, 12);
    paramJceOutputStream.write(this.eIconType, 13);
    if (this.strTermDesc != null) {
      paramJceOutputStream.write(this.strTermDesc, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     friendlist.SimpleOnlineFriendInfo
 * JD-Core Version:    0.7.0.1
 */