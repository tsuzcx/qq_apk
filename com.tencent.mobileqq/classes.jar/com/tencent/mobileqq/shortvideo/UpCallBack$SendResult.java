package com.tencent.mobileqq.shortvideo;

public class UpCallBack$SendResult
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public String c;
  public String d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nSendResult");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("result:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("errCode:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("errStr:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("path:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("size:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("uuid:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("md5:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("groupFileID:");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.UpCallBack.SendResult
 * JD-Core Version:    0.7.0.1
 */