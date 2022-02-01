package com.tencent.wcdb.repair;

import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.support.CancellationSignal.OnCancelListener;

public class RepairKit
  implements CancellationSignal.OnCancelListener
{
  private long a;
  private RepairKit.MasterInfo b;
  private RepairKit.Callback c;
  private RepairKit.RepairCursor d;
  
  private static native void nativeCancel(long paramLong);
  
  private static native void nativeFini(long paramLong);
  
  private static native void nativeFreeMaster(long paramLong);
  
  private static native long nativeInit(String paramString, byte[] paramArrayOfByte1, SQLiteCipherSpec paramSQLiteCipherSpec, byte[] paramArrayOfByte2);
  
  private static native int nativeIntegrityFlags(long paramLong);
  
  private static native String nativeLastError();
  
  private static native long nativeLoadMaster(String paramString, byte[] paramArrayOfByte1, String[] paramArrayOfString, byte[] paramArrayOfByte2);
  
  private static native long nativeMakeMaster(String[] paramArrayOfString);
  
  private native int nativeOutput(long paramLong1, long paramLong2, long paramLong3, int paramInt);
  
  private static native boolean nativeSaveMaster(long paramLong, String paramString, byte[] paramArrayOfByte);
  
  private int onProgress(String paramString, int paramInt, long paramLong)
  {
    if (this.c == null) {
      return 0;
    }
    if (this.d == null) {
      this.d = new RepairKit.RepairCursor(null);
    }
    RepairKit.RepairCursor localRepairCursor = this.d;
    localRepairCursor.g = paramLong;
    return this.c.a(paramString, paramInt, localRepairCursor);
  }
  
  public void a()
  {
    RepairKit.MasterInfo localMasterInfo = this.b;
    if (localMasterInfo != null)
    {
      localMasterInfo.a();
      this.b = null;
    }
    long l = this.a;
    if (l != 0L)
    {
      nativeFini(l);
      this.a = 0L;
    }
  }
  
  public void c()
  {
    long l = this.a;
    if (l == 0L) {
      return;
    }
    nativeCancel(l);
  }
  
  protected void finalize()
  {
    a();
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.repair.RepairKit
 * JD-Core Version:    0.7.0.1
 */