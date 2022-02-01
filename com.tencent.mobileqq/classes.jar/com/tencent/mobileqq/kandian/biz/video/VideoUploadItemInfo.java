package com.tencent.mobileqq.kandian.biz.video;

public class VideoUploadItemInfo
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public int e;
  public int f;
  
  public VideoUploadItemInfo()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoUploadInfo");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("localPath:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("md5:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbPath:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbWidth:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbHeight:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("sendSizeSpec:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileTime:");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileSource:");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("supportProgressive:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileWidth:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileHeight:");
    localStringBuilder.append(this.f);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoUploadItemInfo
 * JD-Core Version:    0.7.0.1
 */