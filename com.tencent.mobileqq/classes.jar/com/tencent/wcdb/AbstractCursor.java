package com.tencent.wcdb;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.wcdb.support.Log;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCursor
  implements CrossProcessCursor
{
  @Deprecated
  protected HashMap<Long, Map<String, Object>> a = new HashMap();
  protected int b = -1;
  @Deprecated
  protected int c = -1;
  @Deprecated
  protected Long d = null;
  protected boolean e;
  protected ContentResolver f;
  private Uri g;
  private final Object h = new Object();
  private ContentObserver i;
  private boolean j;
  private final DataSetObservable k = new DataSetObservable();
  private final ContentObservable l = new ContentObservable();
  private Bundle m = Bundle.EMPTY;
  
  public CursorWindow a()
  {
    return null;
  }
  
  public void a(int paramInt, CursorWindow paramCursorWindow)
  {
    DatabaseUtils.a(this, paramInt, paramCursorWindow);
  }
  
  protected void a(boolean paramBoolean)
  {
    synchronized (this.h)
    {
      this.l.dispatchChange(paramBoolean);
      if ((this.g != null) && (paramBoolean)) {
        this.f.notifyChange(this.g, this.i);
      }
      return;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  protected void b()
  {
    ContentObserver localContentObserver = this.i;
    if (localContentObserver != null)
    {
      this.f.unregisterContentObserver(localContentObserver);
      this.j = false;
    }
    this.k.notifyInvalidated();
  }
  
  protected void c()
  {
    if ((-1 != this.b) && (getCount() != this.b)) {
      return;
    }
    throw new CursorIndexOutOfBoundsException(this.b, getCount());
  }
  
  public void close()
  {
    this.e = true;
    this.l.unregisterAll();
    b();
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    String str = getString(paramInt);
    if (str != null)
    {
      char[] arrayOfChar = paramCharArrayBuffer.data;
      if ((arrayOfChar != null) && (arrayOfChar.length >= str.length())) {
        str.getChars(0, str.length(), arrayOfChar, 0);
      } else {
        paramCharArrayBuffer.data = str.toCharArray();
      }
      paramCharArrayBuffer.sizeCopied = str.length();
      return;
    }
    paramCharArrayBuffer.sizeCopied = 0;
  }
  
  public void deactivate()
  {
    b();
  }
  
  protected void finalize()
  {
    ContentObserver localContentObserver = this.i;
    if ((localContentObserver != null) && (this.j == true)) {
      this.f.unregisterContentObserver(localContentObserver);
    }
    try
    {
      if (!this.e) {
        close();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public byte[] getBlob(int paramInt)
  {
    throw new UnsupportedOperationException("getBlob is not supported");
  }
  
  public int getColumnCount()
  {
    return getColumnNames().length;
  }
  
  public int getColumnIndex(String paramString)
  {
    int i1 = paramString.lastIndexOf('.');
    int n = 0;
    Object localObject = paramString;
    if (i1 != -1)
    {
      localObject = new Exception();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requesting column name with table name -- ");
      localStringBuilder.append(paramString);
      Log.a("Cursor", localStringBuilder.toString(), new Object[] { localObject });
      localObject = paramString.substring(i1 + 1);
    }
    paramString = getColumnNames();
    i1 = paramString.length;
    while (n < i1)
    {
      if (paramString[n].equalsIgnoreCase((String)localObject)) {
        return n;
      }
      n += 1;
    }
    return -1;
  }
  
  public int getColumnIndexOrThrow(String paramString)
  {
    int n = getColumnIndex(paramString);
    if (n >= 0) {
      return n;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("column '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("' does not exist");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public String getColumnName(int paramInt)
  {
    return getColumnNames()[paramInt];
  }
  
  public abstract String[] getColumnNames();
  
  public abstract int getCount();
  
  public Bundle getExtras()
  {
    return this.m;
  }
  
  public abstract long getLong(int paramInt);
  
  public Uri getNotificationUri()
  {
    return this.g;
  }
  
  public final int getPosition()
  {
    return this.b;
  }
  
  public abstract String getString(int paramInt);
  
  public int getType(int paramInt)
  {
    return 3;
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    return false;
  }
  
  public final boolean isAfterLast()
  {
    if (getCount() == 0) {
      return true;
    }
    return this.b == getCount();
  }
  
  public final boolean isBeforeFirst()
  {
    if (getCount() == 0) {
      return true;
    }
    return this.b == -1;
  }
  
  public boolean isClosed()
  {
    return this.e;
  }
  
  public final boolean isFirst()
  {
    return (this.b == 0) && (getCount() != 0);
  }
  
  public final boolean isLast()
  {
    int n = getCount();
    return (this.b == n - 1) && (n != 0);
  }
  
  public final boolean move(int paramInt)
  {
    return moveToPosition(this.b + paramInt);
  }
  
  public final boolean moveToFirst()
  {
    return moveToPosition(0);
  }
  
  public final boolean moveToLast()
  {
    return moveToPosition(getCount() - 1);
  }
  
  public final boolean moveToNext()
  {
    return moveToPosition(this.b + 1);
  }
  
  public boolean moveToPosition(int paramInt)
  {
    int n = getCount();
    if (paramInt >= n)
    {
      this.b = n;
      return false;
    }
    if (paramInt < 0)
    {
      this.b = -1;
      return false;
    }
    n = this.b;
    if (paramInt == n) {
      return true;
    }
    boolean bool = a(n, paramInt);
    if (!bool)
    {
      this.b = -1;
      return bool;
    }
    this.b = paramInt;
    paramInt = this.c;
    if (paramInt != -1) {
      this.d = Long.valueOf(getLong(paramInt));
    }
    return bool;
  }
  
  public final boolean moveToPrevious()
  {
    return moveToPosition(this.b - 1);
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver)
  {
    this.l.registerObserver(paramContentObserver);
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.k.registerObserver(paramDataSetObserver);
  }
  
  public boolean requery()
  {
    ContentObserver localContentObserver = this.i;
    if ((localContentObserver != null) && (!this.j))
    {
      this.f.registerContentObserver(this.g, true, localContentObserver);
      this.j = true;
    }
    this.k.notifyChanged();
    return true;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    return Bundle.EMPTY;
  }
  
  public void setExtras(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = Bundle.EMPTY;
    }
    this.m = localBundle;
  }
  
  public void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
  {
    synchronized (this.h)
    {
      this.g = paramUri;
      this.f = paramContentResolver;
      if (this.i != null) {
        this.f.unregisterContentObserver(this.i);
      }
      this.i = new AbstractCursor.SelfContentObserver(this);
      this.f.registerContentObserver(this.g, true, this.i);
      this.j = true;
      return;
    }
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    if (!this.e) {
      this.l.unregisterObserver(paramContentObserver);
    }
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.k.unregisterObserver(paramDataSetObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.AbstractCursor
 * JD-Core Version:    0.7.0.1
 */