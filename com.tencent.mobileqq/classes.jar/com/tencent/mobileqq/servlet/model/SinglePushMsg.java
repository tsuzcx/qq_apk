package com.tencent.mobileqq.servlet.model;

import java.util.Map;

public class SinglePushMsg
{
  public int a;
  public long a;
  public String a;
  public Map a;
  public boolean a;
  public byte[] a;
  public long b;
  public boolean b;
  
  public SinglePushMsg(long paramLong1, Map paramMap, long paramLong2, String paramString)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public SinglePushMsg(long paramLong1, Map paramMap, long paramLong2, String paramString, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.model.SinglePushMsg
 * JD-Core Version:    0.7.0.1
 */