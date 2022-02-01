package com.tencent.mobileqq.troop.api.troopcreate.impl;

class RelationFriendsSearchHelperImpl$MemberScore
{
  final float a;
  public int a;
  public long a;
  public float b = 0.0F;
  
  public RelationFriendsSearchHelperImpl$MemberScore(float paramFloat)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Int * this.jdField_a_of_type_Float * 0.4F + this.b * 0.6F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopcreate.impl.RelationFriendsSearchHelperImpl.MemberScore
 * JD-Core Version:    0.7.0.1
 */