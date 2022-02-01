package com.tencent.mobileqq.qcircle.api.db;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.qcircle.api.db.util.EncryptUtil;

public class DbSafeCursorWrapper
  extends CursorWrapper
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public DbSafeCursorWrapper(Cursor paramCursor, String paramString)
  {
    super(paramCursor);
    this.jdField_a_of_type_JavaLangString = paramString;
    boolean bool;
    if (paramCursor != null) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
  }
  
  private void a(Throwable paramThrowable)
  {
    DbCacheExceptionHandler.a().a(paramThrowable, this.jdField_a_of_type_JavaLangString);
  }
  
  public void close()
  {
    try
    {
      super.close();
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    try
    {
      super.copyStringToBuffer(paramInt, paramCharArrayBuffer);
      return;
    }
    catch (Throwable paramCharArrayBuffer)
    {
      a(paramCharArrayBuffer);
    }
  }
  
  public void deactivate()
  {
    try
    {
      super.deactivate();
      return;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
  }
  
  public byte[] getBlob(int paramInt)
  {
    try
    {
      byte[] arrayOfByte = super.getBlob(paramInt);
      return arrayOfByte;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return null;
  }
  
  public int getColumnCount()
  {
    try
    {
      int i = super.getColumnCount();
      return i;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return 0;
  }
  
  public int getColumnIndex(String paramString)
  {
    try
    {
      int i = super.getColumnIndex(paramString);
      return i;
    }
    catch (Throwable paramString)
    {
      a(paramString);
    }
    return -1;
  }
  
  public int getColumnIndexOrThrow(String paramString)
  {
    try
    {
      int i = super.getColumnIndexOrThrow(paramString);
      return i;
    }
    catch (Throwable paramString)
    {
      a(paramString);
    }
    return -1;
  }
  
  public String getColumnName(int paramInt)
  {
    try
    {
      String str = super.getColumnName(paramInt);
      return str;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return null;
  }
  
  public String[] getColumnNames()
  {
    try
    {
      String[] arrayOfString = super.getColumnNames();
      return arrayOfString;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return null;
  }
  
  public int getCount()
  {
    try
    {
      int i = super.getCount();
      return i;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return 0;
  }
  
  public double getDouble(int paramInt)
  {
    try
    {
      double d = Double.parseDouble(EncryptUtil.b(super.getString(paramInt)));
      return d;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return 0.0D;
  }
  
  public Bundle getExtras()
  {
    try
    {
      Bundle localBundle = super.getExtras();
      return localBundle;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return null;
  }
  
  public float getFloat(int paramInt)
  {
    try
    {
      float f = Float.parseFloat(EncryptUtil.b(super.getString(paramInt)));
      return f;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return 0.0F;
  }
  
  public int getInt(int paramInt)
  {
    try
    {
      String str = EncryptUtil.b(super.getString(paramInt));
      if (TextUtils.isEmpty(str)) {
        return 0;
      }
      paramInt = Integer.parseInt(str);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return 0;
  }
  
  public long getLong(int paramInt)
  {
    try
    {
      long l = Long.parseLong(EncryptUtil.b(super.getString(paramInt)));
      return l;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return 0L;
  }
  
  public int getPosition()
  {
    try
    {
      int i = super.getPosition();
      return i;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return -1;
  }
  
  public short getShort(int paramInt)
  {
    try
    {
      short s = super.getShort(paramInt);
      return s;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return 0;
  }
  
  public String getString(int paramInt)
  {
    try
    {
      String str = EncryptUtil.b(super.getString(paramInt));
      return str;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return null;
  }
  
  @SuppressLint({"NewApi"})
  public int getType(int paramInt)
  {
    try
    {
      paramInt = super.getType(paramInt);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return 0;
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    try
    {
      boolean bool = super.getWantsAllOnMoveCalls();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return false;
  }
  
  public boolean isAfterLast()
  {
    try
    {
      boolean bool = super.isAfterLast();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return false;
  }
  
  public boolean isBeforeFirst()
  {
    try
    {
      boolean bool = super.isBeforeFirst();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return false;
  }
  
  public boolean isClosed()
  {
    try
    {
      boolean bool = super.isClosed();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean isFirst()
  {
    try
    {
      boolean bool = super.isFirst();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return false;
  }
  
  public boolean isLast()
  {
    try
    {
      boolean bool = super.isLast();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return false;
  }
  
  public boolean isNull(int paramInt)
  {
    try
    {
      boolean bool = super.isNull(paramInt);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return true;
  }
  
  public boolean move(int paramInt)
  {
    try
    {
      boolean bool = super.move(paramInt);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return false;
  }
  
  public boolean moveToFirst()
  {
    try
    {
      boolean bool = super.moveToFirst();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return false;
  }
  
  public boolean moveToLast()
  {
    try
    {
      boolean bool = super.moveToLast();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return false;
  }
  
  public boolean moveToNext()
  {
    try
    {
      boolean bool = super.moveToNext();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return false;
  }
  
  public boolean moveToPosition(int paramInt)
  {
    try
    {
      boolean bool = super.moveToPosition(paramInt);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return false;
  }
  
  public boolean moveToPrevious()
  {
    try
    {
      boolean bool = super.moveToPrevious();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return false;
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver)
  {
    try
    {
      super.registerContentObserver(paramContentObserver);
      return;
    }
    catch (Throwable paramContentObserver)
    {
      a(paramContentObserver);
    }
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    try
    {
      super.registerDataSetObserver(paramDataSetObserver);
      return;
    }
    catch (Throwable paramDataSetObserver)
    {
      a(paramDataSetObserver);
    }
  }
  
  public boolean requery()
  {
    try
    {
      boolean bool = super.requery();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return false;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    try
    {
      paramBundle = super.respond(paramBundle);
      return paramBundle;
    }
    catch (Throwable paramBundle)
    {
      a(paramBundle);
    }
    return null;
  }
  
  public void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
  {
    try
    {
      super.setNotificationUri(paramContentResolver, paramUri);
      return;
    }
    catch (Throwable paramContentResolver)
    {
      a(paramContentResolver);
    }
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    try
    {
      super.unregisterContentObserver(paramContentObserver);
      return;
    }
    catch (Throwable paramContentObserver)
    {
      a(paramContentObserver);
    }
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    try
    {
      super.unregisterDataSetObserver(paramDataSetObserver);
      return;
    }
    catch (Throwable paramDataSetObserver)
    {
      a(paramDataSetObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.DbSafeCursorWrapper
 * JD-Core Version:    0.7.0.1
 */