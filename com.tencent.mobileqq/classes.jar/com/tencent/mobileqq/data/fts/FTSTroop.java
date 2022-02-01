package com.tencent.mobileqq.data.fts;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
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
      ((StringBuilder)localObject).append("DELETE FROM " + getTableName() + " WHERE " + getTableName() + " MATCH 'type:");
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
    return String.format("FTSTroop type=%d, troopuin|memberuin=%s, troopnick|size=%s, nick|size=%s", new Object[] { Integer.valueOf(this.mType), this.mExt1 + "zzz" + this.mExt6, MessageRecordUtil.a(this.mExt4), MessageRecordUtil.a(this.mExt2) });
  }
  
  public String createUpdateSQL()
  {
    return String.format("UPDATE %s SET  EXT2 = '%s', EXT3 = '%s', EXT4 = '%s', EXT5 = '%s' WHERE %s MATCH 'ext1:%s ext6:%s';", new Object[] { getTableName(), this.mExt2, this.mExt3, this.mExt4, this.mExt5, getTableName(), this.mExt1, this.mExt6 });
  }
  
  public void doDeserialize()
  {
    this.mTroopUin = this.mExt1;
    this.mMemberName = this.mExt2;
    this.mMemberCard = this.mExt4;
    this.mMemberUin = this.mExt6;
  }
  
  public void doSerialize()
  {
    this.mType = 2;
    this.mExt1 = this.mTroopUin;
    String str;
    if (this.mMemberName == null)
    {
      str = "";
      this.mMemberName = str;
      if (this.mMemberCard != null) {
        break label115;
      }
      str = "";
      label38:
      this.mMemberCard = str;
      this.mExt2 = this.mMemberName;
      if (!TextUtils.isEmpty(this.mExt2)) {
        break label130;
      }
      this.mExt3 = "";
      label67:
      this.mExt4 = this.mMemberCard;
      if (!TextUtils.isEmpty(this.mExt4)) {
        break label160;
      }
      this.mExt5 = "";
    }
    for (;;)
    {
      this.mExt6 = this.mMemberUin;
      return;
      str = this.mMemberName.replace("'", "''");
      break;
      label115:
      str = this.mMemberCard.replace("'", "''");
      break label38;
      label130:
      this.mExt3 = SQLiteFTSUtils.a(this.mExt2);
      this.mSegmentCount += SQLiteFTSUtils.a(this.mExt3);
      break label67;
      label160:
      this.mExt5 = SQLiteFTSUtils.a(this.mExt4);
      this.mSegmentCount += SQLiteFTSUtils.a(this.mExt5);
    }
  }
  
  public String getTableName()
  {
    return "TroopIndex";
  }
  
  public String toString()
  {
    return "FTSTroop TroopUin=" + this.mTroopUin + " MemberUin=" + this.mMemberUin + " MemberName=" + this.mMemberName + " MemberCard=" + this.mMemberCard;
  }
  
  public int type()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.fts.FTSTroop
 * JD-Core Version:    0.7.0.1
 */