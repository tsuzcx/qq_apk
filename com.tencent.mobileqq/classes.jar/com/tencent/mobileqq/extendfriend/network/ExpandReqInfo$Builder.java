package com.tencent.mobileqq.extendfriend.network;

public class ExpandReqInfo$Builder
{
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int b = 0;
  private int c = 30;
  
  public Builder a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public Builder a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    return this;
  }
  
  public ExpandReqInfo a()
  {
    return new ExpandReqInfo(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.network.ExpandReqInfo.Builder
 * JD-Core Version:    0.7.0.1
 */