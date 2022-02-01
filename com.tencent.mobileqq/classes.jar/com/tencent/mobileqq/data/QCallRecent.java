package com.tencent.mobileqq.data;

import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;

@uniqueConstraints(clause=ConflictClause.FAIL, columnNames="uin,type")
public class QCallRecent
  extends Entity
{
  public static final int DISCUSS_STATE_CALL = 4;
  public static final int DISCUSS_STATE_CALLED = 3;
  public static final int DISCUSS_STATE_DOING = 1;
  public static final int DISCUSS_STATE_IGNORE = 8;
  public static final int DISCUSS_STATE_MISS = 2;
  public static final int DOUBLE_STATE_CHATING = 6;
  public static final int DOUBLE_STATE_INVITING = 5;
  public static final int DOUBLE_STATE_OHTER_TERMINAL_CAHTING = 7;
  public static final String TABLE_NAME = "recent_call";
  public String bindId;
  public int bindType = 0;
  public String businessLogo;
  public String businessName;
  public String businessSeId;
  public int callType = 0;
  public int contactId = -1;
  public String displayName;
  public int extraType = 0;
  public boolean isLastCallRealMissed = false;
  public int isSystemCall = 0;
  public int isVideo = 0;
  public String lastCallMsg;
  public long lastCallTime;
  public byte[] lightalkSig;
  public long memberCount = 0L;
  public int missedCallCount = 0;
  public String phoneNumber = null;
  public String pstnInfo = null;
  public long readTime = 0L;
  public int sendFlag;
  public String senderUin;
  public int state = 0;
  public long time;
  public String troopUin;
  public int type = 0;
  public String uin;
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramObject != null)
    {
      bool1 = bool3;
      if ((paramObject instanceof QCallRecent))
      {
        paramObject = (QCallRecent)paramObject;
        String str = this.uin;
        if (str == null)
        {
          bool1 = bool2;
          if (paramObject.uin == null)
          {
            bool1 = bool2;
            if (this.type == paramObject.type) {
              bool1 = true;
            }
          }
          return bool1;
        }
        if ((!str.equals(paramObject.uin)) || (this.type != paramObject.type))
        {
          bool1 = bool3;
          if (this.uin.equals(paramObject.uin))
          {
            bool1 = bool3;
            if (UinTypeUtil.b(this.type))
            {
              bool1 = bool3;
              if (!UinTypeUtil.b(paramObject.type)) {}
            }
          }
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int getState(QQAppInterface paramQQAppInterface)
  {
    return this.state;
  }
  
  public String getTableName()
  {
    return "recent_call";
  }
  
  public boolean isMissedCall()
  {
    return this.missedCallCount > 0;
  }
  
  public boolean isSend()
  {
    return MessageRecordInfo.b(this.sendFlag);
  }
  
  public boolean isVideo()
  {
    return this.isVideo == 1;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("RecentCall(");
    localStringBuffer.append("uin:");
    localStringBuffer.append(this.uin);
    localStringBuffer.append(",type:");
    localStringBuffer.append(this.type);
    localStringBuffer.append(",troopUin");
    localStringBuffer.append(this.troopUin);
    localStringBuffer.append(",sendFlag:");
    localStringBuffer.append(this.sendFlag);
    localStringBuffer.append(",missedCallCount:");
    localStringBuffer.append(this.missedCallCount);
    localStringBuffer.append(",isVideo:");
    localStringBuffer.append(this.isVideo);
    localStringBuffer.append(",displayName:");
    localStringBuffer.append(this.displayName);
    localStringBuffer.append(",lastCallTime:");
    localStringBuffer.append(this.lastCallTime);
    localStringBuffer.append(",lastCallMsg:");
    localStringBuffer.append(this.lastCallMsg);
    localStringBuffer.append(",readTime:");
    localStringBuffer.append(this.readTime);
    localStringBuffer.append(",extraType:");
    localStringBuffer.append(this.extraType);
    localStringBuffer.append(",bindType:");
    localStringBuffer.append(this.bindType);
    localStringBuffer.append(",bindId:");
    localStringBuffer.append(this.bindId);
    localStringBuffer.append(",callType:");
    localStringBuffer.append(this.callType);
    localStringBuffer.append(")");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QCallRecent
 * JD-Core Version:    0.7.0.1
 */