package com.tencent.mobileqq.ocr.req;

import com.tencent.mobileqq.utils.FileUtils;

public class OCRReqContext
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OCRReqContext{chatType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", imagePath='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", compressPath='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", oriMd5='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", comMd5='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", hasCrop=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append('\'');
    localStringBuilder.append(", comWidth=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append(", comHeiht=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append(", serverUrl=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", seqNumber=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.f = "";
    this.jdField_a_of_type_JavaLangString = "";
    this.d = "";
    this.e = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Int > 0) && (this.jdField_c_of_type_Int > 0) && (FileUtils.fileExistsAndNotEmpty(this.jdField_c_of_type_JavaLangString));
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.req.OCRReqContext
 * JD-Core Version:    0.7.0.1
 */