package com.tencent.mobileqq.troop.essence.data;

public class TroopEssenceMsgItem$TroopEssenceMsgItemKey
{
  public long a;
  public long b;
  public int c;
  
  public TroopEssenceMsgItem$TroopEssenceMsgItemKey(long paramLong1, long paramLong2, int paramInt)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramInt;
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
      if (paramObject.a == this.a)
      {
        bool1 = bool2;
        if (paramObject.b == this.b)
        {
          bool1 = bool2;
          if (paramObject.c == this.c) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return (int)this.a + (int)this.b + this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troopUin:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ");
    localStringBuilder.append("msgSeq:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append("msgRandom:");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemKey
 * JD-Core Version:    0.7.0.1
 */