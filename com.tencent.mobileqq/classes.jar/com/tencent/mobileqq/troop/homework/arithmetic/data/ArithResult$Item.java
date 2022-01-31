package com.tencent.mobileqq.troop.homework.arithmetic.data;

import android.text.TextUtils;

public class ArithResult$Item
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public int c;
  public int d;
  public int e;
  
  public ArithResult$Item()
  {
    this.jdField_a_of_type_JavaLangString = "default";
  }
  
  public boolean a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || ("default".equals(this.jdField_a_of_type_JavaLangString))) {}
    while ((this.b < 0) || (this.c < 0) || (this.d <= 0) || (this.e <= 0)) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return "Item{subject='" + this.jdField_a_of_type_JavaLangString + '\'' + ", correct=" + this.jdField_a_of_type_Boolean + ", confidence=" + this.jdField_a_of_type_Int + ", x=" + this.b + ", y=" + this.c + ", width=" + this.d + ", height=" + this.e + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.data.ArithResult.Item
 * JD-Core Version:    0.7.0.1
 */