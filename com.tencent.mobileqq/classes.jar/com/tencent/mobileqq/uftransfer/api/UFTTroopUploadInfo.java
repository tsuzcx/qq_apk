package com.tencent.mobileqq.uftransfer.api;

import java.util.Arrays;

public class UFTTroopUploadInfo
  extends UFTBaseUploadInfo
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private String jdField_c_of_type_JavaLangString;
  private byte[] jdField_c_of_type_ArrayOfByte;
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    this.jdField_c_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public String d()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void d(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public String e()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void e(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UFTTroopUploadInfo{");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", busId=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", strParentId='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", troopCode=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", fileId='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", serverDns='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bytesSha=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfByte));
    localStringBuilder.append(", bytesMd5=");
    localStringBuilder.append(Arrays.toString(this.jdField_b_of_type_ArrayOfByte));
    localStringBuilder.append(", bytesSha3=");
    localStringBuilder.append(Arrays.toString(this.jdField_c_of_type_ArrayOfByte));
    localStringBuilder.append(", entranceType=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.UFTTroopUploadInfo
 * JD-Core Version:    0.7.0.1
 */