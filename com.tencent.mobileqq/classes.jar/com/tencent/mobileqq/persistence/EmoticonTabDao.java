package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.EmoticonTab;

public class EmoticonTabDao
  extends OGAbstractDao
{
  public EmoticonTabDao()
  {
    this.a = 3;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (EmoticonTab)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("aioHave")))
      {
        paramBoolean = true;
        paramEntity.aioHave = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("kandianHave"))) {
          break label92;
        }
      }
      label92:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.kandianHave = paramBoolean;
        return paramEntity;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("epId");
    if (i == -1) {
      paramNoColumnErrorHandler.a(new NoColumnError("epId", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("aioHave");
      if (i != -1) {
        break;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("aioHave", Boolean.TYPE));
      i = paramCursor.getColumnIndex("kandianHave");
      if (i != -1) {
        break label245;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("kandianHave", Boolean.TYPE));
      return paramEntity;
      paramEntity.epId = paramCursor.getString(i);
    }
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramEntity.aioHave = paramBoolean;
      break;
    }
    label245:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramEntity.kandianHave = paramBoolean;
      return paramEntity;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,epId TEXT UNIQUE ,aioHave INTEGER ,kandianHave INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (EmoticonTab)paramEntity;
    paramContentValues.put("epId", paramEntity.epId);
    paramContentValues.put("aioHave", Boolean.valueOf(paramEntity.aioHave));
    paramContentValues.put("kandianHave", Boolean.valueOf(paramEntity.kandianHave));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.EmoticonTabDao
 * JD-Core Version:    0.7.0.1
 */