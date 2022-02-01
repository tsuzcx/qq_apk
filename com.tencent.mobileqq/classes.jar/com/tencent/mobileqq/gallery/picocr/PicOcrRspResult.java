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
    localStringBuilder.append("mMd5= ").append(this.jdField_a_of_type_JavaLangString).append("\n").append("baseWidth= ").append(this.jdField_a_of_type_Int).append("\n").append("baseHeight= ").append(this.jdField_b_of_type_Int).append("\n").append("mLanguage= ").append(this.jdField_b_of_type_JavaLangString).append("\n").append("url= ").append(this.jdField_c_of_type_JavaLangString).append("\n").append("languageList= ").append(this.jdField_b_of_type_JavaUtilArrayList.toString()).append("\n").append("mSrcLangMap= ").append(this.jdField_a_of_type_JavaUtilHashMap.toString()).append("\n").append("fileSize= ").append(this.jdField_c_of_type_Int).append("\n").append("reqHeight= ").append(this.e).append("\n").append("reqWidth= ").append(this.jdField_d_of_type_Int).append("\n").append("afMd5= ").append(this.jdField_d_of_type_JavaLangString).append("\n").append("rotateDe= ").append(this.f).append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrRspResult
 * JD-Core Version:    0.7.0.1
 */