package com.tencent.wcdb.extension.fts;

import com.tencent.wcdb.extension.SQLiteExtension;

public final class MMFtsTokenizer
  implements SQLiteExtension
{
  public static final SQLiteExtension a = new MMFtsTokenizer();
  
  private static native void nativeInitialize(long paramLong1, long paramLong2);
  
  public void a(long paramLong1, long paramLong2)
  {
    nativeInitialize(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.extension.fts.MMFtsTokenizer
 * JD-Core Version:    0.7.0.1
 */