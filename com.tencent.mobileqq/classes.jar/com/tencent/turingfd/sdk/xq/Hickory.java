package com.tencent.turingfd.sdk.xq;

public class Hickory
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public long b;
  public int c;
  public long c;
  
  public Hickory(Hickory.do paramdo)
  {
    this.jdField_a_of_type_Long = paramdo.jdField_a_of_type_Long;
    this.jdField_a_of_type_Boolean = paramdo.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Int = paramdo.jdField_a_of_type_Int;
    this.jdField_b_of_type_Long = paramdo.jdField_b_of_type_Long;
    this.jdField_c_of_type_Long = paramdo.jdField_c_of_type_Long;
    this.jdField_c_of_type_Int = paramdo.jdField_c_of_type_Int;
    this.jdField_b_of_type_Int = paramdo.jdField_b_of_type_Int;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("_");
    String str;
    if (this.jdField_a_of_type_Boolean) {
      str = "1";
    } else {
      str = "2";
    }
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("_");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("_");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append("_");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("_");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Hickory
 * JD-Core Version:    0.7.0.1
 */