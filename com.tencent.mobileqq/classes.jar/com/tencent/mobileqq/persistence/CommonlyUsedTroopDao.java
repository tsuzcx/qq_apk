package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.CommonlyUsedTroop;

public class CommonlyUsedTroopDao
  extends OGAbstractDao
{
  public CommonlyUsedTroopDao()
  {
    this.a = 2;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (CommonlyUsedTroop)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramEntity.addedTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("addedTimestamp"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("troopUin");
    if (i == -1) {
      paramNoColumnErrorHandler.a(new NoColumnError("troopUin", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("addedTimestamp");
      if (i != -1) {
        break;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("addedTimestamp", Long.TYPE));
      return paramEntity;
      paramEntity.troopUin = paramCursor.getString(i);
    }
    paramEntity.addedTimestamp = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopUin TEXT UNIQUE ,addedTimestamp INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (CommonlyUsedTroop)paramEntity;
    paramContentValues.put("troopUin", paramEntity.troopUin);
    paramContentValues.put("addedTimestamp", Long.valueOf(paramEntity.addedTimestamp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.CommonlyUsedTroopDao
 * JD-Core Version:    0.7.0.1
 */