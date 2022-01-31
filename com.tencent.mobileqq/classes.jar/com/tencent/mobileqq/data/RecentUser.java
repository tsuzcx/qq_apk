package com.tencent.mobileqq.data;

import ajlu;
import android.database.Cursor;
import awhl;
import awhm;
import awhn;
import awhp;
import com.tencent.mobileqq.persistence.ConflictClause;
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
  @awhp
  public Object extraInfo;
  @awhl(a=0)
  public int isHiddenChat;
  @awhp
  public int jumpTabMode;
  @awhm
  public long lFlag;
  @awhm
  public long lastmsgdrafttime;
  public long lastmsgtime;
  @awhp
  public Object msg;
  public byte[] msgData;
  public int msgType;
  @awhm
  public long opTime;
  public byte[] parceledRecentBaseData;
  @awhm
  public long showUpTime;
  public String troopUin;
  @awhn
  private int type;
  public String uin;
  
  @Deprecated
  public RecentUser() {}
  
  public RecentUser(String paramString, int paramInt)
  {
    this.uin = paramString;
    this.type = paramInt;
  }
  
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
    this.msg = ajlu.a(this.msgType, this.msgData);
  }
  
  public boolean entityByCursor(Cursor paramCursor)
  {
    if (1 == paramCursor.getShort(paramCursor.getColumnIndex("mIsParsed"))) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIsParsed = bool;
      this.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      this.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      this.displayName = paramCursor.getString(paramCursor.getColumnIndex("displayName"));
      this.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      this.lastmsgtime = paramCursor.getLong(paramCursor.getColumnIndex("lastmsgtime"));
      this.lastmsgdrafttime = paramCursor.getLong(paramCursor.getColumnIndex("lastmsgdrafttime"));
      this.msgType = paramCursor.getInt(paramCursor.getColumnIndex("msgType"));
      this.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
      this.showUpTime = paramCursor.getLong(paramCursor.getColumnIndex("showUpTime"));
      this.lFlag = paramCursor.getLong(paramCursor.getColumnIndex("lFlag"));
      this.opTime = paramCursor.getLong(paramCursor.getColumnIndex("opTime"));
      this.isHiddenChat = paramCursor.getInt(paramCursor.getColumnIndex("isHiddenChat"));
      this.parceledRecentBaseData = paramCursor.getBlob(paramCursor.getColumnIndex("parceledRecentBaseData"));
      return true;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof RecentUser)))
    {
      paramObject = (RecentUser)paramObject;
      if (this.uin == null) {
        if ((paramObject.uin != null) || (getType() != paramObject.getType())) {}
      }
      while ((this.uin.equals(paramObject.uin)) && (getType() == paramObject.getType()))
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
  
  public int getType()
  {
    return this.type;
  }
  
  public void prewrite()
  {
    this.msgData = ajlu.a(this.msgType, this.msg);
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
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public boolean shouldShowInRecentList()
  {
    return (this.msgType == 24) || (this.msgType == 17) || (this.msgType == 16) || (this.msgType == 10) || (this.msgType == 5) || (this.msgType == 13) || (this.msgType == 27) || (this.msgType == 7) || (this.msgType == 8) || (this.msgType == 18) || (this.msgType == 22) || (this.msgType == 21) || (this.msgType == 2) || (this.msgType == 3) || (this.msgType == 11) || (this.msgType == 29) || (this.msgType == 4) || (this.msgType == 19) || (this.msgType == 14) || (this.msgType == 1) || (this.msgType == 9) || (this.msgType == 12) || (this.msgType == 6) || (this.msgType == 20) || (this.msgType == 23);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.RecentUser
 * JD-Core Version:    0.7.0.1
 */