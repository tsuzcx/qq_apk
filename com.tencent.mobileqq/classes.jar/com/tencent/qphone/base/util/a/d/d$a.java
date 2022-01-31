package com.tencent.qphone.base.util.a.d;

public class d$a
{
  private String a;
  private String b;
  private int c = 8192;
  private boolean d;
  private boolean e;
  
  public a a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public a a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public a a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public d a()
  {
    if (this.b == null) {
      throw new IllegalArgumentException("logFilePath cannot be null");
    }
    if (this.a == null) {
      throw new RuntimeException("need bufferFilePath path");
    }
    return new d(this);
  }
  
  public a b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public a b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.a.d.d.a
 * JD-Core Version:    0.7.0.1
 */