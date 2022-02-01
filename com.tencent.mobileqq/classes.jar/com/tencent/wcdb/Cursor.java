package com.tencent.wcdb;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

public abstract interface Cursor
  extends android.database.Cursor
{
  public abstract void close();
  
  public abstract void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer);
  
  public abstract void deactivate();
  
  public abstract byte[] getBlob(int paramInt);
  
  public abstract int getColumnCount();
  
  public abstract int getColumnIndex(String paramString);
  
  public abstract int getColumnIndexOrThrow(String paramString);
  
  public abstract String getColumnName(int paramInt);
  
  public abstract String[] getColumnNames();
  
  public abstract int getCount();
  
  public abstract double getDouble(int paramInt);
  
  public abstract Bundle getExtras();
  
  public abstract float getFloat(int paramInt);
  
  public abstract int getInt(int paramInt);
  
  public abstract long getLong(int paramInt);
  
  public abstract int getPosition();
  
  public abstract short getShort(int paramInt);
  
  public abstract String getString(int paramInt);
  
  public abstract int getType(int paramInt);
  
  public abstract boolean getWantsAllOnMoveCalls();
  
  public abstract boolean isAfterLast();
  
  public abstract boolean isBeforeFirst();
  
  public abstract boolean isClosed();
  
  public abstract boolean isFirst();
  
  public abstract boolean isLast();
  
  public abstract boolean isNull(int paramInt);
  
  public abstract boolean move(int paramInt);
  
  public abstract boolean moveToFirst();
  
  public abstract boolean moveToLast();
  
  public abstract boolean moveToNext();
  
  public abstract boolean moveToPosition(int paramInt);
  
  public abstract boolean moveToPrevious();
  
  public abstract void registerContentObserver(ContentObserver paramContentObserver);
  
  public abstract void registerDataSetObserver(DataSetObserver paramDataSetObserver);
  
  @Deprecated
  public abstract boolean requery();
  
  public abstract Bundle respond(Bundle paramBundle);
  
  public abstract void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri);
  
  public abstract void unregisterContentObserver(ContentObserver paramContentObserver);
  
  public abstract void unregisterDataSetObserver(DataSetObserver paramDataSetObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.Cursor
 * JD-Core Version:    0.7.0.1
 */