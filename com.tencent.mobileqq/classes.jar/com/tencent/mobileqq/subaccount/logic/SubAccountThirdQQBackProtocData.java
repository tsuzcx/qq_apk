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
    localStringBuilder.append("result:").append(this.jdField_b_of_type_Int).append(" mainAccount:").append(this.jdField_a_of_type_JavaLangString).append(" errorType:").append(this.jdField_a_of_type_Int).append(" errorMsg:").append(this.jdField_b_of_type_JavaLangString).append(" interval:").append(this.c).append(" allLastMsgTime:").append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.logic.SubAccountThirdQQBackProtocData
 * JD-Core Version:    0.7.0.1
 */