package com.tencent.rmonitor.bigbitmap.datainfo;

public class DrawableInfo
{
  public int a;
  public int b;
  public int c;
  public long d;
  public String e;
  
  public DrawableInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, 0L);
  }
  
  public DrawableInfo(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this(paramInt1, paramInt2, paramInt3, paramLong, "");
  }
  
  public DrawableInfo(int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramLong;
    this.e = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.bigbitmap.datainfo.DrawableInfo
 * JD-Core Version:    0.7.0.1
 */