package com.tencent.mobileqq.colornote.data;

public final class ColorNote$Builder
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  byte[] jdField_a_of_type_ArrayOfByte;
  int jdField_b_of_type_Int = 0;
  String jdField_b_of_type_JavaLangString;
  String c;
  String d;
  
  public Builder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    return this;
  }
  
  public ColorNote a()
  {
    return new ColorNote(this);
  }
  
  public Builder b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public Builder d(String paramString)
  {
    this.d = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNote.Builder
 * JD-Core Version:    0.7.0.1
 */