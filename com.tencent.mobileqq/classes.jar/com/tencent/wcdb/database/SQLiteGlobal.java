package com.tencent.wcdb.database;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public final class SQLiteGlobal
{
  public static final int a;
  
  static
  {
    if (!WCDBInitializationProbe.libLoaded) {
      System.loadLibrary("wcdb");
    }
    try
    {
      i = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getBlockSize();
    }
    catch (RuntimeException localRuntimeException)
    {
      int i;
      label31:
      break label31;
    }
    i = 4096;
    a = i;
    nativeSetDefaultCipherSettings(i);
  }
  
  public static void a() {}
  
  private static native int nativeReleaseMemory();
  
  private static native void nativeSetDefaultCipherSettings(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteGlobal
 * JD-Core Version:    0.7.0.1
 */