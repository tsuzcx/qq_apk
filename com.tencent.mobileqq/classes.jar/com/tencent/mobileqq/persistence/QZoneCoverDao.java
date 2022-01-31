package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.QZoneCover;

public class QZoneCoverDao
  extends OGAbstractDao
{
  public QZoneCoverDao()
  {
    this.a = 5;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
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
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label290;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("type", String.class));
      label170:
      i = paramCursor.getColumnIndex("jigsaw");
      if (i != -1) {
        break label305;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("jigsaw", Integer.TYPE));
      label205:
      i = paramCursor.getColumnIndex("vCoverInfo");
      if (i != -1) {
        break label320;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vCoverInfo", [B.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("vPhotoInfo");
      if (i != -1) {
        break label335;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vPhotoInfo", [B.class));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label290:
      paramEntity.type = paramCursor.getString(i);
      break label170;
      label305:
      paramEntity.jigsaw = paramCursor.getInt(i);
      break label205;
      label320:
      paramEntity.vCoverInfo = paramCursor.getBlob(i);
    }
    label335:
    paramEntity.vPhotoInfo = paramCursor.getBlob(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,type TEXT ,jigsaw INTEGER ,vCoverInfo BLOB ,vPhotoInfo BLOB)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (QZoneCover)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("type", paramEntity.type);
    paramContentValues.put("jigsaw", Integer.valueOf(paramEntity.jigsaw));
    paramContentValues.put("vCoverInfo", paramEntity.vCoverInfo);
    paramContentValues.put("vPhotoInfo", paramEntity.vPhotoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.QZoneCoverDao
 * JD-Core Version:    0.7.0.1
 */