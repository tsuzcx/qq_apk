package com.tencent.mobileqq.microapp.a;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class a$b
{
  private final String b;
  private final long[] c;
  private boolean d;
  private a.a e;
  private long f;
  
  private a$b(a parama, String paramString)
  {
    this.b = paramString;
    this.c = new long[a.e(parama)];
  }
  
  private void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length != a.e(this.a)) {
      throw b(paramArrayOfString);
    }
    int i = 0;
    try
    {
      while (i < paramArrayOfString.length)
      {
        this.c[i] = Long.parseLong(paramArrayOfString[i]);
        i += 1;
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw b(paramArrayOfString);
    }
  }
  
  private IOException b(String[] paramArrayOfString)
  {
    throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
  }
  
  public File a(int paramInt)
  {
    return new File(a.f(this.a), this.b + "." + paramInt);
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    long[] arrayOfLong = this.c;
    int j = arrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = arrayOfLong[i];
      localStringBuilder.append(' ').append(l);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public File b(int paramInt)
  {
    return new File(a.f(this.a), this.b + "." + paramInt + ".tmp");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.a.a.b
 * JD-Core Version:    0.7.0.1
 */