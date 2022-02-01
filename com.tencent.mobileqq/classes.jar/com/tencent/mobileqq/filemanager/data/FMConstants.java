package com.tencent.mobileqq.filemanager.data;

import android.text.TextUtils;
import java.util.regex.Pattern;

public class FMConstants
{
  public static int a = 0;
  public static final String a;
  public static boolean a = false;
  public static final char[] a;
  public static final String[] a;
  public static int b = 1;
  public static final String b;
  public static final char[] b;
  public static int c = 2;
  public static int d = 3;
  public static int e = 4;
  public static int f = 5;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { ".doc|.docx|.wps|.pages|", ".xls|.xlsx|.et|.numbers|" };
    jdField_a_of_type_ArrayOfChar = new char[] { '…' };
    jdField_a_of_type_JavaLangString = new String(jdField_a_of_type_ArrayOfChar);
    jdField_b_of_type_ArrayOfChar = new char[] { '‥' };
    jdField_b_of_type_JavaLangString = new String(jdField_b_of_type_ArrayOfChar);
  }
  
  public static final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.matches("(https|http)?(://)?docs.qq.com/(doc|sheet|slide|pdf|form/edit|form/fill|form/page)/.*", paramString);
  }
  
  public static final boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.matches("(https|http)?(://)?docs.qq.com/(doc)/.*", paramString);
  }
  
  public static final boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.matches("(https|http)?(://)?docs.qq.com/(sheet)/.*", paramString);
  }
  
  public static final boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.matches("(https|http)?(://)?docs.qq.com/(slide)/.*", paramString);
  }
  
  public static final boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.matches("(https|http)?(://)?docs.qq.com/(form/edit|form/fill)/.*", paramString);
  }
  
  public static final boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.matches("(https|http)?(://)?docs.qq.com/(pdf)/.*", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FMConstants
 * JD-Core Version:    0.7.0.1
 */