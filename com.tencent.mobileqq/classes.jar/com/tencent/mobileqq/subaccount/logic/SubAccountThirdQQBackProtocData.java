package com.tencent.mobileqq.subaccount.logic;

public class SubAccountThirdQQBackProtocData
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public int d = 0;
  
  public SubAccountThirdQQBackProtocData()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" mainAccount:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" errorType:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" errorMsg:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" interval:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" allLastMsgTime:");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.logic.SubAccountThirdQQBackProtocData
 * JD-Core Version:    0.7.0.1
 */