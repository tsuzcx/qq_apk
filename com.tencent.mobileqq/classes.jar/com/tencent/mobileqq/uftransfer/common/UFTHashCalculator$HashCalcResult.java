package com.tencent.mobileqq.uftransfer.common;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;

class UFTHashCalculator$HashCalcResult
  implements UFTHashCalculator.IHashCalcResult
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  byte[] jdField_a_of_type_ArrayOfByte;
  int jdField_b_of_type_Int = 0;
  byte[] jdField_b_of_type_ArrayOfByte;
  int jdField_c_of_type_Int = 0;
  byte[] jdField_c_of_type_ArrayOfByte;
  byte[] d;
  
  private UFTHashCalculator$HashCalcResult(UFTHashCalculator paramUFTHashCalculator) {}
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public byte[] b()
  {
    return this.jdField_b_of_type_ArrayOfByte;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public byte[] c()
  {
    return this.jdField_c_of_type_ArrayOfByte;
  }
  
  public byte[] d()
  {
    return this.d;
  }
  
  @NonNull
  public String toString()
  {
    String str1 = UFTDependFeatureApi.a(this.jdField_a_of_type_ArrayOfByte);
    String str2 = UFTDependFeatureApi.a(this.jdField_b_of_type_ArrayOfByte);
    String str3 = UFTDependFeatureApi.a(this.jdField_c_of_type_ArrayOfByte);
    String str4 = UFTDependFeatureApi.a(this.d);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" fileSize:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" 10Mmd5:");
    localStringBuilder.append(str1);
    localStringBuilder.append("md5:");
    localStringBuilder.append(str2);
    localStringBuilder.append(" sha1:");
    localStringBuilder.append(str3);
    localStringBuilder.append(" sha3:");
    localStringBuilder.append(str4);
    localStringBuilder.append(" mWith:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" mHeight:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" mDuration:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.UFTHashCalculator.HashCalcResult
 * JD-Core Version:    0.7.0.1
 */