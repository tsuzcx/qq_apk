package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ExpiredPushBanner;

public class ExpiredPushBannerDao
  extends OGAbstractDao
{
  public ExpiredPushBannerDao()
  {
    this.a = 3;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
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
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("cid", Long.TYPE));
      i = paramCursor.getColumnIndex("md5");
      if (i != -1) {
        break label187;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("md5", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("endtime");
      if (i != -1) {
        break label202;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("endtime", Long.TYPE));
      return paramEntity;
      paramEntity.cid = paramCursor.getLong(i);
      break;
      label187:
      paramEntity.md5 = paramCursor.getString(i);
    }
    label202:
    paramEntity.endtime = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,cid INTEGER UNIQUE ,md5 TEXT ,endtime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (ExpiredPushBanner)paramEntity;
    paramContentValues.put("cid", Long.valueOf(paramEntity.cid));
    paramContentValues.put("md5", paramEntity.md5);
    paramContentValues.put("endtime", Long.valueOf(paramEntity.endtime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.ExpiredPushBannerDao
 * JD-Core Version:    0.7.0.1
 */