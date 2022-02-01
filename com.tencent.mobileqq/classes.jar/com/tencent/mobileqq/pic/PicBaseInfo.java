package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.transfile.AbsDownloader;
import java.io.File;

public abstract class PicBaseInfo
  extends PicInfoInterface
{
  public int a;
  public long a;
  public Object a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f;
  
  public PicBaseInfo()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_d_of_type_Int = 5;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public File a()
  {
    return AbsDownloader.getFile(b());
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
      localStringBuilder.append("busiType invalid,busiType:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      a("PicBaseInfo.check", localStringBuilder.toString());
      return false;
    }
    if (this.jdField_b_of_type_Int == -1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("uinType invalid,uinType:");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      a("PicBaseInfo.check", localStringBuilder.toString());
      return false;
    }
    if (this.c == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("peerUin invalid,peerUin:");
      localStringBuilder.append(this.c);
      a("PicBaseInfo.check", localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  abstract String b();
  
  public boolean b()
  {
    return a() != null;
  }
  
  public String c()
  {
    return AbsDownloader.getFilePath(b());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicBaseInfo");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("localUUID:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("uniseq:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("busiType:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("selfUin:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("peerUin:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("secondId:");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("md5:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("errInfo:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicBaseInfo
 * JD-Core Version:    0.7.0.1
 */