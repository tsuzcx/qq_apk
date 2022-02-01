package com.tencent.mobileqq.uftransfer.api;

import java.util.Arrays;

public class UFTC2CUploadInfo
  extends UFTBaseUploadInfo
{
  private long jdField_a_of_type_Long = -1L;
  private String jdField_a_of_type_JavaLangString;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UFTC2CUploadInfo{");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", tempSessionType=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", tmpSessionSig=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfByte));
    localStringBuilder.append(", tmpSessionToPhone='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.UFTC2CUploadInfo
 * JD-Core Version:    0.7.0.1
 */