package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ShieldListInfo;

public class ShieldListInfoDao
  extends OGAbstractDao
{
  public ShieldListInfoDao()
  {
    this.a = 4;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (ShieldListInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      paramEntity.source_id = paramCursor.getInt(paramCursor.getColumnIndex("source_id"));
      paramEntity.source_sub_id = paramCursor.getInt(paramCursor.getColumnIndex("source_sub_id"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("flags");
      if (i != -1) {
        break label240;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("flags", Integer.TYPE));
      label153:
      i = paramCursor.getColumnIndex("source_id");
      if (i != -1) {
        break label255;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("source_id", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("source_sub_id");
      if (i != -1) {
        break label270;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("source_sub_id", Integer.TYPE));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label240:
      paramEntity.flags = paramCursor.getInt(i);
      break label153;
      label255:
      paramEntity.source_id = paramCursor.getInt(i);
    }
    label270:
    paramEntity.source_sub_id = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,flags INTEGER ,source_id INTEGER ,source_sub_id INTEGER,UNIQUE(uin) ON CONFLICT REPLACE)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (ShieldListInfo)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("flags", Integer.valueOf(paramEntity.flags));
    paramContentValues.put("source_id", Integer.valueOf(paramEntity.source_id));
    paramContentValues.put("source_sub_id", Integer.valueOf(paramEntity.source_sub_id));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.ShieldListInfoDao
 * JD-Core Version:    0.7.0.1
 */