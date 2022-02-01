package com.tencent.mobileqq.uftransfer.api;

public class UFTTroopFileUploadBusinessInfo
  extends UFTFileUploadBusinessInfo
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String e()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UFTTroopFileUploadBusiInfo{");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", busId=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", serverDns='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.UFTTroopFileUploadBusinessInfo
 * JD-Core Version:    0.7.0.1
 */