package com.tencent.mobileqq.troop.createNewTroop;

class RelationFriendsSearchHelper$MemberScore
{
  final float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  float b = 0.0F;
  
  public RelationFriendsSearchHelper$MemberScore(RelationFriendsSearchHelper paramRelationFriendsSearchHelper, float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Int * this.jdField_a_of_type_Float * 0.4F + this.b * 0.6F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.RelationFriendsSearchHelper.MemberScore
 * JD-Core Version:    0.7.0.1
 */