package com.tencent.mobileqq.shortvideo;

public class ShortVideoUploadInfo
  extends ShortVideoBaseInfo
{
  public ShortVideoUploadInfo.RetryInfo a;
  public Object a;
  public long b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  public int f;
  public boolean f;
  public int g;
  public boolean g = false;
  public int h;
  public String h;
  public boolean h;
  public int i;
  public String i;
  public boolean i;
  public int j;
  public String j;
  public boolean j;
  public int k = 0;
  public String k;
  public int l;
  public String l;
  public String m = "";
  public String n = "";
  public String o = "";
  public String p = "";
  public String q = "";
  public String r;
  public String s;
  public String t;
  
  public ShortVideoUploadInfo()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_j_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoUploadInfo");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("localPath:");
    localStringBuilder.append(this.jdField_h_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("md5:");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbPath:");
    localStringBuilder.append(this.jdField_j_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbWidth:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbHeight:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("sendSizeSpec:");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileTime:");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileSource:");
    localStringBuilder.append(this.l);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("supportProgressive:");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileWidth:");
    localStringBuilder.append(this.jdField_h_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileHeight:");
    localStringBuilder.append(this.jdField_i_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("templateId:");
    localStringBuilder.append(this.s);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("templateName:");
    localStringBuilder.append(this.t);
    return localStringBuilder.toString();
  }
  
  public boolean a()
  {
    return super.a();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo
 * JD-Core Version:    0.7.0.1
 */