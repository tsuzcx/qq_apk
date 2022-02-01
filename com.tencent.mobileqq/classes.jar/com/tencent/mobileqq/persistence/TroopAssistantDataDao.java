package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopAssistantData;

public class TroopAssistantDataDao
  extends OGAbstractDao
{
  public TroopAssistantDataDao()
  {
    this.columnLen = 3;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (TroopAssistantData)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramEntity.lastmsgtime = paramCursor.getLong(paramCursor.getColumnIndex("lastmsgtime"));
      paramEntity.lastdrafttime = paramCursor.getLong(paramCursor.getColumnIndex("lastdrafttime"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("troopUin");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopUin", String.class));
    } else {
      paramEntity.troopUin = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("lastmsgtime");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastmsgtime", Long.TYPE));
    } else {
      paramEntity.lastmsgtime = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("lastdrafttime");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastdrafttime", Long.TYPE));
      return paramEntity;
    }
    paramEntity.lastdrafttime = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (TroopAssistantData)paramEntity;
    paramContentValues.put("troopUin", paramEntity.troopUin);
    paramContentValues.put("lastmsgtime", Long.valueOf(paramEntity.lastmsgtime));
    paramContentValues.put("lastdrafttime", Long.valueOf(paramEntity.lastdrafttime));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopUin TEXT UNIQUE ,lastmsgtime INTEGER ,lastdrafttime INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.TroopAssistantDataDao
 * JD-Core Version:    0.7.0.1
 */