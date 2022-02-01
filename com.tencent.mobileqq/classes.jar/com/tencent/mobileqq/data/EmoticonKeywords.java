package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="keyword")
public class EmoticonKeywords
  extends Entity
{
  public String keyword;
  public long lastReqTime;
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    if (!(paramObject instanceof EmoticonKeywords)) {
      return false;
    }
    paramObject = (EmoticonKeywords)paramObject;
    return this.keyword.equals(paramObject.keyword);
  }
  
  public int hashCode()
  {
    return this.keyword.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EmoticonKeywords");
    localStringBuilder.append("{");
    localStringBuilder.append("keyword = ");
    localStringBuilder.append(this.keyword);
    localStringBuilder.append(",lastReqTime = ");
    localStringBuilder.append(this.lastReqTime);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.EmoticonKeywords
 * JD-Core Version:    0.7.0.1
 */