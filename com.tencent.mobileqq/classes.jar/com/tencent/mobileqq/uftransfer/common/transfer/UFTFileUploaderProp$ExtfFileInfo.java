package com.tencent.mobileqq.uftransfer.common.transfer;

import android.text.TextUtils;

public class UFTFileUploaderProp$ExtfFileInfo
{
  protected long a;
  protected String a;
  protected byte[] a;
  protected String b;
  protected byte[] b;
  protected String c;
  protected byte[] c;
  protected byte[] d;
  protected byte[] e;
  protected byte[] f;
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_c_of_type_JavaLangString = "filePath is empty";
      return false;
    }
    return true;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public byte[] b()
  {
    return this.jdField_b_of_type_ArrayOfByte;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
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
  
  public void e(byte[] paramArrayOfByte)
  {
    this.e = paramArrayOfByte;
  }
  
  public byte[] e()
  {
    return this.e;
  }
  
  public void f(byte[] paramArrayOfByte)
  {
    this.f = paramArrayOfByte;
  }
  
  public byte[] f()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.ExtfFileInfo
 * JD-Core Version:    0.7.0.1
 */