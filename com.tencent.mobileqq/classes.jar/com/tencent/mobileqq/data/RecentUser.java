package com.tencent.mobileqq.data;

import alkr;
import alku;
import alkv;
import android.database.Cursor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.defaultzero;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.FAIL, columnNames="uin,type")
public class RecentUser
  extends BaseRecentUser
{
  public static final long FLAG_HOTCHAT = 1L;
  public static final long FLAG_PA_AD = 16L;
  public static final String TABLE_NAME = "recent";
  private static final String TAG = "RecentUser";
  @notColumn
  public Object extraInfo;
  @defaultzero
  public long lFlag;
  public byte[] parceledRecentBaseData;
  
  @Deprecated
  public RecentUser() {}
  
  public RecentUser(String paramString, int paramInt)
  {
    this.uin = paramString;
    this.type = paramInt;
  }
  
  public void doParse()
  {
    this.msg = alkv.a(this.msgType, this.msgData);
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
  
  public void prewrite()
  {
    this.msgData = alkv.a(this.msgType, this.msg);
    super.prewrite();
  }
  
  public boolean shouldShowInRecentList(QQAppInterface paramQQAppInterface)
  {
    if (this.msgType == 1) {
      return true;
    }
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = ((alku)paramQQAppInterface.getManager(QQManagerFactory.RECENT_USER)).a(this.msgType);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.a();
      }
    }
    return false;
  }
  
  public String toString()
  {
    return "RecentUser{uin='" + this.uin + '\'' + ", type=" + this.type + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.RecentUser
 * JD-Core Version:    0.7.0.1
 */