package com.tencent.upload.c;

import com.tencent.upload.e.d;

public final class c
{
  private int a;
  private int b;
  private byte[] c;
  private String d;
  
  public a a(byte[] paramArrayOfByte)
  {
    d locald = com.tencent.upload.e.c.b(paramArrayOfByte);
    if (locald == null)
    {
      com.tencent.upload.e.c.a("----------recv header:", paramArrayOfByte);
      return a.b;
    }
    paramArrayOfByte = com.tencent.upload.e.c.a(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      return a.c;
    }
    if ((locald.c != 1) && (locald.c != 2) && (locald.c != 3)) {
      return a.e;
    }
    this.a = locald.c;
    this.b = locald.e;
    this.c = paramArrayOfByte;
    return a.a;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public byte[] a()
  {
    return this.c;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public static enum a
  {
    private int g;
    private String h;
    
    private a(int paramInt, String paramString)
    {
      this.g = paramInt;
      this.h = paramString;
    }
    
    public int a()
    {
      return this.g;
    }
    
    public String b()
    {
      return this.h;
    }
    
    public String toString()
    {
      return "[" + this.g + "," + this.h + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.c.c
 * JD-Core Version:    0.7.0.1
 */