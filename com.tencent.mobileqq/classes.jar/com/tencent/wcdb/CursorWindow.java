package com.tencent.wcdb;

import android.content.res.Resources;
import android.database.CharArrayBuffer;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.wcdb.database.SQLiteClosable;

public class CursorWindow
  extends SQLiteClosable
  implements Parcelable
{
  public static final Parcelable.Creator<CursorWindow> CREATOR = new CursorWindow.1();
  private static int b;
  public long a;
  private int c;
  private final String d;
  
  static
  {
    int i = Resources.getSystem().getIdentifier("config_cursorWindowSize", "integer", "android");
    if (i != 0) {
      b = Resources.getSystem().getInteger(i) * 1024;
    } else {
      b = 2097152;
    }
  }
  
  private CursorWindow(Parcel paramParcel)
  {
    throw new UnsupportedOperationException();
  }
  
  public CursorWindow(String paramString)
  {
    this.c = 0;
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = "<unnamed>";
    }
    this.d = paramString;
    this.a = nativeCreate(this.d, b);
    if (this.a != 0L) {
      return;
    }
    paramString = new StringBuilder();
    paramString.append("Cursor window allocation of ");
    paramString.append(b / 1024);
    paramString.append(" kb failed. ");
    throw new CursorWindowAllocationException(paramString.toString());
  }
  
  public static CursorWindow a(Parcel paramParcel)
  {
    return (CursorWindow)CREATOR.createFromParcel(paramParcel);
  }
  
  private void j()
  {
    long l = this.a;
    if (l != 0L)
    {
      nativeDispose(l);
      this.a = 0L;
    }
  }
  
  private static native boolean nativeAllocRow(long paramLong);
  
  private static native void nativeClear(long paramLong);
  
  private static native void nativeCopyStringToBuffer(long paramLong, int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer);
  
  private static native long nativeCreate(String paramString, int paramInt);
  
  private static native void nativeDispose(long paramLong);
  
  private static native void nativeFreeLastRow(long paramLong);
  
  private static native byte[] nativeGetBlob(long paramLong, int paramInt1, int paramInt2);
  
  private static native double nativeGetDouble(long paramLong, int paramInt1, int paramInt2);
  
  private static native long nativeGetLong(long paramLong, int paramInt1, int paramInt2);
  
  private static native int nativeGetNumRows(long paramLong);
  
  private static native String nativeGetString(long paramLong, int paramInt1, int paramInt2);
  
  private static native int nativeGetType(long paramLong, int paramInt1, int paramInt2);
  
  private static native boolean nativePutBlob(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private static native boolean nativePutDouble(long paramLong, double paramDouble, int paramInt1, int paramInt2);
  
  private static native boolean nativePutLong(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private static native boolean nativePutNull(long paramLong, int paramInt1, int paramInt2);
  
  private static native boolean nativePutString(long paramLong, String paramString, int paramInt1, int paramInt2);
  
  private static native boolean nativeSetNumColumns(long paramLong, int paramInt);
  
  public int a(int paramInt1, int paramInt2)
  {
    h();
    try
    {
      paramInt1 = nativeGetType(this.a, paramInt1 - this.c, paramInt2);
      return paramInt1;
    }
    finally
    {
      i();
    }
  }
  
  public String a()
  {
    return this.d;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer)
  {
    if (paramCharArrayBuffer != null)
    {
      h();
      try
      {
        nativeCopyStringToBuffer(this.a, paramInt1 - this.c, paramInt2, paramCharArrayBuffer);
        return;
      }
      finally
      {
        i();
      }
    }
    throw new IllegalArgumentException("CharArrayBuffer should not be null");
  }
  
  public boolean a(double paramDouble, int paramInt1, int paramInt2)
  {
    h();
    try
    {
      boolean bool = nativePutDouble(this.a, paramDouble, paramInt1 - this.c, paramInt2);
      return bool;
    }
    finally
    {
      i();
    }
  }
  
  public boolean a(long paramLong, int paramInt1, int paramInt2)
  {
    h();
    try
    {
      boolean bool = nativePutLong(this.a, paramLong, paramInt1 - this.c, paramInt2);
      return bool;
    }
    finally
    {
      i();
    }
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    h();
    try
    {
      boolean bool = nativePutString(this.a, paramString, paramInt1 - this.c, paramInt2);
      return bool;
    }
    finally
    {
      i();
    }
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    h();
    try
    {
      boolean bool = nativePutBlob(this.a, paramArrayOfByte, paramInt1 - this.c, paramInt2);
      return bool;
    }
    finally
    {
      i();
    }
  }
  
  public void b()
  {
    h();
    try
    {
      this.c = 0;
      nativeClear(this.a);
      return;
    }
    finally
    {
      i();
    }
  }
  
  public boolean b(int paramInt)
  {
    h();
    try
    {
      boolean bool = nativeSetNumColumns(this.a, paramInt);
      return bool;
    }
    finally
    {
      i();
    }
  }
  
  public byte[] b(int paramInt1, int paramInt2)
  {
    h();
    try
    {
      byte[] arrayOfByte = nativeGetBlob(this.a, paramInt1 - this.c, paramInt2);
      return arrayOfByte;
    }
    finally
    {
      i();
    }
  }
  
  public int c()
  {
    return this.c;
  }
  
  public String c(int paramInt1, int paramInt2)
  {
    h();
    try
    {
      String str = nativeGetString(this.a, paramInt1 - this.c, paramInt2);
      return str;
    }
    finally
    {
      i();
    }
  }
  
  public int d()
  {
    h();
    try
    {
      int i = nativeGetNumRows(this.a);
      return i;
    }
    finally
    {
      i();
    }
  }
  
  public long d(int paramInt1, int paramInt2)
  {
    h();
    try
    {
      long l = nativeGetLong(this.a, paramInt1 - this.c, paramInt2);
      return l;
    }
    finally
    {
      i();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public double e(int paramInt1, int paramInt2)
  {
    h();
    try
    {
      double d1 = nativeGetDouble(this.a, paramInt1 - this.c, paramInt2);
      return d1;
    }
    finally
    {
      i();
    }
  }
  
  public boolean e()
  {
    h();
    try
    {
      boolean bool = nativeAllocRow(this.a);
      return bool;
    }
    finally
    {
      i();
    }
  }
  
  public short f(int paramInt1, int paramInt2)
  {
    return (short)(int)d(paramInt1, paramInt2);
  }
  
  public void f()
  {
    h();
    try
    {
      nativeFreeLastRow(this.a);
      return;
    }
    finally
    {
      i();
    }
  }
  
  protected void finalize()
  {
    try
    {
      j();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int g(int paramInt1, int paramInt2)
  {
    return (int)d(paramInt1, paramInt2);
  }
  
  protected void g()
  {
    j();
  }
  
  public float h(int paramInt1, int paramInt2)
  {
    return (float)e(paramInt1, paramInt2);
  }
  
  public boolean i(int paramInt1, int paramInt2)
  {
    h();
    try
    {
      boolean bool = nativePutNull(this.a, paramInt1 - this.c, paramInt2);
      return bool;
    }
    finally
    {
      i();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(" {");
    localStringBuilder.append(Long.toHexString(this.a));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.CursorWindow
 * JD-Core Version:    0.7.0.1
 */