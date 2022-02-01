package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ApolloObtainedActionData
  extends Entity
{
  public static final int APOLLO_OBTAINED_TYPE_ACTION = 0;
  public static final int APOLLO_OBTAINED_WAY_BUY = 4;
  public static final int APOLLO_OBTAINED_WAY_FREE = 6;
  public static final int APOLLO_OBTAINED_WAY_SLAVE = 7;
  public long beginTs;
  public long endts;
  @unique
  public int id;
  public int type;
  public int way;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id:").append(this.id).append("beginTs:").append(this.beginTs).append("type:").append(this.type);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.ApolloObtainedActionData
 * JD-Core Version:    0.7.0.1
 */