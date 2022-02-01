package com.tencent.qqprotect.qsec;

import android.text.TextUtils;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;

public class ICloudAVEngine$DetectBundle
{
  public int a;
  public String a;
  public byte[] a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  
  public String a()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return this.jdField_b_of_type_JavaLangString;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return null;
    }
    return MD5FileUtil.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public String toString()
  {
    return "[ft:" + this.jdField_a_of_type_Int + ",st:" + this.jdField_b_of_type_Int + ",fs:" + this.jdField_c_of_type_Int + ",fn:" + this.jdField_a_of_type_JavaLangString + ",fm:" + this.jdField_b_of_type_JavaLangString + ",a1:" + this.jdField_c_of_type_JavaLangString + ",a2:" + this.d + ",a3:" + this.e + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.ICloudAVEngine.DetectBundle
 * JD-Core Version:    0.7.0.1
 */