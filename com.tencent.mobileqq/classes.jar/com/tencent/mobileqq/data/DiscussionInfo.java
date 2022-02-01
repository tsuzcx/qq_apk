package com.tencent.mobileqq.data;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.qphone.base.util.QLog;

public class DiscussionInfo
  extends Entity
{
  public static final long UIControlFlag_Hidden_RecentUser = 1L;
  public static final long UIControlFlag_default = 0L;
  public long DiscussionFlag = 536870912L;
  public int createFrom = 0;
  public long createTime;
  public String discussionName;
  public String faceUinSet;
  public long groupCode;
  public long groupUin;
  public boolean hasCollect = false;
  public long infoSeq;
  public String inheritOwnerUin;
  @notColumn
  public long lastMsgTime;
  public int mComparePartInt;
  public String mCompareSpell;
  public long mOrigin = -1L;
  public long mOriginExtra = 0L;
  public int mSelfRight = -1;
  @notColumn
  public int mUnreliableMemberCount = 100;
  public String ownerUin;
  public long timeSec;
  public long uiControlFlag = 0L;
  @unique
  public String uin;
  
  public static boolean isValidDisUin(String paramString)
  {
    boolean bool = false;
    try
    {
      long l = Long.valueOf(Long.parseLong(paramString)).longValue();
      if (l >= 1000000L) {
        bool = true;
      }
      return bool;
    }
    catch (NumberFormatException paramString) {}
    return false;
  }
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    this.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
    this.infoSeq = paramCursor.getLong(paramCursor.getColumnIndex("infoSeq"));
    this.ownerUin = paramCursor.getString(paramCursor.getColumnIndex("ownerUin"));
    this.discussionName = paramCursor.getString(paramCursor.getColumnIndex("discussionName"));
    this.createTime = paramCursor.getLong(paramCursor.getColumnIndex("createTime"));
    this.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
    this.faceUinSet = paramCursor.getString(paramCursor.getColumnIndex("faceUinSet"));
    this.DiscussionFlag = paramCursor.getLong(paramCursor.getColumnIndex("DiscussionFlag"));
    this.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
    this.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
    this.groupCode = paramCursor.getLong(paramCursor.getColumnIndex("groupCode"));
    this.groupUin = paramCursor.getLong(paramCursor.getColumnIndex("groupUin"));
    boolean bool;
    if (paramCursor.getInt(paramCursor.getColumnIndex("hasCollect")) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.hasCollect = bool;
    this.inheritOwnerUin = paramCursor.getString(paramCursor.getColumnIndex("inheritOwnerUin"));
    this.createFrom = paramCursor.getInt(paramCursor.getColumnIndex("createFrom"));
    this.uiControlFlag = paramCursor.getLong(paramCursor.getColumnIndex("uiControlFlag"));
    this.mOrigin = paramCursor.getLong(paramCursor.getColumnIndex("mOrigin"));
    this.mOriginExtra = paramCursor.getLong(paramCursor.getColumnIndex("mOriginExtra"));
    this.mSelfRight = paramCursor.getInt(paramCursor.getColumnIndex("mSelfRight"));
    if (QLog.isDevelopLevel())
    {
      paramCursor = new StringBuilder();
      paramCursor.append("DiscussionInfo, ");
      paramCursor.append(this);
      QLog.w("DiscussionInfo", 1, paramCursor.toString());
    }
    return true;
  }
  
  public int getHrExtra()
  {
    return ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).hrExtra(this.mOriginExtra);
  }
  
  public boolean hasRenamed()
  {
    return (this.DiscussionFlag & 0x40) >>> 6 == 0L;
  }
  
  public boolean isDiscussHrMeeting()
  {
    return ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).isHRConf(this.mOrigin);
  }
  
  public boolean isHidden()
  {
    return ((this.mOrigin & 0x2) == 2L) && (getHrExtra() == 1) && (((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).isNoRight(this.mSelfRight));
  }
  
  public boolean isOwnerOrInheritOwner(String paramString)
  {
    if ((!TextUtils.isEmpty(this.inheritOwnerUin)) && (!"0".equals(this.inheritOwnerUin)) && (paramString.equals(this.inheritOwnerUin))) {
      return true;
    }
    return (!TextUtils.isEmpty(this.ownerUin)) && (!"0".equals(this.ownerUin)) && (paramString.equals(this.ownerUin));
  }
  
  public boolean isPSTNConf()
  {
    return ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).isPSTNConf(this.mOrigin);
  }
  
  public boolean isUIControlFlag_Hidden_RecentUser()
  {
    return (this.uiControlFlag & 1L) == 1L;
  }
  
  public void removeUIControlFlag_Hidden_RecentUser()
  {
    this.uiControlFlag &= 0xFFFFFFFE;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin[");
    localStringBuilder.append(this.uin);
    localStringBuilder.append("], discussionName[");
    localStringBuilder.append(this.discussionName);
    localStringBuilder.append("], mOrigin[");
    localStringBuilder.append(this.mOrigin);
    localStringBuilder.append("], mOriginExtra[");
    localStringBuilder.append(this.mOriginExtra);
    localStringBuilder.append("], mSelfRight[");
    localStringBuilder.append(this.mSelfRight);
    localStringBuilder.append("], isHidden[");
    localStringBuilder.append(isHidden());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.DiscussionInfo
 * JD-Core Version:    0.7.0.1
 */