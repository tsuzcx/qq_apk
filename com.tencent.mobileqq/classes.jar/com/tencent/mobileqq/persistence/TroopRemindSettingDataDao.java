package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopRemindSettingData;

public class TroopRemindSettingDataDao
  extends OGAbstractDao
{
  public TroopRemindSettingDataDao()
  {
    this.a = 2;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (TroopRemindSettingData)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramEntity.isOpenState = paramCursor.getInt(paramCursor.getColumnIndex("isOpenState"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("troopUin");
    if (i == -1) {
      paramNoColumnErrorHandler.a(new NoColumnError("troopUin", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("isOpenState");
      if (i != -1) {
        break;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isOpenState", Integer.TYPE));
      return paramEntity;
      paramEntity.troopUin = paramCursor.getString(i);
    }
    paramEntity.isOpenState = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopUin TEXT UNIQUE ,isOpenState INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (TroopRemindSettingData)paramEntity;
    paramContentValues.put("troopUin", paramEntity.troopUin);
    paramContentValues.put("isOpenState", Integer.valueOf(paramEntity.isOpenState));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.TroopRemindSettingDataDao
 * JD-Core Version:    0.7.0.1
 */