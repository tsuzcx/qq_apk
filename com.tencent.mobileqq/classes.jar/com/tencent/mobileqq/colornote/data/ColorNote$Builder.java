package com.tencent.mobileqq.colornote.data;

public final class ColorNote$Builder
{
  int a;
  String b;
  int c = 0;
  String d;
  String e;
  String f;
  byte[] g;
  long h;
  
  public Builder a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.h = paramLong;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public Builder a(byte[] paramArrayOfByte)
  {
    this.g = paramArrayOfByte;
    return this;
  }
  
  public ColorNote a()
  {
    return new ColorNote(this);
  }
  
  public Builder b(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public Builder c(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public Builder d(String paramString)
  {
    this.f = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNote.Builder
 * JD-Core Version:    0.7.0.1
 */