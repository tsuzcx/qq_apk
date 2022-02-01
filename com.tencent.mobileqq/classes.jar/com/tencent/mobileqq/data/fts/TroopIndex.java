package com.tencent.mobileqq.data.fts;

import android.text.TextUtils;
import avhr;
import avie;
import com.tencent.mobileqq.fts.entity.FTSEntity;

public class TroopIndex
  extends FTSEntity
{
  public String content;
  public String contentindex;
  public String ext4;
  public String ext5;
  public String ext6;
  public String ext7;
  public String ext8;
  public String ext9;
  @avhr
  public String mMemberCard;
  @avhr
  public String mMemberName;
  @avhr
  public String mMemberNick;
  @avhr
  public String mMemberUin;
  @avhr
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
  
  public void doDeserialize()
  {
    this.mTroopUin = this.ext1;
    this.mMemberName = this.ext2;
    this.mMemberCard = this.ext4;
    this.mMemberUin = this.ext6;
    this.mMemberNick = this.ext7;
  }
  
  public void doSerialize()
  {
    this.type = 2;
    this.ext1 = this.mTroopUin;
    String str;
    if (this.mMemberName == null)
    {
      str = "";
      this.mMemberName = str;
      if (this.mMemberCard != null) {
        break label139;
      }
      str = "";
      label38:
      this.mMemberCard = str;
      this.ext2 = this.mMemberName;
      if (!TextUtils.isEmpty(this.ext2)) {
        break label154;
      }
      this.ext3 = "";
      label67:
      this.ext4 = this.mMemberCard;
      if (!TextUtils.isEmpty(this.ext4)) {
        break label168;
      }
    }
    label139:
    label154:
    label168:
    for (this.ext5 = "";; this.ext5 = avie.a(this.ext4))
    {
      this.ext6 = this.mMemberUin;
      this.ext7 = this.mMemberNick;
      if (!TextUtils.isEmpty(this.ext7)) {
        break label182;
      }
      this.ext8 = "";
      return;
      str = this.mMemberName.replace("'", "''");
      break;
      str = this.mMemberCard.replace("'", "''");
      break label38;
      this.ext3 = avie.a(this.ext2);
      break label67;
    }
    label182:
    this.ext8 = avie.a(this.ext7);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.fts.TroopIndex
 * JD-Core Version:    0.7.0.1
 */