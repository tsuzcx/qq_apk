package com.tencent.mobileqq.streamtransfile;

public class StreamDataInfo
{
  private int jdField_a_of_type_Int = 0;
  private short jdField_a_of_type_Short = 0;
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private boolean b = false;
  
  StreamDataInfo(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfByte = new byte[paramInt];
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public short a()
  {
    return this.jdField_a_of_type_Short;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(short paramShort)
  {
    this.jdField_a_of_type_Short = paramShort;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.streamtransfile.StreamDataInfo
 * JD-Core Version:    0.7.0.1
 */