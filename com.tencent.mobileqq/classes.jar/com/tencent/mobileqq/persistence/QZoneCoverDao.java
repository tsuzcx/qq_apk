package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.QZoneCover;

public class QZoneCoverDao
  extends OGAbstractDao
{
  public QZoneCoverDao()
  {
    this.columnLen = 5;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (QZoneCover)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.type = paramCursor.getString(paramCursor.getColumnIndex("type"));
      paramEntity.jigsaw = paramCursor.getInt(paramCursor.getColumnIndex("jigsaw"));
      paramEntity.vCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vCoverInfo"));
      paramEntity.vPhotoInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vPhotoInfo"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
    } else {
      paramEntity.uin = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("type");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("type", String.class));
    } else {
      paramEntity.type = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("jigsaw");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("jigsaw", Integer.TYPE));
    } else {
      paramEntity.jigsaw = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("vCoverInfo");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vCoverInfo", [B.class));
    } else {
      paramEntity.vCoverInfo = paramCursor.getBlob(i);
    }
    i = paramCursor.getColumnIndex("vPhotoInfo");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vPhotoInfo", [B.class));
      return paramEntity;
    }
    paramEntity.vPhotoInfo = paramCursor.getBlob(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (QZoneCover)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("type", paramEntity.type);
    paramContentValues.put("jigsaw", Integer.valueOf(paramEntity.jigsaw));
    paramContentValues.put("vCoverInfo", paramEntity.vCoverInfo);
    paramContentValues.put("vPhotoInfo", paramEntity.vPhotoInfo);
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,type TEXT ,jigsaw INTEGER ,vCoverInfo BLOB ,vPhotoInfo BLOB)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.QZoneCoverDao
 * JD-Core Version:    0.7.0.1
 */