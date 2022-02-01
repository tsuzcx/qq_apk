package com.tencent.mobileqq.qqexpand.network;

import androidx.annotation.Nullable;

public class ExpandResponse
{
  protected int a;
  protected String a;
  
  public ExpandResponse(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(byte[] paramArrayOfByte) {}
  
  @Nullable
  public byte[] a()
  {
    return null;
  }
  
  public String b()
  {
    StringBuffer localStringBuffer = new StringBuffer("ErrorInfo");
    localStringBuffer.append(" errorCode:");
    localStringBuffer.append(a());
    localStringBuffer.append(" errorMsg:");
    localStringBuffer.append(a());
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.network.ExpandResponse
 * JD-Core Version:    0.7.0.1
 */