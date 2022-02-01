package com.tencent.wcdb;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;

public class MatrixCursor
  extends AbstractCursor
{
  private final String[] g;
  private Object[] h;
  private int i;
  private final int j;
  
  private Object a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.j))
    {
      if (this.b >= 0)
      {
        if (this.b < this.i) {
          return this.h[(this.b * this.j + paramInt)];
        }
        throw new CursorIndexOutOfBoundsException("After last row.");
      }
      throw new CursorIndexOutOfBoundsException("Before first row.");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Requested column: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", # of columns: ");
    localStringBuilder.append(this.j);
    throw new CursorIndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public byte[] getBlob(int paramInt)
  {
    return (byte[])a(paramInt);
  }
  
  public String[] getColumnNames()
  {
    return this.g;
  }
  
  public int getCount()
  {
    return this.i;
  }
  
  public double getDouble(int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      return 0.0D;
    }
    if ((localObject instanceof Number)) {
      return ((Number)localObject).doubleValue();
    }
    return Double.parseDouble(localObject.toString());
  }
  
  public float getFloat(int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      return 0.0F;
    }
    if ((localObject instanceof Number)) {
      return ((Number)localObject).floatValue();
    }
    return Float.parseFloat(localObject.toString());
  }
  
  public int getInt(int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      return 0;
    }
    if ((localObject instanceof Number)) {
      return ((Number)localObject).intValue();
    }
    return Integer.parseInt(localObject.toString());
  }
  
  public long getLong(int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      return 0L;
    }
    if ((localObject instanceof Number)) {
      return ((Number)localObject).longValue();
    }
    return Long.parseLong(localObject.toString());
  }
  
  public short getShort(int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      return 0;
    }
    if ((localObject instanceof Number)) {
      return ((Number)localObject).shortValue();
    }
    return Short.parseShort(localObject.toString());
  }
  
  public String getString(int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      return null;
    }
    return localObject.toString();
  }
  
  public int getType(int paramInt)
  {
    return DatabaseUtils.a(a(paramInt));
  }
  
  public boolean isNull(int paramInt)
  {
    return a(paramInt) == null;
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.MatrixCursor
 * JD-Core Version:    0.7.0.1
 */