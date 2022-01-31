package com.tencent.open.base;

import android.text.TextUtils;
import bdht;

public class BspatchUtil
{
  protected static final String a;
  protected static boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = BspatchUtil.class.getName();
    try
    {
      System.loadLibrary("c++_shared");
      System.loadLibrary("bspatch");
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      bdht.e(jdField_a_of_type_JavaLangString, "load bspatch error : " + localThrowable.toString());
      jdField_a_of_type_Boolean = false;
    }
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    bdht.b(jdField_a_of_type_JavaLangString, "srcFile = " + paramString1 + "\npatchFile = " + paramString2 + "\ndstFile = " + paramString3 + "\nisSupport = " + String.valueOf(jdField_a_of_type_Boolean));
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (!jdField_a_of_type_Boolean)) {
      return false;
    }
    try
    {
      boolean bool = bspatch(paramString1, paramString3, paramString2);
      return bool;
    }
    catch (Throwable paramString1)
    {
      bdht.e(jdField_a_of_type_JavaLangString, "patch error : " + paramString1.toString());
    }
    return false;
  }
  
  protected static native boolean bspatch(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.BspatchUtil
 * JD-Core Version:    0.7.0.1
 */