package com.tencent.mobileqq.uftransfer.proto;

public class UFTC2CUploadReq
  extends UFTC2CUploadBaseInfo
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private long jdField_b_of_type_Long = 0L;
  private String jdField_b_of_type_JavaLangString;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private byte[] c;
  private byte[] d;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
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
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public byte[] c()
  {
    return this.jdField_b_of_type_ArrayOfByte;
  }
  
  public long d()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void d(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
  }
  
  public byte[] d()
  {
    return this.c;
  }
  
  public long e()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    this.d = paramArrayOfByte;
  }
  
  public byte[] e()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.proto.UFTC2CUploadReq
 * JD-Core Version:    0.7.0.1
 */