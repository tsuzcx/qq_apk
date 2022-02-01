package com.tencent.mobileqq.shortvideo;

public abstract class ShortVideoBaseInfo
  extends ShortVideoInfoInterface
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public ShortVideoBaseInfo()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public String a()
  {
    return null;
  }
  
  public boolean a()
  {
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_Int == -1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reqBusiType invalid, reqBusiType:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      a("ShortVideoBaseInfo.check", localStringBuilder.toString());
      return false;
    }
    if (this.jdField_b_of_type_Int == -1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("uinType invalid,uinType:");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      a("ShortVideoBaseInfo.check", localStringBuilder.toString());
      return false;
    }
    if (this.c == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("peerUin invalid,peerUin:");
      localStringBuilder.append(this.c);
      a("ShortVideoBaseInfo.check", localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoBaseInfo");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("localUUID:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("uniseq:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("reqBusiType:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("selfUin:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("peerUin:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("secondId:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("md5:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbMD5:");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("errInfo:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoBaseInfo
 * JD-Core Version:    0.7.0.1
 */