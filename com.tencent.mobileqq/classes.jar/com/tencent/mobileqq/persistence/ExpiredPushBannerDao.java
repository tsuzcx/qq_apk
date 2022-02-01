package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ExpiredPushBanner;

public class ExpiredPushBannerDao
  extends OGAbstractDao
{
  public ExpiredPushBannerDao()
  {
    this.columnLen = 3;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (ExpiredPushBanner)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.cid = paramCursor.getLong(paramCursor.getColumnIndex("cid"));
      paramEntity.md5 = paramCursor.getString(paramCursor.getColumnIndex("md5"));
      paramEntity.endtime = paramCursor.getLong(paramCursor.getColumnIndex("endtime"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("cid");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cid", Long.TYPE));
    } else {
      paramEntity.cid = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("md5");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("md5", String.class));
    } else {
      paramEntity.md5 = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("endtime");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("endtime", Long.TYPE));
      return paramEntity;
    }
    paramEntity.endtime = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (ExpiredPushBanner)paramEntity;
    paramContentValues.put("cid", Long.valueOf(paramEntity.cid));
    paramContentValues.put("md5", paramEntity.md5);
    paramContentValues.put("endtime", Long.valueOf(paramEntity.endtime));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,cid INTEGER UNIQUE ,md5 TEXT ,endtime INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.ExpiredPushBannerDao
 * JD-Core Version:    0.7.0.1
 */