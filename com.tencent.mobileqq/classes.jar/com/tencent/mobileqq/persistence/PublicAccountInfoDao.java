package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.PublicAccountInfo;

public class PublicAccountInfoDao
  extends OGAbstractDao
{
  public PublicAccountInfoDao()
  {
    this.columnLen = 24;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (PublicAccountInfo)paramEntity;
    boolean bool = true;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getLong(paramCursor.getColumnIndex("uin"));
      paramEntity.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramEntity.displayNumber = paramCursor.getString(paramCursor.getColumnIndex("displayNumber"));
      paramEntity.summary = paramCursor.getString(paramCursor.getColumnIndex("summary"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isRecvMsg"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isRecvMsg = paramBoolean;
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isRecvPush"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isRecvPush = paramBoolean;
      paramEntity.clickCount = paramCursor.getInt(paramCursor.getColumnIndex("clickCount"));
      paramEntity.certifiedGrade = paramCursor.getLong(paramCursor.getColumnIndex("certifiedGrade"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isSyncLbs"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isSyncLbs = paramBoolean;
      paramEntity.showFlag = paramCursor.getInt(paramCursor.getColumnIndex("showFlag"));
      paramEntity.mShowMsgFlag = paramCursor.getInt(paramCursor.getColumnIndex("mShowMsgFlag"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("mIsAgreeSyncLbs"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.mIsAgreeSyncLbs = paramBoolean;
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("mIsSyncLbsSelected"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.mIsSyncLbsSelected = paramBoolean;
      paramEntity.dateTime = paramCursor.getLong(paramCursor.getColumnIndex("dateTime"));
      paramEntity.accountFlag = paramCursor.getInt(paramCursor.getColumnIndex("accountFlag"));
      paramEntity.accountFlag2 = paramCursor.getLong(paramCursor.getColumnIndex("accountFlag2"));
      paramEntity.eqqAccountFlag = paramCursor.getLong(paramCursor.getColumnIndex("eqqAccountFlag"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isShieldMsg"))) {
        paramBoolean = bool;
      } else {
        paramBoolean = false;
      }
      paramEntity.isShieldMsg = paramBoolean;
      paramEntity.messageSettingFlag = paramCursor.getInt(paramCursor.getColumnIndex("messageSettingFlag"));
      paramEntity.extendType = paramCursor.getInt(paramCursor.getColumnIndex("extendType"));
      paramEntity.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
      paramEntity.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
      paramEntity.logo = paramCursor.getString(paramCursor.getColumnIndex("logo"));
      paramEntity.lastAIOReadTime = paramCursor.getLong(paramCursor.getColumnIndex("lastAIOReadTime"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", Long.TYPE));
    } else {
      paramEntity.uin = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("name");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("name", String.class));
    } else {
      paramEntity.name = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("displayNumber");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("displayNumber", String.class));
    } else {
      paramEntity.displayNumber = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("summary");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("summary", String.class));
    } else {
      paramEntity.summary = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("isRecvMsg");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isRecvMsg", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isRecvMsg = paramBoolean;
    }
    i = paramCursor.getColumnIndex("isRecvPush");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isRecvPush", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isRecvPush = paramBoolean;
    }
    i = paramCursor.getColumnIndex("clickCount");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("clickCount", Integer.TYPE));
    } else {
      paramEntity.clickCount = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("certifiedGrade");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("certifiedGrade", Long.TYPE));
    } else {
      paramEntity.certifiedGrade = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("isSyncLbs");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isSyncLbs", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isSyncLbs = paramBoolean;
    }
    i = paramCursor.getColumnIndex("showFlag");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showFlag", Integer.TYPE));
    } else {
      paramEntity.showFlag = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("mShowMsgFlag");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mShowMsgFlag", Integer.TYPE));
    } else {
      paramEntity.mShowMsgFlag = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("mIsAgreeSyncLbs");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mIsAgreeSyncLbs", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.mIsAgreeSyncLbs = paramBoolean;
    }
    i = paramCursor.getColumnIndex("mIsSyncLbsSelected");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mIsSyncLbsSelected", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.mIsSyncLbsSelected = paramBoolean;
    }
    i = paramCursor.getColumnIndex("dateTime");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dateTime", Long.TYPE));
    } else {
      paramEntity.dateTime = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("accountFlag");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("accountFlag", Integer.TYPE));
    } else {
      paramEntity.accountFlag = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("accountFlag2");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("accountFlag2", Long.TYPE));
    } else {
      paramEntity.accountFlag2 = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("eqqAccountFlag");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("eqqAccountFlag", Long.TYPE));
    } else {
      paramEntity.eqqAccountFlag = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("isShieldMsg");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isShieldMsg", Boolean.TYPE));
    }
    else
    {
      i = paramCursor.getShort(i);
      paramBoolean = true;
      if (1 != i) {
        paramBoolean = false;
      }
      paramEntity.isShieldMsg = paramBoolean;
    }
    i = paramCursor.getColumnIndex("messageSettingFlag");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("messageSettingFlag", Integer.TYPE));
    } else {
      paramEntity.messageSettingFlag = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("extendType");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendType", Integer.TYPE));
    } else {
      paramEntity.extendType = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("mComparePartInt");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mComparePartInt", Integer.TYPE));
    } else {
      paramEntity.mComparePartInt = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("mCompareSpell");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mCompareSpell", String.class));
    } else {
      paramEntity.mCompareSpell = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("logo");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("logo", String.class));
    } else {
      paramEntity.logo = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("lastAIOReadTime");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastAIOReadTime", Long.TYPE));
      return paramEntity;
    }
    paramEntity.lastAIOReadTime = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (PublicAccountInfo)paramEntity;
    paramContentValues.put("uin", Long.valueOf(paramEntity.uin));
    paramContentValues.put("name", paramEntity.name);
    paramContentValues.put("displayNumber", paramEntity.displayNumber);
    paramContentValues.put("summary", paramEntity.summary);
    paramContentValues.put("isRecvMsg", Boolean.valueOf(paramEntity.isRecvMsg));
    paramContentValues.put("isRecvPush", Boolean.valueOf(paramEntity.isRecvPush));
    paramContentValues.put("clickCount", Integer.valueOf(paramEntity.clickCount));
    paramContentValues.put("certifiedGrade", Long.valueOf(paramEntity.certifiedGrade));
    paramContentValues.put("isSyncLbs", Boolean.valueOf(paramEntity.isSyncLbs));
    paramContentValues.put("showFlag", Integer.valueOf(paramEntity.showFlag));
    paramContentValues.put("mShowMsgFlag", Integer.valueOf(paramEntity.mShowMsgFlag));
    paramContentValues.put("mIsAgreeSyncLbs", Boolean.valueOf(paramEntity.mIsAgreeSyncLbs));
    paramContentValues.put("mIsSyncLbsSelected", Boolean.valueOf(paramEntity.mIsSyncLbsSelected));
    paramContentValues.put("dateTime", Long.valueOf(paramEntity.dateTime));
    paramContentValues.put("accountFlag", Integer.valueOf(paramEntity.accountFlag));
    paramContentValues.put("accountFlag2", Long.valueOf(paramEntity.accountFlag2));
    paramContentValues.put("eqqAccountFlag", Long.valueOf(paramEntity.eqqAccountFlag));
    paramContentValues.put("isShieldMsg", Boolean.valueOf(paramEntity.isShieldMsg));
    paramContentValues.put("messageSettingFlag", Integer.valueOf(paramEntity.messageSettingFlag));
    paramContentValues.put("extendType", Integer.valueOf(paramEntity.extendType));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramEntity.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramEntity.mCompareSpell);
    paramContentValues.put("logo", paramEntity.logo);
    paramContentValues.put("lastAIOReadTime", Long.valueOf(paramEntity.lastAIOReadTime));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin INTEGER UNIQUE ,name TEXT ,displayNumber TEXT ,summary TEXT ,isRecvMsg INTEGER ,isRecvPush INTEGER ,clickCount INTEGER ,certifiedGrade INTEGER ,isSyncLbs INTEGER ,showFlag INTEGER ,mShowMsgFlag INTEGER ,mIsAgreeSyncLbs INTEGER ,mIsSyncLbsSelected INTEGER ,dateTime INTEGER ,accountFlag INTEGER ,accountFlag2 INTEGER ,eqqAccountFlag INTEGER ,isShieldMsg INTEGER ,messageSettingFlag INTEGER ,extendType INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,logo TEXT ,lastAIOReadTime INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.PublicAccountInfoDao
 * JD-Core Version:    0.7.0.1
 */