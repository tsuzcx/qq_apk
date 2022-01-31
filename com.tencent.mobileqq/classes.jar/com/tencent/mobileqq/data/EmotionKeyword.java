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
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (paramObject == this) {
          return true;
        }
      } while ((getClass() != paramObject.getClass()) || (!(paramObject instanceof EmotionKeyword)));
      paramObject = (EmotionKeyword)paramObject;
    } while ((!this.epId.equals(paramObject.epId)) || (!this.eId.equals(paramObject.eId)) || (!this.keyword.equals(paramObject.keyword)));
    return true;
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
    return "EmotionKeyword{keyword='" + this.keyword + '\'' + ", epId='" + this.epId + '\'' + ", eId='" + this.eId + '\'' + ", exposeNum=" + this.exposeNum + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.EmotionKeyword
 * JD-Core Version:    0.7.0.1
 */