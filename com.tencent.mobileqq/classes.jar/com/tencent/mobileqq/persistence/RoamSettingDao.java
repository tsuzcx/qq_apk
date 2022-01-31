package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.RoamSetting;

public class RoamSettingDao
  extends OGAbstractDao
{
  public RoamSettingDao()
  {
    this.a = 2;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (RoamSetting)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.path = paramCursor.getString(paramCursor.getColumnIndex("path"));
      paramEntity.value = paramCursor.getString(paramCursor.getColumnIndex("value"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("path");
    if (i == -1) {
      paramNoColumnErrorHandler.a(new NoColumnError("path", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("value");
      if (i != -1) {
        break;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("value", String.class));
      return paramEntity;
      paramEntity.path = paramCursor.getString(i);
    }
    paramEntity.value = paramCursor.getString(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,path TEXT UNIQUE ,value TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (RoamSetting)paramEntity;
    paramContentValues.put("path", paramEntity.path);
    paramContentValues.put("value", paramEntity.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.RoamSettingDao
 * JD-Core Version:    0.7.0.1
 */