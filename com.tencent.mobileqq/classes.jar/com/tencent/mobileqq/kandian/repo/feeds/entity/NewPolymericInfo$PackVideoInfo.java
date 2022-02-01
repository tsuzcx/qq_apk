package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.qphone.base.util.QLog;

public class NewPolymericInfo$PackVideoInfo
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f;
  public String g;
  
  protected Object clone()
  {
    try
    {
      PackVideoInfo localPackVideoInfo = (PackVideoInfo)super.clone();
      return localPackVideoInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PackVideoInfo item clone failed. exception = ");
      localStringBuilder.append(localCloneNotSupportedException);
      QLog.e("NewPolymericInfo", 2, localStringBuilder.toString());
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PackVideoInfo{businessType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(", xgFileSize=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", thirdUrl='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareUrl='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thirdUin=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", thirdUinName='");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thirdName='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thirdIcon='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thirdAction='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackVideoInfo
 * JD-Core Version:    0.7.0.1
 */