package com.tencent.mobileqq.shortvideo;

public class ShortVideoForwardInfo
  extends ShortVideoBaseInfo
{
  public ShortVideoForwardInfo.RetryInfo a;
  public Object a;
  public long b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  public int f;
  public int g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public int m;
  public String m;
  public int n;
  public String n = "";
  public int o;
  public String o = "";
  public int p;
  public String p = "";
  public int q;
  public String q;
  public int r;
  public String r;
  public int s;
  public String s;
  public String t = "";
  
  public ShortVideoForwardInfo()
  {
    this.jdField_q_of_type_JavaLangString = "";
    this.jdField_q_of_type_Int = 0;
    this.jdField_r_of_type_Int = 0;
    this.jdField_s_of_type_Int = 0;
    this.jdField_r_of_type_JavaLangString = "";
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_s_of_type_JavaLangString = "";
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoForwardInfo");
    localStringBuilder.append("\n |-").append("fromChatType:").append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\n |-").append("toChatType:").append(this.d);
    localStringBuilder.append("\n |-").append("fromBusiType:").append(this.jdField_e_of_type_Int);
    localStringBuilder.append("\n |-").append("toBusiType:").append(this.f);
    localStringBuilder.append("\n |-").append("localPath:").append(this.jdField_h_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("md5:").append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("thumbPath:").append(this.jdField_i_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("thumbWidth:").append(this.g);
    localStringBuilder.append("\n |-").append("thumbHeight:").append(this.jdField_h_of_type_Int);
    localStringBuilder.append("\n |-").append("sendSizeSpec:").append(this.jdField_i_of_type_Int);
    localStringBuilder.append("\n |-").append("fileTime:").append(this.jdField_j_of_type_Int);
    localStringBuilder.append("\n |-").append("fileSource:").append(this.jdField_j_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("uuid:").append(this.a);
    localStringBuilder.append("\n |-").append("fromUin:").append(this.l);
    localStringBuilder.append("\n |-").append("fromSessionUin:").append(this.m);
    localStringBuilder.append("\n |-").append("supportProgressive:").append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("\n |-").append("templateId:").append(this.jdField_s_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("templateName:").append(this.t);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo
 * JD-Core Version:    0.7.0.1
 */