package com.tencent.mobileqq.troop.api.impl;

public class BizTroopMemberInfoServiceImpl$TroopMemberLevelValue
{
  public int a;
  public String a;
  
  public BizTroopMemberInfoServiceImpl$TroopMemberLevelValue(BizTroopMemberInfoServiceImpl paramBizTroopMemberInfoServiceImpl) {}
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof TroopMemberLevelValue))
    {
      paramObject = (TroopMemberLevelValue)paramObject;
      if ((paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int) && (paramObject.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int + this.jdField_a_of_type_JavaLangString.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.BizTroopMemberInfoServiceImpl.TroopMemberLevelValue
 * JD-Core Version:    0.7.0.1
 */