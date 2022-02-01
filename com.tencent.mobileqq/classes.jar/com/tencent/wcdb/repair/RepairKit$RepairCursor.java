package com.tencent.wcdb.repair;

import com.tencent.wcdb.AbstractCursor;

class RepairKit$RepairCursor
  extends AbstractCursor
{
  long g;
  
  private static native byte[] nativeGetBlob(long paramLong, int paramInt);
  
  private static native int nativeGetColumnCount(long paramLong);
  
  private static native double nativeGetDouble(long paramLong, int paramInt);
  
  private static native long nativeGetLong(long paramLong, int paramInt);
  
  private static native String nativeGetString(long paramLong, int paramInt);
  
  private static native int nativeGetType(long paramLong, int paramInt);
  
  public byte[] getBlob(int paramInt)
  {
    return nativeGetBlob(this.g, paramInt);
  }
  
  public int getColumnCount()
  {
    return nativeGetColumnCount(this.g);
  }
  
  public String[] getColumnNames()
  {
    throw new UnsupportedOperationException();
  }
  
  public int getCount()
  {
    throw new UnsupportedOperationException();
  }
  
  public double getDouble(int paramInt)
  {
    return nativeGetDouble(this.g, paramInt);
  }
  
  public float getFloat(int paramInt)
  {
    return (float)getDouble(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    return (int)getLong(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    return nativeGetLong(this.g, paramInt);
  }
  
  public short getShort(int paramInt)
  {
    return (short)(int)getLong(paramInt);
  }
  
  public String getString(int paramInt)
  {
    return nativeGetString(this.g, paramInt);
  }
  
  public int getType(int paramInt)
  {
    return nativeGetType(this.g, paramInt);
  }
  
  public boolean isNull(int paramInt)
  {
    return getType(paramInt) == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.repair.RepairKit.RepairCursor
 * JD-Core Version:    0.7.0.1
 */