package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stTroopMemberInfo
  extends JceStruct
  implements Cloneable
{
  static QzoneUserInfo cache_qzusrinfo = new QzoneUserInfo();
  public byte Age;
  public short FaceId;
  public byte Gender;
  public long MemberUin;
  public String Nick = "";
  public byte Status = 20;
  public String bytes_job = "";
  public byte cApolloFlag;
  public byte cConcerned;
  public byte cGender;
  public byte cShielded;
  public long dwApolloTimestamp;
  public long dwCreditLevel;
  public long dwFlag;
  public long dwFlagExt;
  public long dwGlobalGroupLevel;
  public long dwGlobalGroupPoint;
  public long dwJoinTime;
  public long dwLastSpeakTime;
  public long dwMemberLevel;
  public long dwPoint;
  public long dwShutupTimestap;
  public long dwSpecialTitleExpireTime;
  public long dwTitleId;
  public QzoneUserInfo qzusrinfo;
  public String sEmail = "";
  public String sMemo = "";
  public String sName = "";
  public String sPhone = "";
  public String sShowName = "";
  public String sSpecialTitle = "";
  public String strAutoRemark = "";
  
  public stTroopMemberInfo() {}
  
  public stTroopMemberInfo(long paramLong1, short paramShort, byte paramByte1, byte paramByte2, String paramString1, byte paramByte3, String paramString2, String paramString3, byte paramByte4, String paramString4, String paramString5, String paramString6, String paramString7, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, byte paramByte5, byte paramByte6, String paramString8, long paramLong9, String paramString9, byte paramByte7, long paramLong10, long paramLong11, long paramLong12, long paramLong13, long paramLong14, QzoneUserInfo paramQzoneUserInfo)
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
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.MemberUin, 0);
    paramJceOutputStream.write(this.FaceId, 1);
    paramJceOutputStream.write(this.Age, 2);
    paramJceOutputStream.write(this.Gender, 3);
    paramJceOutputStream.write(this.Nick, 4);
    paramJceOutputStream.write(this.Status, 5);
    if (this.sShowName != null) {
      paramJceOutputStream.write(this.sShowName, 6);
    }
    if (this.sName != null) {
      paramJceOutputStream.write(this.sName, 8);
    }
    paramJceOutputStream.write(this.cGender, 9);
    if (this.sPhone != null) {
      paramJceOutputStream.write(this.sPhone, 10);
    }
    if (this.sEmail != null) {
      paramJceOutputStream.write(this.sEmail, 11);
    }
    if (this.sMemo != null) {
      paramJceOutputStream.write(this.sMemo, 12);
    }
    if (this.strAutoRemark != null) {
      paramJceOutputStream.write(this.strAutoRemark, 13);
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
    if (this.sSpecialTitle != null) {
      paramJceOutputStream.write(this.sSpecialTitle, 23);
    }
    paramJceOutputStream.write(this.dwSpecialTitleExpireTime, 24);
    if (this.bytes_job != null) {
      paramJceOutputStream.write(this.bytes_job, 25);
    }
    paramJceOutputStream.write(this.cApolloFlag, 26);
    paramJceOutputStream.write(this.dwApolloTimestamp, 27);
    paramJceOutputStream.write(this.dwGlobalGroupLevel, 28);
    paramJceOutputStream.write(this.dwTitleId, 29);
    paramJceOutputStream.write(this.dwShutupTimestap, 30);
    paramJceOutputStream.write(this.dwGlobalGroupPoint, 31);
    if (this.qzusrinfo != null) {
      paramJceOutputStream.write(this.qzusrinfo, 32);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     friendlist.stTroopMemberInfo
 * JD-Core Version:    0.7.0.1
 */