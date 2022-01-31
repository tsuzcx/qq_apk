package friendlist;

import QQService.VipBaseInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FriendInfo
  extends JceStruct
{
  static int cache_eIconType;
  static int cache_eNetworkType;
  static VipBaseInfo cache_oVipInfo;
  static byte[] cache_vecCardID;
  static byte[] cache_vecIMGroupID = (byte[])new byte[1];
  static byte[] cache_vecMSFGroupID;
  static byte[] cache_vecRing;
  public byte cApolloFlag;
  public byte cKingOfGloryFlag;
  public byte cNetwork;
  public byte cOlympicTorch;
  public byte cSex;
  public byte cSpecialFlag;
  public byte detalStatusFlag;
  public int eIconType = 0;
  public int eNetworkType = 0;
  public short faceId;
  public long friendUin;
  public byte groupId;
  public int iTermType;
  public byte isIphoneOnline;
  public byte isMqqOnLine;
  public byte isRemark;
  public byte memberLevel;
  public String nick = "";
  public VipBaseInfo oVipInfo;
  public String remark = "";
  public String sShowName = "";
  public byte sqqOnLineState;
  public byte sqqOnLineStateV2;
  public byte sqqtype;
  public byte status = 20;
  public String strEimId = "";
  public String strEimMobile = "";
  public String strMasterUin = "";
  public String strTermDesc = "";
  public long uAbiFlag;
  public long uApolloSignTime;
  public long uApolloTimestamp;
  public long uColorRing;
  public long uFaceStoreId;
  public long uFontEffect;
  public long uFounderFont;
  public long uGameAppid;
  public long uGameLastLoginTime;
  public long uLastMedalUpdateTime;
  public long uLaviUin;
  public long uTagUpdateTime;
  public long uVipFont;
  public long ulBitSet;
  public long ulFaceAddonId;
  public long ulKingOfGloryRank;
  public byte[] vecCardID;
  public byte[] vecIMGroupID;
  public byte[] vecMSFGroupID;
  public byte[] vecRing;
  
  static
  {
    ((byte[])cache_vecIMGroupID)[0] = 0;
    cache_vecMSFGroupID = (byte[])new byte[1];
    ((byte[])cache_vecMSFGroupID)[0] = 0;
    cache_oVipInfo = new VipBaseInfo();
    cache_vecRing = (byte[])new byte[1];
    ((byte[])cache_vecRing)[0] = 0;
    cache_eNetworkType = 0;
    cache_eIconType = 0;
    cache_vecCardID = (byte[])new byte[1];
    ((byte[])cache_vecCardID)[0] = 0;
  }
  
  public FriendInfo() {}
  
  public FriendInfo(long paramLong1, byte paramByte1, short paramShort, String paramString1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8, byte paramByte9, String paramString2, byte paramByte10, String paramString3, byte paramByte11, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, VipBaseInfo paramVipBaseInfo, byte paramByte12, byte[] paramArrayOfByte3, long paramLong2, long paramLong3, int paramInt2, long paramLong4, int paramInt3, String paramString4, long paramLong5, byte paramByte13, long paramLong6, byte paramByte14, long paramLong7, String paramString5, String paramString6, byte paramByte15, long paramLong8, long paramLong9, long paramLong10, long paramLong11, long paramLong12, byte[] paramArrayOfByte4, long paramLong13, byte paramByte16, long paramLong14, String paramString7, long paramLong15, long paramLong16, long paramLong17)
  {
    this.friendUin = paramLong1;
    this.groupId = paramByte1;
    this.faceId = paramShort;
    this.remark = paramString1;
    this.sqqtype = paramByte2;
    this.status = paramByte3;
    this.memberLevel = paramByte4;
    this.isMqqOnLine = paramByte5;
    this.sqqOnLineState = paramByte6;
    this.isIphoneOnline = paramByte7;
    this.detalStatusFlag = paramByte8;
    this.sqqOnLineStateV2 = paramByte9;
    this.sShowName = paramString2;
    this.isRemark = paramByte10;
    this.nick = paramString3;
    this.cSpecialFlag = paramByte11;
    this.vecIMGroupID = paramArrayOfByte1;
    this.vecMSFGroupID = paramArrayOfByte2;
    this.iTermType = paramInt1;
    this.oVipInfo = paramVipBaseInfo;
    this.cNetwork = paramByte12;
    this.vecRing = paramArrayOfByte3;
    this.uAbiFlag = paramLong2;
    this.ulFaceAddonId = paramLong3;
    this.eNetworkType = paramInt2;
    this.uVipFont = paramLong4;
    this.eIconType = paramInt3;
    this.strTermDesc = paramString4;
    this.uColorRing = paramLong5;
    this.cApolloFlag = paramByte13;
    this.uApolloTimestamp = paramLong6;
    this.cSex = paramByte14;
    this.uFounderFont = paramLong7;
    this.strEimId = paramString5;
    this.strEimMobile = paramString6;
    this.cOlympicTorch = paramByte15;
    this.uApolloSignTime = paramLong8;
    this.uLaviUin = paramLong9;
    this.uTagUpdateTime = paramLong10;
    this.uGameLastLoginTime = paramLong11;
    this.uGameAppid = paramLong12;
    this.vecCardID = paramArrayOfByte4;
    this.ulBitSet = paramLong13;
    this.cKingOfGloryFlag = paramByte16;
    this.ulKingOfGloryRank = paramLong14;
    this.strMasterUin = paramString7;
    this.uLastMedalUpdateTime = paramLong15;
    this.uFaceStoreId = paramLong16;
    this.uFontEffect = paramLong17;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.friendUin = paramJceInputStream.read(this.friendUin, 0, true);
    this.groupId = paramJceInputStream.read(this.groupId, 1, true);
    this.faceId = paramJceInputStream.read(this.faceId, 2, true);
    this.remark = paramJceInputStream.readString(3, true);
    this.sqqtype = paramJceInputStream.read(this.sqqtype, 4, true);
    this.status = paramJceInputStream.read(this.status, 5, true);
    this.memberLevel = paramJceInputStream.read(this.memberLevel, 6, false);
    this.isMqqOnLine = paramJceInputStream.read(this.isMqqOnLine, 7, false);
    this.sqqOnLineState = paramJceInputStream.read(this.sqqOnLineState, 8, false);
    this.isIphoneOnline = paramJceInputStream.read(this.isIphoneOnline, 9, false);
    this.detalStatusFlag = paramJceInputStream.read(this.detalStatusFlag, 10, false);
    this.sqqOnLineStateV2 = paramJceInputStream.read(this.sqqOnLineStateV2, 11, false);
    this.sShowName = paramJceInputStream.readString(12, false);
    this.isRemark = paramJceInputStream.read(this.isRemark, 13, false);
    this.nick = paramJceInputStream.readString(14, false);
    this.cSpecialFlag = paramJceInputStream.read(this.cSpecialFlag, 15, false);
    this.vecIMGroupID = ((byte[])paramJceInputStream.read(cache_vecIMGroupID, 16, false));
    this.vecMSFGroupID = ((byte[])paramJceInputStream.read(cache_vecMSFGroupID, 17, false));
    this.iTermType = paramJceInputStream.read(this.iTermType, 18, false);
    this.oVipInfo = ((VipBaseInfo)paramJceInputStream.read(cache_oVipInfo, 19, false));
    this.cNetwork = paramJceInputStream.read(this.cNetwork, 20, false);
    this.vecRing = ((byte[])paramJceInputStream.read(cache_vecRing, 21, false));
    this.uAbiFlag = paramJceInputStream.read(this.uAbiFlag, 22, false);
    this.ulFaceAddonId = paramJceInputStream.read(this.ulFaceAddonId, 23, false);
    this.eNetworkType = paramJceInputStream.read(this.eNetworkType, 24, false);
    this.uVipFont = paramJceInputStream.read(this.uVipFont, 25, false);
    this.eIconType = paramJceInputStream.read(this.eIconType, 26, false);
    this.strTermDesc = paramJceInputStream.readString(27, false);
    this.uColorRing = paramJceInputStream.read(this.uColorRing, 28, false);
    this.cApolloFlag = paramJceInputStream.read(this.cApolloFlag, 29, false);
    this.uApolloTimestamp = paramJceInputStream.read(this.uApolloTimestamp, 30, false);
    this.cSex = paramJceInputStream.read(this.cSex, 31, false);
    this.uFounderFont = paramJceInputStream.read(this.uFounderFont, 32, false);
    this.strEimId = paramJceInputStream.readString(33, false);
    this.strEimMobile = paramJceInputStream.readString(34, false);
    this.cOlympicTorch = paramJceInputStream.read(this.cOlympicTorch, 35, false);
    this.uApolloSignTime = paramJceInputStream.read(this.uApolloSignTime, 36, false);
    this.uLaviUin = paramJceInputStream.read(this.uLaviUin, 37, false);
    this.uTagUpdateTime = paramJceInputStream.read(this.uTagUpdateTime, 38, false);
    this.uGameLastLoginTime = paramJceInputStream.read(this.uGameLastLoginTime, 39, false);
    this.uGameAppid = paramJceInputStream.read(this.uGameAppid, 40, false);
    this.vecCardID = ((byte[])paramJceInputStream.read(cache_vecCardID, 41, false));
    this.ulBitSet = paramJceInputStream.read(this.ulBitSet, 42, false);
    this.cKingOfGloryFlag = paramJceInputStream.read(this.cKingOfGloryFlag, 43, false);
    this.ulKingOfGloryRank = paramJceInputStream.read(this.ulKingOfGloryRank, 44, false);
    this.strMasterUin = paramJceInputStream.readString(45, false);
    this.uLastMedalUpdateTime = paramJceInputStream.read(this.uLastMedalUpdateTime, 46, false);
    this.uFaceStoreId = paramJceInputStream.read(this.uFaceStoreId, 47, false);
    this.uFontEffect = paramJceInputStream.read(this.uFontEffect, 48, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.friendUin, 0);
    paramJceOutputStream.write(this.groupId, 1);
    paramJceOutputStream.write(this.faceId, 2);
    paramJceOutputStream.write(this.remark, 3);
    paramJceOutputStream.write(this.sqqtype, 4);
    paramJceOutputStream.write(this.status, 5);
    paramJceOutputStream.write(this.memberLevel, 6);
    paramJceOutputStream.write(this.isMqqOnLine, 7);
    paramJceOutputStream.write(this.sqqOnLineState, 8);
    paramJceOutputStream.write(this.isIphoneOnline, 9);
    paramJceOutputStream.write(this.detalStatusFlag, 10);
    paramJceOutputStream.write(this.sqqOnLineStateV2, 11);
    if (this.sShowName != null) {
      paramJceOutputStream.write(this.sShowName, 12);
    }
    paramJceOutputStream.write(this.isRemark, 13);
    if (this.nick != null) {
      paramJceOutputStream.write(this.nick, 14);
    }
    paramJceOutputStream.write(this.cSpecialFlag, 15);
    if (this.vecIMGroupID != null) {
      paramJceOutputStream.write(this.vecIMGroupID, 16);
    }
    if (this.vecMSFGroupID != null) {
      paramJceOutputStream.write(this.vecMSFGroupID, 17);
    }
    paramJceOutputStream.write(this.iTermType, 18);
    if (this.oVipInfo != null) {
      paramJceOutputStream.write(this.oVipInfo, 19);
    }
    paramJceOutputStream.write(this.cNetwork, 20);
    if (this.vecRing != null) {
      paramJceOutputStream.write(this.vecRing, 21);
    }
    paramJceOutputStream.write(this.uAbiFlag, 22);
    paramJceOutputStream.write(this.ulFaceAddonId, 23);
    paramJceOutputStream.write(this.eNetworkType, 24);
    paramJceOutputStream.write(this.uVipFont, 25);
    paramJceOutputStream.write(this.eIconType, 26);
    if (this.strTermDesc != null) {
      paramJceOutputStream.write(this.strTermDesc, 27);
    }
    paramJceOutputStream.write(this.uColorRing, 28);
    paramJceOutputStream.write(this.cApolloFlag, 29);
    paramJceOutputStream.write(this.uApolloTimestamp, 30);
    paramJceOutputStream.write(this.cSex, 31);
    paramJceOutputStream.write(this.uFounderFont, 32);
    if (this.strEimId != null) {
      paramJceOutputStream.write(this.strEimId, 33);
    }
    if (this.strEimMobile != null) {
      paramJceOutputStream.write(this.strEimMobile, 34);
    }
    paramJceOutputStream.write(this.cOlympicTorch, 35);
    paramJceOutputStream.write(this.uApolloSignTime, 36);
    paramJceOutputStream.write(this.uLaviUin, 37);
    paramJceOutputStream.write(this.uTagUpdateTime, 38);
    paramJceOutputStream.write(this.uGameLastLoginTime, 39);
    paramJceOutputStream.write(this.uGameAppid, 40);
    if (this.vecCardID != null) {
      paramJceOutputStream.write(this.vecCardID, 41);
    }
    paramJceOutputStream.write(this.ulBitSet, 42);
    paramJceOutputStream.write(this.cKingOfGloryFlag, 43);
    paramJceOutputStream.write(this.ulKingOfGloryRank, 44);
    if (this.strMasterUin != null) {
      paramJceOutputStream.write(this.strMasterUin, 45);
    }
    paramJceOutputStream.write(this.uLastMedalUpdateTime, 46);
    paramJceOutputStream.write(this.uFaceStoreId, 47);
    paramJceOutputStream.write(this.uFontEffect, 48);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     friendlist.FriendInfo
 * JD-Core Version:    0.7.0.1
 */