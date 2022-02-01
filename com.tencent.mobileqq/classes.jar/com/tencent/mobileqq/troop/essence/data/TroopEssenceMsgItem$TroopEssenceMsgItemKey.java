package com.tencent.mobileqq.troop.essence.data;

public class TroopEssenceMsgItem$TroopEssenceMsgItemKey
{
  public int a;
  public long a;
  public long b;
  
  public TroopEssenceMsgItem$TroopEssenceMsgItemKey(long paramLong1, long paramLong2, int paramInt)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    boolean bool1 = bool2;
    if ((paramObject instanceof TroopEssenceMsgItemKey))
    {
      paramObject = (TroopEssenceMsgItemKey)paramObject;
      bool1 = bool2;
      if (paramObject.jdField_a_of_type_Long == this.jdField_a_of_type_Long)
      {
        bool1 = bool2;
        if (paramObject.b == this.b)
        {
          bool1 = bool2;
          if (paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return (int)this.jdField_a_of_type_Long + (int)this.b + this.jdField_a_of_type_Int;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troopUin:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" ");
    localStringBuilder.append("msgSeq:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append("msgRandom:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemKey
 * JD-Core Version:    0.7.0.1
 */