package com.tencent.mobileqq.uftransfer.api;

import java.util.Arrays;

public class UFTFileLocalInfo
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int = 0;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int = 0;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private byte[] d;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
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
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public byte[] b()
  {
    return this.jdField_b_of_type_ArrayOfByte;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    this.jdField_c_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public byte[] c()
  {
    return this.jdField_c_of_type_ArrayOfByte;
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    this.d = paramArrayOfByte;
  }
  
  public byte[] d()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UFTFileLocalInfo{fileSize=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", bytes10mMd5=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfByte));
    localStringBuilder.append(", bytesMd5=");
    localStringBuilder.append(Arrays.toString(this.jdField_b_of_type_ArrayOfByte));
    localStringBuilder.append(", bytesSha3=");
    localStringBuilder.append(Arrays.toString(this.jdField_c_of_type_ArrayOfByte));
    localStringBuilder.append(", bytesSha=");
    localStringBuilder.append(Arrays.toString(this.d));
    localStringBuilder.append(", with=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo
 * JD-Core Version:    0.7.0.1
 */