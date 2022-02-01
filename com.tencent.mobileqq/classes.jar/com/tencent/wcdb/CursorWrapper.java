package com.tencent.wcdb;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

public class CursorWrapper
  implements Cursor
{
  protected final Cursor a;
  
  public void close()
  {
    this.a.close();
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    this.a.copyStringToBuffer(paramInt, paramCharArrayBuffer);
  }
  
  public void deactivate()
  {
    this.a.deactivate();
  }
  
  public byte[] getBlob(int paramInt)
  {
    return this.a.getBlob(paramInt);
  }
  
  public int getColumnCount()
  {
    return this.a.getColumnCount();
  }
  
  public int getColumnIndex(String paramString)
  {
    return this.a.getColumnIndex(paramString);
  }
  
  public int getColumnIndexOrThrow(String paramString)
  {
    return this.a.getColumnIndexOrThrow(paramString);
  }
  
  public String getColumnName(int paramInt)
  {
    return this.a.getColumnName(paramInt);
  }
  
  public String[] getColumnNames()
  {
    return this.a.getColumnNames();
  }
  
  public int getCount()
  {
    return this.a.getCount();
  }
  
  public double getDouble(int paramInt)
  {
    return this.a.getDouble(paramInt);
  }
  
  public Bundle getExtras()
  {
    return this.a.getExtras();
  }
  
  public float getFloat(int paramInt)
  {
    return this.a.getFloat(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    return this.a.getInt(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    return this.a.getLong(paramInt);
  }
  
  public Uri getNotificationUri()
  {
    return null;
  }
  
  public int getPosition()
  {
    return this.a.getPosition();
  }
  
  public short getShort(int paramInt)
  {
    return this.a.getShort(paramInt);
  }
  
  public String getString(int paramInt)
  {
    return this.a.getString(paramInt);
  }
  
  public int getType(int paramInt)
  {
    return this.a.getType(paramInt);
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    return this.a.getWantsAllOnMoveCalls();
  }
  
  public boolean isAfterLast()
  {
    return this.a.isAfterLast();
  }
  
  public boolean isBeforeFirst()
  {
    return this.a.isBeforeFirst();
  }
  
  public boolean isClosed()
  {
    return this.a.isClosed();
  }
  
  public boolean isFirst()
  {
    return this.a.isFirst();
  }
  
  public boolean isLast()
  {
    return this.a.isLast();
  }
  
  public boolean isNull(int paramInt)
  {
    return this.a.isNull(paramInt);
  }
  
  public boolean move(int paramInt)
  {
    return this.a.move(paramInt);
  }
  
  public boolean moveToFirst()
  {
    return this.a.moveToFirst();
  }
  
  public boolean moveToLast()
  {
    return this.a.moveToLast();
  }
  
  public boolean moveToNext()
  {
    return this.a.moveToNext();
  }
  
  public boolean moveToPosition(int paramInt)
  {
    return this.a.moveToPosition(paramInt);
  }
  
  public boolean moveToPrevious()
  {
    return this.a.moveToPrevious();
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver)
  {
    this.a.registerContentObserver(paramContentObserver);
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.registerDataSetObserver(paramDataSetObserver);
  }
  
  public boolean requery()
  {
    return this.a.requery();
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    return this.a.respond(paramBundle);
  }
  
  public void setExtras(Bundle paramBundle) {}
  
  public void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
  {
    this.a.setNotificationUri(paramContentResolver, paramUri);
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    this.a.unregisterContentObserver(paramContentObserver);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.unregisterDataSetObserver(paramDataSetObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.CursorWrapper
 * JD-Core Version:    0.7.0.1
 */