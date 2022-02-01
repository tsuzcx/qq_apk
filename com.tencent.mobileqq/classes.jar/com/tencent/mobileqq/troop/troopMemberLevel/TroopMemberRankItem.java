package com.tencent.mobileqq.troop.troopmemberlevel;

public class TroopMemberRankItem
{
  public int a;
  public String a;
  public boolean a;
  public int[] a;
  public int b;
  public String b;
  public boolean b;
  public int[] b;
  public int c = -1;
  public int d = -1;
  
  public TroopMemberRankItem()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfInt = null;
    this.jdField_b_of_type_ArrayOfInt = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rankId = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",realLevel = ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(",rankTitle = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",isShowLevel");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",isShowRank = ");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopmemberlevel.TroopMemberRankItem
 * JD-Core Version:    0.7.0.1
 */