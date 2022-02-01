package com.tencent.turingfd.sdk.xq;

public class Haw
{
  public static final byte[] a;
  public long a;
  public Hickory a;
  public byte[] b;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[0];
  }
  
  public Haw(long paramLong, byte[] paramArrayOfByte, Hickory paramHickory)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.b = paramArrayOfByte;
    this.jdField_a_of_type_ComTencentTuringfdSdkXqHickory = paramHickory;
  }
  
  public static Haw a(long paramLong, Hickory paramHickory)
  {
    if (paramHickory != null) {
      paramHickory.jdField_a_of_type_Long = paramLong;
    }
    return new Haw(paramLong, jdField_a_of_type_ArrayOfByte, paramHickory);
  }
  
  public static Haw a(byte[] paramArrayOfByte, Hickory paramHickory)
  {
    if (paramHickory != null) {
      paramHickory.jdField_a_of_type_Long = 0L;
    }
    return new Haw(0L, paramArrayOfByte, paramHickory);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Haw
 * JD-Core Version:    0.7.0.1
 */