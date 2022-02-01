package com.tencent.mobileqq.data;

import android.database.Cursor;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.defaultzero;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.proxy.api.IRecentUserMsgSerializeApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;

@uniqueConstraints(clause=ConflictClause.FAIL, columnNames="uin,type")
@KeepClassConstructor
public final class RecentUser
  extends Entity
{
  public static final long FLAG_HOTCHAT = 1L;
  public static final long FLAG_PA_AD = 16L;
  public static final String TABLE_NAME = "recent";
  private static final String TAG = "RecentUser";
  public String displayName;
  @notColumn
  public Object extraInfo;
  @defaultValue(defaultInteger=0)
  public int isHiddenChat;
  @notColumn
  public int jumpTabMode;
  @defaultzero
  public long lFlag;
  @defaultzero
  public long lastmsgdrafttime;
  public long lastmsgtime;
  public boolean mIsParsed;
  @notColumn
  public Object msg;
  public byte[] msgData;
  public int msgType;
  @defaultzero
  public long opTime;
  public byte[] parceledRecentBaseData;
  @defaultzero
  public long showUpTime;
  public String troopUin;
  public int type;
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
    IRecentUserMsgSerializeApi localIRecentUserMsgSerializeApi = (IRecentUserMsgSerializeApi)QRoute.api(IRecentUserMsgSerializeApi.class);
    if (localIRecentUserMsgSerializeApi != null) {
      this.msg = localIRecentUserMsgSerializeApi.recentUserMsgDeserialize(this.msgType, this.msgData);
    }
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
  
  public void parse()
  {
    if (!this.mIsParsed) {
      try
      {
        if (!this.mIsParsed)
        {
          doParse();
          this.mIsParsed = true;
        }
        return;
      }
      finally {}
    }
  }
  
  public void prewrite()
  {
    IRecentUserMsgSerializeApi localIRecentUserMsgSerializeApi = (IRecentUserMsgSerializeApi)QRoute.api(IRecentUserMsgSerializeApi.class);
    if (localIRecentUserMsgSerializeApi != null) {
      this.msgData = localIRecentUserMsgSerializeApi.recentUserMsgSerialize(this.msgType, this.msg);
    }
  }
  
  public void reParse()
  {
    if (!this.mIsParsed) {
      return;
    }
    this.mIsParsed = false;
    parse();
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
  
  public String toString()
  {
    return "RecentUser{uin='" + this.uin + '\'' + ", type=" + this.type + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.RecentUser
 * JD-Core Version:    0.7.0.1
 */