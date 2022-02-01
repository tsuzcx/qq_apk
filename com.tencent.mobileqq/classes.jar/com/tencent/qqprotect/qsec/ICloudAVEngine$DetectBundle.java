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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[ft:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",st:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(",fs:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(",fn:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",fm:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",a1:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(",a2:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",a3:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.ICloudAVEngine.DetectBundle
 * JD-Core Version:    0.7.0.1
 */