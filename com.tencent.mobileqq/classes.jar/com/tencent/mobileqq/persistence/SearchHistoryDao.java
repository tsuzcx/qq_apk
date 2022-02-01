package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.SearchHistory;

public class SearchHistoryDao
  extends OGAbstractDao
{
  public SearchHistoryDao()
  {
    this.columnLen = 8;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (SearchHistory)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.key = paramCursor.getString(paramCursor.getColumnIndex("key"));
      paramEntity.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramEntity.displayName = paramCursor.getString(paramCursor.getColumnIndex("displayName"));
      paramEntity.extralInfo = paramCursor.getString(paramCursor.getColumnIndex("extralInfo"));
      paramEntity.count = paramCursor.getInt(paramCursor.getColumnIndex("count"));
      paramEntity.time = paramCursor.getLong(paramCursor.getColumnIndex("time"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("key");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("key", String.class));
    } else {
      paramEntity.key = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("type");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("type", Integer.TYPE));
    } else {
      paramEntity.type = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("uin");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
    } else {
      paramEntity.uin = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("troopUin");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopUin", String.class));
    } else {
      paramEntity.troopUin = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("displayName");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("displayName", String.class));
    } else {
      paramEntity.displayName = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("extralInfo");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extralInfo", String.class));
    } else {
      paramEntity.extralInfo = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("count");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("count", Integer.TYPE));
    } else {
      paramEntity.count = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("time");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("time", Long.TYPE));
      return paramEntity;
    }
    paramEntity.time = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (SearchHistory)paramEntity;
    paramContentValues.put("key", paramEntity.key);
    paramContentValues.put("type", Integer.valueOf(paramEntity.type));
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("troopUin", paramEntity.troopUin);
    paramContentValues.put("displayName", paramEntity.displayName);
    paramContentValues.put("extralInfo", paramEntity.extralInfo);
    paramContentValues.put("count", Integer.valueOf(paramEntity.count));
    paramContentValues.put("time", Long.valueOf(paramEntity.time));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,key TEXT UNIQUE ,type INTEGER ,uin TEXT ,troopUin TEXT ,displayName TEXT ,extralInfo TEXT ,count INTEGER ,time INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.SearchHistoryDao
 * JD-Core Version:    0.7.0.1
 */