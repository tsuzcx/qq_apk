package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ShieldListInfo;

public class ShieldListInfoDao
  extends OGAbstractDao
{
  public ShieldListInfoDao()
  {
    this.columnLen = 4;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
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
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
    } else {
      paramEntity.uin = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("flags");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("flags", Integer.TYPE));
    } else {
      paramEntity.flags = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("source_id");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("source_id", Integer.TYPE));
    } else {
      paramEntity.source_id = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("source_sub_id");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("source_sub_id", Integer.TYPE));
      return paramEntity;
    }
    paramEntity.source_sub_id = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (ShieldListInfo)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("flags", Integer.valueOf(paramEntity.flags));
    paramContentValues.put("source_id", Integer.valueOf(paramEntity.source_id));
    paramContentValues.put("source_sub_id", Integer.valueOf(paramEntity.source_sub_id));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,flags INTEGER ,source_id INTEGER ,source_sub_id INTEGER,UNIQUE(uin) ON CONFLICT REPLACE)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.ShieldListInfoDao
 * JD-Core Version:    0.7.0.1
 */