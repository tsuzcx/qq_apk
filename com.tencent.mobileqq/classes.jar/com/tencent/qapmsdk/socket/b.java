package com.tencent.qapmsdk.socket;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.tencent.qapmsdk.socket.a.i;
import com.tencent.qapmsdk.socket.c.a;
import java.io.InputStream;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class b
  extends InputStream
{
  private byte[] a = new byte[1];
  private InputStream b;
  private a c;
  private i d;
  
  public b(InputStream paramInputStream, a parama)
  {
    this.b = paramInputStream;
    this.d = new i();
    if (parama != null) {
      this.c = parama;
    }
  }
  
  public int available()
  {
    return this.b.available();
  }
  
  public void close()
  {
    this.d.a();
    this.b.close();
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.b.mark(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean markSupported()
  {
    return this.b.markSupported();
  }
  
  public int read()
  {
    if (read(this.a, 0, 1) <= 0) {
      return -1;
    }
    return this.a[0] & 0xFF;
  }
  
  public int read(@NonNull byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.b.read(paramArrayOfByte, paramInt1, paramInt2);
    this.d.a(paramArrayOfByte, paramInt1, paramInt2, i, this.c);
    return i;
  }
  
  public void reset()
  {
    try
    {
      this.b.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long skip(long paramLong)
  {
    return this.b.skip(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.b
 * JD-Core Version:    0.7.0.1
 */