package com.tencent.upload.d;

import com.tencent.upload.common.FileUtils;
import java.io.File;

public class a
{
  private File a;
  private long b;
  private long c;
  private int d;
  private String e;
  private long f;
  
  public a(String paramString)
  {
    this.a = new File(paramString);
    this.b = FileUtils.getFileLength(paramString);
  }
  
  public long a()
  {
    try
    {
      long l1 = this.b;
      long l2 = this.c;
      return l1 - l2;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long a(long paramLong)
  {
    try
    {
      long l = this.c;
      this.c += paramLong;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public a a(int paramInt)
  {
    try
    {
      this.d = paramInt;
      return this;
    }
    finally {}
  }
  
  public a a(String paramString)
  {
    try
    {
      this.e = paramString;
      notifyAll();
      return this;
    }
    finally {}
  }
  
  public a b(long paramLong)
  {
    try
    {
      this.c = paramLong;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public a c(long paramLong)
  {
    try
    {
      this.f = paramLong;
      return this;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.d.a
 * JD-Core Version:    0.7.0.1
 */