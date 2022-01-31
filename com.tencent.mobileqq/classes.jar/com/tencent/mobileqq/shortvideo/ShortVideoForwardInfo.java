package com.tencent.mobileqq.shortvideo;

public class ShortVideoForwardInfo
  extends ShortVideoBaseInfo
{
  public ShortVideoForwardInfo.RetryInfo a;
  public Object a;
  public boolean a;
  public int c;
  public int d;
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
  public String q = "";
  public int r;
  public String r = "";
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoForwardInfo");
    localStringBuilder.append("\n |-").append("fromChatType:").append(this.c);
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
    localStringBuilder.append("\n |-").append("uuid:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("fromUin:").append(this.l);
    localStringBuilder.append("\n |-").append("fromSessionUin:").append(this.m);
    localStringBuilder.append("\n |-").append("supportProgressive:").append(this.jdField_a_of_type_Boolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo
 * JD-Core Version:    0.7.0.1
 */