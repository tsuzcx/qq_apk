package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="eId,epId,keyword")
public class EmotionKeyword
  extends Entity
{
  public String eId;
  public String epId;
  public int exposeNum;
  public String keyword;
  
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
    if (!(paramObject instanceof EmotionKeyword)) {
      return false;
    }
    paramObject = (EmotionKeyword)paramObject;
    return (this.epId.equals(paramObject.epId)) && (this.eId.equals(paramObject.eId)) && (this.keyword.equals(paramObject.keyword));
  }
  
  public int hashCode()
  {
    return this.epId.hashCode() + this.eId.hashCode() + this.keyword.hashCode();
  }
  
  public void replace(EmotionKeyword paramEmotionKeyword)
  {
    if (paramEmotionKeyword != null) {
      this.exposeNum = paramEmotionKeyword.exposeNum;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EmotionKeyword{keyword='");
    localStringBuilder.append(this.keyword);
    localStringBuilder.append('\'');
    localStringBuilder.append(", epId='");
    localStringBuilder.append(this.epId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", eId='");
    localStringBuilder.append(this.eId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", exposeNum=");
    localStringBuilder.append(this.exposeNum);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.EmotionKeyword
 * JD-Core Version:    0.7.0.1
 */