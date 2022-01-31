package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class OGAbstractDao
{
  public int a;
  public boolean a;
  
  public abstract Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler);
  
  public abstract String a(String paramString);
  
  public abstract void a(Entity paramEntity, ContentValues paramContentValues);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.OGAbstractDao
 * JD-Core Version:    0.7.0.1
 */