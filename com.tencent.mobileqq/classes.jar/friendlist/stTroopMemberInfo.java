package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stTroopMemberInfo
  extends JceStruct
{
  static QzoneUserInfo cache_qzusrinfo = new QzoneUserInfo();
  static byte[] cache_vecGroupHonor = (byte[])new byte[1];
  static byte[] cache_vecName;
  public byte Age = 0;
  public short FaceId = 0;
  public byte Gender = 0;
  public long MemberUin = 0L;
  public String Nick = "";
  public byte Status = 20;
  public String bytes_job = "";
  public byte cApolloFlag = 0;
  public byte cConcerned = 0;
  public byte cGender = 0;
  public byte cRichCardNameVer = 0;
  public byte cRichFlag = 0;
  public byte cShielded = 0;
  public long dwApolloTimestamp = 0L;
  public long dwBigClubFlag = 0L;
  public long dwBigClubLevel = 0L;
  public long dwCreditLevel = 0L;
  public long dwFlag = 0L;
  public long dwFlagExt = 0L;
  public long dwGlobalGroupLevel = 0L;
  public long dwGlobalGroupPoint = 0L;
  public long dwJoinTime = 0L;
  public long dwLastSpeakTime = 0L;
  public long dwMemberLevel = 0L;
  public long dwNameplate = 0L;
  public long dwPoint = 0L;
  public long dwShutupTimestap = 0L;
  public long dwSpecialTitleExpireTime = 0L;
  public long dwTitleId = 0L;
  public long dwVipLevel = 0L;
  public long dwVipType = 0L;
  public QzoneUserInfo qzusrinfo = null;
  public String sEmail = "";
  public String sMemo = "";
  public String sName = "";
  public String sPhone = "";
  public String sShowName = "";
  public String sSpecialTitle = "";
  public String strAutoRemark = "";
  public byte[] vecGroupHonor = null;
  public byte[] vecName = null;
  
  static
  {
    ((byte[])cache_vecGroupHonor)[0] = 0;
    cache_vecName = (byte[])new byte[1];
    ((byte[])cache_vecName)[0] = 0;
  }
  
  public stTroopMemberInfo() {}
  
  public stTroopMemberInfo(long paramLong1, short paramShort, byte paramByte1, byte paramByte2, String paramString1, byte paramByte3, String paramString2, String paramString3, byte paramByte4, String paramString4, String paramString5, String paramString6, String paramString7, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, byte paramByte5, byte paramByte6, String paramString8, long paramLong9, String paramString9, byte paramByte7, long paramLong10, long paramLong11, long paramLong12, long paramLong13, long paramLong14, QzoneUserInfo paramQzoneUserInfo, byte paramByte8, long paramLong15, long paramLong16, long paramLong17, long paramLong18, long paramLong19, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte paramByte9)
  {
    this.MemberUin = paramLong1;
    this.FaceId = paramShort;
    this.Age = paramByte1;
    this.Gender = paramByte2;
    this.Nick = paramString1;
    this.Status = paramByte3;
    this.sShowName = paramString2;
    this.sName = paramString3;
    this.cGender = paramByte4;
    this.sPhone = paramString4;
    this.sEmail = paramString5;
    this.sMemo = paramString6;
    this.strAutoRemark = paramString7;
    this.dwMemberLevel = paramLong2;
    this.dwJoinTime = paramLong3;
    this.dwLastSpeakTime = paramLong4;
    this.dwCreditLevel = paramLong5;
    this.dwFlag = paramLong6;
    this.dwFlagExt = paramLong7;
    this.dwPoint = paramLong8;
    this.cConcerned = paramByte5;
    this.cShielded = paramByte6;
    this.sSpecialTitle = paramString8;
    this.dwSpecialTitleExpireTime = paramLong9;
    this.bytes_job = paramString9;
    this.cApolloFlag = paramByte7;
    this.dwApolloTimestamp = paramLong10;
    this.dwGlobalGroupLevel = paramLong11;
    this.dwTitleId = paramLong12;
    this.dwShutupTimestap = paramLong13;
    this.dwGlobalGroupPoint = paramLong14;
    this.qzusrinfo = paramQzoneUserInfo;
    this.cRichCardNameVer = paramByte8;
    this.dwVipType = paramLong15;
    this.dwVipLevel = paramLong16;
    this.dwBigClubLevel = paramLong17;
    this.dwBigClubFlag = paramLong18;
    this.dwNameplate = paramLong19;
    this.vecGroupHonor = paramArrayOfByte1;
    this.vecName = paramArrayOfByte2;
    this.cRichFlag = paramByte9;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.MemberUin = paramJceInputStream.read(this.MemberUin, 0, true);
    this.FaceId = paramJceInputStream.read(this.FaceId, 1, true);
    this.Age = paramJceInputStream.read(this.Age, 2, true);
    this.Gender = paramJceInputStream.read(this.Gender, 3, true);
    this.Nick = paramJceInputStream.readString(4, true);
    this.Status = paramJceInputStream.read(this.Status, 5, true);
    this.sShowName = paramJceInputStream.readString(6, false);
    this.sName = paramJceInputStream.readString(8, false);
    this.cGender = paramJceInputStream.read(this.cGender, 9, false);
    this.sPhone = paramJceInputStream.readString(10, false);
    this.sEmail = paramJceInputStream.readString(11, false);
    this.sMemo = paramJceInputStream.readString(12, false);
    this.strAutoRemark = paramJceInputStream.readString(13, false);
    this.dwMemberLevel = paramJceInputStream.read(this.dwMemberLevel, 14, false);
    this.dwJoinTime = paramJceInputStream.read(this.dwJoinTime, 15, false);
    this.dwLastSpeakTime = paramJceInputStream.read(this.dwLastSpeakTime, 16, false);
    this.dwCreditLevel = paramJceInputStream.read(this.dwCreditLevel, 17, false);
    this.dwFlag = paramJceInputStream.read(this.dwFlag, 18, false);
    this.dwFlagExt = paramJceInputStream.read(this.dwFlagExt, 19, false);
    this.dwPoint = paramJceInputStream.read(this.dwPoint, 20, false);
    this.cConcerned = paramJceInputStream.read(this.cConcerned, 21, false);
    this.cShielded = paramJceInputStream.read(this.cShielded, 22, false);
    this.sSpecialTitle = paramJceInputStream.readString(23, false);
    this.dwSpecialTitleExpireTime = paramJceInputStream.read(this.dwSpecialTitleExpireTime, 24, false);
    this.bytes_job = paramJceInputStream.readString(25, false);
    this.cApolloFlag = paramJceInputStream.read(this.cApolloFlag, 26, false);
    this.dwApolloTimestamp = paramJceInputStream.read(this.dwApolloTimestamp, 27, false);
    this.dwGlobalGroupLevel = paramJceInputStream.read(this.dwGlobalGroupLevel, 28, false);
    this.dwTitleId = paramJceInputStream.read(this.dwTitleId, 29, false);
    this.dwShutupTimestap = paramJceInputStream.read(this.dwShutupTimestap, 30, false);
    this.dwGlobalGroupPoint = paramJceInputStream.read(this.dwGlobalGroupPoint, 31, false);
    this.qzusrinfo = ((QzoneUserInfo)paramJceInputStream.read(cache_qzusrinfo, 32, false));
    this.cRichCardNameVer = paramJceInputStream.read(this.cRichCardNameVer, 33, false);
    this.dwVipType = paramJceInputStream.read(this.dwVipType, 34, false);
    this.dwVipLevel = paramJceInputStream.read(this.dwVipLevel, 35, false);
    this.dwBigClubLevel = paramJceInputStream.read(this.dwBigClubLevel, 36, false);
    this.dwBigClubFlag = paramJceInputStream.read(this.dwBigClubFlag, 37, false);
    this.dwNameplate = paramJceInputStream.read(this.dwNameplate, 38, false);
    this.vecGroupHonor = ((byte[])paramJceInputStream.read(cache_vecGroupHonor, 39, false));
    this.vecName = ((byte[])paramJceInputStream.read(cache_vecName, 40, false));
    this.cRichFlag = paramJceInputStream.read(this.cRichFlag, 41, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.MemberUin, 0);
    paramJceOutputStream.write(this.FaceId, 1);
    paramJceOutputStream.write(this.Age, 2);
    paramJceOutputStream.write(this.Gender, 3);
    paramJceOutputStream.write(this.Nick, 4);
    paramJceOutputStream.write(this.Status, 5);
    Object localObject = this.sShowName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.sName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    paramJceOutputStream.write(this.cGender, 9);
    localObject = this.sPhone;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    localObject = this.sEmail;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    localObject = this.sMemo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    localObject = this.strAutoRemark;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 13);
    }
    paramJceOutputStream.write(this.dwMemberLevel, 14);
    paramJceOutputStream.write(this.dwJoinTime, 15);
    paramJceOutputStream.write(this.dwLastSpeakTime, 16);
    paramJceOutputStream.write(this.dwCreditLevel, 17);
    paramJceOutputStream.write(this.dwFlag, 18);
    paramJceOutputStream.write(this.dwFlagExt, 19);
    paramJceOutputStream.write(this.dwPoint, 20);
    paramJceOutputStream.write(this.cConcerned, 21);
    paramJceOutputStream.write(this.cShielded, 22);
    localObject = this.sSpecialTitle;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 23);
    }
    paramJceOutputStream.write(this.dwSpecialTitleExpireTime, 24);
    localObject = this.bytes_job;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 25);
    }
    paramJceOutputStream.write(this.cApolloFlag, 26);
    paramJceOutputStream.write(this.dwApolloTimestamp, 27);
    paramJceOutputStream.write(this.dwGlobalGroupLevel, 28);
    paramJceOutputStream.write(this.dwTitleId, 29);
    paramJceOutputStream.write(this.dwShutupTimestap, 30);
    paramJceOutputStream.write(this.dwGlobalGroupPoint, 31);
    localObject = this.qzusrinfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 32);
    }
    paramJceOutputStream.write(this.cRichCardNameVer, 33);
    paramJceOutputStream.write(this.dwVipType, 34);
    paramJceOutputStream.write(this.dwVipLevel, 35);
    paramJceOutputStream.write(this.dwBigClubLevel, 36);
    paramJceOutputStream.write(this.dwBigClubFlag, 37);
    paramJceOutputStream.write(this.dwNameplate, 38);
    localObject = this.vecGroupHonor;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 39);
    }
    localObject = this.vecName;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 40);
    }
    paramJceOutputStream.write(this.cRichFlag, 41);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     friendlist.stTroopMemberInfo
 * JD-Core Version:    0.7.0.1
 */