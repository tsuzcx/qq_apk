package com.tencent.qqmusic.mediaplayer.seektable;

public abstract interface Parsable
{
  public abstract long available();
  
  public abstract void readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract int readInt();
  
  public abstract int[] readIntArray(int paramInt);
  
  public abstract void readIntArrayInterleaved(int paramInt, int[]... paramVarArgs);
  
  public abstract long readLong();
  
  public abstract long[] readLongArray(int paramInt);
  
  public abstract void readLongArrayInterleaved(int paramInt, long[]... paramVarArgs);
  
  public abstract String readString(int paramInt);
  
  public abstract long skip(long paramLong);
  
  public abstract long tell();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.Parsable
 * JD-Core Version:    0.7.0.1
 */