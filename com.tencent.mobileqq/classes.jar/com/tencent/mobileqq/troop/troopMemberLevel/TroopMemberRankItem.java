package com.tencent.mobileqq.troop.troopMemberLevel;

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
    return "rankId = " + this.jdField_a_of_type_Int + ",realLevel = " + this.jdField_b_of_type_Int + ",rankTitle = " + this.jdField_a_of_type_JavaLangString + ",isShowLevel" + this.jdField_a_of_type_Boolean + ",isShowRank = " + this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberRankItem
 * JD-Core Version:    0.7.0.1
 */