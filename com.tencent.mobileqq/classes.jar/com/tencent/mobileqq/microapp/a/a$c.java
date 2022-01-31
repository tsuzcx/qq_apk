package com.tencent.mobileqq.microapp.a;

import java.io.Closeable;
import java.io.InputStream;

public final class a$c
  implements Closeable
{
  private final InputStream[] a;
  
  private a$c(a parama, String paramString, long paramLong, InputStream[] paramArrayOfInputStream, long[] paramArrayOfLong)
  {
    this.a = paramArrayOfInputStream;
  }
  
  public InputStream a(int paramInt)
  {
    return this.a[paramInt];
  }
  
  public String b(int paramInt)
  {
    return a.a(a(paramInt));
  }
  
  public void close()
  {
    InputStream[] arrayOfInputStream = this.a;
    int j = arrayOfInputStream.length;
    int i = 0;
    while (i < j)
    {
      i.a(arrayOfInputStream[i]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.a.a.c
 * JD-Core Version:    0.7.0.1
 */