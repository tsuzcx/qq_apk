package com.tencent.mobileqq.fts.data.troop;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.utils.FTSV2FieldUtils;
import com.tencent.mobileqq.fts.v2.entity.FTSEntityV2;
import com.tencent.mobileqq.fts.v2.entity.notColumn;

public class TroopIndex
  extends FTSEntityV2
{
  public String content = null;
  public String contentindex = null;
  public String ext4 = null;
  public String ext5 = null;
  public String ext6 = null;
  public String ext7 = null;
  public String ext8 = null;
  public String ext9 = null;
  @notColumn
  public String mMemberCard;
  @notColumn
  public String mMemberName;
  @notColumn
  public String mMemberNick;
  @notColumn
  public String mMemberUin;
  @notColumn
  public String mTroopUin;
  public long oId = -1L;
  public int type = -1;
  
  public TroopIndex() {}
  
  public TroopIndex(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.type = paramInt;
    this.mTroopUin = paramString1;
    this.mMemberUin = paramString2;
    this.mMemberName = paramString3;
    this.mMemberCard = paramString4;
    this.mMemberNick = paramString5;
  }
  
  protected void doDeserialize()
  {
    this.mTroopUin = this.ext1;
    this.mMemberName = this.ext2;
    this.mMemberCard = this.ext4;
    this.mMemberUin = this.ext6;
    this.mMemberNick = this.ext7;
  }
  
  protected void doSerialize()
  {
    this.type = 2;
    this.ext1 = this.mTroopUin;
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
    this.ext2 = this.mMemberName;
    if (TextUtils.isEmpty(this.ext2)) {
      this.ext3 = "";
    } else {
      this.ext3 = FTSV2FieldUtils.a(this.ext2);
    }
    this.ext4 = this.mMemberCard;
    if (TextUtils.isEmpty(this.ext4)) {
      this.ext5 = "";
    } else {
      this.ext5 = FTSV2FieldUtils.a(this.ext4);
    }
    this.ext6 = this.mMemberUin;
    this.ext7 = this.mMemberNick;
    if (TextUtils.isEmpty(this.ext7))
    {
      this.ext8 = "";
      return;
    }
    this.ext8 = FTSV2FieldUtils.a(this.ext7);
  }
  
  public boolean needCompress()
  {
    return true;
  }
  
  public void postRead()
  {
    super.postRead();
    doDeserialize();
  }
  
  public void preWrite()
  {
    try
    {
      doSerialize();
      super.preWrite();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.data.troop.TroopIndex
 * JD-Core Version:    0.7.0.1
 */