package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class OGAbstractDao
{
  public int columnLen;
  public boolean useIndex;
  
  public abstract Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler);
  
  public abstract void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues);
  
  public abstract String getCreateTableSql(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.OGAbstractDao
 * JD-Core Version:    0.7.0.1
 */