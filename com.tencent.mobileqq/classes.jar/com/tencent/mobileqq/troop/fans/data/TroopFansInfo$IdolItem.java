package com.tencent.mobileqq.troop.fans.data;

public class TroopFansInfo$IdolItem
{
  public int a;
  public long a;
  public String a;
  public long b;
  public String b;
  public String c = "";
  
  public TroopFansInfo$IdolItem()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("idolid:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" ");
    localStringBuilder.append("name:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" ");
    localStringBuilder.append("avatar:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" ");
    localStringBuilder.append("pic:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    localStringBuilder.append("rank:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" ");
    localStringBuilder.append("qScore:");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fans.data.TroopFansInfo.IdolItem
 * JD-Core Version:    0.7.0.1
 */