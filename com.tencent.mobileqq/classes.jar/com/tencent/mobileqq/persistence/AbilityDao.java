package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Ability;

public class AbilityDao
  extends OGAbstractDao
{
  public AbilityDao()
  {
    this.a = 2;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (Ability)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1) {
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("flags");
      if (i != -1) {
        break;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("flags", Integer.TYPE));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
    }
    paramEntity.flags = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,flags INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (Ability)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("flags", Integer.valueOf(paramEntity.flags));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.AbilityDao
 * JD-Core Version:    0.7.0.1
 */