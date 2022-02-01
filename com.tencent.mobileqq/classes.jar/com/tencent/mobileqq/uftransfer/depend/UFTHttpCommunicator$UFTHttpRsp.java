package com.tencent.mobileqq.uftransfer.depend;

public class UFTHttpCommunicator$UFTHttpRsp
{
  final long jdField_a_of_type_Long;
  final String jdField_a_of_type_JavaLangString;
  final byte[] jdField_a_of_type_ArrayOfByte;
  final long b;
  final long c;
  
  public UFTHttpCommunicator$UFTHttpRsp(byte[] paramArrayOfByte, String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_Long = paramLong2;
    this.b = paramLong1;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramLong3;
  }
  
  public long a()
  {
    return this.b;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public long b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.depend.UFTHttpCommunicator.UFTHttpRsp
 * JD-Core Version:    0.7.0.1
 */