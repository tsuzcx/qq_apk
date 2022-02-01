package com.tencent.mobileqq.doutu;

import android.text.TextUtils;

public class DoutuItem
{
  public int a;
  public long a;
  public String a;
  public long b;
  public String b;
  public String c;
  public String d;
  
  public DoutuItem()
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
  }
  
  public DoutuItem(long paramLong, int paramInt)
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public DoutuItem(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Long = paramLong;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DoutuItem uuid:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", md5");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", fileId");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", url");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",key:");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(",count:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",picUin:");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuItem
 * JD-Core Version:    0.7.0.1
 */