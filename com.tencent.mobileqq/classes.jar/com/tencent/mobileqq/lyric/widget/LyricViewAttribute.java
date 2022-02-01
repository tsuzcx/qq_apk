package com.tencent.mobileqq.lyric.widget;

import android.content.res.TypedArray;

public class LyricViewAttribute
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public boolean l;
  public boolean m;
  public int n;
  public boolean o;
  
  public void a(TypedArray paramTypedArray)
  {
    this.a = paramTypedArray.getDimensionPixelSize(19, 16);
    this.b = paramTypedArray.getInt(18, 255);
    this.c = paramTypedArray.getInt(20, 255);
    this.d = paramTypedArray.getDimensionPixelSize(8, 20);
    this.i = paramTypedArray.getDimensionPixelSize(9, 20);
    this.j = paramTypedArray.getDimensionPixelSize(0, 15);
    this.e = paramTypedArray.getDimensionPixelSize(4, 20);
    this.f = paramTypedArray.getInt(2, 255);
    this.g = paramTypedArray.getInt(5, 255);
    this.h = paramTypedArray.getDimensionPixelSize(3, 20);
    this.k = paramTypedArray.getDimensionPixelSize(12, 20);
    this.l = paramTypedArray.getBoolean(11, false);
    this.n = paramTypedArray.getDimensionPixelSize(7, 10);
    this.o = paramTypedArray.getBoolean(6, false);
    this.m = paramTypedArray.getBoolean(1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewAttribute
 * JD-Core Version:    0.7.0.1
 */