package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;

public class TroopKeyWord
  extends Entity
{
  public boolean enable;
  public int expiredFlag;
  public String keyword;
  public String troopUin;
  public long wordId;
  
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof TroopKeyWord)) {
        return false;
      }
      paramObject = (TroopKeyWord)paramObject;
    } while ((equals(this.troopUin, paramObject.troopUin)) && (equals(this.keyword, paramObject.keyword)));
    return false;
  }
  
  public int hashCode()
  {
    if (this.keyword == null) {
      return 0;
    }
    return this.keyword.hashCode();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("TroopKeyWord{");
    localStringBuffer.append("wordId=").append(this.wordId);
    localStringBuffer.append(", troopUin='").append(this.troopUin).append('\'');
    localStringBuffer.append(", keyword='").append(this.keyword).append('\'');
    localStringBuffer.append(", expiredFlag=").append(this.expiredFlag);
    localStringBuffer.append(", enable=").append(this.enable);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopKeyWord
 * JD-Core Version:    0.7.0.1
 */