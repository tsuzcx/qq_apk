package com.tencent.mobileqq.fts.data.troop;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.utils.FTSV2FieldUtils;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.qphone.base.util.QLog;

public class FTSTroop
  extends FTSEntity
{
  public static final String TABLE_NAME = "TroopIndex";
  private static final String TAG = "Q.fts.FTSTroop";
  public String mMemberCard;
  public String mMemberName;
  public String mMemberNick;
  public String mMemberUin;
  public String mTroopUin;
  
  public FTSTroop() {}
  
  public FTSTroop(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, byte[] paramArrayOfByte)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramString1, paramLong, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramArrayOfByte);
  }
  
  public FTSTroop(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.mType = paramInt;
    this.mTroopUin = paramString1;
    this.mMemberUin = paramString2;
    this.mMemberName = paramString3;
    this.mMemberCard = paramString4;
    this.mMemberNick = paramString5;
  }
  
  public String createDeleteSQL()
  {
    try
    {
      Object localObject = new StringBuilder(128);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DELETE FROM ");
      localStringBuilder.append(getTableName());
      localStringBuilder.append(" WHERE ");
      localStringBuilder.append(getTableName());
      localStringBuilder.append(" MATCH 'type:");
      ((StringBuilder)localObject).append(localStringBuilder.toString());
      ((StringBuilder)localObject).append(this.mType);
      ((StringBuilder)localObject).append(" ext1:");
      ((StringBuilder)localObject).append(this.mExt1);
      if (!TextUtils.isEmpty(this.mExt6))
      {
        ((StringBuilder)localObject).append(" ext6:");
        ((StringBuilder)localObject).append(this.mExt6);
      }
      ((StringBuilder)localObject).append("';");
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.FTSTroop", 2, "createDeleteSQL failure: ", localThrowable);
      }
    }
    return null;
  }
  
  public String createInsertSQL()
  {
    int i = this.mType;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mExt1);
    localStringBuilder.append("zzz");
    localStringBuilder.append(this.mExt6);
    return String.format("FTSTroop type=%d, troopuin|memberuin=%s, troopnick|size=%s, nick|size=%s", new Object[] { Integer.valueOf(i), localStringBuilder.toString(), MessageRecordUtil.a(this.mExt4), MessageRecordUtil.a(this.mExt2) });
  }
  
  public String createUpdateSQL()
  {
    return String.format("UPDATE %s SET  EXT2 = '%s', EXT3 = '%s', EXT4 = '%s', EXT5 = '%s' WHERE %s MATCH 'ext1:%s ext6:%s';", new Object[] { getTableName(), this.mExt2, this.mExt3, this.mExt4, this.mExt5, getTableName(), this.mExt1, this.mExt6 });
  }
  
  protected void doDeserialize()
  {
    this.mTroopUin = this.mExt1;
    this.mMemberName = this.mExt2;
    this.mMemberCard = this.mExt4;
    this.mMemberUin = this.mExt6;
  }
  
  protected void doSerialize()
  {
    this.mType = 2;
    this.mExt1 = this.mTroopUin;
    String str = this.mMemberName;
    if (str == null) {
      str = "";
    } else {
      str = str.replace("'", "''");
    }
    this.mMemberName = str;
    str = this.mMemberCard;
    if (str == null) {
      str = "";
    } else {
      str = str.replace("'", "''");
    }
    this.mMemberCard = str;
    this.mExt2 = this.mMemberName;
    if (TextUtils.isEmpty(this.mExt2))
    {
      this.mExt3 = "";
    }
    else
    {
      this.mExt3 = FTSV2FieldUtils.c(this.mExt2);
      this.mSegmentCount += FTSV2FieldUtils.a(this.mExt3);
    }
    this.mExt4 = this.mMemberCard;
    if (TextUtils.isEmpty(this.mExt4))
    {
      this.mExt5 = "";
    }
    else
    {
      this.mExt5 = FTSV2FieldUtils.c(this.mExt4);
      this.mSegmentCount += FTSV2FieldUtils.a(this.mExt5);
    }
    this.mExt6 = this.mMemberUin;
  }
  
  public String getTableName()
  {
    return "TroopIndex";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FTSTroop TroopUin=");
    localStringBuilder.append(this.mTroopUin);
    localStringBuilder.append(" MemberUin=");
    localStringBuilder.append(this.mMemberUin);
    localStringBuilder.append(" MemberName=");
    localStringBuilder.append(this.mMemberName);
    localStringBuilder.append(" MemberCard=");
    localStringBuilder.append(this.mMemberCard);
    return localStringBuilder.toString();
  }
  
  public int type()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.data.troop.FTSTroop
 * JD-Core Version:    0.7.0.1
 */