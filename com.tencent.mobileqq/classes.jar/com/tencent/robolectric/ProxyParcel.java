package com.tencent.robolectric;

import android.os.IBinder;
import android.os.Parcelable.Creator;
import java.io.FileDescriptor;
import java.util.HashMap;

public final class ProxyParcel
{
  public static final Parcelable.Creator<String> a = new ProxyParcel.1();
  private static final ProxyParcel[] b = new ProxyParcel[6];
  private static final ProxyParcel[] c = new ProxyParcel[6];
  private static final HashMap<ClassLoader, HashMap<String, Parcelable.Creator<?>>> d = new HashMap();
  private long e;
  private boolean f;
  private long g;
  private ProxyParcel.ReadWriteHelper h;
  
  private void a()
  {
    long l = this.e;
    if (l != 0L)
    {
      if (this.f)
      {
        nativeDestroy(l);
        a(0L);
      }
      this.e = 0L;
    }
    this.h = null;
  }
  
  private void a(long paramLong)
  {
    if (this.f)
    {
      long l = paramLong;
      if (paramLong > 2147483647L) {
        l = 2147483647L;
      }
      if (l != this.g) {
        this.g = l;
      }
    }
  }
  
  @Deprecated
  static native void closeFileDescriptor(FileDescriptor paramFileDescriptor);
  
  @Deprecated
  static native FileDescriptor dupFileDescriptor(FileDescriptor paramFileDescriptor);
  
  public static native long getGlobalAllocCount();
  
  public static native long getGlobalAllocSize();
  
  private static native long nativeAppendFrom(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private static native int nativeCompareData(long paramLong1, long paramLong2);
  
  private static native long nativeCreate();
  
  private static native byte[] nativeCreateByteArray(long paramLong);
  
  private static native int nativeDataAvail(long paramLong);
  
  private static native int nativeDataCapacity(long paramLong);
  
  private static native int nativeDataPosition(long paramLong);
  
  private static native int nativeDataSize(long paramLong);
  
  private static native void nativeDestroy(long paramLong);
  
  private static native void nativeEnforceInterface(long paramLong, String paramString);
  
  private static native long nativeFreeBuffer(long paramLong);
  
  private static native long nativeGetBlobAshmemSize(long paramLong);
  
  private static native boolean nativeHasFileDescriptors(long paramLong);
  
  private static native boolean nativePushAllowFds(long paramLong, boolean paramBoolean);
  
  private static native byte[] nativeReadBlob(long paramLong);
  
  private static native boolean nativeReadByteArray(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private static native double nativeReadDouble(long paramLong);
  
  private static native FileDescriptor nativeReadFileDescriptor(long paramLong);
  
  private static native float nativeReadFloat(long paramLong);
  
  private static native int nativeReadInt(long paramLong);
  
  private static native long nativeReadLong(long paramLong);
  
  static native String nativeReadString(long paramLong);
  
  private static native IBinder nativeReadStrongBinder(long paramLong);
  
  private static native void nativeRestoreAllowFds(long paramLong, boolean paramBoolean);
  
  private static native void nativeSetDataCapacity(long paramLong, int paramInt);
  
  private static native void nativeSetDataPosition(long paramLong, int paramInt);
  
  private static native long nativeSetDataSize(long paramLong, int paramInt);
  
  @Deprecated
  static native FileDescriptor openFileDescriptor(String paramString, int paramInt);
  
  protected void finalize()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.robolectric.ProxyParcel
 * JD-Core Version:    0.7.0.1
 */