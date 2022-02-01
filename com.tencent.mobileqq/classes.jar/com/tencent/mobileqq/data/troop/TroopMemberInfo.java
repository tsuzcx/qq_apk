package com.tencent.mobileqq.data.troop;

import android.database.Cursor;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.Serializable;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="troopuin,memberuin")
public class TroopMemberInfo
  extends Entity
  implements Serializable
{
  public static final long VALUE_DISTANCE_TO_SELF_EXPIRED = -1000L;
  public static final long VALUE_DISTANCE_TO_SELF_UNKOWN = -100L;
  protected static final int VALUE_INVALID = -100;
  public static final long VALUE_MEMBER_CLOSE_SHARE_LBS = -1001L;
  public long active_point;
  @notColumn
  public int addState;
  public byte age;
  public String alias;
  public String autoremark;
  public long cmduinFlagEx3Grocery;
  public int commonFrdCnt = -2147483648;
  public long credit_level;
  public long datetime;
  @notColumn
  public String displayedNamePinyinFirst;
  public int distance = 0;
  public double distanceToSelf = -100.0D;
  public long distanceToSelfUpdateTimeStamp = 0L;
  public short faceid;
  public String friendnick;
  public long gagTimeStamp;
  public int globalTroopLevel = -100;
  public String honorList;
  public int hotChatGlamourLevel = -100;
  public String hwCourse;
  public int hwIdentity;
  public String hwName;
  public int isShowQZone;
  public boolean isTroopFollowed;
  public long join_time;
  public long lastMsgUpdateHonorRichTime;
  public long last_active_time;
  public int level;
  public int mBigClubTemplateId;
  public int mBigClubVipLevel;
  public int mBigClubVipType;
  public int mGlamourLevel;
  public byte mHonorRichFlag;
  public int mIsHideBigClub;
  public boolean mIsShielded;
  public String mUniqueTitle;
  public int mUniqueTitleExpire = 0;
  public int mVipLevel;
  public int mVipTemplateId;
  public int mVipType;
  public String memberuin;
  public long msgseq = -100L;
  public int newRealLevel;
  public String pyAll_autoremark;
  public String pyAll_friendnick;
  public String pyAll_troopnick;
  public String pyFirst_autoremark;
  public String pyFirst_friendnick;
  public String pyFirst_troopnick;
  public int qqVipInfo = 0;
  public int realLevel;
  public String recommendRemark;
  public byte sex;
  public byte status;
  public int superQqInfo = 0;
  public int superVipInfo = 0;
  public int tribeLevel;
  public int tribePoint;
  public String troopColorNick;
  public int troopColorNickId;
  public String troopnick;
  public String troopremark;
  public String troopuin;
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    this.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
    this.memberuin = paramCursor.getString(paramCursor.getColumnIndex("memberuin"));
    this.friendnick = paramCursor.getString(paramCursor.getColumnIndex("friendnick"));
    this.pyAll_friendnick = paramCursor.getString(paramCursor.getColumnIndex("pyAll_friendnick"));
    this.pyFirst_friendnick = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_friendnick"));
    this.troopColorNick = paramCursor.getString(paramCursor.getColumnIndex("troopColorNick"));
    this.troopColorNickId = paramCursor.getInt(paramCursor.getColumnIndex("troopColorNickId"));
    this.troopnick = paramCursor.getString(paramCursor.getColumnIndex("troopnick"));
    this.pyAll_troopnick = paramCursor.getString(paramCursor.getColumnIndex("pyAll_troopnick"));
    this.pyFirst_troopnick = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_troopnick"));
    this.autoremark = paramCursor.getString(paramCursor.getColumnIndex("autoremark"));
    this.pyAll_autoremark = paramCursor.getString(paramCursor.getColumnIndex("pyAll_autoremark"));
    this.pyFirst_autoremark = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_autoremark"));
    this.troopremark = paramCursor.getString(paramCursor.getColumnIndex("troopremark"));
    this.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
    this.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
    this.faceid = paramCursor.getShort(paramCursor.getColumnIndex("faceid"));
    this.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
    this.sex = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sex")));
    this.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("status")));
    this.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
    this.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
    this.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
    this.level = paramCursor.getInt(paramCursor.getColumnIndex("level"));
    this.realLevel = paramCursor.getInt(paramCursor.getColumnIndex("realLevel"));
    this.newRealLevel = paramCursor.getInt(paramCursor.getColumnIndex("newRealLevel"));
    this.join_time = paramCursor.getLong(paramCursor.getColumnIndex("join_time"));
    this.last_active_time = paramCursor.getLong(paramCursor.getColumnIndex("last_active_time"));
    this.active_point = paramCursor.getLong(paramCursor.getColumnIndex("active_point"));
    this.credit_level = paramCursor.getLong(paramCursor.getColumnIndex("credit_level"));
    int i = paramCursor.getInt(paramCursor.getColumnIndex("isTroopFollowed"));
    boolean bool2 = false;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.isTroopFollowed = bool1;
    this.distance = paramCursor.getInt(paramCursor.getColumnIndex("distance"));
    this.msgseq = paramCursor.getLong(paramCursor.getColumnIndex("msgseq"));
    this.gagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("gagTimeStamp"));
    this.distanceToSelf = paramCursor.getDouble(paramCursor.getColumnIndex("distanceToSelf"));
    this.distanceToSelfUpdateTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("distanceToSelfUpdateTimeStamp"));
    boolean bool1 = bool2;
    if (paramCursor.getInt(paramCursor.getColumnIndex("mIsShielded")) != 0) {
      bool1 = true;
    }
    this.mIsShielded = bool1;
    this.mUniqueTitle = paramCursor.getString(paramCursor.getColumnIndex("mUniqueTitle"));
    this.mUniqueTitleExpire = paramCursor.getInt(paramCursor.getColumnIndex("mUniqueTitleExpire"));
    this.tribeLevel = paramCursor.getInt(paramCursor.getColumnIndex("tribeLevel"));
    this.tribePoint = paramCursor.getInt(paramCursor.getColumnIndex("tribePoint"));
    this.mGlamourLevel = paramCursor.getInt(paramCursor.getColumnIndex("mGlamourLevel"));
    this.hotChatGlamourLevel = paramCursor.getInt(paramCursor.getColumnIndex("hotChatGlamourLevel"));
    this.globalTroopLevel = paramCursor.getInt(paramCursor.getColumnIndex("globalTroopLevel"));
    this.commonFrdCnt = paramCursor.getInt(paramCursor.getColumnIndex("commonFrdCnt"));
    this.hwIdentity = paramCursor.getInt(paramCursor.getColumnIndex("hwIdentity"));
    this.recommendRemark = paramCursor.getString(paramCursor.getColumnIndex("recommendRemark"));
    this.isShowQZone = paramCursor.getInt(paramCursor.getColumnIndex("isShowQZone"));
    this.mVipType = paramCursor.getInt(paramCursor.getColumnIndex("mVipType"));
    this.mVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("mVipLevel"));
    this.mVipTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("mVipTemplateId"));
    this.mBigClubVipType = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubVipType"));
    this.mBigClubVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubVipLevel"));
    this.mBigClubTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubTemplateId"));
    this.mIsHideBigClub = paramCursor.getInt(paramCursor.getColumnIndex("mIsHideBigClub"));
    this.honorList = paramCursor.getString(paramCursor.getColumnIndex("honorList"));
    this.mHonorRichFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("mHonorRichFlag")));
    this.lastMsgUpdateHonorRichTime = paramCursor.getLong(paramCursor.getColumnIndex("lastMsgUpdateHonorRichTime"));
    this.cmduinFlagEx3Grocery = paramCursor.getLong(paramCursor.getColumnIndex("cmduinFlagEx3Grocery"));
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TroopMemberInfo{");
    localStringBuilder.append("datetime=");
    localStringBuilder.append(this.datetime);
    localStringBuilder.append(", troopuin='");
    localStringBuilder.append(this.troopuin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", memberuin='");
    localStringBuilder.append(this.memberuin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", displayedNamePinyinFirst='");
    localStringBuilder.append(this.displayedNamePinyinFirst);
    localStringBuilder.append('\'');
    localStringBuilder.append(", friendnick='");
    localStringBuilder.append(this.friendnick);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pyAll_friendnick='");
    localStringBuilder.append(this.pyAll_friendnick);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pyFirst_friendnick='");
    localStringBuilder.append(this.pyFirst_friendnick);
    localStringBuilder.append('\'');
    localStringBuilder.append(", troopnick='");
    localStringBuilder.append(this.troopnick);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pyAll_troopnick='");
    localStringBuilder.append(this.pyAll_troopnick);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pyFirst_troopnick='");
    localStringBuilder.append(this.pyFirst_troopnick);
    localStringBuilder.append('\'');
    localStringBuilder.append(", autoremark='");
    localStringBuilder.append(this.autoremark);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pyAll_autoremark='");
    localStringBuilder.append(this.pyAll_autoremark);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pyFirst_autoremark='");
    localStringBuilder.append(this.pyFirst_autoremark);
    localStringBuilder.append('\'');
    localStringBuilder.append(", troopremark='");
    localStringBuilder.append(this.troopremark);
    localStringBuilder.append('\'');
    localStringBuilder.append(", alias='");
    localStringBuilder.append(this.alias);
    localStringBuilder.append('\'');
    localStringBuilder.append(", faceid=");
    localStringBuilder.append(this.faceid);
    localStringBuilder.append(", age=");
    localStringBuilder.append(this.age);
    localStringBuilder.append(", sex=");
    localStringBuilder.append(this.sex);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(", qqVipInfo=");
    localStringBuilder.append(this.qqVipInfo);
    localStringBuilder.append(", superQqInfo=");
    localStringBuilder.append(this.superQqInfo);
    localStringBuilder.append(", superVipInfo=");
    localStringBuilder.append(this.superVipInfo);
    localStringBuilder.append(", level=");
    localStringBuilder.append(this.level);
    localStringBuilder.append(", newRealLevel");
    localStringBuilder.append(this.newRealLevel);
    localStringBuilder.append(", join_time=");
    localStringBuilder.append(this.join_time);
    localStringBuilder.append(", last_active_time=");
    localStringBuilder.append(this.last_active_time);
    localStringBuilder.append(", active_point=");
    localStringBuilder.append(this.active_point);
    localStringBuilder.append(", credit_level=");
    localStringBuilder.append(this.credit_level);
    localStringBuilder.append(", isTroopFollowed=");
    localStringBuilder.append(this.isTroopFollowed);
    localStringBuilder.append(", distance=");
    localStringBuilder.append(this.distance);
    localStringBuilder.append(", msgseq=");
    localStringBuilder.append(this.msgseq);
    localStringBuilder.append(", gagTimeStamp=");
    localStringBuilder.append(this.gagTimeStamp);
    localStringBuilder.append(", distanceToSelf=");
    localStringBuilder.append(this.distanceToSelf);
    localStringBuilder.append(", distanceToSelfUpdateTimeStamp=");
    localStringBuilder.append(this.distanceToSelfUpdateTimeStamp);
    localStringBuilder.append(", mIsShielded=");
    localStringBuilder.append(this.mIsShielded);
    localStringBuilder.append(", mUniqueTitle='");
    localStringBuilder.append(this.mUniqueTitle);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mUniqueTitleExpire=");
    localStringBuilder.append(this.mUniqueTitleExpire);
    localStringBuilder.append(", tribeLevel=");
    localStringBuilder.append(this.tribeLevel);
    localStringBuilder.append(", tribePoint=");
    localStringBuilder.append(this.tribePoint);
    localStringBuilder.append(", mGlamourLevel=");
    localStringBuilder.append(this.mGlamourLevel);
    localStringBuilder.append(", hotChatGlamourLevel=");
    localStringBuilder.append(this.hotChatGlamourLevel);
    localStringBuilder.append(", globalTroopLevel=");
    localStringBuilder.append(this.globalTroopLevel);
    localStringBuilder.append(", hwIdentity=");
    localStringBuilder.append(this.hwIdentity);
    localStringBuilder.append(", recommendRemark=");
    localStringBuilder.append(this.recommendRemark);
    localStringBuilder.append(", isShowQzone=");
    localStringBuilder.append(this.isShowQZone);
    localStringBuilder.append(", mVipType=");
    localStringBuilder.append(this.mVipType);
    localStringBuilder.append(", mVipLevel=");
    localStringBuilder.append(this.mVipLevel);
    localStringBuilder.append(", honorList=");
    localStringBuilder.append(this.honorList);
    localStringBuilder.append(", cmduinFlagEx3Grocery=");
    localStringBuilder.append(this.cmduinFlagEx3Grocery);
    localStringBuilder.append(", troopColorNickId=");
    localStringBuilder.append(this.troopColorNickId);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.troop.TroopMemberInfo
 * JD-Core Version:    0.7.0.1
 */