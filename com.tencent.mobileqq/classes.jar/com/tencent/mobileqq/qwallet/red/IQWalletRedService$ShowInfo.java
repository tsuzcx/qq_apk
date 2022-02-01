package com.tencent.mobileqq.qwallet.red;

public class IQWalletRedService$ShowInfo
{
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  
  public IQWalletRedService$ShowInfo(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShowInfo{Red=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",Corner=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(",con='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(",buf='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.red.IQWalletRedService.ShowInfo
 * JD-Core Version:    0.7.0.1
 */