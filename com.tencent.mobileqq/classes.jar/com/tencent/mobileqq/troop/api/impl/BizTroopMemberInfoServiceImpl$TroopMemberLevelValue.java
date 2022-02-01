package com.tencent.mobileqq.troop.api.impl;

public class BizTroopMemberInfoServiceImpl$TroopMemberLevelValue
{
  public int a;
  public String b;
  
  public BizTroopMemberInfoServiceImpl$TroopMemberLevelValue(BizTroopMemberInfoServiceImpl paramBizTroopMemberInfoServiceImpl) {}
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof TroopMemberLevelValue))
    {
      paramObject = (TroopMemberLevelValue)paramObject;
      if ((paramObject.a == this.a) && (paramObject.b.equals(this.b))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a + this.b.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.BizTroopMemberInfoServiceImpl.TroopMemberLevelValue
 * JD-Core Version:    0.7.0.1
 */