package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stTroopNum
  extends JceStruct
{
  static byte[] cache_vecGroupRemark = (byte[])new byte[1];
  public long GroupCode = 0L;
  public long GroupUin = 0L;
  public byte cFlag = 0;
  public byte cIsConfGroup = 0;
  public byte cIsModifyConfGroupFace = 0;
  public byte cIsModifyConfGroupName = 0;
  public long dwAdditionalFlag = 0L;
  public long dwAppPrivilegeFlag = 0L;
  public long dwAppealDeadline = 0L;
  public long dwCertificationType = 0L;
  public long dwCmdUinGroupMask = 0L;
  public long dwCmdUinUinFlag = 0L;
  public long dwCmduinJoinTime = 0L;
  public long dwGroupClassExt = 0L;
  public long dwGroupFlag = 0L;
  public long dwGroupFlagExt = 0L;
  public long dwGroupFlagExt3 = 0L;
  public long dwGroupFlagExt4 = 0L;
  public long dwGroupInfoSeq = 0L;
  public long dwGroupOwnerUin = 0L;
  public long dwGroupRankSeq = 0L;
  public long dwGroupSecType = 0L;
  public long dwGroupSecTypeInfo = 0L;
  public long dwGroupTypeFlag = 0L;
  public long dwMaxGroupMemberNum = 0L;
  public long dwMemberCardSeq = 0L;
  public long dwMemberNum = 0L;
  public long dwMemberNumSeq = 0L;
  public long dwMyShutupTimestamp = 0L;
  public long dwShutupTimestamp = 0L;
  public long dwSubscriptionUin = 0L;
  public String strGroupMemo = "";
  public String strGroupName = "";
  public long udwCmdUinFlagEx2 = 0L;
  public long udwCmdUinRingtoneID = 0L;
  public long udwHLGuildAppid = 0L;
  public long udwHLGuildSubType = 0L;
  public long ulCompanyId = 0L;
  public byte[] vecGroupRemark = null;
  
  static
  {
    ((byte[])cache_vecGroupRemark)[0] = 0;
  }
  
  public stTroopNum() {}
  
  public stTroopNum(long paramLong1, long paramLong2, byte paramByte1, long paramLong3, String paramString1, String paramString2, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, long paramLong12, long paramLong13, long paramLong14, long paramLong15, long paramLong16, long paramLong17, long paramLong18, long paramLong19, long paramLong20, long paramLong21, byte paramByte2, byte paramByte3, byte paramByte4, long paramLong22, long paramLong23, long paramLong24, long paramLong25, long paramLong26, long paramLong27, long paramLong28, long paramLong29, long paramLong30, long paramLong31, long paramLong32, byte[] paramArrayOfByte)
  {
    this.GroupUin = paramLong1;
    this.GroupCode = paramLong2;
    this.cFlag = paramByte1;
    this.dwGroupInfoSeq = paramLong3;
    this.strGroupName = paramString1;
    this.strGroupMemo = paramString2;
    this.dwGroupFlagExt = paramLong4;
    this.dwGroupRankSeq = paramLong5;
    this.dwCertificationType = paramLong6;
    this.dwShutupTimestamp = paramLong7;
    this.dwMyShutupTimestamp = paramLong8;
    this.dwCmdUinUinFlag = paramLong9;
    this.dwAdditionalFlag = paramLong10;
    this.dwGroupTypeFlag = paramLong11;
    this.dwGroupSecType = paramLong12;
    this.dwGroupSecTypeInfo = paramLong13;
    this.dwGroupClassExt = paramLong14;
    this.dwAppPrivilegeFlag = paramLong15;
    this.dwSubscriptionUin = paramLong16;
    this.dwMemberNum = paramLong17;
    this.dwMemberNumSeq = paramLong18;
    this.dwMemberCardSeq = paramLong19;
    this.dwGroupFlagExt3 = paramLong20;
    this.dwGroupOwnerUin = paramLong21;
    this.cIsConfGroup = paramByte2;
    this.cIsModifyConfGroupFace = paramByte3;
    this.cIsModifyConfGroupName = paramByte4;
    this.dwCmduinJoinTime = paramLong22;
    this.ulCompanyId = paramLong23;
    this.dwMaxGroupMemberNum = paramLong24;
    this.dwCmdUinGroupMask = paramLong25;
    this.udwHLGuildAppid = paramLong26;
    this.udwHLGuildSubType = paramLong27;
    this.udwCmdUinRingtoneID = paramLong28;
    this.udwCmdUinFlagEx2 = paramLong29;
    this.dwGroupFlagExt4 = paramLong30;
    this.dwAppealDeadline = paramLong31;
    this.dwGroupFlag = paramLong32;
    this.vecGroupRemark = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.GroupUin = paramJceInputStream.read(this.GroupUin, 0, true);
    this.GroupCode = paramJceInputStream.read(this.GroupCode, 1, true);
    this.cFlag = paramJceInputStream.read(this.cFlag, 2, false);
    this.dwGroupInfoSeq = paramJceInputStream.read(this.dwGroupInfoSeq, 3, false);
    this.strGroupName = paramJceInputStream.readString(4, false);
    this.strGroupMemo = paramJceInputStream.readString(5, false);
    this.dwGroupFlagExt = paramJceInputStream.read(this.dwGroupFlagExt, 6, false);
    this.dwGroupRankSeq = paramJceInputStream.read(this.dwGroupRankSeq, 7, false);
    this.dwCertificationType = paramJceInputStream.read(this.dwCertificationType, 8, false);
    this.dwShutupTimestamp = paramJceInputStream.read(this.dwShutupTimestamp, 9, false);
    this.dwMyShutupTimestamp = paramJceInputStream.read(this.dwMyShutupTimestamp, 10, false);
    this.dwCmdUinUinFlag = paramJceInputStream.read(this.dwCmdUinUinFlag, 11, false);
    this.dwAdditionalFlag = paramJceInputStream.read(this.dwAdditionalFlag, 12, false);
    this.dwGroupTypeFlag = paramJceInputStream.read(this.dwGroupTypeFlag, 13, false);
    this.dwGroupSecType = paramJceInputStream.read(this.dwGroupSecType, 14, false);
    this.dwGroupSecTypeInfo = paramJceInputStream.read(this.dwGroupSecTypeInfo, 15, false);
    this.dwGroupClassExt = paramJceInputStream.read(this.dwGroupClassExt, 16, false);
    this.dwAppPrivilegeFlag = paramJceInputStream.read(this.dwAppPrivilegeFlag, 17, false);
    this.dwSubscriptionUin = paramJceInputStream.read(this.dwSubscriptionUin, 18, false);
    this.dwMemberNum = paramJceInputStream.read(this.dwMemberNum, 19, false);
    this.dwMemberNumSeq = paramJceInputStream.read(this.dwMemberNumSeq, 20, false);
    this.dwMemberCardSeq = paramJceInputStream.read(this.dwMemberCardSeq, 21, false);
    this.dwGroupFlagExt3 = paramJceInputStream.read(this.dwGroupFlagExt3, 22, false);
    this.dwGroupOwnerUin = paramJceInputStream.read(this.dwGroupOwnerUin, 23, false);
    this.cIsConfGroup = paramJceInputStream.read(this.cIsConfGroup, 24, false);
    this.cIsModifyConfGroupFace = paramJceInputStream.read(this.cIsModifyConfGroupFace, 25, false);
    this.cIsModifyConfGroupName = paramJceInputStream.read(this.cIsModifyConfGroupName, 26, false);
    this.dwCmduinJoinTime = paramJceInputStream.read(this.dwCmduinJoinTime, 27, false);
    this.ulCompanyId = paramJceInputStream.read(this.ulCompanyId, 28, false);
    this.dwMaxGroupMemberNum = paramJceInputStream.read(this.dwMaxGroupMemberNum, 29, false);
    this.dwCmdUinGroupMask = paramJceInputStream.read(this.dwCmdUinGroupMask, 30, false);
    this.udwHLGuildAppid = paramJceInputStream.read(this.udwHLGuildAppid, 31, false);
    this.udwHLGuildSubType = paramJceInputStream.read(this.udwHLGuildSubType, 32, false);
    this.udwCmdUinRingtoneID = paramJceInputStream.read(this.udwCmdUinRingtoneID, 33, false);
    this.udwCmdUinFlagEx2 = paramJceInputStream.read(this.udwCmdUinFlagEx2, 34, false);
    this.dwGroupFlagExt4 = paramJceInputStream.read(this.dwGroupFlagExt4, 35, false);
    this.dwAppealDeadline = paramJceInputStream.read(this.dwAppealDeadline, 36, false);
    this.dwGroupFlag = paramJceInputStream.read(this.dwGroupFlag, 37, false);
    this.vecGroupRemark = ((byte[])paramJceInputStream.read(cache_vecGroupRemark, 38, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.GroupUin, 0);
    paramJceOutputStream.write(this.GroupCode, 1);
    paramJceOutputStream.write(this.cFlag, 2);
    paramJceOutputStream.write(this.dwGroupInfoSeq, 3);
    Object localObject = this.strGroupName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.strGroupMemo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    paramJceOutputStream.write(this.dwGroupFlagExt, 6);
    paramJceOutputStream.write(this.dwGroupRankSeq, 7);
    paramJceOutputStream.write(this.dwCertificationType, 8);
    paramJceOutputStream.write(this.dwShutupTimestamp, 9);
    paramJceOutputStream.write(this.dwMyShutupTimestamp, 10);
    paramJceOutputStream.write(this.dwCmdUinUinFlag, 11);
    paramJceOutputStream.write(this.dwAdditionalFlag, 12);
    paramJceOutputStream.write(this.dwGroupTypeFlag, 13);
    paramJceOutputStream.write(this.dwGroupSecType, 14);
    paramJceOutputStream.write(this.dwGroupSecTypeInfo, 15);
    paramJceOutputStream.write(this.dwGroupClassExt, 16);
    paramJceOutputStream.write(this.dwAppPrivilegeFlag, 17);
    paramJceOutputStream.write(this.dwSubscriptionUin, 18);
    paramJceOutputStream.write(this.dwMemberNum, 19);
    paramJceOutputStream.write(this.dwMemberNumSeq, 20);
    paramJceOutputStream.write(this.dwMemberCardSeq, 21);
    paramJceOutputStream.write(this.dwGroupFlagExt3, 22);
    paramJceOutputStream.write(this.dwGroupOwnerUin, 23);
    paramJceOutputStream.write(this.cIsConfGroup, 24);
    paramJceOutputStream.write(this.cIsModifyConfGroupFace, 25);
    paramJceOutputStream.write(this.cIsModifyConfGroupName, 26);
    paramJceOutputStream.write(this.dwCmduinJoinTime, 27);
    paramJceOutputStream.write(this.ulCompanyId, 28);
    paramJceOutputStream.write(this.dwMaxGroupMemberNum, 29);
    paramJceOutputStream.write(this.dwCmdUinGroupMask, 30);
    paramJceOutputStream.write(this.udwHLGuildAppid, 31);
    paramJceOutputStream.write(this.udwHLGuildSubType, 32);
    paramJceOutputStream.write(this.udwCmdUinRingtoneID, 33);
    paramJceOutputStream.write(this.udwCmdUinFlagEx2, 34);
    paramJceOutputStream.write(this.dwGroupFlagExt4, 35);
    paramJceOutputStream.write(this.dwAppealDeadline, 36);
    paramJceOutputStream.write(this.dwGroupFlag, 37);
    localObject = this.vecGroupRemark;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 38);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     friendlist.stTroopNum
 * JD-Core Version:    0.7.0.1
 */