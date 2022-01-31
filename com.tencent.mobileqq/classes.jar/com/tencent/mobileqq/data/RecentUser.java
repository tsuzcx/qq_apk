package com.tencent.mobileqq.data;

import com.tencent.mobileqq.activity.recent.msg.RecentUserMsgFactory;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.defaultzero;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.qphone.base.util.QLog;

@uniqueConstraints(clause=ConflictClause.FAIL, columnNames="uin,type")
public class RecentUser
  extends BaseRecentUser
{
  public static final long FLAG_HOTCHAT = 1L;
  public static final long FLAG_PA_AD = 16L;
  public static final String TABLE_NAME = "recent";
  private static final String TAG = "RecentUser";
  public String displayName;
  @notColumn
  public int jumpTabMode;
  @defaultzero
  public long lFlag;
  @defaultzero
  public long lastmsgdrafttime;
  public long lastmsgtime;
  @notColumn
  public Object msg;
  public byte[] msgData;
  public int msgType;
  @defaultzero
  public long showUpTime;
  public String troopUin;
  public int type;
  public String uin;
  
  public void cleanMsgAndMsgData(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentUser", 2, "cleanMsgAndMsgData " + this.uin + " " + this.uin + " this.msgType " + this.msgType + " msgType " + paramInt);
    }
    if (this.msgType == paramInt)
    {
      this.msg = null;
      this.msgData = null;
      this.msgType = 0;
    }
  }
  
  public void doParse()
  {
    this.msg = RecentUserMsgFactory.a(this.msgType, this.msgData);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof RecentUser)))
    {
      paramObject = (RecentUser)paramObject;
      if (this.uin == null) {
        if ((paramObject.uin != null) || (this.type != paramObject.type)) {}
      }
      while ((this.uin.equals(paramObject.uin)) && (this.type == paramObject.type))
      {
        return true;
        return false;
      }
      return false;
    }
    return false;
  }
  
  public String getTableName()
  {
    return "recent";
  }
  
  protected void prewrite()
  {
    this.msgData = RecentUserMsgFactory.a(this.msgType, this.msg);
    super.prewrite();
  }
  
  public void setMsgAndType(Object paramObject, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentUser", 2, "setMsgAndType " + this.uin + " " + this.uin + " this.msgType " + this.msgType + " msgType " + paramInt);
    }
    if (paramInt >= this.msgType)
    {
      this.msg = paramObject;
      this.msgType = paramInt;
      reParse();
    }
  }
  
  public boolean shouldShowInRecentList()
  {
    return (this.msgType == 20) || (this.msgType == 14) || (this.msgType == 5) || (this.msgType == 12) || (this.msgType == 23) || (this.msgType == 7) || (this.msgType == 8) || (this.msgType == 15) || (this.msgType == 19) || (this.msgType == 18) || (this.msgType == 2) || (this.msgType == 3) || (this.msgType == 10) || (this.msgType == 25) || (this.msgType == 4) || (this.msgType == 16) || (this.msgType == 13) || (this.msgType == 1) || (this.msgType == 9) || (this.msgType == 11) || (this.msgType == 6) || (this.msgType == 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.RecentUser
 * JD-Core Version:    0.7.0.1
 */