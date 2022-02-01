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
  static byte[] cache_vecExtOnlineBusinessInfo;
  static byte[] cache_vecExtSnsFrdData;
  static byte[] cache_vecIMGroupID = (byte[])new byte[1];
  static byte[] cache_vecIntimateInfo;
  static byte[] cache_vecMSFGroupID;
  static byte[] cache_vecMusicInfo;
  static byte[] cache_vecMutualMarkData;
  static byte[] cache_vecPoiInfo;
  static byte[] cache_vecRing;
  public byte cApolloFlag = 0;
  public byte cCentiShow3DFlag = 0;
  public byte cKingOfGloryFlag = 0;
  public byte cNetwork = 0;
  public byte cNewLoverDiamondFlag = 0;
  public byte cOlympicTorch = 0;
  public byte cSex = 0;
  public byte cShowNameplate = 0;
  public byte cSpecialFlag = 0;
  public byte detalStatusFlag = 0;
  public int eIconType = 0;
  public int eNetworkType = 0;
  public short faceId = 0;
  public long friendUin = 0L;
  public byte groupId = 0;
  public int iBatteryStatus = 0;
  public int iTermType = 0;
  public byte isIphoneOnline = 0;
  public byte isMqqOnLine = 0;
  public byte isRemark = 0;
  public byte memberLevel = 0;
  public String nick = "";
  public VipBaseInfo oVipInfo = null;
  public String remark = "";
  public String sDOVId = "";
  public String sShowName = "";
  public byte sqqOnLineState = 0;
  public byte sqqOnLineStateV2 = 0;
  public byte sqqtype = 0;
  public byte status = 20;
  public String strEimId = "";
  public String strEimMobile = "";
  public String strMasterUin = "";
  public String strTermDesc = "";
  public long uAbiFlag = 0L;
  public long uApolloSignTime = 0L;
  public long uApolloTimestamp = 0L;
  public long uBothFlag = 0L;
  public long uColorRing = 0L;
  public long uExtOnlineStatus = 0L;
  public long uFaceStoreId = 0L;
  public long uFontEffect = 0L;
  public long uFounderFont = 0L;
  public long uGameAppid = 0L;
  public long uGameLastLoginTime = 0L;
  public long uLastMedalUpdateTime = 0L;
  public long uLaviUin = 0L;
  public long uTagUpdateTime = 0L;
  public long uVipFont = 0L;
  public long ulBitSet = 0L;
  public long ulFaceAddonId = 0L;
  public long ulKingOfGloryRank = 0L;
  public byte[] vecCardID = null;
  public byte[] vecExtOnlineBusinessInfo = null;
  public byte[] vecExtSnsFrdData = null;
  public byte[] vecIMGroupID = null;
  public byte[] vecIntimateInfo = null;
  public byte[] vecMSFGroupID = null;
  public byte[] vecMusicInfo = null;
  public byte[] vecMutualMarkData = null;
  public byte[] vecPoiInfo = null;
  public byte[] vecRing = null;
  
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
    cache_vecIntimateInfo = (byte[])new byte[1];
    ((byte[])cache_vecIntimateInfo)[0] = 0;
    cache_vecExtSnsFrdData = (byte[])new byte[1];
    ((byte[])cache_vecExtSnsFrdData)[0] = 0;
    cache_vecMutualMarkData = (byte[])new byte[1];
    ((byte[])cache_vecMutualMarkData)[0] = 0;
    cache_vecMusicInfo = (byte[])new byte[1];
    ((byte[])cache_vecMusicInfo)[0] = 0;
    cache_vecPoiInfo = (byte[])new byte[1];
    ((byte[])cache_vecPoiInfo)[0] = 0;
    cache_vecExtOnlineBusinessInfo = (byte[])new byte[1];
    ((byte[])cache_vecExtOnlineBusinessInfo)[0] = 0;
  }
  
  public FriendInfo() {}
  
  public FriendInfo(long paramLong1, byte paramByte1, short paramShort, String paramString1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8, byte paramByte9, String paramString2, byte paramByte10, String paramString3, byte paramByte11, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, VipBaseInfo paramVipBaseInfo, byte paramByte12, byte[] paramArrayOfByte3, long paramLong2, long paramLong3, int paramInt2, long paramLong4, int paramInt3, String paramString4, long paramLong5, byte paramByte13, long paramLong6, byte paramByte14, long paramLong7, String paramString5, String paramString6, byte paramByte15, long paramLong8, long paramLong9, long paramLong10, long paramLong11, long paramLong12, byte[] paramArrayOfByte4, long paramLong13, byte paramByte16, long paramLong14, String paramString7, long paramLong15, long paramLong16, long paramLong17, String paramString8, long paramLong18, byte paramByte17, byte[] paramArrayOfByte5, byte paramByte18, byte paramByte19, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, long paramLong19, int paramInt4, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10)
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
    this.sDOVId = paramString8;
    this.uBothFlag = paramLong18;
    this.cCentiShow3DFlag = paramByte17;
    this.vecIntimateInfo = paramArrayOfByte5;
    this.cShowNameplate = paramByte18;
    this.cNewLoverDiamondFlag = paramByte19;
    this.vecExtSnsFrdData = paramArrayOfByte6;
    this.vecMutualMarkData = paramArrayOfByte7;
    this.uExtOnlineStatus = paramLong19;
    this.iBatteryStatus = paramInt4;
    this.vecMusicInfo = paramArrayOfByte8;
    this.vecPoiInfo = paramArrayOfByte9;
    this.vecExtOnlineBusinessInfo = paramArrayOfByte10;
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
    this.sDOVId = paramJceInputStream.readString(49, false);
    this.uBothFlag = paramJceInputStream.read(this.uBothFlag, 50, false);
    this.cCentiShow3DFlag = paramJceInputStream.read(this.cCentiShow3DFlag, 51, false);
    this.vecIntimateInfo = ((byte[])paramJceInputStream.read(cache_vecIntimateInfo, 52, false));
    this.cShowNameplate = paramJceInputStream.read(this.cShowNameplate, 53, false);
    this.cNewLoverDiamondFlag = paramJceInputStream.read(this.cNewLoverDiamondFlag, 54, false);
    this.vecExtSnsFrdData = ((byte[])paramJceInputStream.read(cache_vecExtSnsFrdData, 55, false));
    this.vecMutualMarkData = ((byte[])paramJceInputStream.read(cache_vecMutualMarkData, 56, false));
    this.uExtOnlineStatus = paramJceInputStream.read(this.uExtOnlineStatus, 57, false);
    this.iBatteryStatus = paramJceInputStream.read(this.iBatteryStatus, 58, false);
    this.vecMusicInfo = ((byte[])paramJceInputStream.read(cache_vecMusicInfo, 59, false));
    this.vecPoiInfo = ((byte[])paramJceInputStream.read(cache_vecPoiInfo, 60, false));
    this.vecExtOnlineBusinessInfo = ((byte[])paramJceInputStream.read(cache_vecExtOnlineBusinessInfo, 61, false));
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
    Object localObject = this.sShowName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    paramJceOutputStream.write(this.isRemark, 13);
    localObject = this.nick;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 14);
    }
    paramJceOutputStream.write(this.cSpecialFlag, 15);
    localObject = this.vecIMGroupID;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 16);
    }
    localObject = this.vecMSFGroupID;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 17);
    }
    paramJceOutputStream.write(this.iTermType, 18);
    localObject = this.oVipInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 19);
    }
    paramJceOutputStream.write(this.cNetwork, 20);
    localObject = this.vecRing;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 21);
    }
    paramJceOutputStream.write(this.uAbiFlag, 22);
    paramJceOutputStream.write(this.ulFaceAddonId, 23);
    paramJceOutputStream.write(this.eNetworkType, 24);
    paramJceOutputStream.write(this.uVipFont, 25);
    paramJceOutputStream.write(this.eIconType, 26);
    localObject = this.strTermDesc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 27);
    }
    paramJceOutputStream.write(this.uColorRing, 28);
    paramJceOutputStream.write(this.cApolloFlag, 29);
    paramJceOutputStream.write(this.uApolloTimestamp, 30);
    paramJceOutputStream.write(this.cSex, 31);
    paramJceOutputStream.write(this.uFounderFont, 32);
    localObject = this.strEimId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 33);
    }
    localObject = this.strEimMobile;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 34);
    }
    paramJceOutputStream.write(this.cOlympicTorch, 35);
    paramJceOutputStream.write(this.uApolloSignTime, 36);
    paramJceOutputStream.write(this.uLaviUin, 37);
    paramJceOutputStream.write(this.uTagUpdateTime, 38);
    paramJceOutputStream.write(this.uGameLastLoginTime, 39);
    paramJceOutputStream.write(this.uGameAppid, 40);
    localObject = this.vecCardID;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 41);
    }
    paramJceOutputStream.write(this.ulBitSet, 42);
    paramJceOutputStream.write(this.cKingOfGloryFlag, 43);
    paramJceOutputStream.write(this.ulKingOfGloryRank, 44);
    localObject = this.strMasterUin;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 45);
    }
    paramJceOutputStream.write(this.uLastMedalUpdateTime, 46);
    paramJceOutputStream.write(this.uFaceStoreId, 47);
    paramJceOutputStream.write(this.uFontEffect, 48);
    localObject = this.sDOVId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 49);
    }
    paramJceOutputStream.write(this.uBothFlag, 50);
    paramJceOutputStream.write(this.cCentiShow3DFlag, 51);
    localObject = this.vecIntimateInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 52);
    }
    paramJceOutputStream.write(this.cShowNameplate, 53);
    paramJceOutputStream.write(this.cNewLoverDiamondFlag, 54);
    localObject = this.vecExtSnsFrdData;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 55);
    }
    localObject = this.vecMutualMarkData;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 56);
    }
    paramJceOutputStream.write(this.uExtOnlineStatus, 57);
    paramJceOutputStream.write(this.iBatteryStatus, 58);
    localObject = this.vecMusicInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 59);
    }
    localObject = this.vecPoiInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 60);
    }
    localObject = this.vecExtOnlineBusinessInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 61);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     friendlist.FriendInfo
 * JD-Core Version:    0.7.0.1
 */