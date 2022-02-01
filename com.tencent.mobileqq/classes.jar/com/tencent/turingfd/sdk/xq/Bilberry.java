package com.tencent.turingfd.sdk.xq;

public class Bilberry
  implements goto
{
  public static final byte[] Mh = new byte[0];
  public final String Eh;
  public final long Fh;
  public final String Hh;
  public final String Ih;
  public final String Jh;
  public final String Kh;
  public Cherry Lh;
  public int Nh = 0;
  public int Oh = 0;
  public final int zg;
  
  public Bilberry(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    this.Eh = "";
    this.Fh = 0L;
    this.zg = paramInt1;
    this.Hh = "";
    this.Ih = "";
    this.Jh = "";
    this.Kh = "";
    this.Lh = new Cherry("");
    this.Nh = paramInt2;
    this.Oh = paramInt3;
  }
  
  public Bilberry(Bilberry.do paramdo)
  {
    this.Eh = paramdo.jdField_a_of_type_JavaLangString;
    this.Fh = paramdo.jdField_a_of_type_Long;
    this.zg = paramdo.jdField_a_of_type_Int;
    byte[] arrayOfByte = paramdo.jdField_a_of_type_ArrayOfByte;
    this.Hh = paramdo.b;
    this.Ih = paramdo.c;
    this.Jh = paramdo.d;
    this.Kh = paramdo.e;
    this.Lh = paramdo.jdField_a_of_type_ComTencentTuringfdSdkXqCherry;
  }
  
  public static Bilberry.do create(int paramInt)
  {
    return new Bilberry.do(paramInt, null);
  }
  
  public static Bilberry g(int paramInt)
  {
    return new Bilberry(paramInt, Mh, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Bilberry
 * JD-Core Version:    0.7.0.1
 */