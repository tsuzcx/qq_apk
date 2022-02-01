package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ApolloRecommendAction
  extends Entity
{
  public static final int TYPE_ASCEND = 2;
  public static final int TYPE_HOT = 1;
  @unique
  public int id;
  public int type;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ApolloRecommendAction{");
    localStringBuffer.append("id=").append(this.id);
    localStringBuffer.append(", type=").append(this.type);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.ApolloRecommendAction
 * JD-Core Version:    0.7.0.1
 */