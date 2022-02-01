package com.tencent.mobileqq.gallery.picocr;

import java.util.ArrayList;
import java.util.HashMap;

public class PicOcrRspResult
{
  public int a;
  public String a;
  public ArrayList<PicOcrResultBean> a;
  public HashMap<String, String> a;
  public int b;
  public String b;
  public ArrayList<String> b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public int f;
  
  public PicOcrRspResult()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mMd5= ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n");
    localStringBuilder.append("baseWidth= ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("baseHeight= ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("mLanguage= ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n");
    localStringBuilder.append("url= ");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("\n");
    localStringBuilder.append("languageList= ");
    localStringBuilder.append(this.jdField_b_of_type_JavaUtilArrayList.toString());
    localStringBuilder.append("\n");
    localStringBuilder.append("mSrcLangMap= ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilHashMap.toString());
    localStringBuilder.append("\n");
    localStringBuilder.append("fileSize= ");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("reqHeight= ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n");
    localStringBuilder.append("reqWidth= ");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("afMd5= ");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("\n");
    localStringBuilder.append("rotateDe= ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrRspResult
 * JD-Core Version:    0.7.0.1
 */