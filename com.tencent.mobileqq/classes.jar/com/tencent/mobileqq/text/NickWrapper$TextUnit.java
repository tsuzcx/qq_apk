package com.tencent.mobileqq.text;

import android.graphics.Paint;
import android.support.annotation.NonNull;

public abstract class NickWrapper$TextUnit
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  public NickWrapper$TextUnit(int paramInt, @NonNull String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  abstract float a(@NonNull Paint paramPaint);
  
  int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.text.NickWrapper.TextUnit
 * JD-Core Version:    0.7.0.1
 */