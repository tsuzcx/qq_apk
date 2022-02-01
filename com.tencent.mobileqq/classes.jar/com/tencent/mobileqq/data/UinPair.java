package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="userUin,friendUin")
public class UinPair
  extends Entity
{
  public String friendUin;
  public String userUin;
  
  public UinPair() {}
  
  public UinPair(String paramString1, String paramString2)
  {
    this.userUin = paramString1;
    this.friendUin = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof UinPair))
    {
      String str = this.userUin;
      UinPair localUinPair;
      if (str == null)
      {
        localUinPair = (UinPair)paramObject;
        if (localUinPair.userUin == null)
        {
          paramObject = this.friendUin;
          if (paramObject == null) {
            return localUinPair.friendUin == null;
          }
          return paramObject.equals(localUinPair.friendUin);
        }
      }
      else
      {
        localUinPair = (UinPair)paramObject;
        if (str.equals(localUinPair.userUin))
        {
          paramObject = this.friendUin;
          if (paramObject == null) {
            return localUinPair.friendUin == null;
          }
          return paramObject.equals(localUinPair.friendUin);
        }
      }
    }
    return super.equals(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.UinPair
 * JD-Core Version:    0.7.0.1
 */