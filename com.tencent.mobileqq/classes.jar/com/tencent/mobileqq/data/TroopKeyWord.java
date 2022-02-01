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
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof TroopKeyWord)) {
      return false;
    }
    paramObject = (TroopKeyWord)paramObject;
    return (equals(this.troopUin, paramObject.troopUin)) && (equals(this.keyword, paramObject.keyword));
  }
  
  public int hashCode()
  {
    String str = this.keyword;
    if (str == null) {
      return 0;
    }
    return str.hashCode();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("TroopKeyWord{");
    localStringBuffer.append("wordId=");
    localStringBuffer.append(this.wordId);
    localStringBuffer.append(", troopUin='");
    localStringBuffer.append(this.troopUin);
    localStringBuffer.append('\'');
    localStringBuffer.append(", keyword='");
    localStringBuffer.append(this.keyword);
    localStringBuffer.append('\'');
    localStringBuffer.append(", expiredFlag=");
    localStringBuffer.append(this.expiredFlag);
    localStringBuffer.append(", enable=");
    localStringBuffer.append(this.enable);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopKeyWord
 * JD-Core Version:    0.7.0.1
 */