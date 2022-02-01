package com.tencent.mobileqq.magicface.drawable;

import java.io.File;

public class PngPlayParam
{
  public int a;
  public boolean a;
  public String[] a;
  public int b;
  public String[] b;
  public int c;
  public int d;
  
  public PngPlayParam()
  {
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
    this.c = 100;
    this.d = 0;
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_b_of_type_ArrayOfJavaLangString = null;
  }
  
  public boolean a()
  {
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    int i;
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
        if (i >= arrayOfString.length) {
          break;
        }
        if (!new File(arrayOfString[i]).exists()) {
          return false;
        }
        i += 1;
      }
    }
    arrayOfString = this.jdField_b_of_type_ArrayOfJavaLangString;
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfString = this.jdField_b_of_type_ArrayOfJavaLangString;
        if (i >= arrayOfString.length) {
          break;
        }
        if (!new File(arrayOfString[i]).exists()) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngPlayParam
 * JD-Core Version:    0.7.0.1
 */