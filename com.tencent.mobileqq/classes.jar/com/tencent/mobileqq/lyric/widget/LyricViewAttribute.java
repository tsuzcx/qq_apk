package com.tencent.mobileqq.lyric.widget;

import android.content.res.TypedArray;

public class LyricViewAttribute
{
  public int a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  
  public void a(TypedArray paramTypedArray)
  {
    this.jdField_a_of_type_Int = paramTypedArray.getDimensionPixelSize(0, 16);
    this.jdField_b_of_type_Int = paramTypedArray.getInt(1, 255);
    this.jdField_c_of_type_Int = paramTypedArray.getInt(2, 255);
    this.d = paramTypedArray.getDimensionPixelSize(4, 20);
    this.i = paramTypedArray.getDimensionPixelSize(3, 20);
    this.j = paramTypedArray.getDimensionPixelSize(9, 15);
    this.e = paramTypedArray.getDimensionPixelSize(5, 20);
    this.f = paramTypedArray.getInt(6, 255);
    this.g = paramTypedArray.getInt(7, 255);
    this.h = paramTypedArray.getDimensionPixelSize(8, 20);
    this.k = paramTypedArray.getDimensionPixelSize(16, 20);
    this.jdField_a_of_type_Boolean = paramTypedArray.getBoolean(17, false);
    this.l = paramTypedArray.getDimensionPixelSize(18, 10);
    this.jdField_c_of_type_Boolean = paramTypedArray.getBoolean(19, false);
    this.jdField_b_of_type_Boolean = paramTypedArray.getBoolean(20, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewAttribute
 * JD-Core Version:    0.7.0.1
 */