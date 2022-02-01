package com.tencent.wcdb;

import android.database.ContentObserver;
import android.database.DataSetObserver;

public class MergeCursor
  extends AbstractCursor
{
  private Cursor g;
  private Cursor[] h;
  
  public boolean a(int paramInt1, int paramInt2)
  {
    this.g = null;
    int j = this.h.length;
    paramInt1 = 0;
    int i = 0;
    while (paramInt1 < j)
    {
      localObject = this.h;
      if (localObject[paramInt1] != null)
      {
        if (paramInt2 < localObject[paramInt1].getCount() + i)
        {
          this.g = this.h[paramInt1];
          break;
        }
        i += this.h[paramInt1].getCount();
      }
      paramInt1 += 1;
    }
    Object localObject = this.g;
    if (localObject != null) {
      return ((Cursor)localObject).moveToPosition(paramInt2 - i);
    }
    return false;
  }
  
  public void close()
  {
    int j = this.h.length;
    int i = 0;
    while (i < j)
    {
      Cursor[] arrayOfCursor = this.h;
      if (arrayOfCursor[i] != null) {
        arrayOfCursor[i].close();
      }
      i += 1;
    }
    super.close();
  }
  
  public void deactivate()
  {
    int j = this.h.length;
    int i = 0;
    while (i < j)
    {
      Cursor[] arrayOfCursor = this.h;
      if (arrayOfCursor[i] != null) {
        arrayOfCursor[i].deactivate();
      }
      i += 1;
    }
    super.deactivate();
  }
  
  public byte[] getBlob(int paramInt)
  {
    return this.g.getBlob(paramInt);
  }
  
  public String[] getColumnNames()
  {
    Cursor localCursor = this.g;
    if (localCursor != null) {
      return localCursor.getColumnNames();
    }
    return new String[0];
  }
  
  public int getCount()
  {
    int m = this.h.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Cursor[] arrayOfCursor = this.h;
      k = j;
      if (arrayOfCursor[i] != null) {
        k = j + arrayOfCursor[i].getCount();
      }
      i += 1;
    }
    return j;
  }
  
  public double getDouble(int paramInt)
  {
    return this.g.getDouble(paramInt);
  }
  
  public float getFloat(int paramInt)
  {
    return this.g.getFloat(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    return this.g.getInt(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    return this.g.getLong(paramInt);
  }
  
  public short getShort(int paramInt)
  {
    return this.g.getShort(paramInt);
  }
  
  public String getString(int paramInt)
  {
    return this.g.getString(paramInt);
  }
  
  public int getType(int paramInt)
  {
    return this.g.getType(paramInt);
  }
  
  public boolean isNull(int paramInt)
  {
    return this.g.isNull(paramInt);
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver)
  {
    int j = this.h.length;
    int i = 0;
    while (i < j)
    {
      Cursor[] arrayOfCursor = this.h;
      if (arrayOfCursor[i] != null) {
        arrayOfCursor[i].registerContentObserver(paramContentObserver);
      }
      i += 1;
    }
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    int j = this.h.length;
    int i = 0;
    while (i < j)
    {
      Cursor[] arrayOfCursor = this.h;
      if (arrayOfCursor[i] != null) {
        arrayOfCursor[i].registerDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
  }
  
  public boolean requery()
  {
    int j = this.h.length;
    int i = 0;
    while (i < j)
    {
      Cursor[] arrayOfCursor = this.h;
      if ((arrayOfCursor[i] != null) && (!arrayOfCursor[i].requery())) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    int j = this.h.length;
    int i = 0;
    while (i < j)
    {
      Cursor[] arrayOfCursor = this.h;
      if (arrayOfCursor[i] != null) {
        arrayOfCursor[i].unregisterContentObserver(paramContentObserver);
      }
      i += 1;
    }
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    int j = this.h.length;
    int i = 0;
    while (i < j)
    {
      Cursor[] arrayOfCursor = this.h;
      if (arrayOfCursor[i] != null) {
        arrayOfCursor[i].unregisterDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.MergeCursor
 * JD-Core Version:    0.7.0.1
 */